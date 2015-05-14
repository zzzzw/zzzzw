package com.henu.service;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
/**
 * Servlet implementation class DownloadwithServlet
 */
@WebServlet("/DownloadwithServlet")
public class DownloadwithServlet extends HttpServlet {
	ServletConfig config = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadwithServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String route =request.getParameter("route");
		SmartUpload su = new SmartUpload();
		// 初始化
		su.initialize(config, request, response);
		// 设定contentDisposition为null以禁止浏览器自动打开文件，
		//保证点击链接后是下载文件。若不设定，则下载的文件扩展名为doc时，浏览器将自动用Word打开它；
		//当扩展名为pdf时，浏览器将用acrobat打开。
		su.setContentDisposition(null);
		// 下载文件
		try {
			su.downloadFile('/'+route);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}

}
