package context; 


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBContext {
    /*Insert your other code right after this comment*/
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "Digital";
    private final String portNumber = "1433";
    private final String userName = "sa";
    private final String password = "123456";

    /**
     * GetConnection method connect database
     *
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userName, password);

    }

    /**
     * CloseConnection method close connect of connection
     *
     *
     * @param con <code>Connection</code>
     * @throws SQLException
     */
    public void closeConnection(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * CloseConnection method close connect of PreparedStatement
     *
     *
     * @param ps <code> PreparedStatement</code>
     * @throws SQLException
     */
    public void closePreparedStatement(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * CloseConnection method close connect of ResultSet
     *
     *
     * @param rs <code>ResultSet</code>
     * @throws SQLException
     */
    public void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * GetImagePath method get image
     *
     * @return image
     * @throws Exception
     */
    public String getImagePath() throws Exception {
        return "images/";
    }
}
