package action.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.exam.JDBCConnectionFactory;
import entity.exam.Teacher;

public class teacherManageupdate  extends ActionSupport 
{
	public String execute() throws Exception 
	{
		Map session = ActionContext.getContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String c_id=request.getParameter("subjectID");
	 	String c_question=request.getParameter("subjectTitle");
		String c_choiceA=request.getParameter("subjectOptionA");
		String c_choiceB=request.getParameter("subjectOptionB");
		String c_choiceC=request.getParameter("subjectOptionC");
		String c_choiceD=request.getParameter("subjectOptionD");
		String c_answer=request.getParameter("subjectAnswer");
		Connection conn=JDBCConnectionFactory.getConnection();
		String sql="update teacher set ";
	    sql=sql+"tname="+"'"+c_question+"'"+","+"sex="+"'"+c_choiceA+"'"+","+"cardNumber="+"'"+c_choiceB+"'"+","+"pwd="+"'"+c_choiceC+"'"+","+"title="+"'"+c_choiceD+"'"+","+"phone="+"'"+c_answer+"'";
		sql=sql+" where tid="+"'"+c_id+"'";
		System.out.println(sql);
	    PreparedStatement pstmt=conn.prepareStatement(sql);
	    if(pstmt.executeUpdate()==1)
	    {
	    Teacher teacher=new Teacher(c_id,c_question,c_choiceA,c_choiceB,c_choiceC,c_choiceD,c_answer);
	    session.put("teacher",teacher);
		this.addActionMessage("更新成功!");
		return SUCCESS;
		}
	    else
	    {
	    	return SUCCESS;
	    }
	}
}
