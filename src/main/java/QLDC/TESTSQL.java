package QLDC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TESTSQL {
    public static void main(String[] args) {
        var url  = "jdbc:mysql://localhost:3306/TEST";
        String ur = "jdbc:sqlserver://latop\\SQLEXPRESS:1433";
        var user = "root";
        var password = "";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println(conn.getCatalog());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    
}
