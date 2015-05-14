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
//引入DBbean
import com.henu.service.DBbean;


//获取系统时间头文件
import java.util.Date; 
import java.text.SimpleDateFormat;
@WebServlet("/UploadwithServlet")
public class UploadwithServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig servletconfig;
	 //重命名
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
		// 新建一个SmartUpload对象
		SmartUpload su = new SmartUpload(); 
		// 上传初始化
		su.initialize(servletconfig, request, response); 
		// 限制每个上传文件的最大长度。
		su.setMaxFileSize(10000000); 
		// 限制总上传数据的长度。
		su.setTotalMaxFileSize(20000000); 
		// 设定允许上传的文件（通过扩展名限制）,仅允许doc,txt文件。
		//su.setAllowedFilesList("jpg,txt,doc,excel");
		// 设定禁止上传的文件（通过扩展名限制）,禁止上传带有exe,bat,
		//jsp,htm,html扩展名的文件和没有扩展名的文件。
		try {
			su.setDeniedFilesList("exe,bat,jsp,htm,html,,");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 上传文件
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
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改 
		for(int i=0;i<count1;i++)
		{
			File ff=f.getFile(i);
			size=ff.getSize();  //获取文件大小  
			Shuoming=su.getRequest().getParameterValues("shuoming");  //获取文本框里面的说明（文本说明）
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
			// 将上传文件全部保存到指定目录
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
