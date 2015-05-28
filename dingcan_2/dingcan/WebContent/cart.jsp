<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.DBbean"%>
<jsp:useBean id="DBbean" scope="page" class="bean.DBbean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<style type="text/css">
div#one{}
div#two{ width:auto; height:20px;background-color:#FAEBD7;text-align:right;}
div#three{ width:auto; height:54px;background-color:#FFFFFF;}
div#four{ width:auto; height:20px;background-color:#FAEBD7;text-align:left;}
div#five{text-align:center;float:center;text-align:left;}
div#six{ width:auto; height:60px;background-color:#FFFFFF;}
div#foot{width:auto; background-color:#FFFFFF;clear:both;text-align:center;}
</style>
<script>   
function qingkong(){
	window.location.href="shopservlet?&action=qingkong";
}
</script>   
<title>三星手机购物网站购物车界面</title>
</head>
<body>
<%String sql="select * from cart ";
ResultSet rs= DBbean.getResultSet(sql);
double e=0;
double f=0;
%>
<div id="one">
<div id="two">
<a style="text-decoration:none" href='cart.jsp'>购物车</a>
</div>
<div id="three">
<img src="upload/logo.jpg">
</div>
<div id="four">
<a style="text-decoration:none" href='home.jsp'>首页</a>-购买
</div>
<div id="six">
</div>
<div id="five">
<h3>订单信息</h3>
<table border="1" >
<tr><td>商品序号</td><td>商品名称</td><td>商品价格</td><td>数量</td><td>总价</td></tr>
<%while(rs.next()){%>
<tr><td><%=rs.getString("xuhao")%></td><td><%=rs.getString("mingchen")%></td><td><%=rs.getString("jiege")%></td><td><a style="text-decoration:none" href='shopservlet?action=jian&xuhao=<%=rs.getString("xuhao")%>'>-</a>
<input type="text" name="shuliang" id="shuliang" value=<%=rs.getString("shuliang")%> size="2">
<a style="text-decoration:none" href='shopservlet?action=jia&xuhao=<%=rs.getString("xuhao")%>'>+</a></td>
<% e=Double.parseDouble(rs.getString("jiege"))*Double.parseDouble(rs.getString("shuliang"));
f=f+e;%>
<td><%=e%></td><td><a href='shopservlet?action=delete2&xuhao=<%=rs.getString("xuhao")%>'onclick="return confirm('确定将此商品删除?')">删除</a></td></tr>
<%} %>
</table>
<%rs.close(); %>
<h4 >总价<%=f %></h4>
<input type="button" name="qingkong" id="qingkong" value="清空" onclick="qingkong()"><input type="button" name="goumai" value="购买">
<h3>收货地址</h3>
<table border="1">
<tr><td>省份</td><td><input type="text" name="shengfen"></td></tr>
<tr><td>详细地址</td><td><textarea  name="miaoshu" rows="3" cols="50"></textarea></td></tr>
<tr><td>邮政编码</td><td><input type="text" name="shengfen"></td></tr>
<tr><td>收货人姓名 </td><td><input type="text" name="shengfen"></td></tr>
<tr><td>手机号码</td><td><input type="text" name="shengfen"></td></tr>
</table>
</div>
<div id="six">
</div>
<div id="foot">
<img src="upload/foot.jpg">
</div>
</div>
</body>
</html>