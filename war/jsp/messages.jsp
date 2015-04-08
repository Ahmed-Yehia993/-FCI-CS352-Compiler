<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
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
		<table  cellspacing="10px cellpadding="5px" border="2px"
			bgcolor="#E8E8E8" style="width: 70%">
			<tr bgcolor="#33FF00">
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
