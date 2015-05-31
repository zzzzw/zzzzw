<%@ Page Language="C#" AutoEventWireup="true" CodeFile="顾客信息.aspx.cs" Theme="TestTheme"Inherits="管理信息浏览_顾客信息aspx" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div style="background-image: url('../Image/白色m.jpg'); height: 552px;">
    
        <div style="height: 81px; background-image: url('../Image/123123123.jpg'); width: 589px; margin-left: 253px;">
        </div>
    
        <asp:Button ID="Button1" runat="server" PostBackUrl="~/管理信息浏览/经办人信息.aspx" 
            Text="经办人信息" Height="37px" Width="173px" />
        <asp:Button ID="Button2" runat="server" PostBackUrl="~/管理信息浏览/顾客信息.aspx" 
            Text="顾客信息" Height="38px" Width="185px" ForeColor="Red" />
        <asp:Button ID="Button3" runat="server" PostBackUrl="~/管理信息浏览/药品信息.aspx" 
            Text="药品信息" Height="37px" Width="185px" />
        <asp:Button ID="Button4" runat="server" PostBackUrl="~/管理员查看列表.aspx" 
            Text="返回" Height="36px" Width="188px"  />
        <asp:Button ID="Button5" runat="server" PostBackUrl="~/Default.aspx" 
            Text="退出登录" Height="34px" Width="207px" />
        <br />
        <br />
        <asp:SqlDataSource ID="SqlDataSource2" runat="server" 
            ConflictDetection="CompareAllValues" 
            ConnectionString="<%$ ConnectionStrings:MediDB1ConnectionString %>" 
            DeleteCommand="DELETE FROM [client] WHERE [cno] = @original_cno AND (([cname] = @original_cname) OR ([cname] IS NULL AND @original_cname IS NULL)) AND (([csex] = @original_csex) OR ([csex] IS NULL AND @original_csex IS NULL)) AND (([cage] = @original_cage) OR ([cage] IS NULL AND @original_cage IS NULL)) AND (([caddress] = @original_caddress) OR ([caddress] IS NULL AND @original_caddress IS NULL)) AND (([cphone] = @original_cphone) OR ([cphone] IS NULL AND @original_cphone IS NULL)) AND (([csymptom] = @original_csymptom) OR ([csymptom] IS NULL AND @original_csymptom IS NULL)) AND (([mno] = @original_mno) OR ([mno] IS NULL AND @original_mno IS NULL)) AND (([ano] = @original_ano) OR ([ano] IS NULL AND @original_ano IS NULL)) AND (([cdate] = @original_cdate) OR ([cdate] IS NULL AND @original_cdate IS NULL)) AND (([cremark] = @original_cremark) OR ([cremark] IS NULL AND @original_cremark IS NULL))" 
            InsertCommand="INSERT INTO [client] ([cno], [cname], [csex], [cage], [caddress], [cphone], [csymptom], [mno], [ano], [cdate], [cremark]) VALUES (@cno, @cname, @csex, @cage, @caddress, @cphone, @csymptom, @mno, @ano, @cdate, @cremark)" 
            OldValuesParameterFormatString="original_{0}" 
            SelectCommand="SELECT * FROM [client]" 
            
            UpdateCommand="UPDATE [client] SET [cname] = @cname, [csex] = @csex, [cage] = @cage, [caddress] = @caddress, [cphone] = @cphone, [csymptom] = @csymptom, [mno] = @mno, [ano] = @ano, [cdate] = @cdate, [cremark] = @cremark WHERE [cno] = @original_cno AND (([cname] = @original_cname) OR ([cname] IS NULL AND @original_cname IS NULL)) AND (([csex] = @original_csex) OR ([csex] IS NULL AND @original_csex IS NULL)) AND (([cage] = @original_cage) OR ([cage] IS NULL AND @original_cage IS NULL)) AND (([caddress] = @original_caddress) OR ([caddress] IS NULL AND @original_caddress IS NULL)) AND (([cphone] = @original_cphone) OR ([cphone] IS NULL AND @original_cphone IS NULL)) AND (([csymptom] = @original_csymptom) OR ([csymptom] IS NULL AND @original_csymptom IS NULL)) AND (([mno] = @original_mno) OR ([mno] IS NULL AND @original_mno IS NULL)) AND (([ano] = @original_ano) OR ([ano] IS NULL AND @original_ano IS NULL)) AND (([cdate] = @original_cdate) OR ([cdate] IS NULL AND @original_cdate IS NULL)) AND (([cremark] = @original_cremark) OR ([cremark] IS NULL AND @original_cremark IS NULL))">
            <DeleteParameters>
                <asp:Parameter Name="original_cno" Type="String" />
                <asp:Parameter Name="original_cname" Type="String" />
                <asp:Parameter Name="original_csex" Type="String" />
                <asp:Parameter Name="original_cage" Type="Int32" />
                <asp:Parameter Name="original_caddress" Type="String" />
                <asp:Parameter Name="original_cphone" Type="String" />
                <asp:Parameter Name="original_csymptom" Type="String" />
                <asp:Parameter Name="original_mno" Type="String" />
                <asp:Parameter Name="original_ano" Type="String" />
                <asp:Parameter Name="original_cdate" Type="DateTime" />
                <asp:Parameter Name="original_cremark" Type="String" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="cno" Type="String" />
                <asp:Parameter Name="cname" Type="String" />
                <asp:Parameter Name="csex" Type="String" />
                <asp:Parameter Name="cage" Type="Int32" />
                <asp:Parameter Name="caddress" Type="String" />
                <asp:Parameter Name="cphone" Type="String" />
                <asp:Parameter Name="csymptom" Type="String" />
                <asp:Parameter Name="mno" Type="String" />
                <asp:Parameter Name="ano" Type="String" />
                <asp:Parameter Name="cdate" Type="DateTime" />
                <asp:Parameter Name="cremark" Type="String" />
            </InsertParameters>
            <UpdateParameters>
                <asp:Parameter Name="cname" Type="String" />
                <asp:Parameter Name="csex" Type="String" />
                <asp:Parameter Name="cage" Type="Int32" />
                <asp:Parameter Name="caddress" Type="String" />
                <asp:Parameter Name="cphone" Type="String" />
                <asp:Parameter Name="csymptom" Type="String" />
                <asp:Parameter Name="mno" Type="String" />
                <asp:Parameter Name="ano" Type="String" />
                <asp:Parameter Name="cdate" Type="DateTime" />
                <asp:Parameter Name="cremark" Type="String" />
                <asp:Parameter Name="original_cno" Type="String" />
                <asp:Parameter Name="original_cname" Type="String" />
                <asp:Parameter Name="original_csex" Type="String" />
                <asp:Parameter Name="original_cage" Type="Int32" />
                <asp:Parameter Name="original_caddress" Type="String" />
                <asp:Parameter Name="original_cphone" Type="String" />
                <asp:Parameter Name="original_csymptom" Type="String" />
                <asp:Parameter Name="original_mno" Type="String" />
                <asp:Parameter Name="original_ano" Type="String" />
                <asp:Parameter Name="original_cdate" Type="DateTime" />
                <asp:Parameter Name="original_cremark" Type="String" />
            </UpdateParameters>
        </asp:SqlDataSource>
        <div style="margin-left: 139px">
        <asp:GridView ID="GridView2" runat="server" AllowPaging="True" 
            AutoGenerateColumns="False" DataKeyNames="cno" DataSourceID="SqlDataSource2">
            <Columns>
                <asp:BoundField DataField="cno" HeaderText="cno" ReadOnly="True" 
                    SortExpression="cno" />
                <asp:BoundField DataField="cname" HeaderText="cname" SortExpression="cname" />
                <asp:BoundField DataField="csex" HeaderText="csex" SortExpression="csex" />
                <asp:BoundField DataField="cage" HeaderText="cage" SortExpression="cage" />
                <asp:BoundField DataField="caddress" HeaderText="caddress" 
                    SortExpression="caddress" />
                <asp:BoundField DataField="cphone" HeaderText="cphone" 
                    SortExpression="cphone" />
                <asp:BoundField DataField="csymptom" HeaderText="csymptom" 
                    SortExpression="csymptom" />
                <asp:BoundField DataField="mno" HeaderText="mno" SortExpression="mno" />
                <asp:BoundField DataField="ano" HeaderText="ano" SortExpression="ano" />
                <asp:BoundField DataField="cdate" HeaderText="cdate" SortExpression="cdate" />
                <asp:BoundField DataField="cremark" HeaderText="cremark" 
                    SortExpression="cremark" />
            </Columns>
        </asp:GridView>
    
        </div>
    
    </div>
    </form>
</body>
</html>
