package jdbc;

import util.jdbcutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcdemo {

    public static void main(String[] args) {
        Connection conn=null;
        //2.定义sql
        String sql="update account set balance =balance -? where id=?";
        String sql2="update account set balance =balance +? where id=?";
        //3.获取执行sql对象
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            PreparedStatement preparedStatement1=conn.prepareStatement(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        PreparedStatement preparedStatement1=conn.prepareStatement(sql2);
        //4.设置参数

        try {
             conn=jdbcutils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
