<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>

<title>jsp:include example</title>
</head>
<body>
this is the thing about include.jsp:
---------------------------------------------<br>
<jsp:include page="include.jsp" flush="true"/>
<br>
this is the thing of the main file 
-----------------------------------------------<br>
check the usage of the include action's mark
<!-- we will use two form to use the date.jsp -->
</body>
</html>