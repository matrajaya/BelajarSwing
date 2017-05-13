package belajarswing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yanu
 */
public class Koneksi {  
   private Connection connect;  
   private static final String driverName = "com.mysql.jdbc.Driver"; // Driver Untuk Koneksi Ke MySQL  
   private static final String jdbc = "jdbc:mysql://";  
   private static final String host = "localhost:"; // Bisa Menggunakan IP Anda, Cnth : 192.168.100.100  
   private static final String port = "3306/"; // Port ini port MySQL  
   private static final String database = "belajarswing"; // Ini Database yang akan digunakan  
   private static final String url = jdbc + host + port + database;  
   private static final String username = "root"; // username default mysql  
   private static final String password = "root";  
   public Connection getKoneksi1() throws SQLException {  
     if (connect == null) {  
       try {  
         Class.forName(driverName);  
         System.out.println("Class Driver Ditemukan");  
         try {  
           connect = DriverManager.getConnection(url, username, password);  
           System.out.println("Koneksi Database Sukses");  
         } catch (SQLException se) {  
           System.out.println("Koneksi Database Gagal : " + se);  
           System.exit(0);  
         }  
       } catch (ClassNotFoundException cnfe) {  
         System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : " + cnfe);  
         System.exit(0);  
       }  
     }
     return connect;  
   }  
    public static Connection getKoneksi() throws SQLException {      
     return DriverManager.getConnection(url, username, password);  
   }  
//    public static void main(String[] args) throws SQLException  {
//        getKoneksi();
//    }
 }  