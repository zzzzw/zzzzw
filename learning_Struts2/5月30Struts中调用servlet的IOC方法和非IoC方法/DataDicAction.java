package com.java1234.action;//所在的包

import java.sql.Connection;//数据库连接的类
import java.util.ArrayList;//ArrayList和List是在private List<DataDic> dataDicList=new ArrayList<DataDic>();中用到
import java.util.List;//ArrayList和List是在private List<DataDic> dataDicList=new ArrayList<DataDic>();中用到

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;//访问Servlet API的时候使用的非IOC方式，方法一：org.apache.Structs2.ServletActionContext获取session，request，response
import org.apache.struts2.interceptor.ServletRequestAware; ////访问Servlet API的时候使用的IOC方式（Inversion of Control，自身不创建对象，仅仅描述创建它们的方式.）这里是让Action实现ServletRequestAware接口而已，没有实现ServletResponseAware接口还有SessionWare接口

import com.java1234.dao.DataDicDao;
import com.java1234.model.DataDic;
import com.java1234.model.PageBean;
import com.java1234.util.DbUtil;
import com.java1234.util.NavUtil;
import com.java1234.util.PageUtil;
import com.java1234.util.PropertiesUtil;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;//action需要继承这个类

/*这里是让类实现ServletRequestAware接口就是非IOC方式，没有实现ServletResponseAware接口还有SessionWare接口*/
// 这里是让类继承了ActionSupport这个类，实现IOC方式
public class DataDicAction extends ActionSupport implements ServletRequestAware{  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;//定义request
	private DbUtil dbUtil=new DbUtil();
	private DataDicDao dataDicDao=new DataDicDao();
	private List<DataDic> dataDicList=new ArrayList<DataDic>();//定义一个DataDic类型的ArrayLst，但是ArrayList定义的时候需要用List a=new ArrayList（）；定义
	
	private String mainPage; 
	private String navCode;	
	
	private String s_ddTypeName;
	
	private String page;
	private int total;
	private String pageCode;
	
	private String ddId;
	
	
	
	
	public String getDdId() {
		return ddId;
	}

	public void setDdId(String ddId) {
		this.ddId = ddId;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public List<DataDic> getDataDicList() {
		return dataDicList;
	}

	public void setDataDicList(List<DataDic> dataDicList) {
		this.dataDicList = dataDicList;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public String getNavCode() {
		return navCode;
	}

	public void setNavCode(String navCode) {
		this.navCode = navCode;
	}

	public String getS_ddTypeName() {
		return s_ddTypeName;
	}

	public void setS_ddTypeName(String s_ddTypeName) {
		this.s_ddTypeName = s_ddTypeName;
	}

	public String list(){//定义一个方法
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		Connection con=null;
		try{
			HttpSession session=request.getSession();//非IoC方式的第一种方法：使用org.apache.struts2.SerVletActionContext获取session对象
			DataDic s_dataDic=new DataDic();
			if(s_ddTypeName!=null){
				s_dataDic.setDdTypeName(s_ddTypeName);//非IoC方式的第一种方法：使用org.apache.struts2.SerVletActionContext获取session对象
				session.setAttribute("s_ddTypeName", s_ddTypeName);//非IoC方式的第一种方法：使用org.apache.struts2.SerVletActionContext获取session对象
			}else{
				Object o=session.getAttribute("s_ddTypeName");//非IoC方式的第一种方法：使用org.apache.struts2.SerVletActionContext获取session对象
				if(o!=null){
					s_ddTypeName=(String)session.getAttribute("s_ddTypeName");//非Ioc方式的第一种方法：使用org.apache.struts2.SerVletActionContext获取session对象
					s_dataDic.setDdTypeName(s_ddTypeName);
				}
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			con=dbUtil.getCon();
			dataDicList=dataDicDao.dataDicList(con,s_dataDic,pageBean);
			total=dataDicDao.dataDicCount(con, s_dataDic);
			pageCode=PageUtil.genPagation(request.getContextPath()+"/dataDic!list", total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			navCode=NavUtil.getNavgation("系统管理", "数据字典维护");
			mainPage="dataDic/dataDicList.jsp";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {//IoC方式访问Servlet API,要用到request对象。为request方法添加setter方法
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	public String delete(){
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject resultJson=new JSONObject();
			dataDicDao.dataDicDelete(con, ddId);
			resultJson.put("success", true);
			ResponseUtil.write(resultJson, ServletActionContext.getResponse());//非Ioc方式的第一种方法：使用org.apache.struts2.SerVletActionContext
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
