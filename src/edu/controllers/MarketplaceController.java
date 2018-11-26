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
 * Servlet implementation class Marketplace
 */
@WebServlet("/items")
public class MarketplaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MarketplaceController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = request.getParameter("search");
		if(search == null) {
			search = "";
		}
		System.out.println(search);
		
		ArrayList<Listing> listings = new ArrayList<>();
//		String operatingSystem = System.getProperty("os.name");
//		String domain = "";
//		if(!operatingSystem.equals("Linux")) {
//			domain = "http://mav-market.ddns.net:8080/marketplace/";
//		}
		
		// Get all listings and associated user from database
		Connection conn = (Connection) getServletContext().getAttribute("DBConnect");
		String query = "SELECT listing.id AS listingId,listing.name AS listingName,listing.price,listing.description,listing.time_created,listing.image_filepath AS listingImageFilepath,user.name AS userName,user.email,user.image_filepath AS userImageFilepath FROM listing INNER JOIN user ON listing.seller_id = user.id WHERE deleted = ? AND listing.name LIKE ?";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, "%" + search + "%");
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				User seller = new User(-1, rs.getString("userName"), rs.getString("email"),
						rs.getString("userImageFilepath"));
				Listing listing = new Listing(rs.getInt("listingId"), rs.getString("listingName"), rs.getInt("price"),
						rs.getString("description"), seller, rs.getTimestamp("time_created"),rs.getString("listingImageFilepath"));
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

		request.getRequestDispatcher("Views/marketplace.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
