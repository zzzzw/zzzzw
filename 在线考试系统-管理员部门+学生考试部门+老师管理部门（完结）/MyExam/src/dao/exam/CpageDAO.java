package dao.exam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import entity.exam.ChoiceQuestion;
public class CpageDAO 
{
	public List<ChoiceQuestion> queryByPage (int pageSize, int pageNow)
	{  
		List<ChoiceQuestion>list=new LinkedList<ChoiceQuestion>();
		Connection conn=JDBCConnectionFactory.getConnection();
		ChoiceQuestion choice=null;
		try{
			if (pageSize>0 && pageNow>0)
			{
				Statement stmt= conn.createStatement();
				String sql="select * from choiceQuestion order by c_id limit "+(pageNow*pageSize-pageSize)+","+pageSize;
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					choice=new ChoiceQuestion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				    list.add(choice);
				}
				}
			}catch(SQLException ee){
					ee.printStackTrace();					
				}finally{}
		return list;
	}  
}
