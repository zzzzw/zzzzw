package dao.exam;
import java.sql.*;

import entity.exam.Administrator;

public class AdministratorDAO{
      //根据管理员号查询教师信息
	public Administrator selectAdministrator(String adid)
	{
		Connection conn=JDBCConnectionFactory.getConnection();
        Administrator ad=null;
        //根据学号查询学生
        try{
        	Statement stmt=conn.createStatement();
        	String sql="select * from administrator where adid='"+adid+"'";
        	ResultSet rs=stmt.executeQuery(sql);
        	if(rs.next())
        	{
        		ad=new Administrator(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
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
        return ad;
        
	} 
	//更新管理员信息
	public int updateAdministrator(Administrator ad)
	{
		if(selectAdministrator(ad.getAdid())==null)
			return 1;
		Connection conn=JDBCConnectionFactory.getConnection();
		try{ 
	        //更新记录
			String str="updata  administrator set aname='"+ad.getName()+"',sex='"+ad.getSex()+"',cardnumber='"+ad.getCardNumber()+"',pwd='"+ad.getPassword()+"',phone='"+ad.getPhone()+"' where adid='"+ad.getAdid()+"'";
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
