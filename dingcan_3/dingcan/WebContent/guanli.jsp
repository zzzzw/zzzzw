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
<title>������Ʒ</title>
</head>
<body>
<h1 align="center">��Ʒ�б�</h1>
<%
request.setCharacterEncoding("gbk");
String sql="select * from shop";
ResultSet rs=DBbean.getResultSet(sql);
%>
<table border="1" align="center">
<tr>
	<th>��Ʒ���</th>
	<th>��Ʒ����</th>
	<th>��Ʒ�۸�</th>
	<th>��Ʒ���</th>
	<th>���¼ܹ���</th>
</tr>
<%while(rs.next()){%>
<tr>
	<td><%=rs.getString("xuhao") %></td>
	<td><%=rs.getString("mingchen") %></td>
	<td><%=rs.getString("jiege") %></td>
	<td><%=rs.getString("cunhuo") %></td>
	<td><a href='shopservlet?action=delete&xuhao=<%=rs.getString("xuhao") %>' onclick="return confirm('ȷ�Ͻ��˼�¼ɾ����')">ɾ��</a></td>
	<td><a href='update.jsp?action=update&xuhao=<%=rs.getString("xuhao")%>'>�޸�</a></td>
	<%}
       rs.close();%>
</tr>
</table>
<form action="uploadservlet" method="post" enctype="multipart/form-data" name="upload">
<table align=center>
	<tr>
		<td align=center><h1>�ϴ���Ʒ</h1></td>
	</tr>
	<tr>
		<td >
		���<input type="text" name="xuhao" size="10">����<input type="text" name="mingchen" size="20">
		�۸�<input type="text" name="jiege" size="10">���<input type="text" name="cunhuo" size="10"><br>
		����<textarea  name="miaoshu" rows="5" cols="65"></textarea><br>
		��Ʒ״̬ѡ��<input type="radio" name="zhuangtai" value="�ϼ�" checked="checked">������Ʒ<input type="radio" name="zhuangtai" value="�¼�">����ֿ�&nbsp
		�ϴ�ͼƬ<input type="file" name="tupian" size="20">
		</td>
	</tr>
	<tr>
	    <td  align="center"><input value="��ʼ�ϴ�" type="submit"></td>
	</tr>
</table>
</form>
</body>
</html>
