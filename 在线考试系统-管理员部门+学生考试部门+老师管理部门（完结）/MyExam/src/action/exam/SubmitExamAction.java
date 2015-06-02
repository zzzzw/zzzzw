package action.exam;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
public class SubmitExamAction extends ActionSupport 
{
	int GeneralPoint = 0;
	public String execute() throws Exception 
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> cAnswers = new ArrayList<String>();
		List<String> fAnswers = new ArrayList<String>();
		List<String> cAnswerss = new ArrayList<String>();
		List<String> fAnswerss = new ArrayList<String>();
		for(int i = 0; i < 10; i++) 
		{
			String canswer = request.getParameter("c_answer"+i);
			cAnswers.add(canswer);
			String canswer1 = request.getParameter("c_answer1"+i);
			cAnswerss.add(canswer1);
			String fanswer = request.getParameter("f_answer"+i);
			fAnswers.add(fanswer);
			String fanswer1 = request.getParameter("f_answer1"+i);
			fAnswerss.add(fanswer1);
		}
		for(int j=0;j<10;j++)
		{
			if(cAnswers.get(j).equals(cAnswerss.get(j)))
				GeneralPoint += 5;//加5分
		}
		for(int k=0;k<10;k++)
		{
			if(fAnswers.get(k).equals(fAnswerss.get(k)))
				GeneralPoint += 5;//加5分
		}
		request.setAttribute("GeneralPoint", GeneralPoint);
		request.setAttribute("cz",cAnswerss);
		request.setAttribute("fz",fAnswerss);
		return SUCCESS;
	}
}
