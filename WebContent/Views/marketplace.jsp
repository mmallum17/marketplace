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
				<li><a style="align:center;" href="home">home</a></li>
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


	<!--  PAGE HEADER: PAGE DESCRIPTION  -->
	<!-- 	<div id="page-description" class="body"> -->
	<!-- 		<h2> -->
	<!-- 			Welcome to the <strong>Marketplace</strong>! -->
	<!-- 		</h2> -->
	<!-- 		<p>Here you will find items listed for sale by MavMarket users.</p> -->
	
	
	<div style="padding-bottom:25px"class="container">
		<form action="items">
  <div class="row">
    <div class="col-xs-6 col-md-4">
      <div class="input-group">
        <input name="search" type="text" class="form-control" placeholder="Search" id="txtSearch"/>
        <div class="input-group-btn">
          <button class="btn btn-danger" type="submit">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </div>
      </div>
    </div>
  </div>
</form>                       
	</div>

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
				<a href="item-details?id=<%=listing.getId()%>">
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
	<%-- 		Name: <a href="item-details?id=<%=listing.getId()%>"><%=listing.getName()%></a> --%>
	<%-- 		<img src="<%=listing.getImageFilepath()%>" --%>
	<!-- 			style="width: 60px; height: 60px">  -->
	<%--Price: $<%=listing.getPrice()%><br> --%>
	<%--Description: <%=listing.getDescription()%><br> --%>
	<%-- 		<img src="<%=listing.getSeller().imageFilepath()%>" --%>
	<!-- 			style="width: 60px; height: 60px">  -->
	<%-- Seller: <%=listing.getSeller().getName()%><br><br>--%>


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
</html>