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
<body>
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
	<%
		String like = request.getSession().getAttribute("like").toString();
		if (like.equals("0")) {
	%>
	<div align="center">
		<form action="/social/likepage" method="post">
			<input class="tfbutton" type="submit" value="Like this page">
		</form>
	</div>
	<br>
	<hr>
	<br>
	<%
		}
	%>

	<%
		String owner = request.getSession().getAttribute("owner")
				.toString();
		if (owner.equals("1")) {
	%>
	<div align="center">
		<form action="/social/pagepost" method="post">
			<!-- 			<input class="tftextinput" type="text" name="recieverID" size="35">  -->
			<textarea rows="10" cols="50" name="text"
				placeholder="Write what's in your mind"></textarea>
			<br> <br> <input class="tfbutton" type="submit"
				value="post">
		</form>
	</div>
	<br>
	<hr>
	<br>
	<%
		}
	%>

	<div style="border: 1px solid black; width: 600px; margin-left: 400px;">
		<div align="center">
			<c:forEach items="${it.PagePostsList}" var="page">
				<h3>
					page Name:
					<%
					out.println(request.getSession().getAttribute(
								"current_page_name"));
				%>
				</h3>
				<h5>
					post Time:
					<c:out value="${page.creationTime}"></c:out>
				</h5>
				<p>
					Status :
					<c:out value="${page.text}"></c:out>
				</p>
				<hr>
				<%-- 					<td><center> --%>
				<%-- 							<c:out value="${page.numberOFLike}"></c:out> --%>
				<%-- 						</center></td> --%>
				<!-- 				</tr> -->
			</c:forEach>
		</div>
	</div>
</body>

</html>