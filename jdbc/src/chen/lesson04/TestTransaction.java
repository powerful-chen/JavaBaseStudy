package chen.lesson04;

import chen.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            // 关闭数据库的自动提交，自动会开启事务
            conn.setAutoCommit(false);//开启事务

            String sql1 = "update account set money = money-200 where `name`='A'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            int a = 1 / 0;

            String sql2 = "update account set money = money+200 where `name`='B'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            // 业务完毕，提交事务
            conn.commit();
            System.out.println("success!!!!");
        } catch (SQLException e) {
            try {
                conn.rollback();// 失败则进行回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }


}
