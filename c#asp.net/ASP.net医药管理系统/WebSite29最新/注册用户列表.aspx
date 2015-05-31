<%@ Page Language="C#" AutoEventWireup="true" CodeFile="注册用户列表.aspx.cs" Theme="TestTheme"Inherits="Default2" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 682px">
    <form id="form1" runat="server">
    <div style="background-image: url('Image/白色m.jpg'); height: 742px;">
    
        <div style="height: 81px; background-image: url('Image/123123123.jpg'); width: 589px; margin-left: 252px;">
        </div>
    
        <asp:Button ID="Button1" runat="server" PostBackUrl="~/agency.aspx" 
            Text="经办人查询录入删除修改" Height="34px" Width="253px" />
        <asp:Button ID="Button2" runat="server" PostBackUrl="~/client.aspx" 
            Text="顾客查询录入删除修改" Height="33px" Width="218px" />
        <asp:Button ID="Button3" runat="server" PostBackUrl="~/medicine.aspx" 
            Text="药品查询录入删除修改" Height="32px" Width="220px" />
        <asp:Button ID="Button4" runat="server" PostBackUrl="~/注册用户列表.aspx" 
            Text="注册用户列表" Height="31px" Width="118px" ForeColor="Red" />
        <asp:Button ID="Button5" runat="server" 
            PostBackUrl="~/管理信息浏览/顾客信息.aspx" Text="信息浏览" Height="31px" Width="78px" />
        <asp:Button ID="Button7" runat="server" PostBackUrl="~/管理数据报表/agency.aspx" 
            Text="数据报表" Height="30px" Width="78px" />
        <asp:Button ID="Button6" runat="server" Text="退出登录" 
            PostBackUrl="~/Default.aspx" Height="32px" Width="78px" />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConflictDetection="CompareAllValues" 
            ConnectionString="<%$ ConnectionStrings:MediDB1ConnectionString %>" 
            DeleteCommand="DELETE FROM [tb_LoginUser] WHERE [UserID] = @original_UserID AND (([UserName] = @original_UserName) OR ([UserName] IS NULL AND @original_UserName IS NULL)) AND (([PassWord] = @original_PassWord) OR ([PassWord] IS NULL AND @original_PassWord IS NULL)) AND (([leibie] = @original_leibie) OR ([leibie] IS NULL AND @original_leibie IS NULL))" 
            InsertCommand="INSERT INTO [tb_LoginUser] ([UserID], [UserName], [PassWord], [leibie]) VALUES (@UserID, @UserName, @PassWord, @leibie)" 
            OldValuesParameterFormatString="original_{0}" 
            SelectCommand="SELECT * FROM [tb_LoginUser]" 
            
            UpdateCommand="UPDATE [tb_LoginUser] SET [UserName] = @UserName, [PassWord] = @PassWord, [leibie] = @leibie WHERE [UserID] = @original_UserID AND (([UserName] = @original_UserName) OR ([UserName] IS NULL AND @original_UserName IS NULL)) AND (([PassWord] = @original_PassWord) OR ([PassWord] IS NULL AND @original_PassWord IS NULL)) AND (([leibie] = @original_leibie) OR ([leibie] IS NULL AND @original_leibie IS NULL))">
            <DeleteParameters>
                <asp:Parameter Name="original_UserID" Type="Int32" />
                <asp:Parameter Name="original_UserName" Type="String" />
                <asp:Parameter Name="original_PassWord" Type="String" />
                <asp:Parameter Name="original_leibie" Type="String" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="UserID" Type="Int32" />
                <asp:Parameter Name="UserName" Type="String" />
                <asp:Parameter Name="PassWord" Type="String" />
                <asp:Parameter Name="leibie" Type="String" />
            </InsertParameters>
            <UpdateParameters>
                <asp:Parameter Name="UserName" Type="String" />
                <asp:Parameter Name="PassWord" Type="String" />
                <asp:Parameter Name="leibie" Type="String" />
                <asp:Parameter Name="original_UserID" Type="Int32" />
                <asp:Parameter Name="original_UserName" Type="String" />
                <asp:Parameter Name="original_PassWord" Type="String" />
                <asp:Parameter Name="original_leibie" Type="String" />
            </UpdateParameters>
        </asp:SqlDataSource>
        <div style="margin-left: 279px">
        <asp:GridView ID="GridView1" runat="server" AllowPaging="True" 
            AllowSorting="True" AutoGenerateColumns="False" DataKeyNames="UserID" 
            DataSourceID="SqlDataSource1" onrowcommand="GridView1_RowCommand">
            <Columns>
                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                <asp:BoundField DataField="UserID" HeaderText="UserID" ReadOnly="True" 
                    SortExpression="UserID" />
                <asp:BoundField DataField="UserName" HeaderText="UserName" 
                    SortExpression="UserName" />
                <asp:BoundField DataField="PassWord" HeaderText="PassWord" 
                    SortExpression="PassWord" />
                <asp:BoundField DataField="leibie" HeaderText="leibie" 
                    SortExpression="leibie" />
                <asp:ButtonField CommandName="Insert" Text="插入" />
            </Columns>
            <EmptyDataTemplate>
                <asp:DetailsView ID="DetailsView1" runat="server" AutoGenerateRows="False" 
                    DataKeyNames="UserID" DataSourceID="SqlDataSource1" DefaultMode="Insert" 
                    Height="50px" oniteminserted="DetailsView1_ItemInserted" Width="429px">
                    <Fields>
                        <asp:BoundField DataField="UserID" HeaderText="UserID" ReadOnly="True" 
                            SortExpression="UserID" />
                        <asp:BoundField DataField="UserName" HeaderText="UserName" 
                            SortExpression="UserName" />
                        <asp:BoundField DataField="PassWord" HeaderText="PassWord" 
                            SortExpression="PassWord" />
                        <asp:BoundField DataField="leibie" HeaderText="leibie（”管理员“或者“顾客”）" 
                            SortExpression="leibie" />
                        <asp:CommandField ShowInsertButton="True" />
                    </Fields>
                </asp:DetailsView>
            </EmptyDataTemplate>
        </asp:GridView>
        </div>
        <br />
    
    </div>
    </form>
</body>
</html>
