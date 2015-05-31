package action.exam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.exam.TpageDAO;
import entity.exam.Teacher;

public class teacherQuery  extends ActionSupport {
	private List<Teacher> students ;  
    private int pageNow = 1 ; //��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ  
    private int pageSize = 10 ; //ÿҳ��ʾ5����¼  
      
    private TpageDAO pageDAO = new TpageDAO () ;  
      
    public List<Teacher> getStudents() {  
        return students;  
    }  
  
    public void setStudents(List<Teacher> students) {  
        this.students = students;  
    }  
      
    public int getPageNow() {  
        return pageNow;  
    }  
  
    public void setPageNow(int pageNow) {  
        this.pageNow = pageNow;  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public String execute() throws Exception { 
    	HttpServletRequest request = ServletActionContext.getRequest();
        students = pageDAO.queryByPage(pageSize, pageNow) ;
    	request.setAttribute("teacher2",  students);
        return SUCCESS ;  
    }  
}
