<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
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
		<h1>Enter ID of the group or sender to seen the history of msgs</h1>
		<form action="/social/messages" method="post">
			<input type="submit" value="view"> <input type="text" name="receiverID" />
			<div style="display: inline-block;">
				<input id="single" type="checkbox" name="single" value="single">
				<label for="option">single</label> <input id="group"
					type="checkbox" name="group" value="group"> <label
					for="option">group</label>
			</div>
		</form>
		<br>
		<hr>
		<br>
		<h1>Enter the id of the msg that you seen</h1>
		<form action="/social/seenmsg" method="post">
			<input type="text" name="msgID" /> <input type="submit" value="seen">
		</form>
		<br>
		<hr>
		<br>
		<h1>The Notifications of messages</h1>
		<table cellspacing="10px" cellpadding="5px" border="2px"
			bgcolor="#E8E8E8" style="width: 70%">
			<tr bgcolor="#E8E8E80">
				<td><center>ID</center></td>
				<td><center>GroupID</center></td>
				<td><center>SenderID</center></td>
				<td><center>ReceiverID</center></td>
				<%-- 				<td><center>Timestamp</center></td> --%>
				<td><center>Text</center></td>
				<td><center>seen</center></td>
			</tr>
			<c:forEach items="${it.msgnotificationList}" var="msg">
				<tr>
					<td><center>
							<c:out value="${msg.id}"></c:out>
						</center></td>
					<td><center>
							<c:out value="${msg.groupID}"></c:out>
						</center></td>
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
					<td><center>
							<c:out value="${msg.seen}"></c:out>
						</center></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
