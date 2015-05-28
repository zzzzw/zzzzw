<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.DBbean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>三星手机购物网站</title>
<style type="text/css">
div#one{}
div#two{ width:auto; height:20px;background-color:#FAEBD7;text-align:right;}
div#three{ width:auto; height:54px;background-color:#FFFFFF;}
div#four{ width:auto; height:20px;background-color:#FAEBD7;text-align:left;}
div#six{width:auto;background-color:#000000;text-align:center;}
div#five{float:center;text-align:center;}
div#seven{height:50px;background-color:#FFFFFF;}
div#foot{width:auto; background-color:#FFFFFF;clear:both;text-align:center;}
</style>
</head>
<body>
<div id="one" ></div>
<div id="two"><a href="cart.jsp" style="text-decoration:none">购物车</a></div>
<div id="three"><img src="upload/logo.jpg"></div>
<div id="four"><a  href='home.jsp'>首页</a></div>
<div id="six"><a href='buy.jsp?xuhao=7'><img src="upload/top.jpg" border="0" /></a></div>
<div id="seven"><img src="upload/top2.jpg"></div>
<div id="five">
<%
request.setCharacterEncoding("gbk");
String sql="select * from shop where zhuangtai='上架'";
ResultSet rs= DBbean.getResultSet(sql);
int n=0;
%>
<table width="1200" align="center">
<% while(rs.next()){if(n%4==0){ %>
<tr>
<% } %>
<% String xuhao=rs.getString("xuhao"); %>
<td><a href="buy.jsp?xuhao=<%=rs.getString("xuhao")%>"><img src="<%=rs.getString("tupian") %>" ></a><br>价格：<%=rs.getString("jiege")%></td>
<% n++;if(n%4==0){%>
</tr>
<% } %>
<% } rs.close(); %>
</table>
</div>
<div id="foot"><img src="upload/foot.jpg" ></div>
</body>
</html>