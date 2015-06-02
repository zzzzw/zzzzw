package action.exam;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.ChoiceQuestionDAO;
import entity.exam.ChoiceQuestion;
public class choicequestionShow extends ActionSupport 
{
	private int subjectID;
	private ChoiceQuestionDAO choicequestion = new ChoiceQuestionDAO();
	public int getSubjectID() 
	{
		return subjectID;
	}
	public void setSubjectID(int subjectID) 
	{
		this.subjectID = subjectID;
	}
	public String execute() throws Exception 
	{
		ChoiceQuestion choice=choicequestion.selectOneChoiceQuestion(subjectID);
		ServletActionContext.getRequest().setAttribute("choiceshow",choice);
		return SUCCESS;
	}
}
