package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc2 {
    public static void main(String[] args){
        Statement statement = null;
        Connection connection=null ;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.定义sql
            String sql = "insert into account values(null,'wangwu',3000)";
            //3.获取connection对象
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8", "root", "aA107824");
            //4.获取执行sql的对象 statement
             statement = connection.createStatement();
            //5.执行sql
            int count = statement.executeUpdate(sql);//影响的行数
            System.out.println(count);//打印的行数
            if (count > 0) {
                System.out.println("successful");
            } else {
                System.out.println("fall");
            }
        }catch (ClassNotFoundException e)  {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //7.释放空间
            if(statement!=null){
                try{
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                if (connection!=null){
                    try{
                        statement.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }

            }
        }


    }
}
