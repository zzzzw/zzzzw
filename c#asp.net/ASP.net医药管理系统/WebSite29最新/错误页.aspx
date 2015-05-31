<%@ Page Language="C#" AutoEventWireup="true" CodeFile="错误页.aspx.cs" Inherits="错误页" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div style="font-weight: 700">
    
        &nbsp;&nbsp;&nbsp;&nbsp;
        <br />
        <br />
&nbsp;注意！你的操作不合法！<br />
        <asp:Button ID="Button1" runat="server" PostBackUrl="~/client.aspx" Text="返回" />
    
    </div>
    </form>
</body>
</html>
