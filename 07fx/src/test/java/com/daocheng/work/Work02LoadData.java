package com.daocheng.work;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;


public class Work02LoadData {

    private static final Logger logger = Logger.getLogger(String.valueOf(Work02LoadData.class));

    private Connection conn = null;

    private static String url = "jdbc:mysql://rm-bp1f60sm3gkeh40uhqo.mysql.rds.aliyuncs.com:3306/order?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false";

    private static String userName = "root";

    private static String password = "gwq_806186987";


    public static InputStream getTestDataInputStream(){
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j <= 1000000; j++) {
            builder.append(630000000+j);
            builder.append("\t");
            builder.append("已下单");
            builder.append("\t");
            builder.append(1);
            builder.append("\t");
            builder.append(100);
            builder.append("\t");
            builder.append(20000000+j);
            builder.append("\t");
            builder.append(1655136000);
            builder.append("\t");
            builder.append(1655136000);
            builder.append("\t");
            builder.append("2021-12-26 00:00:00");
            builder.append("\t");
            builder.append("2021-12-26 00:00:00");
            builder.append("\t");
            builder.append(0);
            builder.append("\n");
        }

        byte[] bytes = builder.toString().getBytes(StandardCharsets.UTF_8);

        InputStream is = new ByteArrayInputStream(bytes);

        return is;

    }

    public int bulkLoadFromInputStream(String loadDataSql, InputStream dataStream) throws SQLException {
        if (dataStream == null) {
            logger.info("InputStream is null ,No data is imported");
            return 0;
        }


//        conn = DriverManager.getConnection(url,userName,password);
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setAllowLoadLocalInfile(true);
        mysqlDataSource.setURL(url);
        conn = mysqlDataSource.getConnection(userName, password);
        PreparedStatement statement = this.conn.prepareStatement(loadDataSql);
        int result = 0;

        if (statement.isWrapperFor(com.mysql.cj.jdbc.JdbcStatement.class)) {
            com.mysql.cj.jdbc.StatementImpl mysqlStatement = statement.unwrap(com.mysql.cj.jdbc.StatementImpl.class);
            mysqlStatement.setLocalInfileInputStream(dataStream);
            result = mysqlStatement.executeUpdate(loadDataSql);
        }
        return result;
    }


//1w：花费:1262毫秒 100w：花费:49670毫秒
    public static void main(String[] args) throws SQLException {

        String testsql = "LOAD DATA LOCAL INFILE 'sql.csv' IGNORE INTO TABLE order.t_order(order_id,order_status,product_count,price,user_id,order_create_time,order_finish_time,create_time,update_time,is_delete)";
        InputStream dataStream = getTestDataInputStream();
        Work02LoadData dao = new Work02LoadData();

        long start = System.currentTimeMillis();
        int rows = dao.bulkLoadFromInputStream(testsql, dataStream);
        long end = System.currentTimeMillis();

        System.out.println("花费:" +(end - start) + "毫秒");

    }
}
