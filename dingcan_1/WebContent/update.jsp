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
<title>�޸���Ʒ</title>
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
	    <td align=center><h1>�޸���Ʒ</h1></td>
   </tr>
   <tr>
   	<td>
   	���<input type="text" name="xuhao" size="10" value="<%=rs.getString("xuhao") %>">
   	����<input type="text" name="mingchen" size="20" value="<%=rs.getString("mingchen") %>">
   	�۸�<input type="text" name="jiege" size="10" value="<%=rs.getString("jiege") %>" >
   	���<input type="text" name="cunhuo" size="10" value="<%=rs.getString("cunhuo") %>"><br>
   	����<textarea name="miaoshu" row="" cols="65"><%=rs.getString("miaoshu") %></textarea><br>
   	��Ʒ״̬ѡ��<input type="radio" name="zhuangtai" value="�ϼ�" checked="checked">������Ʒ<input type="radio" name="zhuangtai" value="�¼�">����ֿ�<br>
             ��ǰͼƬ<br><img alt="��Ƭ" src="<%=rs.getString("tupian") %>">
       <!--   
       <img src="<%=rs.getString("tupian") %>"  width="140" height="105">
        -->    
    <input type="hidden" name="tupian" value="<%=rs.getString("tupian")%>" >
	</td>
  </tr>
  <tr>
      <td align="center"><input type="submit" value="�޸�"/></td>
  </tr>
   	   
</table>
<% }rs.close(); %>
</form>

</body>
</html>