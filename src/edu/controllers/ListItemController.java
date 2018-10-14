package edu.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

/**
 * Servlet implementation class ListItem
 */
@WebServlet("/list-item")
public class ListItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Views/list-item.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get parameters
		String itemName = request.getParameter("itemName");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		String imagePath = request.getParameter("imagePath");
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		System.out.println(itemName + ", " + price + ", " + description + ", " + imagePath + ", " + userId );

		// Insert new item into database
		Connection conn = (Connection) getServletContext().getAttribute("DBConnect");
		String query = "INSERT INTO item (name, description, price, seller_id, image_filepath) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, itemName);
			preparedStmt.setString(2, description);
			preparedStmt.setInt(3, price);
			preparedStmt.setInt(4, userId);
			preparedStmt.setString(5, imagePath);
			preparedStmt.execute();
			System.out.println("Item added to the database");
		} catch (SQLException e) {
			System.out.println("Database Error... Item not added to database!!");
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			e.printStackTrace();
		}

		// Redirect to marketplace page
		response.sendRedirect("items");
	}

}
