using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Configuration;
using System.Data;
using System.Data.SqlClient;

public partial class _Default : System.Web.UI.Page
{
    public SqlConnection GetCon()
    {
        //实例化SqlConnection对象
        SqlConnection sqlCon = new SqlConnection();
        //实例化SqlConnection对象连接数据库的字符串
        sqlCon.ConnectionString = "Data Source=XZ-20140816IMDR\\SQLEXPRESS;DataBase=MediDB1;uid=sa;pwd=sasasa";
        return sqlCon;
    }
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void GridView1_RowCommand(object sender, GridViewCommandEventArgs e)
    {
        if (e.CommandName == "Insert")
        {
            GridView1.DataSourceID = "";
            GridView1.DataBind();
        }
    }
    protected void DetailsView1_ItemInserted(object sender, DetailsViewInsertedEventArgs e)
    {
        GridView1.DataSourceID = "SqlDataSource1";
        GridView1.DataBind();

    }
    protected void Button7_Click(object sender, EventArgs e)
    {
        
        string sqlStr = "select * from client where 1=1";
        if (TextBox1.Text.Trim() != null)
        {
            sqlStr += "and cno like '%" + TextBox1.Text.Trim() + "%'";
        }
        if (TextBox2.Text.Trim() != null)
        {
            sqlStr += "and cname like '%" + TextBox2.Text.Trim() + "%'";
        }
        if (TextBox3.Text.Trim() != null)
        {
            sqlStr += "and csex like '%" + TextBox3.Text.Trim() + "%'";
        }
        if (TextBox4.Text.Trim() != null)
        {
            sqlStr += "and cage like '%" + TextBox4.Text.Trim() + "%'";
        }
        if (TextBox5.Text.Trim() != null)
        {
            sqlStr += "and caddress like '%" + TextBox5.Text.Trim() + "%'";
        }
        if (TextBox5.Text.Trim() != null)
        {
            sqlStr += "and cphone like '%" + TextBox6.Text.Trim() + "%'";
        }
        if (TextBox5.Text.Trim() != null)
        {
            sqlStr += "and csymptom like '%" + TextBox7.Text.Trim() + "%'";
        }
        if (TextBox5.Text.Trim() != null)
        {
            sqlStr += "and mno like '%" + TextBox8.Text.Trim() + "%'";
        }
        if (TextBox5.Text.Trim() != null)
        {
            sqlStr += "and ano like '%" + TextBox9.Text.Trim() + "%'";
        }
        if (TextBox5.Text.Trim() != null)
        {
            sqlStr += "and cdate like '%" + TextBox10.Text.Trim() + "%'";
        }
        if (TextBox5.Text.Trim() != null)
        {
            sqlStr += "and cremark like '%" + TextBox11.Text.Trim() + "%'";
        }
        
        
       
        SqlConnection myConn = GetCon();
        //定义SQL语句
        myConn.Open();
        //实例化SqlDataAdapter对象
        SqlDataAdapter da = new SqlDataAdapter(sqlStr, myConn);
        //实例化数据集DataSet
        DataSet ds = new DataSet();
        da.Fill(ds, "client");
        //绑定DataList控件
        GridView2.DataSource = ds;//设置数据源，用于填充控件中的项的值列表
        GridView2.DataKeyNames = new string[] { "cno" };  //设置表的主键名，要想对表编辑，必须设主键
        GridView2.DataBind();//将控件及其所有子控件绑定到指定的数据源
    }

    }
