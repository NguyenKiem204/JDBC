package test;

import database.JDBCUntil;

import java.sql.Connection;

public class testJDBCUntil {
    public static void main(String[] args) {
        Connection connection = JDBCUntil.getConnection();
        System.out.println(connection);
        JDBCUntil.printInfo(connection);
        JDBCUntil.close(connection);
    }
}
