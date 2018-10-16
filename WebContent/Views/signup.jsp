<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "ex" uri = "/WEB-INF/custom-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<ex:navbar/>
	<form action="signup" method="post" enctype="multipart/form-data">
		Name:<br> <input type="text" name="name" required><br>
		Email:<br> <input type="email" name="email" required><br>
		Password:<br> <input type="text" name="password" required><br>
		Upload profile photo:<br> <input type="file" name="photo" /><br>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>