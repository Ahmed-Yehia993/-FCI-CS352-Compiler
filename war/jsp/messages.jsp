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
	<div align="center">
		<h1>Enter the id of friend to send message</h1>
		<form action="/social/sendmsg" method="post">
			<input type="text" name="recieverID" /> <input type="submit"
				value="send"> <br> <br>
			<textarea rows="10" cols="50" name="text"></textarea>
		</form>
		<br>
		<hr>
		<br>
		<h1>The History of messages between you and him</h1>
		<table cellspacing="10px cellpadding=" 5px" border="2px"
			bgcolor="#E8E8E8" style="width: 70%">
			<tr bgcolor="#0095cd">
				<%-- 				<td><center>GroupID</center></td> --%>
				<td><center>Sender</center></td>
				<td><center>Receiver</center></td>
				<%-- 				<td><center>Timestamp</center></td> --%>
				<td><center>Text</center></td>
			</tr>
			<c:forEach items="${it.messagesList}" var="msg">
				<tr>
					<%-- 					<td><center> --%>
					<%-- 							<c:out value="${msg.groupID}"></c:out> --%>
					<%-- 						</center></td> --%>
					<td><center>
							<c:out value="${msg.senderID}"></c:out>
						</center></td>
					<td><center>
							<c:out value="${msg.receiverID}"></c:out>
						</center></td>
					<td><center>
							<c:out value="${msg.text}"></c:out>
						</center></td>
					<%-- 					<td><center> --%>
					<%-- 							<c:out value="${msg.times}"></c:out> --%>
					<%-- 						</center></td> --%>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
