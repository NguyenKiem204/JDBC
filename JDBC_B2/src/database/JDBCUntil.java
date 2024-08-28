package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUntil {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Nạp driver JDBC vào bộ nhớ (nếu cần)
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=ASM;encrypt=true;trustServerCertificate=true";
            String userName = "sa";
            String password = "123456789";

            connection = DriverManager.getConnection(url, userName, password);
//        } catch (ClassNotFoundException e) {
//            System.err.println("Driver class not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL exception: " + e.getMessage());
        }
        return connection;
    }


    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
