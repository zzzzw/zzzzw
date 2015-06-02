<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>to confirm the target of session</title>
</head>
<body>
<%
   String name=request.getParameter("abc");
   String pwd=request.getParameter("efg");
   if(name.equals("sa")&&pwd.equals("sasasa"))
   {
	   session.setAttribute("abc",name);
	   session.setAttribute("efg",pwd);
	   out.print("welcome to login in the system!"+((String)session.getAttribute("abc")));
   }
   else
   {
	   out.print("<script type=\"text/javascript\">alert('sorry,your name or password is wrong.try again please');history.go(-1);</script>");
   }
%>
</body>
</html>