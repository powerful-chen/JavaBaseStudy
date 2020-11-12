package chen.lesson01;

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动
        Class.forName("com.mysql.jdbc.Driver");//固定写法，加载驱动

        //2、用户信息和url
        //useUnicode=true&character=utf8 字符集编码
        //useSSL=false 使用ssl传输协议
        String url = "jdbc:mysql://localhost:3306/jdbcStudy?useUnicode=true&character=utf8&useSSL=false";
        String user = "root";
        String password = "123456";
        //3、连接成功，数据库对象 Connection代表数据库
        Connection connection = DriverManager.getConnection(url, user, password);

        //4、执行SQL的对象 Statement 执行 sql 的对象
        Statement statement = connection.createStatement();

        //5、执行SQL的对象 去执行SQL，可能存在结果，查看结果
        String sql = "select * from users";

        ResultSet resultSet = statement.executeQuery(sql);//返回结果集，结果集中封装了我们全部的查询出来的结果

        while (resultSet.next()) {
            System.out.println("id  " + resultSet.getObject("id"));
            System.out.println("name  " + resultSet.getObject("NAME"));
            System.out.println("pwd  " + resultSet.getObject("PASSWORD"));
            System.out.println("email  " + resultSet.getObject("email"));
            System.out.println("birth  " + resultSet.getObject("birthday"));
            System.out.println("===========================");
        }
        //6、释放连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
