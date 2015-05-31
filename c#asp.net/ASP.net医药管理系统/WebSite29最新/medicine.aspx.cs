using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Configuration;

using System.Data;
using System.Data.SqlClient;

public partial class medicine : System.Web.UI.Page
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
          string sqlStr = "select * from medicine where 1=1";
        if (TextBox1.Text.Trim() != null)
        {
            sqlStr += "and mno like '%" + TextBox1.Text.Trim() + "%'";
        }
        if (TextBox2.Text.Trim() != null)
        {
            sqlStr += "and mname like '%" + TextBox2.Text.Trim() + "%'";
        }
        if (TextBox3.Text.Trim() != null)
        {
            sqlStr += "and mmode like '%" + TextBox3.Text.Trim() + "%'";
        }
        if (TextBox4.Text.Trim() != null)
        {
            sqlStr += "and mefficacy like '%" + TextBox4.Text.Trim() + "%'";
        }
      
        
       
        SqlConnection myConn = GetCon();
        //定义SQL语句
        myConn.Open();
        //实例化SqlDataAdapter对象
        SqlDataAdapter da = new SqlDataAdapter(sqlStr, myConn);
        //实例化数据集DataSet
        DataSet ds = new DataSet();
        da.Fill(ds, "medicine");
        //绑定DataList控件
        GridView2.DataSource = ds;//设置数据源，用于填充控件中的项的值列表
        GridView2.DataKeyNames = new string[] { "mno" };  //设置表的主键名，要想对表编辑，必须设主键
        GridView2.DataBind();//将控件及其所有子控件绑定到指定的数据源
    }
    }
