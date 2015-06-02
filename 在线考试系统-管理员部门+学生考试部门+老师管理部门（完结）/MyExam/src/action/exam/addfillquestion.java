package action.exam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.exam.FillQuestion;
import javax.servlet.http.HttpServletRequest;

import dao.exam.FillQuestionDAO;
import dao.exam.JDBCConnectionFactory;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class addfillquestion extends ActionSupport 
{
	public String execute() throws Exception 
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		Connection conn=JDBCConnectionFactory.getConnection();
		int f_id = 0;
		Statement stmt= conn.createStatement();
		ResultSet rsl=stmt.executeQuery("select MAX(f_id) FROM fillquestion");
		if(rsl.next())
		{
			f_id=rsl.getInt(1)+1;
		}
		String f_question=request.getParameter("subjectTitle");
		String f_answer=request.getParameter("subjectAnswer");
		FillQuestionDAO fdao=new FillQuestionDAO();
	    int i=fdao.insertFillQuestion(new FillQuestion(f_id,f_question,f_answer));
		if(i==0)
		{
			this.addActionMessage("添加成功!");
			return "success";
		}
		else
		{
			this.addActionMessage("添加失败！");
			return "input";
		}
    }
}
