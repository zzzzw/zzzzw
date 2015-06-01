package dao.exam;
import java.sql.*;
import java.util.*;
import entity.exam.FillQuestion;

public class FillQuestionDAO
{
     //产生多个随机数方法
     private int[] random_number(int max,int num)
     {
    	int[] number=new int[num];
 		for(int i=0;i<num;i++)
 		{
 			number[i]=(int)(Math.random()*max)+1;
 			for(int j=1;j<=i;j++)
 			{
 				if(number[j-1]==number[i])
 				{
 					i=i-1; 
 					break;
 				}
 			}
 		}
 		return number;
    
    }
     //从题库中随机生成填空题，返回保存num个填空题的链表
     public List<FillQuestion>selectFillQuestion(int num)
     {
    	 Connection conn=JDBCConnectionFactory.getConnection();
    	 FillQuestion fill=null;
 		 List<FillQuestion>list=new LinkedList<FillQuestion>();
        //查询该选择题
 		try{
 			Statement stmt= conn.createStatement();
           //生成num个随机数作为需选择题的题号
 			ResultSet rsl=stmt.executeQuery("select MAX(f_id) FROM fillquestion");
 			int maxfid=30;
 			if(rsl.next())
 			{
 				maxfid=rsl.getInt(1);
 			}
            //生成选题编号数组
 			int[] number=random_number(maxfid,num);
            //查询所有选择题并选出num道题
 			String sql="select * from FillQuestion";
 			ResultSet rs=stmt.executeQuery(sql);
 			while(rs.next())
 			{
 				for(int i=0;i<num;i++)
 				{
 					if(rs.getInt(1)==number[i])
 					{
 						fill=new FillQuestion(rs.getString(2),rs.getString(3));
 					    list.add(fill);
 					}
 				}
 			}
 			}catch(SQLException ee){
 				ee.printStackTrace();
 				
 			}finally{}
 		return list;
    }
    //根据题号查询一道填空题
    public FillQuestion selectOneFillQuestion(int fid)
    {
    	Connection conn=JDBCConnectionFactory.getConnection();
    	FillQuestion fill=null;
        //查询该选择题
		try{
			Statement stmt= conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from FillQuestion"+" where f_id='"+fid+"'");
		    if(rs.next())
		    {
		    	fill=new FillQuestion(rs.getInt(1),rs.getString(2),rs.getString(3));
		    }
		}catch(SQLException ee){
			ee.printStackTrace();
		}finally{}
		return fill;
    }
    //插入一条填空题记录
    //返回值为0表示插入成功
    //-1表不成功
    public int insertFillQuestion(FillQuestion fill) 
    {
    	Connection conn=JDBCConnectionFactory.getConnection();
        //插入一条记录
		try{
			String str="insert into FillQuestion(f_id,f_question,f_answer)values('"+fill.getF_id()+"','"+fill.getF_question()+"','"+fill.getF_answer()+"')";
			PreparedStatement pstmt=conn.prepareStatement(str);
			if(pstmt.executeUpdate()==1) 
			{
				return 0;
			}
			else
			{ 
				return-1;
			}
			}catch(SQLException ee){
				return -1;
				}finally{}
    }
}
