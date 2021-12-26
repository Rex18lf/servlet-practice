package com.pluto.util;

import java.sql.*;

public class JDBCutil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JDBCutil() {

    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ExamSystem?useUnicode=true?characterEncoding=utf8&useSSL=true", "root", "1118");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn, Statement st, ResultSet res) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public PreparedStatement createStatement(String sql) throws SQLException {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(sql);
        return st;
    }
}
