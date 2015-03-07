<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<h1>Enter the id of the friend that you want to add </h1>
 ${it}
<c:forEach items="${it}" var="entry" >
</c:forEach>

<form action="/social/addfriend" method="post"> 
  <input type="text" name="recieverID" />
  <input type="submit" value="send">
</form>
	<!-- 
	 ${it.size}  ${it.name0}  ${it.email0}  ${it.id0}

	hello world ${it.size}
	${it}
-->
 





</body>

</html>