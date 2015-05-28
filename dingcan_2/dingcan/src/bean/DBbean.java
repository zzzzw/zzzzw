package bean;


import java.sql.*;
//import javax.sql.*;

//import javax.naming.Context;
//import javax.naming.InitialContext;

public class DBbean 
{
	static Connection con;
	static String url;
	static String driverName="com.mysql.jdbc.Driver";
	static String userName="root";
	static String userPassword="123456";
	static String dbName="dbtemp";
	
	public DBbean() throws ClassNotFoundException,SQLException
	{
		url="jdbc:mysql://localhost/"+dbName+"?autoReconnect=true&useUnicode=true&characterEncoding=GBK&user="+userName+"&password="+userPassword;
	}
	public static Connection getDBConnection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");//��������
			con=DriverManager.getConnection(url);
		}catch(ClassNotFoundException e){
					}catch(SQLException e){}
		return con;
	}
	/*public static Connection getPoolConnection()
	{
		try{
			Context ctx=new InitialContext();//����ת�ͣ�Context��java.name���е�һ���ӿڣ����ڲ������ݿ����ӳص������ļ�
			ctx=(Context)ctx.lookup("java:com/env");
			DataSource ds=(DataSource)ctx.lookup("DBPool");
			con=ds.getConnection();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}*/
	//���и��¡����롣ɾ������
	public static void executesql(String query)throws SQLException
	{
		Statement stmt=null;
		try{
			stmt=DBbean.getDBConnection().createStatement();
			stmt.execute(query);
			stmt.close();
		}catch(SQLException e){}
		
	}
	//��ѯһ�������ֶ�ֵ
	public int getIntResult(String query)throws SQLException
	{
		Statement stmt=null;
		int i=0;
		try{
			stmt=DBbean.getDBConnection().createStatement();
			//stmt=DBbean.getPoolConncetion().creatStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				i=Integer.parseInt(rs.getString(1));
				
			}
			stmt.close();
			con.close();
		}catch(SQLException e){}
		return i;
	}
	//��ѯһ���ַ����ֶ�ֵ
	public String getOneStringResult(String query,int i)throws SQLException
	{
		Statement stmt=null;
		ResultSet rs=null;
		String str="Null";
		try{
			stmt=DBbean.getDBConnection().createStatement();
			//stmt=DBbean.getPoolConnection().creatStatement();
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				str=rs.getString(i);				
			}
			stmt.close();
			con.close();
		}catch(SQLException e){}
		return str;
	}
	//��ѯ����һ�������
	public static ResultSet getResultSet(String query)throws SQLException
	{
		ResultSet rs=null;
		Statement stmt=null;
		try{
			stmt=DBbean.getDBConnection().createStatement();
			rs=stmt.executeQuery(query);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	//��ѯһ���ֶεĽ�����������ַ���������ʽ����
	public String[] getResultSetToStr(String query)throws SQLException
	{
		ResultSet rs1=null,rs2=null;
		int i=0,counter=0;
		String[] name=null;
		Statement stmt1=null,stmt2=null;
		try{
			stmt1=DBbean.getDBConnection().createStatement();
			rs2=stmt1.executeQuery(query);
			while(rs2.next())
			{
				counter++;
			}
			stmt2=DBbean.getDBConnection().createStatement();
			rs1=stmt2.executeQuery(query);
			name=new String[counter];
			while(rs1.next())
			{
				name[i]=rs1.getString(1);
				i++;
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		rs1.close();
		rs2.close();
		stmt1.close();
		stmt2.close();
		con.close();
		return name;
		
	}
	public static boolean execute(String query)
	{
		boolean result=false;
		Statement stmt=null;
		try{
			stmt=DBbean.getDBConnection().createStatement();
			result=stmt.execute(query);
			
		}catch(SQLException e){}
		return result;
	}
	public void closeon() throws SQLException
	{
		con.close();
	}

}
