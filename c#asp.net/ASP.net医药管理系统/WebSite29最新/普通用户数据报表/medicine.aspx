<%@ Page Language="C#" AutoEventWireup="true" CodeFile="medicine.aspx.cs" Theme="TestTheme"Inherits="管理数据报表_medicine" %>

<%@ Register assembly="Microsoft.ReportViewer.WebForms, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a" namespace="Microsoft.Reporting.WebForms" tagprefix="rsweb" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div style="background-image: url('../Image/白色m.jpg'); height: 796px; margin-top: 0px;">
    
        <div style="height: 81px; background-image: url('../Image/123123123.jpg'); width: 589px; margin-left: 253px;">
        </div>
    
        <asp:Button ID="Button1" runat="server" PostBackUrl="~/普通用户数据报表/client.aspx" 
            Text="顾客报表" Height="44px" Width="167px" />
        <asp:Button ID="Button2" runat="server" PostBackUrl="~/普通用户数据报表/agency.aspx" 
            Text="经办人报表" Height="43px" Width="187px" />
        <asp:Button ID="Button3" runat="server" PostBackUrl="~/普通用户数据报表/medicine.aspx" 
            Text="药品报表" Height="43px" Width="192px" ForeColor="Red" />
        <asp:Button ID="Button4" runat="server" PostBackUrl="~/查看报表.aspx" Text="返回" 
            Height="44px" Width="204px" />
    
    <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
        ConflictDetection="CompareAllValues" 
        ConnectionString="<%$ ConnectionStrings:MediDB1ConnectionString %>" 
        DeleteCommand="DELETE FROM [medicine] WHERE [mno] = @original_mno AND (([mname] = @original_mname) OR ([mname] IS NULL AND @original_mname IS NULL)) AND (([mmode] = @original_mmode) OR ([mmode] IS NULL AND @original_mmode IS NULL)) AND (([mefficacy] = @original_mefficacy) OR ([mefficacy] IS NULL AND @original_mefficacy IS NULL))" 
        InsertCommand="INSERT INTO [medicine] ([mno], [mname], [mmode], [mefficacy]) VALUES (@mno, @mname, @mmode, @mefficacy)" 
        OldValuesParameterFormatString="original_{0}" 
        SelectCommand="SELECT * FROM [medicine]" 
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
    <div style="background-image: url('../Image/白色m.jpg')">
    
    </div>
    <asp:ScriptManager ID="ScriptManager1" runat="server">
    </asp:ScriptManager>
    <rsweb:ReportViewer ID="ReportViewer1" runat="server" Font-Names="Verdana" 
        Font-Size="8pt" InteractiveDeviceInfos="(集合)" WaitMessageFont-Names="Verdana" 
        WaitMessageFont-Size="14pt">
        <LocalReport ReportPath="管理数据报表\medicine.rdlc">
            <DataSources>
                <rsweb:ReportDataSource DataSourceId="SqlDataSource1" Name="DataSet1" />
            </DataSources>
        </LocalReport>
    </rsweb:ReportViewer>
    
    </div>
    <br />
    </form>
</body>
</html>
