package action.exam;
import dao.exam.ChoiceQuestionDAO;
import dao.exam.FillQuestionDAO;
import entity.exam.ChoiceQuestion;
import entity.exam.FillQuestion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class GetRandomSubject extends ActionSupport
{
	public String execute() throws Exception 
	{
		ChoiceQuestionDAO cdao=new ChoiceQuestionDAO();
		List<ChoiceQuestion> cq=cdao.selectChoiceQuestion(10);
		FillQuestionDAO fdao=new FillQuestionDAO();
		List<FillQuestion> fq=fdao.selectFillQuestion(10);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("ChoiceQuestion", cq);
		request.setAttribute("FillQuestion", fq);
		return SUCCESS;
	}
}
