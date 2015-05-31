<%@ Page Language="C#" AutoEventWireup="true" CodeFile="agency.aspx.cs"Theme="TestTheme" Inherits="管理数据报表_agency" %>

<%@ Register assembly="Microsoft.ReportViewer.WebForms, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a" namespace="Microsoft.Reporting.WebForms" tagprefix="rsweb" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div style="background-image: url('../Image/白色m.jpg'); height: 852px;">
    
        <div style="height: 81px; background-image: url('../Image/123123123.jpg'); width: 589px; margin-left: 256px;">
        </div>
    
        <asp:Button ID="Button1" runat="server" PostBackUrl="~/普通用户数据报表/client.aspx" 
            Text="顾客报表" Height="44px" Width="167px" ForeColor="Black" />
        <asp:Button ID="Button2" runat="server" PostBackUrl="~/普通用户数据报表/agency.aspx" 
            Text="经办人报表" Height="43px" Width="187px" ForeColor="Red" />
        <asp:Button ID="Button3" runat="server" PostBackUrl="~/普通用户数据报表/medicine.aspx" 
            Text="药品报表" Height="43px" Width="192px" />
        <asp:Button ID="Button4" runat="server" PostBackUrl="~/查看报表.aspx" Text="返回" 
            Height="44px" Width="204px" />
    
        <rsweb:ReportViewer ID="ReportViewer1" runat="server" Font-Names="Verdana" 
            Font-Size="8pt" InteractiveDeviceInfos="(集合)" WaitMessageFont-Names="Verdana" 
            WaitMessageFont-Size="14pt" Width="1001px">
            <LocalReport ReportPath="管理数据报表\agency.rdlc">
                <DataSources>
                    <rsweb:ReportDataSource DataSourceId="SqlDataSource1" Name="DataSet1" />
                </DataSources>
            </LocalReport>
        </rsweb:ReportViewer>
        <asp:ScriptManager ID="ScriptManager1" runat="server">
        </asp:ScriptManager>
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
    
    </div>
    </form>
</body>
</html>
