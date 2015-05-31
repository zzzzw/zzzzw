package dao.exam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import entity.exam.Teacher;

public class TpageDAO 
{
	public List<Teacher> queryByPage (int pageSize, int pageNow)
	{  
		List<Teacher>list=new LinkedList<Teacher>();
		Connection conn=JDBCConnectionFactory.getConnection();
		Teacher st=null;
		try{
			if (pageSize>0 && pageNow>0)
			{
				Statement stmt= conn.createStatement();
				String sql="select * from Teacher order by tid limit "+(pageNow*pageSize-pageSize)+","+pageSize;
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					st=new Teacher(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					list.add(st);
				}
				}
			}catch(SQLException ee){
				ee.printStackTrace();
				}finally{}
		return list;
	}  
}
