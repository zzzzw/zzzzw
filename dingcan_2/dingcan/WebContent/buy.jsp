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
<style type="text/css">
div#one{}
div#two{ width:auto; height:20px;background-color:#FAEBD7; text-align:right;}
div#three{width:auto;height:54px;background-color:#FFFFFF;}
div#four{width:auto;height:20px;background-color:#FAEBD7;text-align:left;}
div#five{text-align:center;float:center;text-align:left;}
div#six{width:auto;height:60px;blackground-color:#FFFFFF;}
dv#foot{width:auto; background-color:#FFFFFF;clear:both;text-align:center;}
</style>
<script>
function dojian(){
	  var a=document.getElementById("shuliang").value;
	  if(a==1){
		  document.getElementById("shuliang").value=1;
		  }
	  else{
	      document.getElementById("shuliang").value=a-1;
	      }
}
function dojia(){
	  var a=document.getElementById("shuliang").value;
	  document.getElementById("shuliang").value=parseFloat(a)+1;
}
function buy(){
	  var a=document.getElementById("xuhao").value;
	  var b=document.getElementById("mingchen").value;
	  var c=document.getElementById("jiage").value;
	  var d=document.getElementById("shuliang").value;
	  window.location.href="buy2.jsp?xuhao="+a+"&mingchen="+b+"&jiage="+c+"&shuliang="+d;
}
function cart(){
	  var a=document.getElementById("xuhao").value;
	  var b=document.getElementById("mingchen").value;
	  var c=document.getElementById("jiage").value;
	  var d=document.getElementById("shuliang").value;
	  window.location.href="shopservlet?action=cart&xuhao="+a+"&mingchen="+b+"&jiage="+c+"&shuliang="+d;
}
</script>
<title>三星手机购物网站购买界面</title>
</head>
<body>
<%request.setCharacterEncoding("gbk");
String a=request.getParameter("xuhao");
String sql="select * from shop where xuhao='"+a+"'";
ResultSet rs=DBbean.getResultSet(sql);%>
<div id="one">
<div id="two">
<a style="text-decoration:none" href='cart.jsp'>购物车</a>
</div>
<div id="three"><img src="upload/logo.jpg"></div>
<div id="four"><a href="home.jsp" style="text-decoration:none">首页</a>-宝贝详情</div>
<div id="six"></div>
<div id="five">
<table align="center">
<%while(rs.next()){ %>
<tr><td><img src="<%=rs.getString("tupian") %>">
<input type="hidden" name="xuhao" value="<%=rs.getString("xuhao")%>" id="xuhao">
<input type="hidden" name="mingchen" value="<%=rs.getString("mingchen")%>" id="mingchen">
<input type="hidden" name="jiage" value="<%=rs.getString("jiege")%>" id="jiage">
<br>
<td><%=rs.getString("miaoshu")%><br>
价格：<%=rs.getString("jiege")%><br>
存货：<%=rs.getString("cunhuo")%><br>
运费：包邮<br>
数量：<input type="button" name="jian" value="-" onclick="dojian()"><input type="text" name="shuliang" id="shuliang" value=1 size="2"><input type="button" name="jia" value="+" onclick="dojia()"><br>
<a href='#' onclick="buy()"><img src="upload/buy.png"></a>
<a href='#' onclick="cart()"><img src="upload/cart.png"></a><br>
承诺：七天无理由退换货<br>
支付：支付宝     网上银行<br>
</td></tr>
<%}rs.close();%>
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