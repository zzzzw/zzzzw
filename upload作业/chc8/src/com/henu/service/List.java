package com.henu.service;
import java.sql.ResultSet;
import com.henu.service.DBbean;
public class List{

	private StringBuffer list;
	public StringBuffer getList()
	{
		list = new  StringBuffer("");
		String sql="select * from information";
		DBbean.getDBConnection();
		try
		{
			ResultSet rs =new DBbean().getResultSet(sql);
			list.append("<table align=center border=1 >");
			list.append("<tr><th>�ļ�˵��</th><th>�ļ���</th><th>�ļ���С</th><th>�ϴ�ʱ��</th></tr>");
			while(rs.next())
			{
				list.append("<tr><td><a href='DownloadwithServlet?route="+rs.getString("route")+"'>"+rs.getString("shuoming")+"</a></td>");
				list.append("<td>"+rs.getString("name")+"</td><td>"+rs.getString("size")+"</td><td>"+rs.getString("time")+"</td></tr>");
			}
			list.append("</table>");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.list;
	}
	public void setList(StringBuffer list)
	{
		this.list=list;
	}
}
