using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        if (xingming.Text != "")
        {
            OperateDataBase odb = new OperateDataBase();
            int i = odb.checkLogin(xingming.Text, TextBox2.Text, RadioButtonList1.SelectedValue);
            if (i > 0)
            {
                Session["UserName"] = this.xingming.Text;
                if (RadioButtonList1.SelectedValue == "管理员")
                { Response.Redirect("~/管理员查看列表.aspx"); }
                else if (RadioButtonList1.SelectedValue == "顾客")
                {
                    Response.Redirect("~/查看报表.aspx");
                }

            }
            else
            {
                Label1.Text = "用户名或者密码或者用户类型选择错误！";
                Label1.ForeColor = System.Drawing.Color.Red;
            }

        }
        else
        {
            lblMessage.Text = "用户名不能空！";
            //lblMessage.ForeColor = System.Drawing.Color.Red;
        }
    }
    protected void Button2_Click(object sender, EventArgs e)
    {
        xingming.Text = "";
        TextBox2.Text = "";
    }

    protected void RadioButtonList1_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}