package chen.lesson03;

import chen.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils.getConnection();
            // 区别
            // 使用了 ？ 占位符代替参数
            String sql = "INSERT INTO `users`(`id`,`NAME`,`PASSWORD`,`email`,`birthday`)" +
                    "VALUES(?,?,?,?,?)";

            st = conn.prepareStatement(sql);//预编译SQL，先写sql，然后不执行

            // 手动给参数赋值
            st.setInt(1, 4);
            st.setString(2, "xiaohuang");
            st.setString(3, "1231231");
            st.setString(4, "241331232@qq.com");
            // 注意点：sql.Date 数据库   java.sql.Date()
            // java.util.Date   Java      new Date().getTime())获得时间戳
            st.setDate(5, new java.sql.Date(new Date().getTime()));

            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, null);
        }
    }
}
