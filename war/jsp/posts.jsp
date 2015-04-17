<%@page import="com.FCI.SWE.Models.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body background="/jsp/home.jpg">
	<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	margin-left: 33px;
	padding: 0;
	overflow: hidden;
}

li {
	float: left;
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

button:hover, button:active {
	background-color: rgb(201, 48, 44);
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
	width: 120px; padding : 5px 15px;
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
	padding: 5px 15px;
}
.tfbtn {
	margin: 0;
	width: 60px; padding : 5px 15px;
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
	padding: 5px 15px;
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


	<br>
	<br>
	<br>
	
	<div align="center">
		<form action="/social/createpost" method="post">
			<!-- 			<input class="tftextinput" type="text" name="recieverID" size="35">  -->
			<textarea rows="7" cols="70" name="text"
				placeholder="Write what's in your mind"></textarea>
				
			<br> <br> 
			<div style="display: inline-block;">
				<input id="privatee" type="checkbox" name="privatee" value="privatee">
				<label for="option">private</label> 
				<input id="publice" type="checkbox" name="publice" value="privatee"> 
				<label for="option">public </label>&nbsp;&nbsp;
			</div><input class="tfbutton" type="submit"
				value="post">
		</form>
	</div>
	<br>
	<hr>
	<br>

	<div style="border: 1px solid black; width: 600px; margin-left: 366px;">
		<div align="center">
			<c:forEach items="${it.PostsList}" var="post">
			    <c:set var="post_id" value="${post.id}" scope="session" />
				<h3>
					Poster Name:
					<c:out value="${post.ownerID}"></c:out>
				</h3>
				<h5>
					post Time:
					<c:out value="${post.creationTime}"></c:out>
				</h5>
				<p>
					Status :
					<c:out value="${post.text}"></c:out>
				</p>
				<p>
					Likes : <label id="NOL${post.id}"  >${post.numberOFLike}</label>
				</p>
				<p>
					Shares :
					<c:out value="${post.numberOFShare}"></c:out>
				</p>
				<p>
					privacy :
					<c:out value="${post.privacy}"></c:out>
				</p>
				
				<div>

					<form action="/social/likepost" method="post"
						style="display: inline-block;">
						<input type="text" name="post_id" value="${post.id}" hidden>

						<button id="${post.id}" class="tfbtn" onclick=change(${post.id})>
							${post.va}</button>
					</form>
					<script type="text/javascript">
				
				function change(t) {
					vasr = document.getElementById(t).innerHTML ;
					var srt1 = "NOL";
					x = document.getElementById(srt1.concat(t)).innerHTML;
					xx = parseInt(x,10) ;
					if(vasr.toLowerCase().indexOf("like") == 0) {
						document.getElementById(t).innerHTML = 'UnLike';
						xx += 1;
						document.getElementById(srt1.concat(t)).innerHTML = xx;
					} else {
						document.getElementById(t).innerHTML = 'Like';
						xx -= 1;
						document.getElementById(srt1.concat(t)).innerHTML = xx;
					}
				}
				</script>
					<form action="/social/sharepost" method="post"
						style="display: inline-block;">
						<input type="text" name="post_id" value="${post.id}" hidden>
						<input class="tfbtn" type="submit" value="Share" />
					</form>
				</div>
				
				<hr>
			</c:forEach>
		</div>
	</div>
</body>

</html>