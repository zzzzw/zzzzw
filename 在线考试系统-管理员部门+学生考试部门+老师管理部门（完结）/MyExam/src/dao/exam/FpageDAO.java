package dao.exam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import entity.exam.FillQuestion;
public class FpageDAO {
	public List<FillQuestion> queryByPage (int pageSize, int pageNow){  
		List<FillQuestion>list=new LinkedList<FillQuestion>();
		Connection conn=JDBCConnectionFactory.getConnection();
		FillQuestion fill=null;
		try{
			if (pageSize>0 && pageNow>0){
			Statement stmt= conn.createStatement();
			String sql="select * from FillQuestion order by f_id limit "+(pageNow*pageSize-pageSize)+","+pageSize;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				fill=new FillQuestion(rs.getInt(1),rs.getString(2),rs.getString(3));
					    list.add(fill);
					}
			}}catch(SQLException ee){
				ee.printStackTrace();
				
			}finally{
				
			}
		return list;
		  }  
}
