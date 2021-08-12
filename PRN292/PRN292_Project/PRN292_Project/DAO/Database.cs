using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace PRN292_Project.DAO
{
    class Database
    {
        public static SqlConnection GetConnection()
        {

            return new SqlConnection(ConfigurationManager.ConnectionStrings["PRN292"].ToString());
        }

        //select - disconnected
        public static DataTable getDataBySQL(string sql)
        {
            SqlCommand cmd = new SqlCommand(sql, GetConnection());
            SqlDataAdapter da = new SqlDataAdapter();
            da.SelectCommand = cmd;
            DataSet ds = new DataSet(); // result Set
            da.Fill(ds);
            return ds.Tables[0];
        }


        //Insert, Update, Delete - connected
        public static int executeSQL(string sql, params SqlParameter[] sqlParameter)
        {
            SqlCommand cmd = new SqlCommand(sql, GetConnection());
            cmd.Parameters.AddRange(sqlParameter);
            cmd.Connection.Open();
            int result = cmd.ExecuteNonQuery();
            cmd.Connection.Close();
            return result;
        }
    }
}
