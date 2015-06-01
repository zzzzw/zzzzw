package dao.exam;
import java.sql.*;
import java.util.*;
import entity.exam.FillQuestion;

public class FillQuestionDAO
{
     //����������������
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
     //������������������⣬���ر���num������������
     public List<FillQuestion>selectFillQuestion(int num)
     {
    	 Connection conn=JDBCConnectionFactory.getConnection();
    	 FillQuestion fill=null;
 		 List<FillQuestion>list=new LinkedList<FillQuestion>();
        //��ѯ��ѡ����
 		try{
 			Statement stmt= conn.createStatement();
           //����num���������Ϊ��ѡ��������
 			ResultSet rsl=stmt.executeQuery("select MAX(f_id) FROM fillquestion");
 			int maxfid=30;
 			if(rsl.next())
 			{
 				maxfid=rsl.getInt(1);
 			}
            //����ѡ��������
 			int[] number=random_number(maxfid,num);
            //��ѯ����ѡ���Ⲣѡ��num����
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
    //������Ų�ѯһ�������
    public FillQuestion selectOneFillQuestion(int fid)
    {
    	Connection conn=JDBCConnectionFactory.getConnection();
    	FillQuestion fill=null;
        //��ѯ��ѡ����
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
    //����һ��������¼
    //����ֵΪ0��ʾ����ɹ�
    //-1���ɹ�
    public int insertFillQuestion(FillQuestion fill) 
    {
    	Connection conn=JDBCConnectionFactory.getConnection();
        //����һ����¼
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
