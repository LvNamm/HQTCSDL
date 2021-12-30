/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Luong Nam
 */
public class ConnectSQLSV {
   public static Connection getConnect(String username, String pass) throws SQLException {
//        return DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=test_SQL;user=sa;password=1234");
        String url = "jdbc:sqlserver://localhost;databaseName=quanlybenhvien;user="+username+";password="+pass;
        Connection connection = DriverManager.getConnection(url);
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection cn = getConnect("sa","1");
        Statement statement = (Statement) cn.createStatement();
        //statement.executeUpdate("INSERT INTO value ('009','phong','vn',10,11100)");
        ResultSet resultSet = statement.executeQuery("select * from BenhNhan");

        while (resultSet.next()) {
            resultSet.getString(3);
            String hoTen = resultSet.getString(1);
                   System.out.println(hoTen);          }

     
    }
}
