package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo4 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        //1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接对象
            conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8", "root", "aA107824");
            //3.定义sql
            String sql="create table student (id int ,name varchar (20))";
            //4.获取执行sql的对象
            stmt=conn.createStatement();
            //5.执行sql语句
            int count=stmt.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if(count>0){
                System.out.println("修改成功！");
            }else{
                System.out.println("修改失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            //2.获取连接对象
        }finally {
            //7.释放资源
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

            if (conn !=null){
                try{
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
