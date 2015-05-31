package dao.exam;
import java.sql.*;

import entity.exam.Student;


public class StudentDAO
{
   //根据学号查询学生信息
     public Student selectStudent(String sid)
     {
    	 Connection conn=JDBCConnectionFactory.getConnection();
         Student st=null;
         //根据学号查询学生
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
     //插入一条学生记录
     //返回值为1该学生已存在
     //返回值0表插入成功
     //-1表不成功
     public int insertStudnet(Student st)
     {
    	 if(selectStudent(st.getSid())!=null)
    		 return 1;
    	 Connection conn=JDBCConnectionFactory.getConnection();
    	 try{
    		 //插入记录
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
     //更新学生记录
     //返回值为1该学生不存在
     //返回值0表更新成功
     //-1表不成功
     public int updateStudent(Student st)
     {
    	 if(selectStudent(st.getSid())==null)
    		 return 1;
    	 Connection conn=JDBCConnectionFactory.getConnection();
    	 try{ 
    		 //更新记录
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
     //删除学生记录
     //返回值为1该学生不存在
     //返回值0表删除成功
     //-1表不成功
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
     //测试这个类，项目中可以没有
     public static void main (String args[])
     {
    	 Student st=new Student("201302","陈文","男","211111199009091234","111","信息工程学院","13222222334");
    	 StudentDAO dao=new StudentDAO();
    	 int i=dao.deleteStudent(st);
    	 System.out.println(i);
    }
}