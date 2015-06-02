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
	private String id; 			// �����û����
	private String password;	// �����û�����
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
	    Map session = ActionContext.getContext().getSession();//��IoC��ʽ������һ��
		if("student".equals(role)) 
		{
			//�����ѧ����ݵ�¼
			StudentDAO sdao=new StudentDAO();
			Student st=sdao.selectStudent(id);  
			if(st==null) 
			{
				addActionError("��ѧ����Ų�����!");
				return "input";
			}
			else if(!st.getPassword().equals(password))
			{
				addActionError("��ѧ�����벻��ȷ!");
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
				addActionError("�ù���Ա��Ų�����!");
				return "input";
			}
			else if(!ad.getPassword().equals(password))
			{
				addActionError("�ù���Ա���벻��ȷ!");
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
				addActionError("�ý�ʦ��Ų�����!");
				return "input";
			}
			else if(!te.getPassword().equals(password))
			{
				addActionError("�ý�ʦ���벻��ȷ!");
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
