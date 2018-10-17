package edu.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/signup")
@MultipartConfig
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Views/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get parameters
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String filename = "";
		
		// Get and store image
//		Part filePart = request.getPart("photo");
//		String filename = getSubmittedFileName(filePart);
//		InputStream fileContent = filePart.getInputStream();
//		String operatingSystem = System.getProperty("os.name");
//		String rootPath = null;
//		if(operatingSystem.equals("Linux")) {
//			rootPath = getServletContext().getInitParameter("linuxRoot");
//		}
//		else {
//			rootPath = getServletContext().getInitParameter("windowsRoot");
//		}
//		Path serverImageFilepath = Paths.get(rootPath, getServletContext().getInitParameter("userImagePath"), filename);
//		Files.deleteIfExists(serverImageFilepath);
//		Files.copy(fileContent, serverImageFilepath, StandardCopyOption.REPLACE_EXISTING);
		
		// Insert new user into database
		Connection conn = (Connection) getServletContext().getAttribute("DBConnect");
		String query = " insert into user (name, email, password, image_filepath) values (?, ?, ?, ?) ";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, email);
			preparedStmt.setString(3, password);
			preparedStmt.setString(4,  filename);
			preparedStmt.execute();		
			// Redirect to login
			response.sendRedirect("login");
		} catch (SQLException e) {
			
			System.out.println("Database Error!!");
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			e.printStackTrace();
			request.setAttribute("invalidSignupCreds", true);
			request.getRequestDispatcher("Views/signup.jsp").forward(request, response);
		}


	}
	
	private static String getSubmittedFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}

}
