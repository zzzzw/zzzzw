package action.exam;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.StudentDAO;
import entity.exam.Student;

public class studentUpdateBefore  extends ActionSupport 
{
	private String subjectID;
	private StudentDAO choicequestion = new StudentDAO();
	public String getSubjectID() 
	{
		return subjectID;
	}
	public void setSubjectID(String subjectID) 
	{
		this.subjectID = subjectID;
	}
	public String execute() throws Exception 
	{
		Student choice=choicequestion.selectStudent(subjectID);
		ServletActionContext.getRequest().setAttribute("studentshow",choice);
		return SUCCESS;
	}
}
