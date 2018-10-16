package edu.taghandlers;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class NavbarTag extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<ul>"
				+ "<li><a href=\"home\">Home</a></li>"
				+ "<li><a href=\"list-item\">List Item</a></li>"
				+ "<li><a href=\"login\">Login</a></li>\r\n"
				+ "<li><a href=\"items\">Marketplace</a></li>"
				+ "<li><a href=\"signup\">Signup</a></li>"
				+ "<li><a href=\"user-dashboard\">User Dashboard</a></li>"
				+ "<li><a href=\"user-details\">User Details</a></li>"
				+ "</ul>");
	}
}
