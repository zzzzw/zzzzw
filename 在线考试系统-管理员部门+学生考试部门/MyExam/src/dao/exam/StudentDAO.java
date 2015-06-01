package dao.exam;
import java.sql.*;

import entity.exam.Student;


public class StudentDAO
{
   //����ѧ�Ų�ѯѧ����Ϣ
     public Student selectStudent(String sid)
     {
    	 Connection conn=JDBCConnectionFactory.getConnection();
         Student st=null;
         //����ѧ�Ų�ѯѧ��
         try{
        	 Statement stmt=conn.createStatement();
        	 String sql="select * from student where sid='"+sid+"'";
        	 ResultSet rs=stmt.executeQuery(sql);
        	 if(rs.next())
        	 {
        		 st=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
        	 }
        	 }catch(SQLException ee){
        		 ee.printStackTrace();
        		 }finally{
        			 if(conn!=null)
        			 {
        				 try{
        					 conn.close();
        					 }catch(SQLException e){
        						 e.printStackTrace();
        						 }
        				 }
        			 }
         return st;
       }
     //����һ��ѧ����¼
     //����ֵΪ1��ѧ���Ѵ���
     //����ֵ0�����ɹ�
     //-1���ɹ�
     public int insertStudnet(Student st)
     {
    	 if(selectStudent(st.getSid())!=null)
    		 return 1;
    	 Connection conn=JDBCConnectionFactory.getConnection();
    	 try{
    		 //�����¼
    		 String str="insert into student values"+"('"+st.getSid()+"','"+st.getName()+"','"+st.getSex()+"','"+st.getCardNumber()+"','"+st.getPassword()+"','"+st.getDept()+"','"+st.getPhone()+"')";
    		 PreparedStatement pstmt=conn.prepareStatement(str);
    		 if(pstmt.executeUpdate()==1)
    		 {
    			 return 0;
    		 }
    		 else
    		 {
    			 return-1;
    		 }
         	 }catch(SQLException ee)
    		 {
    			 return-1;
    		}finally{
    			if(conn!=null)
    			{
    				try{
    					conn.close();
    					}catch(SQLException e){
    						e.printStackTrace();
    						}
    				}
    			}
   	 }
     //����ѧ����¼
     //����ֵΪ1��ѧ��������
     //����ֵ0����³ɹ�
     //-1���ɹ�
     public int updateStudent(Student st)
     {
    	 if(selectStudent(st.getSid())==null)
    		 return 1;
    	 Connection conn=JDBCConnectionFactory.getConnection();
    	 try{ 
    		 //���¼�¼
    		 String str="update  student set sname='"+st.getName()+"',sex='"+st.getSex()+"',cardnumber='"+st.getCardNumber()+"',pwd='"+st.getPassword()+"',department='"+st.getDept()+"',phone='"+st.getPhone()+"' where sid='"+st.getSid()+"'";
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
	        	ee.printStackTrace();
	        	return-1;
	        	}finally{
	        		if(conn!=null)
	        		{
	        			try{
	        				conn.close();
	        				}catch(SQLException e){
	        					e.printStackTrace();
	        					}
	        			}
	        		}
    	 }
     //ɾ��ѧ����¼
     //����ֵΪ1��ѧ��������
     //����ֵ0��ɾ���ɹ�
     //-1���ɹ�
     public int deleteStudent(Student st)
     {
    	 if(selectStudent(st.getSid())==null)
    		 return 1;
    	 Connection conn=JDBCConnectionFactory.getConnection();
    	 try{
    		 String str="delete form student where sid='"+st.getSid()+"'";
    		 PreparedStatement pstmt=conn.prepareStatement(str);
    		 if(pstmt.executeUpdate()==1)
    		 {
    			 return 0;
    		}else
    		{
    			return-1;
    		}
    		 }catch(SQLException ee){
    			 ee.printStackTrace();
    			 return-1;
    			 }finally{
    				 if(conn!=null)
    				 {
    					 try{
    						 conn.close();
    						 }catch(SQLException e){
    							 e.printStackTrace();
    							 }
    					 }
    				 }
    	 }
     //��������࣬��Ŀ�п���û��
     public static void main (String args[])
     {
    	 Student st=new Student("201302","����","��","211111199009091234","111","��Ϣ����ѧԺ","13222222334");
    	 StudentDAO dao=new StudentDAO();
    	 int i=dao.deleteStudent(st);
    	 System.out.println(i);
    }
}