package dao.exam;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import entity.exam.ChoiceQuestion;

public class ChoiceQuestionDAO
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

    //�����������������⣬���ر���num��ѡ���������
	public List<ChoiceQuestion> selectChoiceQuestion(int num)
	{
		
		Connection conn=JDBCConnectionFactory.getConnection();
		ChoiceQuestion choice=null;
		List<ChoiceQuestion> list=new LinkedList<ChoiceQuestion>();
        //��ѯ��ѡ����
		try{
			Statement stmt= conn.createStatement();
            //����num���������Ϊ��ѡ��������
			ResultSet rsl=stmt.executeQuery("select MAX(c_id) FROM choicequestion");
			int maxcid=30;
			if(rsl.next())
			{
				maxcid=rsl.getInt(1);
			}
			//����ѡ��������
			int[] number=random_number(maxcid,num);
			//��ѯ����ѡ���Ⲣѡ��num����
			String sql="select * from choiceQuestion";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				for(int i=0;i<num;i++)
				{
					if(rs.getInt(1)==number[i])
					{
						choice=new ChoiceQuestion(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					    list.add(choice);
					}
				}
			}
			}catch(SQLException ee){
				ee.printStackTrace();				
			}finally{
				try{
					conn.close();
				}catch (SQLException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return list;
		}

    //������Ų�ѯһ��ѡ����
	public ChoiceQuestion selectOneChoiceQuestion(int cid)
	{
		Connection conn=JDBCConnectionFactory.getConnection();
		ChoiceQuestion choice=null;
        //��ѯ��ѡ����
		try{
			Statement stmt= conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from choicequestion"+" where c_id='"+cid+"'");
		    if(rs.next())
		    {
		    	choice=new ChoiceQuestion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		    }
		}catch(SQLException ee){
			ee.printStackTrace();
			}finally{
				try {
					conn.close();
					} catch (SQLException e){
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
				}
		return choice;
	}
    //����һ��������¼
    //����ֵΪ0��ʾ����ɹ�
	//-1���ɹ�
	public int insertChoiceQuestion(ChoiceQuestion choice)
	{
		Connection conn=JDBCConnectionFactory.getConnection();
		//����һ����¼
		try{
			String str="insert into choiceQuestion(c_id,c_question,c_choiceA,c_choiceB,c_choiceC,c_choiceD,c_answer)values('"+choice.getC_id()+"','"+choice.getC_question()+"','"+choice.getC_choiceA()+"','"+choice.getC_choiceB()+"','"+choice.getC_choiceC()+"','"+choice.getC_choiceD()+"','"+choice.getC_answer()+"')";
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