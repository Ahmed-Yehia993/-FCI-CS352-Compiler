<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1> Welcome : ${it.name} </h1>
<h1> E-mail  : ${it.email} </h1>
</div>
<br><br><br><br>
<div align="center" style="width: 700px; margin-left: 300px; margin-right: 100px;"  >
<form action="/social/logout" method="get">
<input type="submit" value="sign out" >
</form>
<br>
<form action="/social/preaddfriend" method="get">
<input type="submit" value="add friend" >
</form>
<br>
<form action="/social/preacceptfriend" method="get">
<input type="submit" value="notification" >
</form>
<br>
<form action="/social/showMyfriends" method="get">
<input type="submit" value="Show My Friends" >
</form>
</div>
</body>
</html>