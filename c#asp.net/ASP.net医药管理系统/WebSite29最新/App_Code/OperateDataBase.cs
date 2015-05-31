using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.Data;
using System.Configuration;
using System.Data.SqlClient;

/// <summary>
///OperateDataBase 的摘要说明
/// </summary>
public class OperateDataBase
{
    protected SqlConnection conn;
    protected string conStr;
    public OperateDataBase()
    {
        conStr = "Data Source=XZ-20140816IMDR\\SQLEXPRESS;DataBase=MediDB1;uid=sa;pwd=sasasa";
    }
    private void Open()                          //定义一个私有方法，防止外界访问
    {
        if (conn == null)                        //判断数据库连接是否存在
        {
            conn = new SqlConnection(conStr);    //不存在，新建数据库连接
            conn.Open();                         //打开数据库连接
        }
        else
        {
            if (conn.State.Equals(ConnectionState.Closed))//存在，判断是否关闭
                conn.Open();                             //连接处于关闭状态，重新打开
        }
    }
    public void Close()                                 //定义一个公有方法，关闭数据库连接
    {
        if (conn.State.Equals(ConnectionState.Open))
        {
            conn.Close();                               //连接处于打开状态，关闭连接
        }
    }
    public void Dispose()
    {
        if (conn != null)
        {
            conn.Dispose();
            conn = null;
        }
    }
    /// <summary>
    /// 析构函数，释放非托管资源
    /// </summary>
    ~OperateDataBase()
    {
        try
        {
            if (conn != null)
                conn.Close();
        }
        catch { }
        try
        {
            Dispose();                                //释放占有资源
        }
        catch { }
    }
    /// <summary>
    /// 此方法用来执行SQL语句
    /// </summary>
    /// <param name="SqlCom">要执行的SQL语句</param>
    /// <returns></returns>
    public bool ExceSql(string strSqlCom)
    {
        Open();
        SqlCommand sqlcom = new SqlCommand(strSqlCom, conn);
        try
        {
            sqlcom.ExecuteNonQuery();                       //执行添加操作的SQL语句
            return true;
        }
        catch
        {
            return false;                                   //执行SQL语句失败，返回false
        }
        finally
        {
            Close();
        }
    }
    /// <summary>
    /// 此方法返回一个SqlDataReader类型的参数
    /// </summary>
    /// <param name="SqlCom"></param>
    /// <returns></returns>

    /// <summary>
    /// 参数传值方法，防止SQL注入式攻击
    /// </summary>
    public int checkLogin(string loginName, string loginPwd,string leibie)
    {
        string strsql = "select count(*) from tb_LoginUser where UserName=@UserName and PassWord=@PassWord and leibie=@leibie";
        Open();
        SqlCommand sqlcom = new SqlCommand(strsql, conn);
        sqlcom.Parameters.Add(new SqlParameter("@UserName", SqlDbType.NVarChar, 50));
        sqlcom.Parameters["@UserName"].Value = loginName;
        sqlcom.Parameters.Add(new SqlParameter("@PassWord", SqlDbType.NVarChar, 50));
        sqlcom.Parameters["@PassWord"].Value = loginPwd;
        sqlcom.Parameters.Add(new SqlParameter("@leibie", SqlDbType.NVarChar, 50));
        sqlcom.Parameters["@leibie"].Value = leibie;
        int i = (int)sqlcom.ExecuteScalar();              //执行查询，并返回结果的第一行的第一列
        Close();
        return i;
    }
    public SqlDataReader ExceRead(string sqlCom)
    {
        Open();                                            //打开数据库连接
        SqlCommand com = new SqlCommand(sqlCom, conn);      //创建命令对象
        SqlDataReader read = com.ExecuteReader();
        return read;
    }


}


