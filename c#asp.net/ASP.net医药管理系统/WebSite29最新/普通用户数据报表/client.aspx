<%@ Page Language="C#" AutoEventWireup="true" CodeFile="client.aspx.cs"Theme="TestTheme" Inherits="管理数据报表_client" %>

<%@ Register assembly="Microsoft.ReportViewer.WebForms, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a" namespace="Microsoft.Reporting.WebForms" tagprefix="rsweb" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div style="background-image: url('../Image/白色m.jpg'); height: 832px;">
    
        <div style="height: 81px; background-image: url('../Image/123123123.jpg'); width: 589px; margin-left: 254px;">
        </div>
    
        <asp:Button ID="Button1" runat="server" PostBackUrl="~/普通用户数据报表/client.aspx" 
            Text="顾客报表" Height="44px" Width="167px" ForeColor="Red" />
        <asp:Button ID="Button2" runat="server" PostBackUrl="~/普通用户数据报表/agency.aspx" 
            Text="经办人报表" Height="43px" Width="187px" />
        <asp:Button ID="Button3" runat="server" PostBackUrl="~/普通用户数据报表/medicine.aspx" 
            Text="药品报表" Height="43px" Width="192px" />
        <asp:Button ID="Button4" runat="server" PostBackUrl="~/查看报表.aspx" Text="返回" 
            Height="44px" Width="204px" />
    
        <br />
        <asp:ScriptManager ID="ScriptManager1" runat="server">
        </asp:ScriptManager>
    
        <rsweb:ReportViewer ID="ReportViewer1" runat="server" Font-Names="Verdana" 
            Font-Size="8pt" InteractiveDeviceInfos="(集合)" WaitMessageFont-Names="Verdana" 
            WaitMessageFont-Size="14pt" Width="1324px" Height="406px">
            <LocalReport ReportPath="管理数据报表\client.rdlc">
                <DataSources>
                    <rsweb:ReportDataSource DataSourceId="SqlDataSource1" Name="DataSet1" />
                </DataSources>
            </LocalReport>
        </rsweb:ReportViewer>
    
        <br />
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
    
    </div>
    </form>
</body>
</html>
