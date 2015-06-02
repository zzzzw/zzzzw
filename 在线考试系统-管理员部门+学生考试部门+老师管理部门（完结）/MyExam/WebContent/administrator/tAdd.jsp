<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>教师信息添加页面</title>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #EEF2FB;
	}
	#addSubjectForm table  td{
		font-size:12px;
	}
	-->
	</style>
	<link href="images/skin.css" rel="stylesheet" type="text/css">
  </head>
<body> 
 <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">录入教师信息</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="53%" valign="top">&nbsp;</td>
        </tr>
      <tr>
        <td valign="middle"><span class="left_txt">
			<div id="addSubjectForm" align="center">
				<form action="addteacher" method="post">
				<table border="0" cellspacing="10" cellpadding="0">
				 <tr>
						<td colspan="2"><s:actionmessage/></td>
				</tr>
				<tr>
					<td>教师登陆ID:</td>
					<td><input type="text" name="subjectID" size="20" ></td>
				  </tr>
				  <tr>
					<td>教师姓名:</td>
					<td><input type="text" name="subjectTitle" size="20" ></td>
				  </tr>
				  <tr>
					<td>教师性别:</td>
					<td><input type="text" name="subjectOptionA" size="20" ></td>
				  </tr>
				   <tr>
					<td>身份证号:</td>
					<td><input type="text" name="subjectOptionB" size="20" ></td>
				  </tr>
				   <tr>
					<td>教师用户密码:</td>
					<td><input type="text" name="subjectOptionC" size="20" ></td>
				  </tr>
				   <tr>
					<td>职称:</td>
					<td><input type="text" name="subjectOptionD" size="20" ></td>
				  </tr>
				   <tr>
					<td>电话:</td>
					<td>
						<input name="subjectAnswer" type="text" size="20" >
					</td>
				  </tr>
				  <tr>
				  	<td colspan="2"><div align="center">
				  	  <input type="submit" value="录入">				  	  
				  	  <input type="reset" value="重置">
			  	  </div>
				</td>
				  </tr>
			</table>
			</form>	
			</div>
		</td>
        </tr>
      
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
</html>