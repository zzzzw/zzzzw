package action.exam;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//import dao.exam.ChoiceQuestionDAO;
import dao.exam.JDBCConnectionFactory;
import entity.exam.ChoiceQuestion;

public class choicequestionUpdate extends ActionSupport 
{
	public String execute() throws Exception 
	{
		HttpServletRequest request = ServletActionContext.getRequest();
	    int c_id=Integer.parseInt(request.getParameter("subjectID"));
	 	String c_question=request.getParameter("subjectTitle");
		String c_choiceA=request.getParameter("subjectOptionA");
		String c_choiceB=request.getParameter("subjectOptionB");
		String c_choiceC=request.getParameter("subjectOptionC");
		String c_choiceD=request.getParameter("subjectOptionD");
		String c_answer=request.getParameter("subjectAnswer");
		Connection conn=JDBCConnectionFactory.getConnection();
		String sql="update choicequestion set ";
	    sql=sql+"c_question="+"'"+c_question+"'"+","+"c_choiceA="+"'"+c_choiceA+"'"+","+"c_choiceB="+"'"+c_choiceB+"'"+","+"c_choiceC="+"'"+c_choiceC+"'"+","+"c_choiceD="+"'"+c_choiceD+"'"+","+"c_answer="+"'"+c_answer+"'";
		sql=sql+"where c_id="+"'"+c_id+"'";
		System.out.println(sql);
	    PreparedStatement pstmt=conn.prepareStatement(sql);
	    if(pstmt.executeUpdate()==1)
	    {
		    ServletActionContext.getRequest().setAttribute("choiceshow", new ChoiceQuestion(c_id,c_question,c_choiceA,c_choiceB,c_choiceC,c_choiceD,c_answer));
			this.addActionMessage("更新成功!");
			return SUCCESS;
		}
	    else
	    {
	    	return SUCCESS;
	    }
	}
}
