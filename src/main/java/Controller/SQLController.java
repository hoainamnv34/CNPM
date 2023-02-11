package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLController {
    //url = "jdbc:sqlserver://" +serverName + ":1433;DatabaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;
    public static String DB_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=QLDC;encrypt=true;trustServerCertificate=true;";
//    private static String DB_URL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;DatabaseName=TEST;encrypt=true;trustServerCertificate=true;";
    //
//            + "databaseName=TEST;"
//            + "integratedSecurity=true";
    public static String USER_NAME = "sa";
    public static String PASSWORD = "123";

    public static void main(String args[]) {
        try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
             ResultSet rs = stmt.executeQuery("select * from HoKhau");
             // show data
             while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2));
             }
//             close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}