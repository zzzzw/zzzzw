<%@ Page Language="C#" AutoEventWireup="true" CodeFile="药品信息.aspx.cs" Theme="TestTheme"Inherits="管理信息浏览_药品信息" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div style="background-image: url('../Image/白色m.jpg'); height: 765px;">
    
        <div style="height: 81px; background-image: url('../Image/123123123.jpg'); width: 589px; margin-left: 251px;">
        </div>
    
        <asp:Button ID="Button1" runat="server" PostBackUrl="~/管理信息浏览/经办人信息.aspx" 
            Text="经办人信息" Height="37px" Width="173px" />
        <asp:Button ID="Button2" runat="server" PostBackUrl="~/管理信息浏览/顾客信息.aspx" 
            Text="顾客信息" Height="38px" Width="185px" />
        <asp:Button ID="Button3" runat="server" PostBackUrl="~/管理信息浏览/药品信息.aspx" 
            Text="药品信息" Height="37px" Width="185px" ForeColor="Red" />
        <asp:Button ID="Button4" runat="server" PostBackUrl="~/管理员查看列表.aspx" 
            Text="返回" Height="36px" Width="188px"  />
        <asp:Button ID="Button5" runat="server" PostBackUrl="~/Default.aspx" 
            Text="退出登录" Height="34px" Width="207px" />
        <br />
        <asp:SqlDataSource ID="SqlDataSource3" runat="server" 
            ConnectionString="<%$ ConnectionStrings:MediDB1ConnectionString %>" 
            SelectCommand="SELECT * FROM [medicine]" 
            ConflictDetection="CompareAllValues" 
            DeleteCommand="DELETE FROM [medicine] WHERE [mno] = @original_mno AND (([mname] = @original_mname) OR ([mname] IS NULL AND @original_mname IS NULL)) AND (([mmode] = @original_mmode) OR ([mmode] IS NULL AND @original_mmode IS NULL)) AND (([mefficacy] = @original_mefficacy) OR ([mefficacy] IS NULL AND @original_mefficacy IS NULL))" 
            InsertCommand="INSERT INTO [medicine] ([mno], [mname], [mmode], [mefficacy]) VALUES (@mno, @mname, @mmode, @mefficacy)" 
            OldValuesParameterFormatString="original_{0}" 
            UpdateCommand="UPDATE [medicine] SET [mname] = @mname, [mmode] = @mmode, [mefficacy] = @mefficacy WHERE [mno] = @original_mno AND (([mname] = @original_mname) OR ([mname] IS NULL AND @original_mname IS NULL)) AND (([mmode] = @original_mmode) OR ([mmode] IS NULL AND @original_mmode IS NULL)) AND (([mefficacy] = @original_mefficacy) OR ([mefficacy] IS NULL AND @original_mefficacy IS NULL))">
            <DeleteParameters>
                <asp:Parameter Name="original_mno" Type="String" />
                <asp:Parameter Name="original_mname" Type="String" />
                <asp:Parameter Name="original_mmode" Type="String" />
                <asp:Parameter Name="original_mefficacy" Type="String" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="mno" Type="String" />
                <asp:Parameter Name="mname" Type="String" />
                <asp:Parameter Name="mmode" Type="String" />
                <asp:Parameter Name="mefficacy" Type="String" />
            </InsertParameters>
            <UpdateParameters>
                <asp:Parameter Name="mname" Type="String" />
                <asp:Parameter Name="mmode" Type="String" />
                <asp:Parameter Name="mefficacy" Type="String" />
                <asp:Parameter Name="original_mno" Type="String" />
                <asp:Parameter Name="original_mname" Type="String" />
                <asp:Parameter Name="original_mmode" Type="String" />
                <asp:Parameter Name="original_mefficacy" Type="String" />
            </UpdateParameters>
        </asp:SqlDataSource>
        <div style="margin-left: 403px">
        <asp:GridView ID="GridView3" runat="server" AllowPaging="True" 
            AutoGenerateColumns="False" DataKeyNames="mno" DataSourceID="SqlDataSource3">
            <Columns>
                <asp:BoundField DataField="mno" HeaderText="mno" ReadOnly="True" 
                    SortExpression="mno" />
                <asp:BoundField DataField="mname" HeaderText="mname" SortExpression="mname" />
                <asp:BoundField DataField="mmode" HeaderText="mmode" SortExpression="mmode" />
                <asp:BoundField DataField="mefficacy" HeaderText="mefficacy" 
                    SortExpression="mefficacy" />
            </Columns>
        </asp:GridView>
    
        </div>
        <br />
    
    </div>
    </form>
</body>
</html>
