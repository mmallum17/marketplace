<%@page import="edu.models.Listing"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "ex" uri = "/WEB-INF/custom-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Details</title>
</head>
<body>
	<ex:navbar/>
	<%
		Listing listing = (Listing) request.getAttribute("listing");
	%>
	Name: <%=listing.getName()%><br>
	Price: $<%=listing.getPrice()%><br> 
	Description: <%=listing.getDescription()%><br> 
	Seller: <%=listing.getSeller().getName()%><br>
</body>
</html>