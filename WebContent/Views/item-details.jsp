<%@page import="edu.models.User"%>
<%@page import="edu.models.Listing"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ex" uri="/WEB-INF/custom-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>MavMarket Community Marketplace</title>
<link rel="stylesheet" type="text/css"
	href="assets/css/mavmarketcss.css">
</head>
<body>
	<!--  BANNER: MAVERICK MARKET LOGO  -->
	<header id="mavbanner" class="body">
		<img id="logo" src="images/mavmarket2.png" alt="MavMarket logo" />

		<!--  NAVIGATION BAR: LIST ITEMS CAN BE GENERATED DYNAMICALLY BASED ON USER ACCOUNT  -->
		<nav>
			<ul>
				<li><a href="home">home</a></li>
				<li class="active"><a href="items">marketplace</a></li>
				<%
					User currentUser = (User) session.getAttribute("user");
					if (currentUser == null) {
				%>
				<li><a href="login">log in</a></li>
				<li><a href="signup">sign up</a></li>
				<%
					} else {
				%>
				<li><a href="list-item">list item</a></li>
				<li><a href="my-items">my items</a></li>
				<li><a href="logout">logout</a></li>
				<%
					}
				%>
			</ul>
		</nav>
	</header>

	<!--  CONTENT: THIS IS WHERE PAGE SPECIFIC CONTENT IS TO BE ADDED  -->
	<div id="content" class="body">


		<%
			Listing listing = (Listing) request.getAttribute("listing");
		%>
	<img src="http://mav-market.ddns.net:8080/marketplace/images/item/<%=listing.getImageFilepath()%>" class="img-responsive" style="width: 50%; height: 200px" onerror="this.onerror=null;this.src='http://mav-market.ddns.net:8080/marketplace/images/default-image.png';"align="left">
     <h2 align="center"><%=listing.getName()%>  ---$<%=listing.getPrice()%></h2> 
	 <div align="center"><%=listing.getDescription()%><br><br><br><br></div> 

	<div align="center">	Interested in <%=listing.getSeller().getName()%>'s Item? <a style="color:white; margin-left: 5px; padding: 2px 4px;"  href="#notifyModal" id="notifyBtn" class="btn btn-danger" data-toggle="modal" 
							data-listing-name="<%=listing.getName() %>" data-seller-email="<%=listing.getSeller().getEmail() %>" 
							data-buyer-name="<%=request.getAttribute("userName") %>" data-buyer-email="<%=request.getAttribute("userEmail") %>"
							data-buyer-phone="<%=request.getAttribute("userPhone") %>">Notify Seller</a></div>
	</div>
	
	<div class="modal" id="notifyModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h2 align="left" class="modal-title">Notify Seller</h2>
				</div>
				<div class="modal-body">
					Send Contact Info To The Seller:
					<form action="send-email" method="post">
					<br>Name: <br> <input type="text" name="userName" value="" required><br>
			        <br>Email:<br> <input type="email" name="userEmail" value="" required><br>
					<br>Phone:<br> <input type="text" name="userPhone" value=""><br>
						<input type="hidden" name="sellerEmail" value="">
						<input type="hidden" name="listingName" value="">
						<br><button name="saveChangesBtn" type="submit" class="btn btn-danger" value="">Send Contact Info</button>
					</form>
<!-- 					<input type="text" name="bookId" value="" /> -->
<!-- 					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
				</div>
			</div>
		</div>
	</div>

	<!--  FOOTER: WEBSITE DESCRIPTION  -->
	<footer id="website-description" class="body">
		The <b>MavMarket</b> web application is a group project deliverable
		created by students of <b><a href="https://www.unomaha.edu/">University
				of Nebraska Omaha</a></b> for <b>CSCI 4830</b>. <br> <br> <strong>Group
			Members: </strong>Austin Smith, Marcus Mallum, Phil Baumberger, Randal Bachle
	</footer>

	<!-- COPYRIGHT TEXT -->
	<p class="body" id="copyright">&copy; 2018 Los Tres Muchachos</p>
</body>
<script type="text/javascript">
	$('#notifyModal').on('show.bs.modal', function(e) {
     	var sellerEmail = $(e.relatedTarget).data('seller-email');
     	var listingName = $(e.relatedTarget).data('listing-name');
     	var buyerName = $(e.relatedTarget).data('buyer-name');
     	var buyerEmail = $(e.relatedTarget).data('buyer-email');
     	var buyerPhone = $(e.relatedTarget).data('buyer-phone');
     	
     	$(e.currentTarget).find('input[name="userName"]').val(buyerName);
     	$(e.currentTarget).find('input[name="userEmail"]').val(buyerEmail);
     	$(e.currentTarget).find('input[name="userPhone"]').val(buyerPhone);
     	$(e.currentTarget).find('input[name="sellerEmail"]').val(sellerEmail);
      	$(e.currentTarget).find('input[name="listingName"]').val(listingName);

 	});
</script>

</html>