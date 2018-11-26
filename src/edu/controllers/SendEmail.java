package edu.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.util.EmailUtility;;

/**
 * Servlet implementation class NotifyInterest
 */
@WebServlet("/send-email")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String listingName = request.getParameter("listingName");
		String sellerEmail = request.getParameter("sellerEmail");
		String buyerName = request.getParameter("userName");
		String buyerEmail = request.getParameter("userEmail");
		String buyerPhone = request.getParameter("userPhone");
		
//		System.out.println(listingName);
//		System.out.println(sellerEmail);
//		System.out.println(buyerName);
//		System.out.println(buyerEmail);
//		System.out.println(buyerPhone);
		
		ServletContext context = getServletContext();
		String emailHost = context.getInitParameter("emailHost");
		String emailPort = context.getInitParameter("emailPort");
		String sendUser = context.getInitParameter("emailUser");
		String sendPass = context.getInitParameter("emailPass");
		
//		System.out.println(emailHost);
//		System.out.println(emailPort);
//		System.out.println(sendUser);
//		System.out.println(sendPass);
		
		String subject = "Someone is interested in your item on MavMarket!!";
		String message = "Hello!\n\n" + buyerName + " is interested in buying the following item: " + listingName + ".\n\nTo contact the buyer, here is their contact info:\nName: " + 
							buyerName + "\nEmail: " + buyerEmail + " \nPhone: " + buyerPhone + "\n\nThanks,\nMavMarket Team";
		
		try {
			EmailUtility.sendEmail(emailHost, emailPort, sendUser, sendPass, sellerEmail, subject, message);
			System.out.println("Email sent successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error in sending email");
		}
		
		
		response.sendRedirect("items");

	}

}
