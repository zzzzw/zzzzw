package action.exam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;//��IoC��ʽ��ʹ��org.apache.struts2.ServletActionContext��ȡsession��request��response��

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.SpageDAO;
import entity.exam.Student;

public class studentQuery extends ActionSupport 
{
	private List<Student> students ;  
    private int pageNow = 1 ; //��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ  
    private int pageSize = 10 ; //ÿҳ��ʾ5����¼  
      
    private SpageDAO pageDAO = new SpageDAO () ;  
      
    public List<Student> getStudents() 
    {  
        return students;  
    }    
    public void setStudents(List<Student> students) 
    {  
        this.students = students;  
    }        
    public int getPageNow() 
    {  
        return pageNow;  
    }    
    public void setPageNow(int pageNow) 
    {  
        this.pageNow = pageNow;  
    }    
    public int getPageSize() 
    {  
        return pageSize;  
    }    
    public void setPageSize(int pageSize) 
    {  
        this.pageSize = pageSize;  
    }    
    public String execute() throws Exception
    { 
    	HttpServletRequest request = ServletActionContext.getRequest();//��IoC��ʽ��ʹ��org.apache.struts2.ServletActionContext��ȡsession��request��response��
        students = pageDAO.queryByPage(pageSize, pageNow) ;
    	request.setAttribute("student2",  students);
        return SUCCESS ;  
    }  
}
