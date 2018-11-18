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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		String[] Name = new String[100];	
		int[] Price = new int[100];
		String[] Description = new String[100];	
		String[] Image = new String[100];
// 		String[] Location = new String[100];
				ArrayList<Listing> currentListings = (ArrayList<Listing>) request.getAttribute("listings");
			for (int i = 0; i < currentListings.size(); i++) {
				Listing listing = currentListings.get(i);
                Name[i] = listing.getName();		
				Price[i] = listing.getPrice();
// 				Location[i] = listing.getLocation();
				Description[i] = listing.getDescription();
				Image[i] = listing.getImageFilepath();
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
		
			
		
<!-- 	</div> -->
<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-danger">
        <div class="panel-heading mypanel-heading"><%=Name[0]%></div>
        <div class="panel-body"><img src=<%=Image[0]%> class="img-responsive" style="width:100%; height:200px" alt="Image"></div>
        <div class="panel-footer mypanel-footer">$<%=Price[0]%><br>Location<br> 
		</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading mypanel-heading"><%=Name[1]%></div>
        <div class="panel-body"><img src=<%=Image[1]%> class="img-responsive" style="width:100%; height:200px" alt="Image"></div>
        <div class="panel-footer mypanel-footer">$<%=Price[1]%><br>Location</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading mypanel-heading"><%=Name[2]%></div>
        <div class="panel-body"><img src=<%=Image[2]%> class="img-responsive" style="width:100%; height:200px" alt="Image"></div>
        <div class="panel-footer mypanel-footer">$<%=Price[2]%><br>Location</div>
      </div>
    </div>
  </div>
</div><br>

<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-danger">
        <div class="panel-heading mypanel-heading"><%=Name[3]%></div>
        <div class="panel-body"><img src=<%=Image[3]%> style="width:100%; height:200px" alt="Image"></div>
        <div class="panel-footer mypanel-footer">$<%=Price[3]%><br>Location</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading mypanel-heading"><%=Name[4]%></div>
        <div class="panel-body"><img src=<%=Image[4]%> class="img-responsive" style="width:100%; height:200px" alt="Image"></div>
        <div class="panel-footer mypanel-footer">$<%=Price[4]%><br>Location</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading mypanel-heading"><%=Name[5]%></div>
        <div class="panel-body"><img src=<%=Image[5]%> class="img-responsive" style="width:100%; height:200px" alt="Image"></div>
        <div class="panel-footer mypanel-footer">$<%=Price[5]%><br>Location</div>
      </div>
    </div>
  </div>
</div><br>

<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-danger">
        <div class="panel-heading mypanel-heading"><%=Name[6]%></div>
        <div class="panel-body"><img src=<%=Image[6]%> class="img-responsive" style="width:100%; height:200px" alt="Image"></div>
        <div class="panel-footer mypanel-footer">$<%=Price[6]%><br>Location<br> 
		</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading mypanel-heading"><%=Name[7]%></div>
        <div class="panel-body"><img src=<%=Image[7]%> class="img-responsive" style="width:100%; height:200px" alt="Image"></div>
        <div class="panel-footer mypanel-footer">$<%=Price[7]%><br>Location</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading mypanel-heading"><%=Name[8]%></div>
        <div class="panel-body"><img src=<%=Image[8]%> class="img-responsive" style="width:100%; height:200px" alt="Image"></div>
        <div class="panel-footer mypanel-footer">$<%=Price[8]%><br>Location</div>
      </div>
    </div>
  </div>
</div><br><br>
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
</html>