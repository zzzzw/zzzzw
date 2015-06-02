package action.exam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.FpageDAO;
import entity.exam.FillQuestion;

public class fillquestionQuery extends ActionSupport 
{
	 private List<FillQuestion> students ;  
	    private int pageNow = 1 ; //初始化为1,默认从第一页开始显示  
	    private int pageSize = 10 ; //每页显示5条记录  
	      
	    private FpageDAO pageDAO = new FpageDAO () ;  
	      
	    public List<FillQuestion> getStudents() 
	    {  
	        return students;  
	    }  
	  
	    public void setStudents(List<FillQuestion> students) 
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
	    	HttpServletRequest request = ServletActionContext.getRequest();
	        students = pageDAO.queryByPage(pageSize, pageNow) ;
	    	request.setAttribute("fillquestion2",  students);
	        return SUCCESS ;  
	    }  
}
