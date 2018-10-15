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

import edu.models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get parameters
		String email = request.getParameter("email");
		String inputPassword = request.getParameter("password");

		// Get user from database
		Connection conn = (Connection) getServletContext().getAttribute("DBConnect");
		String query = "SELECT id,name,password FROM user WHERE email = ?";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, email);
			ResultSet rs = preparedStmt.executeQuery();
			if (rs.next()) {
				String actualPassword = rs.getString("password");
				if(inputPassword.equals(actualPassword)) {
					System.out.println("User is logged in");
					// Store user in session
					User loggedInUser = new User(rs.getInt("id"), rs.getString("name"), email, null);
					request.getSession().setAttribute("user", loggedInUser);
				}
				else {
					System.out.println("Incorrect password");
				}
			}
			else {
				System.out.println("User does not exist");
			}

		} catch (SQLException e) {
			System.out.println("Database Error!!");
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			e.printStackTrace();
		}

		// Redirect to user's dashboard
		response.sendRedirect("user-dashboard");
	}

}
