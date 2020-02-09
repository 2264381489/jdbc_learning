package jdbc;

import util.jdbcutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcDemo7 {
    Statement statement= null;
    Connection connection=null;
    ResultSet resultSet=null;
    /**
     * 测试方法
     */
    public static void main(String[] args) {


        //1.键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        //2.调用方法
        boolean flag=new jdbcDemo7().login(username,password);
        System.out.println(flag);
        if(flag){
            System.out.println("登陆成功");
        }else
        {
            System.out.println("登陆失败。");
        }
    }
    /**
     * 登陆方法
     */
    public boolean login(String username,String password){
        if(username == null || password == null){
            System.out.println("输入内容错误");
            return false;
//            System.out.println("输入内容错误");
        }
        //连接数据库判断是否登陆成功
        //1.获取连接
        try {
             connection=jdbcutils.getConnection();
            //2.定义sql
            String sql="select*from user where username= '"+username+"' and  password = '"+password+"'";
            //注意这个里面的单引号和双引号，很有问题/
            //3获取执行sql对象
             statement=connection.createStatement();
            //4.执行查询
            resultSet=statement.executeQuery(sql);
            //判断
          return  resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcutils.close(resultSet,statement,connection);
        }
        System.out.println("输入内容成功");
        return true;
    }


}
