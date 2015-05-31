package action.exam;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.TeacherDAO;
import entity.exam.Teacher;

public class teacherUpdate  extends ActionSupport 
{
	public String execute() throws Exception 
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String c_id=request.getParameter("subjectID");
		String c_question=request.getParameter("subjectTitle");
		String c_choiceA=request.getParameter("subjectOptionA");
		String c_choiceB=request.getParameter("subjectOptionB");
		String c_choiceC=request.getParameter("subjectOptionC");
		String c_choiceD=request.getParameter("subjectOptionD");
		String c_answer=request.getParameter("subjectAnswer");
		TeacherDAO cdao=new TeacherDAO();
	    int i=cdao.updateTeacher(new Teacher(c_id,c_question,c_choiceA,c_choiceB,c_choiceC,c_choiceD,c_answer));
		if(i==0)
		{
			this.addActionMessage("修改成功!");
			ServletActionContext.getRequest().setAttribute("teachershow",new Teacher(c_id,c_question,c_choiceA,c_choiceB,c_choiceC,c_choiceD,c_answer));
			return "success";
		}
		else
		{
			this.addActionMessage("修改失败!");
			return "success";
		}
	}
}
