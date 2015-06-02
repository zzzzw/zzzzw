<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.sql.*"
    errorPage="../inc/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>validate.jsp</title>
</head>
<body>
<% 
 String User=request.getParameter("text");
 String Pwd=request.getParameter("password");
 
 Connection conn=null;
 String uri="jdbc:mysql://localhost:3306/newsdb";
 //driver for the driver and built the connection
 try{
	 Class.forName("com.mysql.jdbc.Driver");
	 conn=DriverManager.getConnection(uri,"root","123456");
 }catch(Exception e)
 {
	 response.sendRedirect("main.jsp");
 }
 Statement stmt;
 String sql="select password,usertype,audit from users where username='"+User+"'";
 //create the statement's concrete examples and run the sql 
 stmt=conn.createStatement();
 ResultSet rs=stmt.executeQuery(sql);
 if(rs.next())  // check whether the user is surval
 {
	 if(Pwd.equals(rs.getString("password"))&&rs.getString("audit").equals("1"))
	 {
		 String usertype=rs.getString("usertype");
		 String lastIP=request.getRemoteAddr();
		 java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyy/MM/dd hh:mm:ss");
		 java.util.Date now=new java.util.Date();
		 // if the message is suitable to the sql,update the user's message now
		 String mysql="update 'newdb'.'users'set lastIP='"+lastIP+"',status='1',lastLogin='"+sdf.format(now)+"' where username='"+User+"'";
		 stmt.executeUpdate(mysql);
		 //set the users'type and users'settings to be session
		 session.setAttribute("usertype",usertype);
		 session.setAttribute("login",User);
		 // post to the main.jsp
		 response.sendRedirect("main.jsp");
	 }
	 else
	 {
		 out.print("<script Language='javascript'>alert('the password is wrong!');history.go(-1);</script>");
	 }
 }
 else
 {
	 out.print("<script language='javascript'>alert('the user name is wrong');history.go(-1)</script>");
 }
 rs.close();
 conn.close();
  
%>

</body>
</html>