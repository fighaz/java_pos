/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class database {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String host = "jdbc:mysql://localhost/lsp_sofi_xiirpl1";
    private static String username = "root";
    private static String password = "";
    private static Connection con;
    
    public static void koneksi(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(host, username, password);
        } catch (Exception e) {
            System.out.println("koneksi gagal : " + e.getMessage());
        }
    }
    public static ResultSet ambildata(String sql){
        ResultSet rs = null ;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("ambil data gagal : " + e.getMessage());
        }
        return rs;
    }
    public static void eksekusi(String sql){
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("ambil data gagal : " + e.getMessage());
        }
    }
}
