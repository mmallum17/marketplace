<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "ex" uri = "/WEB-INF/custom-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Item</title>
</head>
<body>
	<ex:navbar/>
	<h3>Add New Listing</h3>
	<form action="list-item" method="post" enctype="multipart/form-data">
		Item Name:<br> <input type="text" name="itemName" required><br>
		Price:<br> <input type="number" name="price" required><br>
		Description:<br> <input type="text" name="description"><br>
		Upload item photo:<br> <input type="file" name="photo" /><br>		
		<br> <input type="submit" value="List Item">
	</form>
</body>
</html>