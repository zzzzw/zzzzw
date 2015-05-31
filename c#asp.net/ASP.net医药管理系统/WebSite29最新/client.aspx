<%@ Page Language="C#" AutoEventWireup="true" CodeFile="client.aspx.cs" Theme="TestTheme"Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 268px; margin-left: 0px;">
    <form id="form1" runat="server" style="background-image: url('Image/白色m.jpg')">
    <div align="left" 
        
        style="background-position: center; height: 81px; background-image: url('Image/123123123.jpg'); width: 589px; margin-left: 260px;">
    </div>
    <asp:Button ID="Button1" runat="server" PostBackUrl="~/agency.aspx" 
        Text="经办人查询录入删除修改" Width="173px" Height="45px" />
    <asp:Button ID="Button2" runat="server" PostBackUrl="~/client.aspx" 
        Text="顾客查询录入删除修改" Width="177px" Height="37px" ForeColor="Red" />
    <asp:Button ID="Button3" runat="server" PostBackUrl="~/medicine.aspx" 
        Text="药品查询录入删除修改" Width="182px" Height="35px" />
    <asp:Button ID="Button6" runat="server" PostBackUrl="~/注册用户列表.aspx" 
        Text="注册用户列表查询添加删除修改" Width="263px" Height="36px" />
    <asp:Button ID="Button5" runat="server" PostBackUrl="~/管理员查看列表.aspx" 
        Text="信息浏览" Height="35px" Width="86px" />
    <asp:Button ID="Button8" runat="server" PostBackUrl="~/管理数据报表/client.aspx" 
        Text="数据报表" Height="33px" Width="89px" />
    <asp:Button ID="Button4" runat="server" PostBackUrl="~/Default.aspx" 
        Text="退出登录" Height="32px" Width="102px" />
    <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
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
    <br />
    <br />
    <div style="height: 1045px">
    <br />
        编号：<asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        姓名：<asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
        性别：<asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
        年龄:<asp:TextBox ID="TextBox4" runat="server"></asp:TextBox>
        地址：<asp:TextBox ID="TextBox5" runat="server"></asp:TextBox>
        电话：<asp:TextBox ID="TextBox6" runat="server"></asp:TextBox>
        症状：<asp:TextBox ID="TextBox7" runat="server"></asp:TextBox>
        已购药品：<asp:TextBox ID="TextBox8" runat="server"></asp:TextBox>
        经办人：<asp:TextBox ID="TextBox9" runat="server"></asp:TextBox>
        录入日期：<asp:TextBox ID="TextBox10" runat="server"></asp:TextBox>
        备注：<asp:TextBox ID="TextBox11" runat="server"></asp:TextBox>
    <asp:Button ID="Button7" runat="server" onclick="Button7_Click" Text="确定" />
        <br />
        <br />
    &nbsp;<asp:GridView ID="GridView2" runat="server" style="margin-left: 242px">
        </asp:GridView>
    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" 
        AllowSorting="True" AutoGenerateColumns="False" DataKeyNames="cno" 
        DataSourceID="SqlDataSource1" onrowcommand="GridView1_RowCommand" 
            style="margin-left: 239px; margin-top: 0px">
        <Columns>
            <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
            <asp:BoundField DataField="cno" HeaderText="编号" ReadOnly="True" 
                SortExpression="cno" />
            <asp:BoundField DataField="cname" HeaderText="姓名" SortExpression="cname" />
            <asp:BoundField DataField="csex" HeaderText="性别" SortExpression="csex" />
            <asp:BoundField DataField="cage" HeaderText="年龄" SortExpression="cage" />
            <asp:BoundField DataField="caddress" HeaderText="住址" 
                SortExpression="caddress" />
            <asp:BoundField DataField="cphone" HeaderText="电话" 
                SortExpression="cphone" />
            <asp:BoundField DataField="csymptom" HeaderText="症状" 
                SortExpression="csymptom" />
            <asp:BoundField DataField="mno" HeaderText="已购药品" SortExpression="mno" />
            <asp:BoundField DataField="ano" HeaderText="经办人" SortExpression="ano" />
            <asp:BoundField DataField="cdate" HeaderText="录入日期" SortExpression="cdate" />
            <asp:BoundField DataField="cremark" HeaderText="备注" 
                SortExpression="cremark" />
            <asp:ButtonField CommandName="Insert" Text="添加" />
        </Columns>
        <EmptyDataTemplate>
            <asp:DetailsView ID="DetailsView1" runat="server" AutoGenerateRows="False" 
                DataKeyNames="cno" DataSourceID="SqlDataSource1" DefaultMode="Insert" 
                Height="50px" oniteminserted="DetailsView1_ItemInserted" Width="466px" >
                <Fields>
                    <asp:BoundField DataField="cno" HeaderText="编号" ReadOnly="True" 
                        SortExpression="cno" />
                    <asp:BoundField DataField="cname" HeaderText="姓名" SortExpression="cname" />
                    <asp:BoundField DataField="csex" HeaderText="性别（男/女）" SortExpression="csex" />
                    <asp:BoundField DataField="cage" HeaderText="年龄" SortExpression="cage" />
                    <asp:BoundField DataField="caddress" HeaderText="住址" 
                        SortExpression="caddress" />
                    <asp:BoundField DataField="cphone" HeaderText="电话" SortExpression="cphone" />
                    <asp:BoundField DataField="csymptom" HeaderText="症状" 
                        SortExpression="csymptom" />
                    <asp:BoundField DataField="mno" HeaderText="已购药品（填写已经有药品的编号）" 
                        SortExpression="mno" />
                    <asp:BoundField DataField="ano" HeaderText="经办人（填写已经有经办人的编号）" 
                        SortExpression="ano" />
                    <asp:BoundField DataField="cdate" HeaderText="录入日期（****-**-** **:**:**）" 
                        SortExpression="cdate" />
                    <asp:BoundField DataField="cremark" HeaderText="备注" SortExpression="cremark" />
                    <asp:CommandField ShowInsertButton="True" />
                </Fields>
            </asp:DetailsView>
        </EmptyDataTemplate>
    </asp:GridView>
    </div>
    <br />
    </form>
</body>
</html>
