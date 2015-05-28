<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ page import="com.mysql.jdbc.Driver" %> 
<%@ page import="java.sql.*" %>
<%@ page import="bean.DBbean" %>
<jsp:useBean id="DBbean" scope="page" class="bean.DBbean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>修改商品</title>
</head>
<body>
<%
request.setCharacterEncoding("gbk");
String sql="select *from shop where xuhao='";
String a=request.getParameter("xuhao");
sql=sql+a+"'";
ResultSet rs=DBbean.getResultSet(sql);
while(rs.next()){
%>
<form action="shopservlet?action=update" method="post">
<table align=center>
   <tr>
	    <td align=center><h1>修改商品</h1></td>
   </tr>
   <tr>
   	<td>
   	序号<input type="text" name="xuhao" size="10" value="<%=rs.getString("xuhao") %>">
   	名称<input type="text" name="mingchen" size="20" value="<%=rs.getString("mingchen") %>">
   	价格<input type="text" name="jiege" size="10" value="<%=rs.getString("jiege") %>" >
   	存货<input type="text" name="cunhuo" size="10" value="<%=rs.getString("cunhuo") %>"><br>
   	描述<textarea name="miaoshu" row="" cols="65"><%=rs.getString("miaoshu") %></textarea><br>
   	商品状态选择：<input type="radio" name="zhuangtai" value="上架" checked="checked">发布商品<input type="radio" name="zhuangtai" value="下架">存入仓库<br>
             当前图片<br><img alt="相片" src="<%=rs.getString("tupian") %>">
       <!--   
       <img src="<%=rs.getString("tupian") %>"  width="140" height="105">
        -->    
    <input type="hidden" name="tupian" value="<%=rs.getString("tupian")%>" >
	</td>
  </tr>
  <tr>
      <td align="center"><input type="submit" value="修改"/></td>
  </tr>
   	   
</table>
<% }rs.close(); %>
</form>

</body>
</html>