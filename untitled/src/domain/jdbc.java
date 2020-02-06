package domain;

//import com.sun.java.util.jar.pack.Package;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<EMP> list=new jdbc().findall();
        System.out.println(list);

    }
    private int id;
    private String ename;
    Connection connection=null;
    public List<EMP> findall() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT%2B8", "root", "aA107824");
        //3,.设置emp表
        String sql="select*from emp";
        Statement stmt=connection.createStatement();
        //执行sql
        ResultSet rs=stmt.executeQuery(sql);
        //6.遍历结果集
        EMP emp=null;
        List<EMP> list=new ArrayList<EMP>();
        while (rs.next()){
            int id=rs.getInt("id");
            String ename=rs.getString("ename");
            emp=new EMP();
            emp.setId(id);
            emp.setEname(ename);
            //装载集合
            list.add(emp);

        }
        connection.close();
        stmt.close();
        return list;
    }

}
