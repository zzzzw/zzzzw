package com.java1234.action;//���ڵİ�

import java.sql.Connection;//���ݿ����ӵ���
import java.util.ArrayList;//ArrayList��List����private List<DataDic> dataDicList=new ArrayList<DataDic>();���õ�
import java.util.List;//ArrayList��List����private List<DataDic> dataDicList=new ArrayList<DataDic>();���õ�

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;//����Servlet API��ʱ��ʹ�õķ�IOC��ʽ������һ��org.apache.Structs2.ServletActionContext��ȡsession��request��response
import org.apache.struts2.interceptor.ServletRequestAware; ////����Servlet API��ʱ��ʹ�õ�IOC��ʽ��Inversion of Control�������������󣬽��������������ǵķ�ʽ.����������Actionʵ��ServletRequestAware�ӿڶ��ѣ�û��ʵ��ServletResponseAware�ӿڻ���SessionWare�ӿ�

import com.java1234.dao.DataDicDao;
import com.java1234.model.DataDic;
import com.java1234.model.PageBean;
import com.java1234.util.DbUtil;
import com.java1234.util.NavUtil;
import com.java1234.util.PageUtil;
import com.java1234.util.PropertiesUtil;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;//action��Ҫ�̳������

/*����������ʵ��ServletRequestAware�ӿھ��Ƿ�IOC��ʽ��û��ʵ��ServletResponseAware�ӿڻ���SessionWare�ӿ�*/
// ����������̳���ActionSupport����࣬ʵ��IOC��ʽ
public class DataDicAction extends ActionSupport implements ServletRequestAware{  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;//����request
	private DbUtil dbUtil=new DbUtil();
	private DataDicDao dataDicDao=new DataDicDao();
	private List<DataDic> dataDicList=new ArrayList<DataDic>();//����һ��DataDic���͵�ArrayLst������ArrayList�����ʱ����Ҫ��List a=new ArrayList����������
	
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

	public String list(){//����һ������
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		Connection con=null;
		try{
			HttpSession session=request.getSession();//��IoC��ʽ�ĵ�һ�ַ�����ʹ��org.apache.struts2.SerVletActionContext��ȡsession����
			DataDic s_dataDic=new DataDic();
			if(s_ddTypeName!=null){
				s_dataDic.setDdTypeName(s_ddTypeName);//��IoC��ʽ�ĵ�һ�ַ�����ʹ��org.apache.struts2.SerVletActionContext��ȡsession����
				session.setAttribute("s_ddTypeName", s_ddTypeName);//��IoC��ʽ�ĵ�һ�ַ�����ʹ��org.apache.struts2.SerVletActionContext��ȡsession����
			}else{
				Object o=session.getAttribute("s_ddTypeName");//��IoC��ʽ�ĵ�һ�ַ�����ʹ��org.apache.struts2.SerVletActionContext��ȡsession����
				if(o!=null){
					s_ddTypeName=(String)session.getAttribute("s_ddTypeName");//��Ioc��ʽ�ĵ�һ�ַ�����ʹ��org.apache.struts2.SerVletActionContext��ȡsession����
					s_dataDic.setDdTypeName(s_ddTypeName);
				}
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			con=dbUtil.getCon();
			dataDicList=dataDicDao.dataDicList(con,s_dataDic,pageBean);
			total=dataDicDao.dataDicCount(con, s_dataDic);
			pageCode=PageUtil.genPagation(request.getContextPath()+"/dataDic!list", total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			navCode=NavUtil.getNavgation("ϵͳ����", "�����ֵ�ά��");
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
	public void setServletRequest(HttpServletRequest request) {//IoC��ʽ����Servlet API,Ҫ�õ�request����Ϊrequest�������setter����
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
			ResponseUtil.write(resultJson, ServletActionContext.getResponse());//��Ioc��ʽ�ĵ�һ�ַ�����ʹ��org.apache.struts2.SerVletActionContext
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
