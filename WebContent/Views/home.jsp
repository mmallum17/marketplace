<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ex" uri="/WEB-INF/custom-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
				<li class="active"><a href="home">home</a></li>
				<li><a href="items">marketplace</a></li>
				<li><a href="login">log in</a></li>
				<li><a href="signup">sign up</a></li>
			</ul>
		</nav>
	</header>


	<!--  PAGE HEADER: PAGE DESCRIPTION  -->
	<div id="page-description" class="body">
		<h2>
			Welcome to <strong>MavMarket v1.0</strong>
		</h2>
		<p>
			Mav Market is an online retail web application that allows users to
			buy and sell amongst themselves. Users will be able to create
			accounts to track the items they buy and sell on the community
			marketplace. Click <a href="#">here</a> to get started!
		</p>
	</div>

	<!--  CONTENT: THIS IS WHERE PAGE SPECIFIC CONTENT IS TO BE ADDED  -->
	<div id="content" class="body">


		<h2>
			<b>10/17/2018:</b> MavMarket Released
		</h2>
		<p>MavMarket v1.0 is released. Features include:</p>
		<br>
		<h2>
			<b>9/25/2018:</b> MavMarket Design Complete
		</h2>
		<p>MavMarket design is completed. Features include:</p>
		<br>
		<h2>
			<b>9/10/2018:</b> Los Tres Muchachos Formed
		</h2>
		<p>The creators of the MavMarket online retail web application
			assembled as a team to complete the project</p>

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
</html>