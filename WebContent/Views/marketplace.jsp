<%@page import="models.User"%>
<%@page import="models.Listing"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marketplace</title>
</head>
<body>
	<ul>
		<li><a href="">Home</a></li>
		<li><a href="list-item">List Item</a></li>
		<li><a href="login">Login</a></li>
		<li><a href="items">Marketplace</a></li>
		<li><a href="signup">Signup</a></li>
		<li><a href="user-dashboard">User Dashboard</a></li>
		<li><a href="user-details">User Details</a></li>
	</ul>
	<% 
		ArrayList<Listing> currentListings = (ArrayList<Listing>) request.getAttribute("listings");
		for (int i = 0; i < currentListings.size(); i++) {
		Listing listing = currentListings.get(i);
	%>
		Name: <a href="item-details?id=<%= listing.getId() %>"><%= listing.getName() %></a><br>
		Price: $<%= listing.getPrice() %><br>
		Description: <%= listing.getDescription() %><br>
		Seller: <%= listing.getSeller().getName() %><br><br>
	<% } %>
</body>
</html>