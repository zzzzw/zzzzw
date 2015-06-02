<%@page contentType="text/html;charset=gb2312"%>
 <%@page import="java.util.*"%> 
<html> 
<head>
 <title> 三角形判断 </title> 
 <script type="text/javascript" > 
function limitnumber(limit)
{          
	var strnumber=limit.value     ;
	if(strnumber.length>4)
	{
		alert("位数超过4位!!")     ;
		limit.value=""    ; 
		return;    
	}   
	var array=new Array();
    array=strnumber.split("")      ; 
    for(var i=0;i<array.length;i++)
    {   
         if(array[i]<"0"||array[i]>"9")
         {     
          alert("边长："+strnumber+"-->有非数字!!")  ;
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
 <p align="center" class="em">判断三个任意边是否为三角形</p> 
<form action="sanjiaoxin.jsp" method="post"> 
<table align="center"> 
<tr>  
<td colspan="2">   
请输入边长值(输入小于等于4位整数)： 
 </td> 
</tr> 
<tr> 
<td>   
边长1：<input type="text" style="width: 60px; height: 20px;" name="bianone" id="1" onkeyup="limitnumber(this);" value="0"> </td> <td>   
 边长2：<input type="text" style="width: 60px; height: 20px;" name="biantwo" id="2" onkeyup="limitnumber(this);" value="0"> </td> <td>  
 边长3：<input type="text" style="width: 60px; height: 20px;"  name="bianthree" id="3" onkeyup="limitnumber(this);" value="0"> </td> </tr> 
<tr> 
 <td colspan="3">  
 <TEXTAREA  name="textarea" id="textarea"   cols="60"  rows="6">   
<%@include file="sanjiaojb.jsp"%>  
 </TEXTAREA> 
</td> 
</tr> 
<tr>  
<td align="right" colspan="3"> 
 <input type="submit" name="tijiao" value="执行判断" >
 </td>
 </tr> 
</table> 
</form> 
</body> 
</html>