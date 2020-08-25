package com.karin.jdcb;


import java.sql.*;

public class JdbcTestDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 加载驱动, 固定写法;
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 用户信息和url
        String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&useSSl=true";
        String username = "root";
        String password = "huangyuan";
        // 3. 连接成功，数据库对象  Connection 代表数据库;
        Connection connection = DriverManager.getConnection(url, username, password);
        // 4. 执行SQL的对象
        Statement statement = connection.createStatement();
        // 5. 执行SQL的对象
        String sql = "SELECT * FROM user";
        // 返回的结果集，结果集中封装了我们全部的查询出来的结果;
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id" + resultSet.getObject("id"));
            System.out.println("name" + resultSet.getObject("name"));
            System.out.println("pwd" + resultSet.getObject("pwd"));
        }
        // 6. 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
