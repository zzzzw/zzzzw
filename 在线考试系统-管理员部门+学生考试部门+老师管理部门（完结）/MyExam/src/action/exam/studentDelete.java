package action.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.JDBCConnectionFactory;

public class studentDelete extends ActionSupport 
{
	public String execute() throws Exception 
	{
		HttpServletRequest request = ServletActionContext.getRequest();//非IoC方式访问servlet获得request，请看下一句
	    String c_id=request.getParameter("subjectID");
		Connection conn=JDBCConnectionFactory.getConnection();
		String str="delete from student where sid='"+c_id+"'";
		PreparedStatement pstmt=conn.prepareStatement(str);
		 if(pstmt.executeUpdate()==1)
		 {
			 this.addActionMessage("更新成功!");
			 return SUCCESS;
		 }
		 else
		 {
			 return SUCCESS;
	     }
	 }
}
