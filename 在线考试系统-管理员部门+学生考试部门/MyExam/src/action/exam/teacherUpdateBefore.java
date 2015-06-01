package action.exam;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.TeacherDAO;
import entity.exam.Teacher;

public class teacherUpdateBefore extends ActionSupport{
	private String subjectID;
	private TeacherDAO choicequestion = new TeacherDAO();
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String execute() throws Exception {
		Teacher choice=choicequestion.selectTeacher(subjectID);
		ServletActionContext.getRequest().setAttribute("teachershow",choice);
		return SUCCESS;
	}
}
