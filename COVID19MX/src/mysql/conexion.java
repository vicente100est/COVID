/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author JUAN100CORR
 */
public class conexion {
    
    

     private static final String url = "jdbc:mysql://localhost/bdoo_covid19";
     private static final String user = "root";
     private static final String password = "Chabelo100";
      
      public static Connection conectar(){
      Connection conexion = null;          
          try {
           Class.forName("com.mysql.jdbc.Driver");
           conexion = DriverManager.getConnection(url, user, password);
           System.out.print("Conexion Buena");
          } catch (ClassNotFoundException | SQLException e){
          System.out.print("Conexion Mala" +e);
           
          } 
          return conexion;

      }   
 }

    

