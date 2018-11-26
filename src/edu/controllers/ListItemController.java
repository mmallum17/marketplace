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

import edu.models.User;

/**
 * Servlet implementation class ListItem
 */
@WebServlet("/list-item")
@MultipartConfig
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
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		
		System.out.println(itemName);
		System.out.println(price);
		System.out.println(description);
//		String filename = "";

		// Get and store image
		Part filePart = request.getPart("photo");
		String filename = getSubmittedFileName(filePart);
		InputStream fileContent = filePart.getInputStream();
		String operatingSystem = System.getProperty("os.name");
		String rootPath = null;
		if(operatingSystem.equals("Linux")) {
			rootPath = getServletContext().getInitParameter("linuxRoot");
		}
		else {
			rootPath = getServletContext().getInitParameter("windowsRoot");
		}
		Path serverImageFilepath = Paths.get(rootPath, getServletContext().getInitParameter("itemImagePath"), filename);
		Files.deleteIfExists(serverImageFilepath);
		Files.copy(fileContent, serverImageFilepath, StandardCopyOption.REPLACE_EXISTING);
		
		// Insert new item into database
		Connection conn = (Connection) getServletContext().getAttribute("DBConnect");
		String query = "INSERT INTO listing (name, description, price, seller_id, image_filepath) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, itemName);
			preparedStmt.setString(2, description);
			preparedStmt.setInt(3, price);
			preparedStmt.setInt(4, userId);
			preparedStmt.setString(5, filename);
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
