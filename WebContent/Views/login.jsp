<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
	<form action="login" method="post">
		Name:<br> 
		<input type="text" name="name" required><br> 
		Email:<br> 
		<input type="text" name="email" required><br>
		Password:<br> 
		<input type="text" name="password" required><br>
		<br> <input type="submit" value="Submit">
	</form>

</body>
</html>