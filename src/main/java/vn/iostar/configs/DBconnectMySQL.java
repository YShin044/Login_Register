package vn.iostar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectMySQL {

		   private static String USERNAME = "root";
		   private static String PASSWORD = "Tam2b8a9s";
		   private static String DRIVER = "com.mysql.cj.jdbc.Driver";
		   private static String URL = "jdbc:mysql://localhost:3306/ltweb";

		   public static Connection getDatabaseConnection() throws SQLException, Exception{    
		       try {	Class.forName(DRIVER);
				return DriverManager.getConnection(URL,USERNAME,PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		   }
		   
		   public static void main(String[] args) {
			   try {
				   new DBconnectMySQL();
				   System.out.println(DBconnectMySQL.getDatabaseConnection());
			   } catch(Exception e) {
				   e.printStackTrace();
			   }
			
		}
}
