package dao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;

public class DBManage implements ServletContextListener {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/"; //"user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
    private static final String DB_UserName = "root";
    private static final String DB_UserPsd = "123456";

    private static final String DB_Name = "blog";

    private static Connection conn = null;

    public static Connection getConn() {
        return conn;
    }

    private void initDB() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Mysql Driver Loaded.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can't load Mysql Driver.");
        }

        try {
            //create db if not exists
            conn = DriverManager.getConnection(DB_URL, DB_UserName, DB_UserPsd);
            Statement stmt = conn.createStatement();
            String sql = "create database if not exists blog;";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //connection db and create tables
        String url = DB_URL + DB_Name + "?user=" + DB_UserName + "&password=" + DB_UserPsd + "&useUnicode=true&characterEncoding=UTF8";
        try {
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "create table if not exists userinfo(uid int(11) auto_increment,"
                    + "username varchar(16) not null,"
                    + "password varchar(16) not null,"
                    + "nick varchar(20) default \"\","
                    + "role int(2) default 0,"
                    + "primary key(uid,username)"
                    + ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";

            stmt.executeUpdate(sql);

            sql = "create table if not exists bloginfo("
                    + "bid int(11) primary key auto_increment,"
                    + "blogname varchar(40) default \"\","
                    + "master varchar(16) not null,"
                    + "introduction varchar(300) default \"\","
                    + "status int(2) default 0,"
                    + "create_time datetime not null default now()"
                    + ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";

            stmt.executeUpdate(sql);

            sql = "create table if not exists article("
                    + "id int(10) primary key auto_increment,"
                    + "author varchar(16) not null,"
                    + "title varchar(60) not null,"
                    + "content varchar(10000) not null,"
                    + "create_time datetime not null default now(),"
                    + "status int(2) default 0,"
                    + "publish_time datetime not null default now(),"
                    + "siteid int(15)"
                    + ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
            stmt.executeUpdate(sql);

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.initDB();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
