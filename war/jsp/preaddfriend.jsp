<<<<<<< HEAD
<%@page import="com.FCI.SWE.Models.User"%>
=======
>>>>>>> 8f76aa76f075412c0bcaf1c97799b8ae0a9d0f9a
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h1>Enter the id of the friend that you want to add </h1>
<form action="/social/addfriend" method="post"> 
  <input type="text" name="recieverID" />
  <input type="submit" value="send">
</form>
<br><br>
<table cellspacing="5px" cellpadding="5px" border="2px" bgcolor="#E8E8E8" style="width:70%">
<tr bgcolor="#E8E8E80">
   <td><center>ID</center></td>
   <td><center>NAME</center></td>
   <td><center>E-MAIL</center></td>
<<<<<<< HEAD
   
=======
>>>>>>> 8f76aa76f075412c0bcaf1c97799b8ae0a9d0f9a
</tr>
<c:forEach items="${it.usersList}" var="user" >
   <tr>
   <td><center><c:out value="${user.id}"></c:out></center></td>
   <td><center><c:out value="${user.name}"></c:out></center></td>
   <td><center><c:out value="${user.email}"></c:out></center></td>
   </tr>
<<<<<<< HEAD
  
</c:forEach>

=======
</c:forEach>
>>>>>>> 8f76aa76f075412c0bcaf1c97799b8ae0a9d0f9a
</table>
</div>
</body>

</html>