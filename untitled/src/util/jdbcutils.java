package util;

//import com.mysql.cj.protocol.Resultset;
//import com.mysql.cj.protocol.Resultset;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import  java.sql.*;
import java.util.Properties;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;

public class jdbcutils {
    /**
     * 文件的读取，只需要读取一次即可拿到这些值，使用静态代码块，
     * @return
     */
    private static String url;
    private static  String user;
    private static  String password;
    private static  String driver;
    static {
        //1.创建集合类
        Properties pro =new Properties();
        //获取src路径下面问价的方式---》classloader类加载器
        ClassLoader classLoader=jdbcutils.class.getClassLoader();
        URL res=classLoader.getResource("jdbc.properties");
        String path=res.getPath();
        System.out.println(path);

        //2.加载文件
        try {
            pro.load(new FileReader(path));//这里正常会报一个错误。
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.获取数据，赋值
        url=pro.getProperty("url");
        user=pro.getProperty("user");
        password=pro.getProperty("password");
        driver=pro.getProperty("driver");
        //注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//读取资源文件，获取值

    public  static Connection getConnection() throws SQLException {
        /**
         * 获取连接，
         * @return 连接对象
         */
        return DriverManager.getConnection(url,user,password);

//        return null;
    }

    /**
     * 释放资源
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection){

        if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }//释放statement的资源
        if (connection!=null){
            try {
              connection .close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }//释放connection的资源
    }

    /**
     * 释放代码重载
     * @param rs
     * @param statement
     * @param connection
     */
    public static void close(ResultSet rs, Statement statement, Connection connection){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }//释放result的资源
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }//释放statement的资源
        if (connection!=null){
            try {
                connection .close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }//释放connection的资源
    }
}
