<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    <jsp:useBean id="List" class="com.henu.service.List" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<table align=center>
<tr><td>�ϴ��ɹ������� </td><td>&nbsp&nbsp����ļ�˵��������</td><tr>
</table>
<jsp:getProperty property="list" name="List"/>
<table align=center>
<br>
<tr><td><a href='fileUpload.jsp'>�ϴ��ļ�</a></td><tr>
</table>
</body>
</html>