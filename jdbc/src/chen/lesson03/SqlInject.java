package chen.lesson03;


import chen.lesson02.utils.JdbcUtils;

import java.sql.*;

public class SqlInject {
    public static void main(String[] args) {
        login("xiaochen", "123456");
//        login("'' or 1=1", "123456");
    }

    // 登录业务
    public static void login(String username, String password) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            // PreparedStatement防止SQL注入的本质，把传递进来的参数当字符
            // 假设其中存在转义字符，比如说 ' 会被直接转义，就是直接忽略
            String sql = "select * from users where `NAME`=? and `PASSWORD`=?";

            st = conn.prepareStatement(sql);//获得SQL的执行对象

            st.setString(1, username);
            st.setString(2, password);

            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("NAME"));
                System.out.println(rs.getString("PASSWORD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
