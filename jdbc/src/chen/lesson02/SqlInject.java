package chen.lesson02;

import chen.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInject {
    public static void main(String[] args) {
        //login("xiaochen","123456");
        login(" 'or'2=2", "123456");
    }

    // 登录业务
    public static void login(String username, String password) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL的执行对象
            String sql = "select * from users where `NAME`='" + username + "'and `PASSWORD`= '" + password + "'";
            rs = st.executeQuery(sql);
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
