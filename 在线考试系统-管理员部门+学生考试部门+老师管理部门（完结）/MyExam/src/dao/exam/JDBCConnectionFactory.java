package dao.exam;
import java.sql.*;
public class JDBCConnectionFactory 
{
	public static Connection getConnection()
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/exam";
		String usr="root";
		String pwd="123456";
		String url1=url+"?autoReconnect=true&useUnicode=true&characterEncoding=GBK&user="+usr+"&password="+pwd;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url1);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
				}
		return conn;
	}
	public static void main(String args[])
	{
		Connection conn=JDBCConnectionFactory.getConnection();
		System.out.println(conn);
	}
}
