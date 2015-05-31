<%@ Page Language="C#" AutoEventWireup="true" CodeFile="修改密码.aspx.cs" Inherits="修改密码" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div style="background-image: url('Image/白色m.jpg'); height: 713px;">
    
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <div style="height: 241px; width: 414px; margin-left: 309px">
            <strong>用户名</strong>：<asp:DropDownList ID="DropDownList1" runat="server">
        </asp:DropDownList>
        <br />
            <strong>请输入原密码</strong>：<asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
            ControlToValidate="TextBox1" ErrorMessage="密码不能为空"></asp:RequiredFieldValidator>
        <br />
            <strong>输入新密码</strong>：&nbsp;&nbsp;&nbsp; <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
            ControlToValidate="TextBox2" ErrorMessage="密码不能为空"></asp:RequiredFieldValidator>
        <br />
            <strong>再输入新密码</strong>：<asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
        <asp:CompareValidator ID="CompareValidator1" runat="server" 
            ControlToCompare="TextBox2" ControlToValidate="TextBox3" ErrorMessage="两次输入不一致"></asp:CompareValidator>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="Button8" runat="server" onclick="Button8_Click" Text="确定" />
        <asp:Button ID="Button9" runat="server" onclick="Button9_Click" Text="重置" />
    
    &nbsp;</div>
    
    </div>
    </form>
    <p>
        &nbsp;</p>
</body>
</html>
