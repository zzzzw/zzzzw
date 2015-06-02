<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>

<title>calculate.jsp</title>
</head>
<body>
<%!
int sum(int opt1,int opt2)
{
	return (opt1+opt2);
}
int sumVal=0;
%>

<%
        // use the request.getparamter() to gain the result of <jsp.param> 
     int opt1=Integer.parseInt(request.getParameter("opt1"));
       int opt2 = Integer.parseInt(request.getParameter("opt2"));
       sumVal=sum(opt1, opt2);
       out.print(opt1 +"+"+opt2+"="+sumVal);
%>
</body>
</html>