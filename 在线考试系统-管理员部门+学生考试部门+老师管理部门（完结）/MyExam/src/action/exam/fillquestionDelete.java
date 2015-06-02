package action.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.JDBCConnectionFactory;

public class fillquestionDelete  extends ActionSupport
{
	public String execute() throws Exception 
	{
		HttpServletRequest request = ServletActionContext.getRequest();
	    int c_id=Integer.parseInt(request.getParameter("subjectID"));
		Connection conn=JDBCConnectionFactory.getConnection();
		String str="delete from fillquestion where f_id='"+c_id+"'";
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
