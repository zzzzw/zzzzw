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
<title>�����ֻ�������վ���ﳵ����</title>
</head>
<body>
<%String sql="select * from cart ";
ResultSet rs= DBbean.getResultSet(sql);
double e=0;
double f=0;
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
<%while(rs.next()){%>
<tr><td><%=rs.getString("xuhao")%></td><td><%=rs.getString("mingchen")%></td><td><%=rs.getString("jiege")%></td><td><a style="text-decoration:none" href='shopservlet?action=jian&xuhao=<%=rs.getString("xuhao")%>'>-</a>
<input type="text" name="shuliang" id="shuliang" value=<%=rs.getString("shuliang")%> size="2">
<a style="text-decoration:none" href='shopservlet?action=jia&xuhao=<%=rs.getString("xuhao")%>'>+</a></td>
<% e=Double.parseDouble(rs.getString("jiege"))*Double.parseDouble(rs.getString("shuliang"));
f=f+e;%>
<td><%=e%></td><td><a href='shopservlet?action=delete2&xuhao=<%=rs.getString("xuhao")%>'onclick="return confirm('ȷ��������Ʒɾ��?')">ɾ��</a></td></tr>
<%} %>
</table>
<%rs.close(); %>
<h4 >�ܼ�<%=f %></h4>
<input type="button" name="qingkong" id="qingkong" value="���" onclick="qingkong()"><input type="button" name="goumai" value="����">
<h3>�ջ���ַ</h3>
<table border="1">
<tr><td>ʡ��</td><td><input type="text" name="shengfen"></td></tr>
<tr><td>��ϸ��ַ</td><td><textarea  name="miaoshu" rows="3" cols="50"></textarea></td></tr>
<tr><td>��������</td><td><input type="text" name="shengfen"></td></tr>
<tr><td>�ջ������� </td><td><input type="text" name="shengfen"></td></tr>
<tr><td>�ֻ�����</td><td><input type="text" name="shengfen"></td></tr>
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