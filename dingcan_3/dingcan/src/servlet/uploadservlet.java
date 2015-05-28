package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DBbean;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class uploadservlet
 */
@WebServlet("/uploadservlet")
public class uploadservlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final int SAVEAS_PHYSICAL=0;
	ServletConfig servletconfig;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadservlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config)throws ServletException
    {
    	this.servletconfig=config;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("gbk");
		SmartUpload su=new SmartUpload();
		su.initialize(servletconfig, request, response);
		//limit the size of the upload's things
		su.setMaxFileSize(1000000);
		//限制总上传数据的长度
		su.setTotalMaxFileSize(2000000);
		//设定允许上传的文件（通过扩展名限制），禁止上传带有exe,bat,jsp,htm,html扩展名的文件和没有扩展名的文件。
		try{
			su.setDeniedFilesList("exe,bat,jsp,htm,html,");
		}catch(SQLException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			su.upload();
		}catch(SmartUploadException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		String a=su.getRequest().getParameter("xuhao");
		String b=su.getRequest().getParameter("mingchen");
		//b=new String(b.getBytes("ISO-8859-1"),"gbk");
		String c=su.getRequest().getParameter("miaoshu");
		String d=su.getRequest().getParameter("jiege");
		String e=su.getRequest().getParameter("cunhuo");
		String f=su.getRequest().getParameter("zhuangtai");
		File g=su.getFiles().getFile(0);//得到上传的第一个文件
		String h=b+"."+g.getFileExt();
		
		
		
		/*h="/upload/"+h;
		String realpath="/dingcan/WebContent";//这个要根据具体情况填写
		realpath=realpath+h;
		h="D:/Java"+realpath;//??
		System.out.println(h);*/
		
		
		String path=request.getSession().getServletContext().getRealPath("/upload");
		System.out.println(path);
		 String h1="upload/"+h;
		
		
		
		String sql="insert into shop values(";
		//sql=sql+"'"+a+"'"+","+"'"+b+"'"+","+"'"+c+"'"+"'"+"'"+h+"'"+","+"'"+d+"'"+","+"'"+e+"'"+","+"'"+f+"'"+")";
		sql=sql+"'"+a+"'"+","+"'"+b+"'"+","+"'"+c+"'"+","+"'"+h1+"'"+","+"'"+d+"'"+","+"'"+e+"'"+","+"'"+f+"'"+")";
		try{
			DBbean.executesql(sql);
		}catch(SQLException e1){
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			//g.saveAs(h, SAVEAS_PHYSICAL);//?
			g.saveAs(path+"/"+h);
			
		}catch(SmartUploadException e1){
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.sendRedirect("guanli.jsp");
	}

}
