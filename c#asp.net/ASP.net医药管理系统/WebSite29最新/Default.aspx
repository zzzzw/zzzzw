<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs"Theme="TestTheme" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div style="background-image: url('Image/9d82d158ccbf6c81faae37eabe3eb13533fa4012.jpg'); height: 763px; width: 1369px; margin-left: 0px; font-weight: 900; color: #0000FF; margin-top: 0px;">
    
        <br />
        <div style="height: 263px; width: 614px; margin-left: 485px; margin-top: 244px; font-size: x-large;">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <br />
            <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 医药管理信息系统<br />
&nbsp;&nbsp;&nbsp;
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 用户：<asp:TextBox 
                ID="xingming" runat="server"></asp:TextBox>
        <asp:Label ID="lblMessage" runat="server"></asp:Label>
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 密码：<asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
            <asp:Label ID="Label1" runat="server"></asp:Label>
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:RadioButtonList ID="RadioButtonList1" runat="server" 
            RepeatDirection="Horizontal" RepeatLayout="Flow" onselectedindexchanged="RadioButtonList1_SelectedIndexChanged"  
               >
            <asp:ListItem>管理员</asp:ListItem>
            <asp:ListItem>顾客</asp:ListItem>
        </asp:RadioButtonList>
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="Button1" runat="server" onclick="Button1_Click" Text="登陆" 
            Width="55px" />
        <asp:Button ID="Button2" runat="server" Text="重置" Width="57px" 
            onclick="Button2_Click" />
            <asp:Button ID="Button8" runat="server" PostBackUrl="~/修改密码.aspx" Text="修改密码" />
        </div>
        <br />
        <br />
        <br />
        <br />
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <br />
        <br />
&nbsp;</div>
    </form>
</body>
</html>
