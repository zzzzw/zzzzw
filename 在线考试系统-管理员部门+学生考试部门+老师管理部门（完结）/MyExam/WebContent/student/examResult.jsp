<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>考试结果</title>
<link href="images/css2.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
<!--
.STYLE3 {font-size: 18px; }
.STYLE4 {font-size: 18px; font-weight: bold; }
.STYLE5 {color: #FF0000}
-->
</style>

<body>
<table width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
  <tr>
    <td width="149" height="485">&nbsp;</td>
    <td width="741" valign="top" class="rightbian">
	<table width="60%" align="center" cellpadding="10" cellspacing="0" border="1">
      <tr>
        <td height="35" colspan="2"></td>
      </tr>
      <tr>
        <td height="49" colspan="2"><div align="center"><span class="STYLE4"><strong>JAVA</strong>考试情况表</span></div></td>
      </tr>
      <tr>
        <td><div align="center">考试姓名:${sessionScope.student.name}</div></td>
        <td><div align="center">考生得分:${request.GeneralPoint}分</div></td>
      </tr><tr>
      <td><div align="center">选择题答案：</div></td> 
      <td><div align="center"> <s:iterator id="li" value="#request.cz"><s:if test="#li!=null"><s:property /></s:if></s:iterator>
      </div></td>
      </tr>
      <tr>
        <td colspan="2"><div align="center">填空题答案：</div></td>
      </tr>
       <s:iterator id="li2" value="#request.fz" status="sta"><tr><td><div align="center">第${sta.index+1}题</div></td> <td ><div align="center"><s:if test="#li!=null"><s:property /></s:if></div></td></tr></s:iterator>
    </table></td>
    <td width="113">&nbsp;</td>
  </tr>
</table>
</body>
</html>
