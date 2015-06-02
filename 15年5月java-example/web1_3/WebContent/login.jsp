<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form id="loginForm"name="loginForm" action="Validate.jsp"method="post">
  account:<input type="text"/><br>
  password:<input type="password"/><br>
  <input value="login"type="submit">
  <input value="register" type="button" >
  <a href="getPassword.jsp">find your password</a><br>
</form>
</body>
</html>