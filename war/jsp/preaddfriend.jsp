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
ul {list-style-type: none;margin: 0;margin-left: 33px;padding: 0;overflow: hidden;}
li {float: left;}
button, visited {display: block;width: 250px;font-weight: bold;color: #FFFFFF;background-color: #190707;text-align: center;padding: 10px;text-decoration: none;text-transform: uppercase;}
button:hover, button:active { background-color: rgb(201, 48, 44);}
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
		<h1>Enter the id of the friend that you want to add</h1>
		<form action="/social/addfriend" method="post">
			<input type="text" name="recieverID" /> <input type="submit"
				value="send">
		</form>
		<br> <br>
		<table cellspacing="5px" cellpadding="5px" border="2px"
			bgcolor="#E8E8E8" style="width: 70%">
			<tr bgcolor="#E8E8E80">
				<td><center>ID</center></td>
				<td><center>NAME</center></td>
				<td><center>E-MAIL</center></td>
			</tr>
			<c:forEach items="${it.usersList}" var="user">
				<tr>
					<td><center>
							<c:out value="${user.id}"></c:out>
						</center></td>
					<td><center>
							<c:out value="${user.name}"></c:out>
						</center></td>
					<td><center>
							<c:out value="${user.email}"></c:out>
						</center></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>