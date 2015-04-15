<%@page import="javax.mail.Session"%>
<%@page import="com.FCI.SWE.Controller.UserController"%>
<%@page import="com.FCI.SWE.Models.User"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>HOME</title>
<!-- Bootstrap -->
<link href="bootstrap.min.css" rel="stylesheet">
</head>
<body background="/jsp/home.jpg">

	<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	margin-left: 33;
	padding: 0;
	overflow: hidden;
}

li {
	float: left;
}

#tfheader {
	background-color: #c3dfef;
}

.tftextinput {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	border: 1px solid #0076a3;
	border-right: 0px;
	border-top-left-radius: 5px 5px;
	border-bottom-left-radius: 5px 5px;
}

.tfbutton {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	border: solid 1px #0076a3;
	border-right: 0px;
	color: #ffffff;
	background: #0095cd;
	background: -webkit-gradient(linear, left top, left bottom, from(#00adee),
		to(#0078a5));
	background: -moz-linear-gradient(top, #00adee, #0078a5);
	border-top-right-radius: 5px 5px;
	border-bottom-right-radius: 5px 5px;
}

.tfbutton:hover {
	text-decoration: none;
	background: #007ead;
	background: -webkit-gradient(linear, left top, left bottom, from(#0095cc),
		to(#00678e));
	background: -moz-linear-gradient(top, #0095cc, #00678e);
}
/* Fixes submit button height problem in Firefox */
.tfbutton::-moz-focus-inner {
	border: 0;
}

button, visited {
	display: block;
	width: 250px;
	font-weight: bold;
	color: #ffffff;
	background: #0095cd;
	text-align: center;
	padding: 10px;
	text-decoration: none;
	text-transform: uppercase;
}

.head1, .head2, .head3 {
	float: left;
}

button:hover, button:active {
	background-color: rgb(201, 48, 44);
}
</style>

	<ul>
		<li><form action="/social/preaddfriend" method="post">
				<button>add friend</button>
			</form></li>
		<li><form action="/social/preacceptfriend" method="post">
				<button>Friends notification</button>
			</form></li>
		<li><form action="/social/msgnotification" method="post">
				<button>msg notification</button>
			</form></li>
		<li><form action="/social/showMyfriends" method="post">
				<button>Show My Friends</button>
			</form></li>
		<li><form action="/social/logout" method="get">
				<button>sign out</button>
			</form></li>
	</ul>
	<div>

		<div style="margin-left: 33px;" class="head1">
			<form action="/social/timeline" method="post">
				<button><% out.println(request.getSession().getAttribute("current_user_name").toString() + " TIMELINE"); %></button>
			</form>
			<div style="border: 1px solid black; width: 245px;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img alt="user"
					src="/jsp/images.jpg">

				<h3 style="margin-left: 80px;">${it.name}</h3>
				<h3 style="margin-left: 80px;">${it.email}</h3>
			</div>
			<br>
			<form id="tfnewsearch" method="post" action="/social/searchtag">
				<input type="text" placeholder="search Hashtag" class="tftextinput" name="tagname"
					size="16" maxlength="120"><input type="submit"
					value="search" class="tfbutton">
			</form>
			<form id="tfnewsearch" method="post" action="/social/searchaboutpage">
				<input type="text" placeholder="search pages" class="tftextinput" name="pagename"
					size="16" maxlength="120"><input type="submit"
					value="search" class="tfbutton">
			</form>
			<form action="/social/mypages" method="post">
				<button>Create Page</button>
			</form>
			<form action="/social/posts" method="post">
				<button>Take a Tour</button>
			</form>
		</div>
		<div class="head2" style=" margin-left: 10px; border-left: 1px solid #000; height: 600px;"></div>
		<div class="head3">
<!-- 			here timeline -->
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>