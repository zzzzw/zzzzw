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
		// ��ʼ��
		su.initialize(config, request, response);
		// �趨contentDispositionΪnull�Խ�ֹ������Զ����ļ���
		//��֤������Ӻ��������ļ��������趨�������ص��ļ���չ��Ϊdocʱ����������Զ���Word������
		//����չ��Ϊpdfʱ�����������acrobat�򿪡�
		su.setContentDisposition(null);
		// �����ļ�
		try {
			su.downloadFile('/'+route);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}

}
