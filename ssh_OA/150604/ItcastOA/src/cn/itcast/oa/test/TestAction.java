package cn.itcast.oa.test;

import com.opensymphony.xwork2.ActionSupport;


public class TestAction extends ActionSupport
{
	@Override
	public String execute() throws Exception 
	{
		System.out.println("------->TestAction.execute()");
		return "success";
	}
}
