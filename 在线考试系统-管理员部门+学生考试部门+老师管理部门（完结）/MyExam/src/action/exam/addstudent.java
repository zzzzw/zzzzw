package action.exam;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.StudentDAO;
import entity.exam.Student;

public class addstudent  extends ActionSupport
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
		StudentDAO cdao=new StudentDAO();
	    int i=cdao.insertStudnet(new Student(c_id,c_question,c_choiceA,c_choiceB,c_choiceC,c_choiceD,c_answer));
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
