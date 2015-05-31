<%@ Page Language="C#" AutoEventWireup="true" CodeFile="管理员查看列表.aspx.cs"Theme="TestTheme" Inherits="管理员查看列表" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div style="background-image: url('Image/白色m.jpg'); height: 523px;">
    
        <div style="margin-left: 283px; margin-top: 136px">
    
        <asp:Button ID="Button1" runat="server" PostBackUrl="~/agency.aspx" 
            Text="经办人查询录入删除修改" Width="274px" Height="38px" />
        <asp:Button ID="Button4" runat="server" PostBackUrl="~/管理信息浏览/顾客信息.aspx" 
            Text="信息浏览" Height="39px" Width="281px" />
            <br />
        <asp:Button ID="Button2" runat="server" PostBackUrl="~/client.aspx" 
            Text="顾客查询录入删除修改" Width="274px" Height="44px" />
        <asp:Button ID="Button7" runat="server" PostBackUrl="~/管理数据报表/agency.aspx" 
            Text="数据报表" Height="45px" Width="282px" />
            <br />
        <asp:Button ID="Button3" runat="server" PostBackUrl="~/medicine.aspx" 
            Text="药品查询录入删除修改" Height="46px" Width="272px" />
            <asp:Button ID="Button8" runat="server" Height="43px" Text="备份" Width="283px" 
                PostBackUrl="~/备份.aspx" />
            <br />
        <asp:Button ID="Button6" runat="server" PostBackUrl="~/注册用户列表.aspx" 
            Text="注册用户列表查询添加删除修改" Width="279px" Height="45px" 
                style="margin-left: 0px; margin-top: 0px" />
        <asp:Button ID="Button5" runat="server" PostBackUrl="~/Default.aspx" 
            Text="退出" Height="47px" Width="284px" />
            <br />
            <br />
            <br />
        </div>
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <br />
        <br />
    
    </div>
    </form>
</body>
</html>
