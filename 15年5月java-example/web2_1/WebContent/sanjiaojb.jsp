<%@ page language="java" import="java.util.*"
 pageEncoding="gb2312"%>   
 <jsp:useBean id="sanjiao" class="lab.sanjiao" scope="application" /> 
 <%       
 String n=request.getParameter("bianone");   
 if(n==null||n.equals(""))
 {
	 n="0";
 }   
 int bian1=Integer.parseInt(n); 
 
 
 n=request.getParameter("biantwo"); 
 if(n==null||n.equals(""))
 {
	n="0";
 } 
 int bian2=Integer.parseInt(n); 
 
 
 n=request.getParameter("bianthree"); 
 if(n==null||n.equals(""))
 {
	 n="0";
 } 
 int bian3=Integer.parseInt(n);
 
 if(bian3!=0&&bian2!=0&&bian1!=0)
 {    
	 sanjiao.setbian(bian1,bian2,bian3);   
	 out.println(" ���ͣ�"+sanjiao.getType()+"   ");
	 out.println(" �����"+sanjiao.getArea()+"   "); 
	 out.println(" �߳���"+bian1+" "+bian2+" "+bian3);  
 }  
 %>