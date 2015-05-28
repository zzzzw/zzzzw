<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.DBbean" %>
<jsp:useBean id="DBbean" scope="page" class="bean.DBbean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>管理商品</title>
</head>
<body>
<h1 align="center">商品列表</h1>
<%
request.setCharacterEncoding("gbk");
String sql="select * from shop";
ResultSet rs=DBbean.getResultSet(sql);
%>
<table border="1" align="center">
<tr>
	<th>商品序号</th>
	<th>商品名称</th>
	<th>商品价格</th>
	<th>商品存货</th>
	<th>上下架管理</th>
</tr>
<%while(rs.next()){%>
<tr>
	<td><%=rs.getString("xuhao") %></td>
	<td><%=rs.getString("mingchen") %></td>
	<td><%=rs.getString("jiege") %></td>
	<td><%=rs.getString("cunhuo") %></td>
	<td><a href='shopservlet?action=delete&xuhao=<%=rs.getString("xuhao") %>' onclick="return confirm('确认将此记录删除？')">删除</a></td>
	<td><a href='update.jsp?action=update&xuhao=<%=rs.getString("xuhao")%>'>修改</a></td>
	<%}
       rs.close();%>
</tr>
</table>
<form action="uploadservlet" method="post" enctype="multipart/form-data" name="upload">
<table align=center>
	<tr>
		<td align=center><h1>上传商品</h1></td>
	</tr>
	<tr>
		<td >
		序号<input type="text" name="xuhao" size="10">名称<input type="text" name="mingchen" size="20">
		价格<input type="text" name="jiege" size="10">存货<input type="text" name="cunhuo" size="10"><br>
		描述<textarea  name="miaoshu" rows="5" cols="65"></textarea><br>
		商品状态选择：<input type="radio" name="zhuangtai" value="上架" checked="checked">发布商品<input type="radio" name="zhuangtai" value="下架">存入仓库&nbsp
		上传图片<input type="file" name="tupian" size="20">
		</td>
	</tr>
	<tr>
	    <td  align="center"><input value="开始上传" type="submit"></td>
	</tr>
</table>
</form>
</body>
</html>
