<%@ Page Language="C#" AutoEventWireup="true" CodeFile="备份.aspx.cs" Inherits="备份" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .style1
        {
            width: 59%;
            height: 214px;
            margin-left: 0px;
            top: 199px;
            left: 195px;
        }
        .style2
        {
            width: 254px;
           
        }
        .style4
        {
            width: 254px;
            height: 174px;
        }
        .style5
        {
            height: 174px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div style="background-image: url('Image/白色m.jpg'); height: 773px;">
    
        <br />
    
        <div style="height: 81px; background-image: url('Image/123123123.jpg'); width: 589px; margin-left: 253px;">
        </div>
        <div style="margin-top: 109px">
        <table class="style1" style="position: absolute">
            <tr>
                <td class="style4">
                    请输入备份的文件名</td>
                <td class="style5">
                    <asp:TextBox ID="TextBox1" runat="server" Height="37px" Width="302px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="position: absolute">
                    &nbsp;</td>
                <td>
                    <asp:Button ID="Button1" runat="server" Height="27px" onclick="Button1_Click" 
                        Text="备份" Width="71px" />
                    <asp:Button ID="Button2" runat="server" Height="26px" 
                        PostBackUrl="~/管理员查看列表.aspx" Text="返回" Width="61px" />
                </td>
            </tr>
        </table>
        </div>
        <br />
        <br />
        <br />
&nbsp;</div>
    </form>
</body>
</html>
