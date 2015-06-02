<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>

<title>check the param action mark</title>
</head>
<body>
check the usage of the param action mark ,this is the include of calculate:<br>
<!-- send two mark to calculate.jso -->
<jsp:include page="calculate.jsp">
   <jsp:param name="opt1" value="50"/>
   <jsp:param name="opt2" value="100"/>
</jsp:include>
</body>
</html>