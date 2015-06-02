<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>教师信息页面</title>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #EEF2FB;
	}
	#updateSubjectForm table  td{
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
        <td height="31"><div class="titlebt">教师信息</div></td>
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
			<div id="updateSubjectForm" align="center"><!--更新试题表单-->
				<form action="teacherManageupdate.action" method="post">
				<table border="0" cellspacing="10" cellpadding="0">
					<tr>
						<td colspan="2"><s:actionmessage/></td>
					</tr>
				  <tr>
					<td>教师登陆ID:</td>
					<td>
						${sessionScope.teacher.tid}<input name="subjectID" type="hidden"  value="${sessionScope.teacher.tid}">
					</td>
				  </tr>
				   <tr>
					<td>教师姓名:</td>
					<td>
						<input name="subjectTitle" type="text" size="40"  value="${sessionScope.teacher.name}">
					</td>
				  </tr>
				  <tr>
					<td>教师性别:</td>
					<td><input type="text" name="subjectOptionA" size="40" value="${sessionScope.teacher.sex}"></td>
				  </tr>
				   <tr>
					<td>身份证号:</td>
					<td><input type="text" name="subjectOptionB" size="40" value="${sessionScope.teacher.cardNumber}"></td>
				  </tr>
				   <tr>
					<td>教师用户密码:</td>
					<td><input type="text" name="subjectOptionC" size="40" value="${sessionScope.teacher.password}"></td>
				  </tr>
				   <tr>
					<td>职称:</td>
					<td><input type="text" name="subjectOptionD" size="40" value="${sessionScope.teacher.title}"></td>
				  </tr>
				   <tr>
					<td>电话:</td>
					<td><input type="text" name="subjectAnswer" size="40" value="${sessionScope.teacher.phone}"></td>
				  </tr>
				  <tr>
				  	<td colspan="2"><div align="center">
				  	  <input type="submit" value="修改">				  	  
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
