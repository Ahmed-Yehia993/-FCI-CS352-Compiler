<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<table cellspacing="5px" cellpadding="5px" border="2px" bgcolor="#E8E8E8" style="width:70%">
<tr bgcolor="#E8E8E80">
   <td><center>ID</center></td>
   <td><center>NAME</center></td>
   <td><center>E-MAIL</center></td>
</tr>
<c:forEach items="${it.FriendsList}" var="user" >
   <tr>
   <td><center><c:out value="${user.id}"></c:out></center></td>
   <td><center><c:out value="${user.name}"></c:out></center></td>
   <td><center><c:out value="${user.email}"></c:out></center></td>
   </tr>
</c:forEach>
</table>

<br><br>
<h1>Enter the id of friend to unfriend </h1>
<form action="/social/unfriend"" method="post"> 
  <input type="text" name="recieverID" />
  <input type="submit" value="unfriend">
</form>

<br><br>
<h1>Enter the id of friend to send message </h1>
<form action="/social/sendmsg"" method="post"> 
  <input type="text" name="recieverID" />
  <input type="submit" value="send">
  <br><br>
  <textarea rows="10" cols="50" name="text"></textarea>
</form>

</div>

</body>
</html>