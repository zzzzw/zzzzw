package dao.exam;
import java.sql.*;

import entity.exam.Teacher;

public class TeacherDAO
{ 
        //根据教师号查询教师信息
	public Teacher selectTeacher(String tid)
	{
		Connection conn=JDBCConnectionFactory.getConnection();
		Teacher te=null;
		//根据学号查询学生
		try{
			Statement stmt=conn.createStatement();
			String sql="select * from teacher where tid='"+tid+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				te=new Teacher(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
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
		return te;
		
	}
	//插入一条教师记录
	public int insertTeacher(Teacher te)
	{
		if(selectTeacher(te.getTid())!=null)
			return 1;
		Connection conn=JDBCConnectionFactory.getConnection();
		try{
	         //插入记录
			String str="insert into teacher values"+"('"+te.getTid()+"','"+te.getName()+"','"+te.getSex()+"','"+te.getCardNumber()+"','"+te.getPassword()+"','"+te.getTitle()+"','"+te.getPhone()+"')";
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
	//更新教师记录
	public int updateTeacher(Teacher te)
	{
		if(selectTeacher(te.getTid())==null)
			return 1;
		Connection conn=JDBCConnectionFactory.getConnection();
    	try{ 
            //更新记录
    		String str="update  teacher set tname='"+te.getName()+"',sex='"+te.getSex()+"',cardnumber='"+te.getCardNumber()+"',pwd='"+te.getPassword()+"',title='"+te.getTitle()+"',phone='"+te.getPhone()+"' where tid='"+te.getTid()+"'";
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
         //删除教师记录
	public int deleteTeacher(Teacher te)
	{
    	if(selectTeacher(te.getTid())==null)
    		return 1;
    	Connection conn=JDBCConnectionFactory.getConnection();
    	try{
    		String str="delete form teacher where tid='"+te.getTid()+"'";
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
    			if(conn!=null){
    				try{
    					conn.close();
    					}catch(SQLException e){
    						e.printStackTrace();
    						}
    				}
    			}
    }
}