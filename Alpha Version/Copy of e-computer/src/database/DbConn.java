/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database;
import java.sql.*;
 
/**
 *
 * @author knoman
 */
public class DbConn {
    
    public static final String driver="com.mysql.jdbc.Driver";
    public static final String dbSource="jdbc:mysql://localhost:3307/e_computer";
    public static final  String uName="root";
    public static final   String pwd="123";
  
    public static Connection dbConnection(){
        Connection conn=null;
        try{
        Class.forName(driver);
        }catch(Exception e){
            System.out.println("Driver Not Found");
        }

        try{
                conn=DriverManager.getConnection(dbSource,uName,pwd);
                System.out.println("Connectd");
        }catch(Exception e){
            System.out.println("Not Connectd");
        }
     
     return conn;
    }
}