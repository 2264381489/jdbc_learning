package jdbc;

//import com.sun.java.util.jar.pack.Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
    //快速创建主函数可以考psvm创建
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.导入驱动jar包，驱动什么导入什么
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8", "root", "aA107824");
    //4.定义sql语句
        String sql="update account set balance=1000 where id=1";
        //5.获取执行sql的对象 statement
        Statement statement=connection.createStatement();
        //6.执行sql
       int count= statement.executeUpdate(sql);
       //7.处理结果
        System.out.println(count);
        //8.释放资源
        statement.close();
        connection.close();
    }
}