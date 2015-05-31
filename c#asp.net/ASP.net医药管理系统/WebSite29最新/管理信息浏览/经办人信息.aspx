<%@ Page Language="C#" AutoEventWireup="true" CodeFile="经办人信息.aspx.cs"Theme="TestTheme" Inherits="信息浏览_经办人信息" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div style="background-image: url('../Image/白色m.jpg'); height: 645px;">
    
        <div style="background-position: center center; height: 81px; background-image: url('../Image/123123123.jpg'); width: 589px; margin-left: 246px;">
        </div>
    
        <asp:Button ID="Button1" runat="server" PostBackUrl="~/管理信息浏览/经办人信息.aspx" 
            Text="经办人信息" Height="37px" Width="173px" ForeColor="Red" />
        <asp:Button ID="Button2" runat="server" PostBackUrl="~/管理信息浏览/顾客信息.aspx" 
            Text="顾客信息" Height="38px" Width="185px" />
        <asp:Button ID="Button3" runat="server" PostBackUrl="~/管理信息浏览/药品信息.aspx" 
            Text="药品信息" Height="37px" Width="185px" />
        <asp:Button ID="Button4" runat="server" PostBackUrl="~/管理员查看列表.aspx" 
            Text="返回" Height="36px" Width="188px"  />
        <asp:Button ID="Button5" runat="server" PostBackUrl="~/Default.aspx" 
            Text="退出登录" Height="34px" Width="207px" />
        <br />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConflictDetection="CompareAllValues" 
            ConnectionString="<%$ ConnectionStrings:MediDB1ConnectionString %>" 
            DeleteCommand="DELETE FROM [agency] WHERE [ano] = @original_ano AND (([aname] = @original_aname) OR ([aname] IS NULL AND @original_aname IS NULL)) AND (([asex] = @original_asex) OR ([asex] IS NULL AND @original_asex IS NULL)) AND (([aphone] = @original_aphone) OR ([aphone] IS NULL AND @original_aphone IS NULL)) AND (([aremark] = @original_aremark) OR ([aremark] IS NULL AND @original_aremark IS NULL))" 
            InsertCommand="INSERT INTO [agency] ([ano], [aname], [asex], [aphone], [aremark]) VALUES (@ano, @aname, @asex, @aphone, @aremark)" 
            OldValuesParameterFormatString="original_{0}" 
            SelectCommand="SELECT * FROM [agency]" 
            
            UpdateCommand="UPDATE [agency] SET [aname] = @aname, [asex] = @asex, [aphone] = @aphone, [aremark] = @aremark WHERE [ano] = @original_ano AND (([aname] = @original_aname) OR ([aname] IS NULL AND @original_aname IS NULL)) AND (([asex] = @original_asex) OR ([asex] IS NULL AND @original_asex IS NULL)) AND (([aphone] = @original_aphone) OR ([aphone] IS NULL AND @original_aphone IS NULL)) AND (([aremark] = @original_aremark) OR ([aremark] IS NULL AND @original_aremark IS NULL))">
            <DeleteParameters>
                <asp:Parameter Name="original_ano" Type="String" />
                <asp:Parameter Name="original_aname" Type="String" />
                <asp:Parameter Name="original_asex" Type="String" />
                <asp:Parameter Name="original_aphone" Type="String" />
                <asp:Parameter Name="original_aremark" Type="String" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="ano" Type="String" />
                <asp:Parameter Name="aname" Type="String" />
                <asp:Parameter Name="asex" Type="String" />
                <asp:Parameter Name="aphone" Type="String" />
                <asp:Parameter Name="aremark" Type="String" />
            </InsertParameters>
            <UpdateParameters>
                <asp:Parameter Name="aname" Type="String" />
                <asp:Parameter Name="asex" Type="String" />
                <asp:Parameter Name="aphone" Type="String" />
                <asp:Parameter Name="aremark" Type="String" />
                <asp:Parameter Name="original_ano" Type="String" />
                <asp:Parameter Name="original_aname" Type="String" />
                <asp:Parameter Name="original_asex" Type="String" />
                <asp:Parameter Name="original_aphone" Type="String" />
                <asp:Parameter Name="original_aremark" Type="String" />
            </UpdateParameters>
        </asp:SqlDataSource>
        <div style="margin-left: 376px">
        <asp:GridView ID="GridView1" runat="server" AllowPaging="True" 
            AutoGenerateColumns="False" DataKeyNames="ano" DataSourceID="SqlDataSource1">
            <Columns>
                <asp:BoundField DataField="ano" HeaderText="ano" ReadOnly="True" 
                    SortExpression="ano" />
                <asp:BoundField DataField="aname" HeaderText="aname" SortExpression="aname" />
                <asp:BoundField DataField="asex" HeaderText="asex" SortExpression="asex" />
                <asp:BoundField DataField="aphone" HeaderText="aphone" 
                    SortExpression="aphone" />
                <asp:BoundField DataField="aremark" HeaderText="aremark" 
                    SortExpression="aremark" />
            </Columns>
        </asp:GridView>
    
        </div>
        <br />
    
        <br />
    
    </div>
    </form>
</body>
</html>
