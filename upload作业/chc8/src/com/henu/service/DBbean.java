package com.henu.service;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
public class DBbean {
static Connection con;
static String url;
//static String dsnName ="jdbc:odbc:yourdsnname" ;
static String driverName="com.mysql.jdbc.Driver";
static String userName="root";
static String userPasswd="123456";
static String dbName="file";
public DBbean() throws ClassNotFoundException,SQLException {
  url="jdbc:mysql://localhost/"+dbName+"?autoReconnect=true&useUnicode=true&characterEncoding=GBK&user="+userName+"&password="+userPasswd;
}
public static Connection getDBConnection() {
try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(url);
}catch(ClassNotFoundException e){
}catch(SQLException e){
}
return con;
}

public static Connection getPoolConnection()
{
	try
	{
		//Context是javax.name包中的一个接口，用于查找数据库连接池的配置文件
		Context ctx = new InitialContext();  //向上转型
		ctx = (Context) ctx.lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup("DBPool");
		con = ds.getConnection();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
}

//运行更新、插入、删除操作。
public  void executesql(String query) throws SQLException {
Statement stmt=null;
try {
stmt = DBbean.getDBConnection().createStatement(); 
//stmt = DBbean.getPoolConnection().createStatement();	
stmt.execute(query);
stmt.close();
con.close();
}
catch(SQLException e){}
}

//查询一个整数字段值；
public int getIntResult(String query)throws SQLException {
	Statement stmt=null;
	int i=0;
	try {
	stmt = DBbean.getDBConnection().createStatement(); 
	//stmt = DBbean.getPoolConnection().createStatement();	
	ResultSet rs =stmt.executeQuery(query);
	while(rs.next()) {
	i=Integer.parseInt(rs.getString(1));	
	}
	stmt.close();
	con.close();
	}
	catch(SQLException e){}
	return i;
}

//查询一个字符串字段值；
public String getOneStringResult(String query)throws SQLException {
	Statement stmt=null;
	ResultSet rs=null;
	String str="Null";
	try {
	stmt = DBbean.getDBConnection().createStatement(); 
	//stmt = DBbean.getPoolConnection().createStatement();	
	rs =stmt.executeQuery(query);
	while(rs.next()) {
	 str=rs.getString(1);	
	}	
	stmt.close();
	con.close();
	}
	catch(SQLException e){}
	return str;
}

//查询返回一个结果集
public ResultSet getResultSet(String query) throws SQLException{
	ResultSet rs = null;	
	Statement stmt=null;
	try {
	  stmt = DBbean.getDBConnection().createStatement();
	  //stmt = DBbean.getPoolConnection().createStatement();	
	rs = stmt.executeQuery(query);
	}catch(SQLException e){
		e.printStackTrace() ;
	}	
	return rs;
}

//查询一个字段的结果集，并以字符串数组形式返回。
public String[] getResultSetToStr(String query) throws SQLException {
ResultSet rs1 = null,rs2=null;
int i=0,counter=0;
String[] name = null;
Statement stmt1=null,stmt2=null;
try {
stmt1 = DBbean.getDBConnection().createStatement();
rs2 = stmt1.executeQuery(query);
while(rs2.next()){
counter++;
}
stmt2 = DBbean.getDBConnection().createStatement();
rs1 = stmt2.executeQuery(query);
name = new String[counter];
while(rs1.next()) {
name[i] = rs1.getString(1);
i++;
}
}
catch(SQLException e){
e.printStackTrace() ;
}
rs1.close();
rs2.close();
stmt1.close();
stmt2.close();
con.close();
return name;
}

public void closecon()throws SQLException{
	con.close();
}
}//class end;
