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
function dojian(){
	  var a=document.getElementById("shuliang").value;
	  var b=document.getElementById("jiage").value;
	  if(a==1){
		  document.getElementById("shuliang").value=1;
		  document.getElementById("zongjia").value=b;
		  }
	  else{
	      document.getElementById("shuliang").value=a-1;
	      document.getElementById("zongjia").value=b*(a-1);
	      }
}
function dojia(){
	  var a=document.getElementById("shuliang").value;
	  var b=document.getElementById("jiage").value;
	  document.getElementById("shuliang").value=parseFloat(a)+1;
	  document.getElementById("zongjia").value=b*(parseFloat(a)+1);
} 
</script>   
<title>�����ֻ�������վ���˽���</title>
</head>
<body>
<%request.setCharacterEncoding("gbk");
String a=request.getParameter("xuhao");
String b=request.getParameter("mingchen");
b=new String(b.getBytes("ISO-8859-1"),"gbk");
String c=request.getParameter("jiage");
String d=request.getParameter("shuliang");
double e=Double.parseDouble(c)*Double.parseDouble(d);
%>
<div id="one">
<div id="two">
<a style="text-decoration:none" href='cart.jsp'>���ﳵ</a>
</div>
<div id="three">
<img src="upload/logo.jpg">
</div>
<div id="four">
<a style="text-decoration:none" href='home.jsp'>��ҳ</a>-����
</div>
<div id="six">
</div>
<div id="five">
<h3>������Ϣ</h3>
<table border="1" >
<tr><td>��Ʒ���</td><td>��Ʒ����</td><td>��Ʒ�۸�</td><td>����</td><td>�ܼ�</td></tr>
<tr><td><%=a%></td><td><%=b%></td><td><input type="button" name="jiage" id="jiage"value="<%=c%>"></td><td><input type="button" name="jian" value="-" onclick="dojian()"><input type="text" name="shuliang" id="shuliang" value=<%=d%> size="2"><input type="button" name="jia" value="+" onclick="dojia()"></td>
<td><input type="button" name="zongjia" id="zongjia" value="<%=e%>"></td></tr>
</table>
<h3>�ջ���ַ</h3>
<table border="1" >
<tr><td>ʡ��</td><td><input type="text" name="shengfen"></td></tr>
<tr><td>��ϸ��ַ</td><td><textarea  name="miaoshu" rows="3" cols="50"></textarea></td></tr>
<tr><td>��������</td><td><input type="text" name="shengfen"></td></tr>
<tr><td>�ջ������� </td><td><input type="text" name="shengfen"></td></tr>
<tr><td>�ֻ�����</td><td><input type="text" name="shengfen"></td></tr>
</table>
<input type="button" name="goumai" value="����">
</div>
<div id="six">
</div>
<div id="foot">
<img src="upload/foot.jpg">
</div>
</div>
</body>
</html>