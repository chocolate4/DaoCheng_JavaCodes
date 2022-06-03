package com.daocheng.work.work10;

import java.sql.*;

public class JDBCTest {

    private static String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false";

    private static String userName = "root";

    private static String password = "gwq806186987";

    private static Connection connection;

    public static void main(String[] args) throws SQLException {

        connection = DriverManager.getConnection(url,userName,password);

        String sql  = "insert into t_user(id,username,age,email,is_delete) values(?,?,?,?,?)";

        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int i = 1;i <= 10;i++) {

            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, "b"+i);
            preparedStatement.setInt(3, i);
            preparedStatement.setString(4, "c"+i);
            preparedStatement.setInt(5, 0);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();

        connection.commit();


    }
}
