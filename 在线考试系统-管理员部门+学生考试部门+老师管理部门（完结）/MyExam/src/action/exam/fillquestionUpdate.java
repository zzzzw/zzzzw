package action.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.JDBCConnectionFactory;
import entity.exam.FillQuestion;

public class fillquestionUpdate extends ActionSupport 
{
	public String execute() throws Exception 
	{
		HttpServletRequest request = ServletActionContext.getRequest();
	    int f_id=Integer.parseInt(request.getParameter("subjectID"));
	 	String f_question=request.getParameter("subjectTitle");
		String f_answer=request.getParameter("subjectAnswer");
		Connection conn=JDBCConnectionFactory.getConnection();
		String sql="update fillquestion set ";
	    sql=sql+"f_question="+"'"+f_question+"'"+","+"f_answer="+"'"+f_answer+"'";
		sql=sql+"where f_id="+"'"+f_id+"'";
	    PreparedStatement pstmt=conn.prepareStatement(sql);
	    if(pstmt.executeUpdate()==1)
	    {
		    ServletActionContext.getRequest().setAttribute("fillshow", new FillQuestion(f_id,f_question,f_answer));
			this.addActionMessage("更新成功!");
			return SUCCESS;
		}
	    else
	    {
	    	return SUCCESS;
	    }
	}
}
