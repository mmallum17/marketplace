package edu.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.models.Listing;
import edu.models.User;

/**
 * Servlet implementation class RemoveItemController
 */
@WebServlet("/remove-item")
public class RemoveItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Listing> listings = new ArrayList<>();
		String operatingSystem = System.getProperty("os.name");
		String domain = "";
		if(!operatingSystem.equals("Linux")) {
			domain = "http://mav-market.ddns.net:8080/marketplace/";
		}
		User currentUser = (User) request.getSession().getAttribute("user");
		int userId = currentUser.getId();
		
		// Get all listings for a user from the database
		Connection conn = (Connection) getServletContext().getAttribute("DBConnect");
		String query = "SELECT id,name,price,description,time_created,image_filepath FROM listing WHERE deleted = ? AND seller_id = ?";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, userId);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				Listing listing = new Listing(rs.getInt("id"), rs.getString("name"), rs.getInt("price"),
						rs.getString("description"), currentUser, rs.getTimestamp("time_created"),
						domain + "images/item/" + rs.getString("image_filepath"));
				listings.add(listing);
			}
			// Send listings to jsp
			request.setAttribute("listings", listings);
		} catch (SQLException e) {
			System.out.println("Database Error!!");
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			e.printStackTrace();
		}

		request.getRequestDispatcher("Views/remove-item.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("bookId"));
		System.out.println(id);
		
		try
	    {
			// create a java mysql database connection
			Connection conn = (Connection) getServletContext().getAttribute("DBConnect");
	    
			// create the java mysql update preparedstatement
			String query = "UPDATE listing SET deleted = ? WHERE id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, 1);
			preparedStmt.setInt(2, id);

			// execute the java preparedstatement
			preparedStmt.executeUpdate();
	      
	    }
	    catch (SQLException e)
	    {
	    	System.out.println("Database Error!!");
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			e.printStackTrace();
	    }
				
		response.sendRedirect("remove-item");
	}

}
