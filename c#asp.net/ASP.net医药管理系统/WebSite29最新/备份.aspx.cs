using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Configuration;
using System.Data;
using System.Data.SqlClient;

public partial class 备份 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["MediDB1ConnectionString"].ToString());
        string sql = "backup database MediDB1 to disk='" + Server.MapPath("backup").ToString() + "/" + TextBox1.Text + System.DateTime.Now.DayOfYear.ToString() + DateTime.Now.Hour.ToString() + ".bak'";

        conn.Open();
        SqlCommand mycmd = new SqlCommand(sql, conn);
        try
        {
            mycmd.ExecuteNonQuery();
            //Response.Write("<script language=javascript>alert('备份成功!')</script>");
            Response.Write("<script language=javascript>alert('备份成功!');location='javascript:history.go(-1)'</script>");
        }
        catch (SqlException Err)
        {
            throw new System.Exception(Err.Message);
        }
    }
    }
