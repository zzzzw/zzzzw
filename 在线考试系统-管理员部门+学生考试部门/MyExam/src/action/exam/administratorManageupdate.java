package action.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;//非IoC的第一种方式

import com.opensymphony.xwork2.ActionContext;//非IoC的第二种方式
import com.opensymphony.xwork2.ActionSupport;

import dao.exam.JDBCConnectionFactory;
import entity.exam.Administrator;

public class administratorManageupdate  extends ActionSupport
{
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();//非IoC的第二种方式
		HttpServletRequest request = ServletActionContext.getRequest();//非IoC的第一种方式
		String c_id=request.getParameter("subjectID");
	 	String c_question=request.getParameter("subjectTitle");
		String c_choiceA=request.getParameter("subjectOptionA");
		String c_choiceB=request.getParameter("subjectOptionB");
		String c_choiceC=request.getParameter("subjectOptionC");
		String c_answer=request.getParameter("subjectAnswer");
		Connection conn=JDBCConnectionFactory.getConnection();
		String sql="update administrator set ";
	    sql=sql+"aname="+"'"+c_question+"'"+","+"sex="+"'"+c_choiceA+"'"+","+"cardNumber="+"'"+c_choiceB+"'"+","+"pwd="+"'"+c_choiceC+"'"+","+"phone="+"'"+c_answer+"'";
		sql=sql+" where adid="+"'"+c_id+"'";
		System.out.println(sql);
	    PreparedStatement pstmt=conn.prepareStatement(sql);
	    if(pstmt.executeUpdate()==1)
	    {
	    	Administrator teacher=new Administrator(c_id,c_question,c_choiceA,c_choiceB,c_choiceC,c_answer);
	    	session.put("administrator",teacher);//非IoC的第二种方式
	    	this.addActionMessage("更新成功!");
	    	return SUCCESS;
	    }
	    else
	    {
	    	return SUCCESS;
	    }
	}
}
