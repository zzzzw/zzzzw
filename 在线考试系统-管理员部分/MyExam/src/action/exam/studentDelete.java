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
		HttpServletRequest request = ServletActionContext.getRequest();//��IoC��ʽ����servlet���request���뿴��һ��
	    String c_id=request.getParameter("subjectID");
		Connection conn=JDBCConnectionFactory.getConnection();
		String str="delete from student where sid='"+c_id+"'";
		PreparedStatement pstmt=conn.prepareStatement(str);
		 if(pstmt.executeUpdate()==1)
		 {
			 this.addActionMessage("���³ɹ�!");
			 return SUCCESS;
		 }
		 else
		 {
			 return SUCCESS;
	     }
	 }
}
