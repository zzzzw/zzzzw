package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DBbean;

/**
 * Servlet implementation class shopservlet
 */
@WebServlet("/shopservlet")
public class shopservlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopservlet()
    {
        super();
        // TODO Auto-generated constructor stub
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
		String action=request.getParameter("action");
		if(action.equals("delete"))
		{
			String a=request.getParameter("xuhao");
			String sql="delete from shop where xuhao='"+a+"'";
			try{
				DBbean.executesql(sql);
			}catch(SQLException e){
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("guanli.jsp");
		}
		if(action.equals("delete2"))
		{
			String a=request.getParameter("xuhao");
			String sql="delete from cart where xuhao='"+"'";
			try{
				DBbean.executesql(sql);
				
			}catch(SQLException e){
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("cart.jsp");
		}
		if(action.equals("jian"))
		{
			String a=request.getParameter("xuhao");
			String sql="update cart set shuliang=shuliang-1 where xuhao='"+a+"'";
			try{
				DBbean.executesql(sql);
			}catch(SQLException e){
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("car.jsp");
		}
		if(action.equals("jia"))
		{
			String a=request.getParameter("xuhao");
			String sql="update cart set shuliang =shuliang+1 where xuhao='"+a+"'";
			try {
				DBbean.executesql(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("cart.jsp");
		}
		if(action.equals("update"))
		{
			String a=request.getParameter("xuhao");
			String b=request.getParameter("mingchen");
			//b=new String(b.getBytes("ISO-8859-1"),"gbk");
			String c=request.getParameter("miaoshu");
			//c=new String(c.getBytes("ISO-8859-1"),"gbk");
			String d=request.getParameter("jiege");
			String e=request.getParameter("cunhuo");
			String f=request.getParameter("zhuangtai");
			//f=new String(f.getBytes("ISO-8859-1"),"gbk");
			String sql="update shop set ";
			sql=sql+"mingchen='"+b+"', miaoshu='"+c+"', jiege='"+d+"', cunhuo='"+e+"', zhuangtai='"+f+"'";
			sql=sql+" where xuhao='"+a+"'";
			try {
				DBbean.executesql(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.sendRedirect("guanli.jsp");
		}
		if(action.equals("qingkong"))
		{
			String sql="delete from cart";
			try {
				DBbean.executesql(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("home.jsp");
		}
		if(action.equals("upordown"))
		{
			String a=request.getParameter("xuhao");
			String b=new String(request.getParameter("zhuangtai").getBytes("iso-8859-1"),"gbk");
			String sql2=null;
			try{
				if(b.equals("�¼�"))
				{
					sql2="update shop set zhuangtai='�ϼ�' where  xuhao='"+a+"'";
					DBbean.executesql(sql2);
				}
				if(b.equals("�ϼ�"))
				{
					sql2="update shop set zhuangtai='�ϼ�' where xuhao='"+a+"'";
					DBbean.execute(sql2);
				}
			}catch(SQLException e){
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("guanli.jsp");
		}
	}

}
