/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import static MainPackage.MainGui.con;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luong Nam
 */
public class Connect_dbSQLBV {

    public static Connection getConnect(String username, String pass) throws SQLException {
//        return DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=test_SQL;user=sa;password=1234");
        String url = "jdbc:sqlserver://localhost;databaseName=quanlybenhvien;user=" + username + ";password=" + pass;
        Connection connection = DriverManager.getConnection(url);
        return connection;
    }

    public static void insert(String TenBn, String NamSinh, String Gioitinh, String diachi, String sdt, String dt, String scmt) throws SQLException, ParseException {
        Connection cn = getConnect("sa", "1");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date udob = sdf1.parse(NamSinh);
        System.out.println(udob);
        java.sql.Date date = new java.sql.Date(udob.getTime());
        System.out.println(date);
        String query = "insert into BenhNhan values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStmt = cn.prepareStatement(query);
        preparedStmt.setString(1, TenBn);
        preparedStmt.setDate(2, date);
        preparedStmt.setString(3, Gioitinh);
        preparedStmt.setString(4, diachi);
        preparedStmt.setString(5, sdt);
        preparedStmt.setString(6, dt);
        preparedStmt.setString(7, scmt);

        // execute the preparedstatement
        preparedStmt.execute();
    }
    public static void DelBn(int MaBn) throws SQLException{
      Connection cn = getConnect("sa", "1");
      String query = "delete from BenhNhan where Mabn = ?";
      PreparedStatement preparedStmt = cn.prepareStatement(query);
      preparedStmt.setInt(1, MaBn);
      // execute the preparedstatement
      preparedStmt.execute();
    }
    public static ArrayList<String> selectBn(int MaBn) throws SQLException{
            ArrayList<String> a = new ArrayList<>();
            Connection cn = getConnect("sa", "1");
            Statement statement = (Statement) cn.createStatement();
        //statement.executeUpdate("INSERT INTO value ('009','phong','vn',10,11100)");
        ResultSet resultSet = statement.executeQuery("select * from BenhNhan where MaBn = "+MaBn);

        while (resultSet.next()) {
           a.add(resultSet.getString(2));
           a.add(resultSet.getString(3));
           a.add(resultSet.getString(4));
           a.add(resultSet.getString(5));
           a.add(resultSet.getString(6));
           a.add(resultSet.getString(7));
           a.add(resultSet.getString(8));
        }
        return a;
    }
    
    public static String Iden(String TenBang) throws SQLException{
        Connection cn = getConnect("sa", "1");
        String a = null;
        Statement statement = (Statement) cn.createStatement();
        //statement.executeUpdate("INSERT INTO value ('009','phong','vn',10,11100)");
        ResultSet resultSet = statement.executeQuery("select IDENT_CURRENT('"+TenBang+"')");
        while (resultSet.next()) {
            int b = resultSet.getInt(1);
            a = Integer.toString(b+1);
        }
        return a;
    }
    
    public static String GetTenBn(int MaBn) throws SQLException{
        Connection cn = getConnect("sa", "1");
        Statement statement = (Statement) cn.createStatement();
        //statement.executeUpdate("INSERT INTO value ('009','phong','vn',10,11100)");
        ResultSet resultSet = statement.executeQuery("select TenBn from BenhNhan where MaBn = "+MaBn);
        String a = null;
        while (resultSet.next()) {
            
            a = resultSet.getString(1);
        }
        return a;
    }
    public static String getTenBnByMaBa(int MaBa) throws SQLException{
        Connection cn = getConnect("sa", "1");
        Statement statement = (Statement) cn.createStatement();
        //statement.executeUpdate("INSERT INTO value ('009','phong','vn',10,11100)");
        ResultSet resultSet = statement.executeQuery("select TenBn from BenhNhan,BenhAn where BenhNhan.MaBn = BenhAn.MaBn and BenhAn.MaBa = "+MaBa);
        String a = null;
        while (resultSet.next()) {
            
            a = resultSet.getString(1);
        }
        return a;
    }
    public static double getDonGia(int MaPhong) throws SQLException{
        Connection cn = getConnect("sa", "1");
        Statement statement = (Statement) cn.createStatement();
        //statement.executeUpdate("INSERT INTO value ('009','phong','vn',10,11100)");
        ResultSet resultSet = statement.executeQuery("select DonGia from Phong where MaPhong = "+MaPhong);
        double a = 0;
        while (resultSet.next()) {
            
            a = resultSet.getDouble(1);
        }
        return a;
    }
    public static String GetTenNv(int MaNv) throws SQLException{
        Connection cn = getConnect("sa", "1");
        Statement statement = (Statement) cn.createStatement();
        //statement.executeUpdate("INSERT INTO value ('009','phong','vn',10,11100)");
        ResultSet resultSet = statement.executeQuery("select TenNv from NhanVien where MaNv = "+MaNv);
        String a = null;
        while (resultSet.next()) {
            
            a = resultSet.getString(1);
        }
        return a;
    }
    public static void insertBa(int Mabn, int Manv,String ngayvaovien,Double Vienphidadong,String sothebhyt) throws SQLException, ParseException {
        Connection cn = getConnect("sa", "1");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date udob = sdf1.parse(ngayvaovien);
        java.sql.Date date = new java.sql.Date(udob.getTime());
        String query = "insert into BenhAn(MaBn, MaNv, NgayVaoVien,VienPhiDaDong, SoTheBHYT) values(?,?,?,?,?)";
        PreparedStatement preparedStmt = cn.prepareStatement(query);
        preparedStmt.setInt(1, Mabn);
        preparedStmt.setInt(2, Manv);
        preparedStmt.setDate(3, date);
        preparedStmt.setDouble(4, Vienphidadong);
        preparedStmt.setString(5, sothebhyt);
        // execute the preparedstatement
        preparedStmt.execute();
    }
        public static void insertPhong(int Sogiuong,double Dongia) throws SQLException, ParseException {
        Connection cn = getConnect("sa", "1");
        String query = "insert into Phong values(?,?,?)";
        PreparedStatement preparedStmt = cn.prepareStatement(query);
        preparedStmt.setInt(1, Sogiuong);
        preparedStmt.setInt(2, Sogiuong);
        preparedStmt.setDouble(3, Dongia);
        // execute the preparedstatement
        preparedStmt.execute();
    }
    
       public static void insertBa_Phong(int Maba, int MaPhong, String ngayvaophong) throws SQLException, ParseException {
        Connection cn = getConnect("sa", "1");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date udob = sdf1.parse(ngayvaophong);
        java.sql.Date date = new java.sql.Date(udob.getTime());
        String query = "insert into BA_Phong(MaBa, MaPhong, NgayVaoPhong) values(?,?,?)";
        PreparedStatement preparedStmt = cn.prepareStatement(query);
        preparedStmt.setInt(1, Maba);
        preparedStmt.setInt(2, MaPhong);
        preparedStmt.setDate(3, date);
//        // execute the preparedstatement
        preparedStmt.execute();
    }
    public static void main(String[] args) throws SQLException, ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date udob = new Date();
        while (true) {            
            
            Scanner sc = new Scanner(System.in);
            String c = sc.nextLine();
            udob = sdf1.parse(c);
            java.sql.Date date = new java.sql.Date(udob.getTime());
            System.out.println(date);
        }
    }
    
}
