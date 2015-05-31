using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;

public partial class 修改密码 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        OperateDataBase odb = new OperateDataBase();
        if (!IsPostBack)
        {
            string strUserID = "select * from tb_LoginUser";
            SqlDataReader sqr = odb.ExceRead(strUserID);
            if (sqr.HasRows)
            {
                while (sqr.Read())
                {
                    DropDownList1.Items.Add(sqr["UserName"].ToString());
                }
                ListItem li = new ListItem("请选择", "0");
                DropDownList1.Items.Insert(0, li);
            }
            sqr.Close();
        }

    }
    protected void Button8_Click(object sender, EventArgs e)
    {
        OperateDataBase odb = new OperateDataBase();
        string cmdsql = "select * from tb_LoginUser where UserName='" + DropDownList1.SelectedValue.Trim() + "'";
        SqlDataReader myRead = odb.ExceRead(cmdsql);
        myRead.Read();
        string cao = myRead["PassWord"].ToString().Trim();
        myRead.Close();
        if (TextBox1.Text != "")
        {
            if (TextBox1.Text.Trim() != cao)
            {
                Response.Write("<script>alert('原密码输入错误！')</script>");
            }
            else
            {
                    string pwd = this.TextBox2.Text;
                    string update_sql = "update tb_LoginUser set PassWord='" + pwd + "'where UserName='" + DropDownList1.SelectedValue.Trim() + "'";
                    bool update_data = odb.ExceSql(update_sql);
                    if (update_data == true)
                    {
                        Response.Write("<script language=javascript>alert('修改成功!');location='Default.aspx'</script>");
                    }
                    else
                    {
                        Response.Write("<script language=javascript>alert('修改失败!');location='javascript:history.go(-1)'</script>");
                    }
                }
           
        }
        else
        {
            Response.Write("<script>alert('请输入原密码！')</script>");
        }

    }
    protected void Button9_Click(object sender, EventArgs e)
    {

        this.TextBox1.Text = this.TextBox2.Text = this.TextBox3.Text = "";
    }
}

    