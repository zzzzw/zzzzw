package action.exam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;//非IoC方式，使用org.apache.struts2.ServletActionContext获取session，request，response；

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.SpageDAO;
import entity.exam.Student;

public class studentQuery extends ActionSupport 
{
	private List<Student> students ;  
    private int pageNow = 1 ; //初始化为1,默认从第一页开始显示  
    private int pageSize = 10 ; //每页显示5条记录  
      
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
    	HttpServletRequest request = ServletActionContext.getRequest();//非IoC方式，使用org.apache.struts2.ServletActionContext获取session，request，response；
        students = pageDAO.queryByPage(pageSize, pageNow) ;
    	request.setAttribute("student2",  students);
        return SUCCESS ;  
    }  
}
