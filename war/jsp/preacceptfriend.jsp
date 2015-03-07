<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<h1>Enter the id of the friend that you want to accept </h1>
  ${it}
<form action="/social/acceptfriend" method="post"> 
  <input type="text" name="recieverID" />
  <input type="submit" value="Accept">
</form>
<br>
</body>
</html>
