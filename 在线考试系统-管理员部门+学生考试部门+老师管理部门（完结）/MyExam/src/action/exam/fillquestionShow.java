package action.exam;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.FillQuestionDAO;
import entity.exam.FillQuestion;

public class fillquestionShow extends ActionSupport
{
	private int subjectID;
	private FillQuestionDAO choicequestion = new FillQuestionDAO();
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
		FillQuestion choice=choicequestion.selectOneFillQuestion(subjectID);
		ServletActionContext.getRequest().setAttribute("fillshow",choice);
		return SUCCESS;
	}
}
