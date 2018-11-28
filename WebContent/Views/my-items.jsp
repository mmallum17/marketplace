<%@page import="edu.models.User"%>
<%@page import="edu.models.Listing"%>
<%@page import="java.util.ArrayList"%>
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
				<li><a href="items">marketplace</a></li>
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
				<li class="active"><a href="my-items">my items</a></li>
				<li><a href="logout">logout</a></li>
				<%
					}
				%>
			</ul>
		</nav>
	</header>


	<!--  PAGE HEADER: PAGE DESCRIPTION  -->
	<!-- 	<div id="page-description" class="body"> -->
	<!-- 		<h2> -->
	<!-- 			Welcome to the <strong>Marketplace</strong>! -->
	<!-- 		</h2> -->
	<!-- 		<p>Here you will find items listed for sale by MavMarket users.</p> -->
	<%
		ArrayList<Listing> currentListings = (ArrayList<Listing>) request.getAttribute("listings");
		int rows = (currentListings.size() + 2) / 3;
		for (int i = 0; i < rows; i++) {
	%>
	<div class="container">
		<div class="row">
			<%
				Listing[] rowListings = new Listing[3];
					for (int j = 0; j < 3; j++) {
						if (i * 3 + j < currentListings.size()) {
							Listing listing = currentListings.get(i * 3 + j);
			%>
			<div class="col-sm-4">
				<a href="#editModal" data-toggle="modal" data-listing-id=<%=listing.getId()%> data-listing-name=<%=listing.getName() %> data-listing-price=<%=listing.getPrice() %> data-listing-description="<%=listing.getDescription() %>" data-listing-image=<%=listing.getImageFilepath() %>>
					<div class="panel panel-danger">
						<div style="color:black;" class="panel-heading mypanel-heading"><%=listing.getName()%></div>
						<div class="panel-body">
							<img src="http://mav-market.ddns.net:8080/marketplace/images/item/<%=listing.getImageFilepath()%>" class="img-responsive"
								style="width: 100%; height: 200px" onerror="this.onerror=null;this.src='http://mav-market.ddns.net:8080/marketplace/images/default-image.png';">
						</div>
						<div class="panel-footer mypanel-footer">
							$<%=listing.getPrice()%>
						</div>
					</div>
				</a>
			</div>
			<%
				}
					}
			%>
		</div>
	</div>
	<br>
	<%
		}
	%>

	<div class="modal" id="editModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Edit Listing</h4>
				</div>
				<div class="modal-body">
					<form action="my-items" method="post">
						Item Name:<br> <input type="text" name="itemName" value="" required><br>
						<br>Price:<br> <input type="number" name="price" value="" required><br>
						<br>Description:<br> <input type="text" name="description" value=""><br>
<!-- 						Upload new item photo:<br> <input type="file" name="newPhoto" value="" /><br> -->
						<input type="hidden" name="origImagePath" value="">
						<input type="hidden" name="listingId" value="">
						<br><button name="saveChangesBtn" type="submit" class="btn btn-default" value="">Save Changes</button>
						<a style="color:white; padding:6px 12px;" href="#confirmModal" id="deleteButton" class="btn btn-danger" data-toggle="modal" data-listing-id="" data-dismiss="modal">Delete</a>
					</form>
<!-- 					<input type="text" name="bookId" value="" /> -->
<!-- 					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
				</div>
			</div>
		</div>
	</div>


	<div class="modal" id="confirmModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Delete Item</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to remove item?</p>
					<form action="my-items" method="post">
						<button name="confirmBtn" type="submit" class="btn btn-default" value="">Yes</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
					</form>
<!-- 					<input type="text" name="bookId" value="" /> -->
<!-- 					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
				</div>
			</div>
		</div>
	</div>
	
	<footer id="website-description" class="body">
	Want to list a new item? Click <b><a href="list-item">here</a></b> to start selling today!
	</footer>

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
	$('#editModal').on('show.bs.modal', function(e) {
     	var listingId = $(e.relatedTarget).data('listing-id');
     	var listingName = $(e.relatedTarget).data('listing-name');
     	var listingPrice = $(e.relatedTarget).data('listing-price');
     	var listingDescription = $(e.relatedTarget).data('listing-description');
     	var listingImage = $(e.relatedTarget).data('listing-image');
     	
     	$(e.currentTarget).find('input[name="listingId"]').val(listingId);
     	$(e.currentTarget).find('input[name="itemName"]').val(listingName);
     	$(e.currentTarget).find('input[name="price"]').val(listingPrice);
     	$(e.currentTarget).find('input[name="description"]').val(listingDescription);
      	$(e.currentTarget).find('input[name="origImagePath"]').val(listingImage);

    	$(e.currentTarget).find('a[id="deleteButton"]').attr("data-listing-id", listingId);
 	});
	
	$('#confirmModal').on('show.bs.modal', function(e) {
		var listingId = $(e.relatedTarget).data('listing-id');
		$(e.currentTarget).find('button[name="confirmBtn"]').val(listingId);
	});
</script>

</html>