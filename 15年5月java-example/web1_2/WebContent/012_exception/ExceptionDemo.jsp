<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>the target of exception</title>
</head>
<body>
<%
  out.println("throwError.jsp happen an error,the concrete reason is:");
  out.println("-------------------------------------------------------");
  out.println("exception.getMessage()");
%>
</body>
</html>