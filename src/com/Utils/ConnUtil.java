package com.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnUtil extends ThreadLocal{
    private static String name = "root";
    private static String pwd = "647252";
    private static String url = "jdbc:mysql://localhost:3306/ood?useOldAliasMetadataBehavior=true";
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private static Connection createConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, name, pwd);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getConn() {
        Connection conn = threadLocal.get();
        if(conn == null) {
            threadLocal.set(createConn());
            conn = threadLocal.get();
        }
        return conn;
    }

    public static void close() {
        Connection conn = threadLocal.get();
        if(conn == null) {
            return;
        }
        try {
            if(!conn.isClosed()) {
                conn.close();
                threadLocal.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
