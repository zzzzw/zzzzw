<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import ="java.util.Date"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>how to use the page</title>
</head>
<body>
<%Date date=new Date(); %>
now the system time is:<%=date %>
<br>
<%
for(int i=1;i<=6;i++)
	out.print("print\t"+i+"times<br>");
%>

</body>
</html>