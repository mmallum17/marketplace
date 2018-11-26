package edu.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.models.Listing;
import edu.models.User;

/**
 * Servlet implementation class ItemDetails
 */
@WebServlet("/item-details")
public class ItemDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get parameters
		int listingId = Integer.parseInt(request.getParameter("id"));
		
//		String operatingSystem = System.getProperty("os.name");
//		String domain = "";
//		if(!operatingSystem.equals("Linux")) {
//			domain = "http://mav-market.ddns.net:8080/marketplace/";
//		}

		// Get user from database
		Connection conn = (Connection) getServletContext().getAttribute("DBConnect");
		String query = "SELECT listing.name AS listingName,listing.price,listing.description,listing.time_created,listing.image_filepath AS listingImageFilepath,user.name AS userName,user.email,user.image_filepath AS userImageFilepath FROM listing INNER JOIN user ON listing.seller_id = user.id WHERE listing.id = ?";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, listingId);
			ResultSet rs = preparedStmt.executeQuery();
			if (rs.next()) {
				User seller = new User(-1, rs.getString("userName"), rs.getString("email"), rs.getString("userImageFilePath"));
				Listing listing = new Listing(listingId, rs.getString("listingName"), rs.getInt("price"), rs.getString("description"), seller, rs.getTimestamp("time_created"), rs.getString("listingImageFilepath"));
				request.setAttribute("listing", listing);
			}
			else {
				System.out.println("Item does not exist");
			}

		} catch (SQLException e) {
			System.out.println("Database Error!!");
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Views/item-details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
