<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="ExceptionDemo.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Throw Error</title>
</head>
<body>
<%
int []array={1,2,3,4,5};
for(int i=0;i<6;i++)
   {
     out.print("array["+i+"]="+array[i]);
     out.newLine();
    }
 %>


</body>
</html>