package dao;

import beans.User;

import java.sql.*;

public class UserDao {
    private static Connection conn = DBManage.getConn();

    public static User getUser(String name, String argPsd) {
        String sql = "select uid,password,nick,role from userinfo where username=?;";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet resultSet = pstmt.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            String psd = resultSet.getString("password");
            if (!argPsd.equals(psd)) {
                return null;
            }
            int uid = resultSet.getInt("uid");
            String nick = resultSet.getString("nick");
            int role = resultSet.getInt("role");
            resultSet.close();
            return new User(uid, name, nick, role);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean hasUser(String username) {
        String sql = "select uid from userinfo where username=\"" + username + "\";";
        boolean result = false;
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            result = resultSet.next();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean insertUser(User user) {
        String sql = "insert userinfo(username,password,nick,role) value(?,?,?,?);";
        try {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, user.getName());
            pStmt.setString(2, user.getPassword());
            pStmt.setString(3, user.getNick());
            pStmt.setInt(4, user.getRole());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
