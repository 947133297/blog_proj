package dao;

import beans.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BlogDao {
    static Connection conn = DBManage.getConn();

    public static Blog getBlogInfo(String username) {
        String sql = "select bid,blogname,introdution,status,create_time from bloginfo where master=?;";
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, username);
            ResultSet resultSet = pStmt.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            int bid = resultSet.getInt("bid");
            String intro = resultSet.getString("introduction");
            String blogname = resultSet.getString("blogname");
            int status = resultSet.getInt("status");
            Date createTime = resultSet.getDate("create_time");
            resultSet.close();
            return new Blog(bid, username, blogname, intro, status, createTime);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean insertBlog(Blog blog) {
        String sql = "insert bloginfo(master,blogname,introduction) value(?,?,?);";
        PreparedStatement pStmt = null;
        try {
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, blog.getMaster());
            pStmt.setString(2, blog.getName());
            pStmt.setString(3, blog.getIntroduction());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
