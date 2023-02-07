package QLDC;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class TESTSQL {
    public static void main(String[] args) {
        System.out.println("Nam");
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("123");
        ds.setServerName("Laptop\\SQLEXPRESS");
    //   ds.setServerName("SQLEXPRESS");
        ds.setPortNumber(1433);
        ds.setDatabaseName("TEST");
        try {
            Connection conn = ds.getConnection();
            System.out.println("connect success");
            System.out.println(conn.getMetaData());
        } catch (SQLServerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
