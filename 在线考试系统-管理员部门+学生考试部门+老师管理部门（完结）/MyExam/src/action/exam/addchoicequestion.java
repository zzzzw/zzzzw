package action.exam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import entity.exam.ChoiceQuestion;
import javax.servlet.http.HttpServletRequest;
import dao.exam.ChoiceQuestionDAO;
import dao.exam.JDBCConnectionFactory;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class addchoicequestion  extends ActionSupport 
{
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		Connection conn=JDBCConnectionFactory.getConnection();
		int c_id = 0;
		Statement stmt= conn.createStatement();
		ResultSet rsl=stmt.executeQuery("select MAX(c_id) FROM choicequestion");
		if(rsl.next())
		{
			c_id=rsl.getInt(1)+1;
		}
		String c_question=request.getParameter("subjectTitle");
		String c_choiceA=request.getParameter("subjectOptionA");
		String c_choiceB=request.getParameter("subjectOptionB");
		String c_choiceC=request.getParameter("subjectOptionC");
		String c_choiceD=request.getParameter("subjectOptionD");
		String c_answer=request.getParameter("subjectAnswer");
		ChoiceQuestionDAO cdao=new ChoiceQuestionDAO();
	    int i=cdao.insertChoiceQuestion(new ChoiceQuestion(c_id,c_question,c_choiceA,c_choiceB,c_choiceC,c_choiceD,c_answer));
		if(i==0)
		{
			this.addActionMessage("添加成功!");
			return "success";
		}
		else
		{
			this.addActionMessage("添加失败!");
			return "input";
		}
	}
}
