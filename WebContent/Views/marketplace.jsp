<%@page import="edu.models.User"%>
<%@page import="edu.models.Listing"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "ex" uri = "/WEB-INF/custom-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marketplace</title>
</head>
<body>
	<ex:navbar/>
	<% 
		ArrayList<Listing> currentListings = (ArrayList<Listing>) request.getAttribute("listings");
		for (int i = 0; i < currentListings.size(); i++) {
		Listing listing = currentListings.get(i);
	%>
		Name: <a href="item-details?id=<%= listing.getId() %>"><%= listing.getName() %></a><br>
		<img src="<%= listing.getImageFilepath() %>">
		Price: $<%= listing.getPrice() %><br>
		Description: <%= listing.getDescription() %><br>
		<img src="<%= listing.getSeller().imageFilepath() %>">
		Seller: <%= listing.getSeller().getName() %><br><br>
	<% } %>
</body>
</html>