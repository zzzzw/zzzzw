<%@page contentType="text/html;charset=gb2312"%>
 <%@page import="java.util.*"%> 
<html> 
<head>
 <title> �������ж� </title> 
 <script type="text/javascript" > 
function limitnumber(limit)
{          
	var strnumber=limit.value     ;
	if(strnumber.length>4)
	{
		alert("λ������4λ!!")     ;
		limit.value=""    ; 
		return;    
	}   
	var array=new Array();
    array=strnumber.split("")      ; 
    for(var i=0;i<array.length;i++)
    {   
         if(array[i]<"0"||array[i]>"9")
         {     
          alert("�߳���"+strnumber+"-->�з�����!!")  ;
          limit.value="";
          break;    
         }  
    }
 }  
 function clear()
{       
	 document.getElementById("textarea").value="";  
} 
 </script> 
 <style type="text/css">
 p.em{  
font-size:24px;
 word-spacing: 5px;
 font-style:italic;
 font-weight: 900; 
}  
</style> 
</head> 
 <body > 
 <p align="center" class="em">�ж�����������Ƿ�Ϊ������</p> 
<form action="sanjiaoxin.jsp" method="post"> 
<table align="center"> 
<tr>  
<td colspan="2">   
������߳�ֵ(����С�ڵ���4λ����)�� 
 </td> 
</tr> 
<tr> 
<td>   
�߳�1��<input type="text" style="width: 60px; height: 20px;" name="bianone" id="1" onkeyup="limitnumber(this);" value="0"> </td> <td>   
 �߳�2��<input type="text" style="width: 60px; height: 20px;" name="biantwo" id="2" onkeyup="limitnumber(this);" value="0"> </td> <td>  
 �߳�3��<input type="text" style="width: 60px; height: 20px;"  name="bianthree" id="3" onkeyup="limitnumber(this);" value="0"> </td> </tr> 
<tr> 
 <td colspan="3">  
 <TEXTAREA  name="textarea" id="textarea"   cols="60"  rows="6">   
<%@include file="sanjiaojb.jsp"%>  
 </TEXTAREA> 
</td> 
</tr> 
<tr>  
<td align="right" colspan="3"> 
 <input type="submit" name="tijiao" value="ִ���ж�" >
 </td>
 </tr> 
</table> 
</form> 
</body> 
</html>