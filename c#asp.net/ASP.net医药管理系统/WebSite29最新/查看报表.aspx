<%@ Page Language="C#" AutoEventWireup="true" CodeFile="查看报表.aspx.cs" Theme="TestTheme"Inherits="查看报表" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 258px">
    <form id="form1" runat="server">
    <div style="background-image: url('Image/白色m.jpg'); height: 820px;">
    
        <div style="height: 81px; background-image: url('Image/123123123.jpg'); width: 589px; margin-left: 248px;">
        </div>
    
        <br />
        <br />
        <br />
        <div style="margin-left: 263px">
        <asp:Button ID="Button1" runat="server" PostBackUrl="~/普通用户信息浏览/顾客信息.aspx" 
            Text="信息浏览" Width="234px" Height="65px" />
            <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="Button3" runat="server" PostBackUrl="~/普通用户数据报表/agency.aspx" 
            Text="数据报表" Height="67px" Width="359px" />
            <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="Button2" runat="server" PostBackUrl="~/Default.aspx" 
            Text="退出登录" Height="78px" Width="434px" />
        </div>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
    
    </div>
    </form>
</body>
</html>
