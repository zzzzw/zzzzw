package com.henu.service;
import java.io.IOException;
import java.util.Calendar; 
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
//����DBbean
import com.henu.service.DBbean;


//��ȡϵͳʱ��ͷ�ļ�
import java.util.Date; 
import java.text.SimpleDateFormat;
@WebServlet("/UploadwithServlet")
public class UploadwithServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig servletconfig;
	 //������
	 /*File file=new File("D:\\abc.txt");  
	 if(file.exists())
	 {
	 file.renameTo(new File("D:\\123.txt"));
	 }*/
    public UploadwithServlet() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {
		this.servletconfig = config;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK"); 
		// �½�һ��SmartUpload����
		SmartUpload su = new SmartUpload(); 
		// �ϴ���ʼ��
		su.initialize(servletconfig, request, response); 
		// ����ÿ���ϴ��ļ�����󳤶ȡ�
		su.setMaxFileSize(10000000); 
		// �������ϴ����ݵĳ��ȡ�
		su.setTotalMaxFileSize(20000000); 
		// �趨�����ϴ����ļ���ͨ����չ�����ƣ�,������doc,txt�ļ���
		//su.setAllowedFilesList("jpg,txt,doc,excel");
		// �趨��ֹ�ϴ����ļ���ͨ����չ�����ƣ�,��ֹ�ϴ�����exe,bat,
		//jsp,htm,html��չ�����ļ���û����չ�����ļ���
		try {
			su.setDeniedFilesList("exe,bat,jsp,htm,html,,");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// �ϴ��ļ�
		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		Files f=su.getFiles();
		int count1=f.getCount();
		int size;
		String time;
		String[] Shuoming;
		String name,s,sql;
		int j;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println(path);
		//System.out.println(path1);
		Calendar c = Calendar.getInstance();//���Զ�ÿ��ʱ���򵥶��޸� 
		for(int i=0;i<count1;i++)
		{
			File ff=f.getFile(i);
			size=ff.getSize();  //��ȡ�ļ���С  
			Shuoming=su.getRequest().getParameterValues("shuoming");  //��ȡ�ı��������˵�����ı�˵����
			j=(int)(Math.random()*900)+100;
			s = String.valueOf(j);
			int year = c.get(Calendar.YEAR); 
			String Year = String.valueOf(year);
			int month = c.get(Calendar.MONTH); 
			String Month = String.valueOf(month);
			int date = c.get(Calendar.DATE); 
			String Date = String.valueOf(date);
			int hour = c.get(Calendar.HOUR_OF_DAY); 
			String Hour = String.valueOf(hour);
			int minute = c.get(Calendar.MINUTE); 
			String Minute = String.valueOf(minute);
			int second = c.get(Calendar.SECOND);
			String Second = String.valueOf(second);
			name=Year+'-'+Month+'-'+Date+' '+Hour+'-'+Minute+'-'+Second+' '+s+'.'+ff.getFileExt();
			time = Year+'-'+Month+'-'+Date+' '+Hour+'-'+Minute+'-'+Second;
			String path=request.getSession().getServletContext().getRealPath("/upload");
			System.out.println(path);
			String path1="upload/"+name;
			sql="insert into information values ('";
			sql+=name+"',"+size+",'"+time+"','"+path1+"','"+Shuoming[i]+"')";
			//System.out.println(sql);
			DBbean.getDBConnection();
			try {
				new DBbean().executesql(sql);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ���ϴ��ļ�ȫ�����浽ָ��Ŀ¼
			try {
				 int count = su.save("/upload");
				  ff.saveAs(path+"/"+name); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		response.sendRedirect("view.jsp");
	}
}
