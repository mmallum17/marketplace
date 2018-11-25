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
				<li class="active"><a href="remove-item">remove item</a></li>
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
				<a href="#my_modal" data-toggle="modal" data-book-id=<%=listing.getId()%>>
					<div class="panel panel-danger">
						<div class="panel-heading mypanel-heading"><%=listing.getName()%></div>
						<div class="panel-body">
							<img src=<%=listing.getImageFilepath()%> class="img-responsive"
								style="width: 100%; height: 200px" alt="Image">
						</div>
						<div class="panel-footer mypanel-footer">
							$<%=listing.getPrice()%><br>Location<br>
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

	<div class="modal" id="my_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Modal header</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to remove item?</p>
					<form action="remove-item" method="post">
						<button name="bookId" type="submit" class="btn btn-default" value="">Yes</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
					</form>
<!-- 					<input type="text" name="bookId" value="" /> -->
<!-- 					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
				</div>
			</div>
		</div>
	</div>
	<!--  CONTENT: THIS IS WHERE PAGE SPECIFIC CONTENT IS TO BE ADDED  -->
	<!-- 	<div id="content" class="body"> -->


	<!-- 		<h2> -->
	<!-- 			<b>10/17/2018:</b> MavMarket Released -->
	<!-- 		</h2> -->
	<!-- 		<p>MavMarket v1.0 is released. Features include:</p> -->
	<!-- 		<br> -->
	<!-- 		<h2> -->
	<!-- 			<b>9/25/2018:</b> MavMarket Design Complete -->
	<!-- 		</h2> -->
	<!-- 		<p>MavMarket design is completed. Features include:</p> -->
	<!-- 		<br> -->
	<!-- 		<h2> -->
	<!-- 			<b>9/10/2018:</b> Los Tres Muchachos Formed -->
	<!-- 		</h2> -->
	<!-- 		<p>The creators of the MavMarket online retail web application -->
	<!-- 			assembled as a team to complete the project</p> -->

	<!-- 	</div> -->

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
$('#my_modal').on('show.bs.modal', function(e) {
    var bookId = $(e.relatedTarget).data('book-id');
    $(e.currentTarget).find('button[name="bookId"]').val(bookId);
});
</script>

</html>