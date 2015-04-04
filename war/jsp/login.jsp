<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<div align="center" style=" margin: 200px;"  >
<table cellpadding="5" bgcolor="#E8E8E8" > 
<form action="/social/home" method="POST">
   <tr>
   <td><center><i><b>Name:</b></i></center></td>
   <td><center><input type="text" name="uname" /></center></td>
   </tr>
   <tr>
   <td><center><i><b>Password:</b></i></center></td>
   <td><center><input type="password" name="password" /></center></td>
   </tr>
   <tr>
   <td colspan="4"><center><input type="submit" value="Login"></center></td>
   </tr>
</form>
</table>
</div>
</body>
</html>