package jdbc;

import java.sql.*;

public class jdbcDemo5 {

    public static void main(String[] args){
        Statement statement = null;
        Connection connection=null ;
        ResultSet resultSet=null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.定义sql
            String sql = "select *from account";
            //3.获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8", "root", "aA107824");
            //4.获取执行sql的对象 statement
            statement = connection.createStatement();
            //5.执行sql
             resultSet = statement.executeQuery(sql);//影响的行数
            //6.1处理结果
            //6.1让游标向下游动一行
            while (resultSet.next()) {
                //循环判断游标是否有下一行
                //6.2获取数据
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                System.out.println(id + "----" + balance + "-----" + name);
            }
            //6.1让游标向下游动一行
            if(resultSet.next()) {
                //6.2获取数据
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                System.out.println(id + "----" + balance + "-----" + name);
            }
            //6.1让游标向下游动一行
            if(resultSet.next()) {
                //6.2获取数据
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                System.out.println(id + "----" + balance + "-----" + name);
            }
//            System.out.println(count);//打印的行数
//            if (count > 0) {
//                System.out.println("successful");
//            } else {
//                System.out.println("fall");
//            }
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
