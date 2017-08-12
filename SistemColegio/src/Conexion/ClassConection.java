
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ClassConection {
    
    public Connection conecion(){
        Connection cn = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
         cn=DriverManager.getConnection("jdbc:mysql://localhost/db_colegio","root","");
         }catch(  ClassNotFoundException | SQLException c){}
       return cn; 
    }
    
}
