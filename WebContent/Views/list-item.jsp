<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Item</title>
</head>
<body>
	<ul>
		<li><a href="">Home</a></li>
		<li><a href="item-details">Item Details</a></li>
		<li><a href="list-item">List Item</a></li>
		<li><a href="login">Login</a></li>
		<li><a href="items">Marketplace</a></li>
		<li><a href="signup">Signup</a></li>
		<li><a href="user-dashboard">User Dashboard</a></li>
		<li><a href="user-details">User Details</a></li>
	</ul>

	<h3>Add New Listing</h3>
	<form action="list-item" method="post">
		Item Name:<br> <input type="text" name="itemName" required><br>
		Price:<br> <input type="number" name="price" required><br>
		Description:<br> <input type="text" name="description"><br>
		Image Path:<br> <input type="text" name="imagePath"><br>
		<br> <input type="submit" value="List Item">
	</form>
</body>
</html>