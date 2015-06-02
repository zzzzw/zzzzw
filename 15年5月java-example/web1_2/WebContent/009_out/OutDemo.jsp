<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>out对象实例</title>
</head>
<body>
<%
	//向JSP页面中输出文本
	out.print("明德新民，至于至善");
	out.newLine();
	//输出HTML标签
	out.print("<br>");
%>
缓冲区的大小为：<%=out.getBufferSize() %><br>
缓冲区的可用大小为：<%=out.getRemaining() %><br>
是否为自动清空缓冲区<%=out.isAutoFlush() %><br>
<%
	//输出JavaScript脚本
	out.println("<SCRIPT type=\"text/javascript\">alert(\"测试out对象的使用！\");</SCRIPT>");
%>
</body>
</html>
