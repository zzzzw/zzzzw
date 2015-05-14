<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>多文件上传</title>
  <script language="javascript">
     function addComponet()
     {
    	
      var uploadHTML = document.createElement("<input type='text' name='shuoming'/>");
      document.getElementById("files").appendChild(uploadHTML);
      uploadHTML = document.createElement("<input type='file' name='upload' />");
      document.getElementById("files").appendChild(uploadHTML);
      uploadHTML = document.createElement("<br>");
      document.getElementById("files").appendChild(uploadHTML);
     }
    </script>
</head>
<body>
<center>
<input type="button" onclick="addComponet()" value="继续添加" />
<FORM action="UploadwithServlet" method="post" ENCTYPE="multipart/form-data">
     <span id="files">
     <table>
     <tr><td>第一个文本框输入文本说明</td></tr>
     </table>
     <tr>
     <td><input type="text" name="shuoming" /></td><td><input type="file" name="upload" /></td>
     </tr>
     <br>
     </span>
     <input type="submit" value="上传" />
     <br> 
</FORM>
</center>
</body>
</html>