package dao.exam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import entity.exam.Student;
public class SpageDAO 
{
	public List<Student> queryByPage (int pageSize, int pageNow)
	{  
		List<Student>list=new LinkedList<Student>();
		Connection conn=JDBCConnectionFactory.getConnection();
		Student st=null;
		try{
			if (pageSize>0 && pageNow>0)
			{
				Statement stmt= conn.createStatement();
				String sql="select * from Student order by sid limit "+(pageNow*pageSize-pageSize)+","+pageSize;
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					st=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					list.add(st);
				}
			}
		}catch(SQLException ee){
				ee.printStackTrace();
				}finally{}
		return list;
	}  
}
