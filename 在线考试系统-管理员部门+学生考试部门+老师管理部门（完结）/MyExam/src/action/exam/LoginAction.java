package action.exam;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.exam.StudentDAO;
import dao.exam.TeacherDAO;
import dao.exam.AdministratorDAO;
import entity.exam.Student;
import entity.exam.Administrator;
import entity.exam.Teacher;
public class LoginAction extends ActionSupport
{
	private String id; 			// 接受用户编号
	private String password;	// 接受用户密码
	private String role;
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getRole() 
	{
		return role;
	}
	public void setRole(String role) 
	{
		this.role = role;
	}
	public String execute() throws Exception 
	{
	    Map session = ActionContext.getContext().getSession();//非IoC方式的另外一种
		if("student".equals(role)) 
		{
			//如果以学生身份登录
			StudentDAO sdao=new StudentDAO();
			Student st=sdao.selectStudent(id);  
			if(st==null) 
			{
				addActionError("该学生编号不存在!");
				return "input";
			}
			else if(!st.getPassword().equals(password))
			{
				addActionError("该学生密码不正确!");
				return "input";
			}
			else
			{
				session.put("student",st);
				return "studentSuccess";
			}
		}
		else if("administrator".equals(role))
		{
			AdministratorDAO adao=new AdministratorDAO();
			Administrator ad=adao.selectAdministrator(id);
			if(ad==null) 
			{
				addActionError("该管理员编号不存在!");
				return "input";
			}
			else if(!ad.getPassword().equals(password))
			{
				addActionError("该管理员密码不正确!");
				return "input";
			}
			else
			{
				session.put("administrator",ad);
				return "administratorSuccess";
			}
		}
		else 
		{
			TeacherDAO tdao=new TeacherDAO();
			Teacher te=tdao.selectTeacher(id);
			if(te==null) 
			{
				addActionError("该教师编号不存在!");
				return "input";
			}
			else if(!te.getPassword().equals(password))
			{
				addActionError("该教师密码不正确!");
				return "input";
			}
			else
			{
				session.put("teacher",te);
				return "teacherSuccess";
			}
		}
	}
}
