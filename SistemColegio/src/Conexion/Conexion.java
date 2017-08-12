package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    Connection cn;

    public Connection getCn(){
        this.conectar();
        return cn;
    }
    
    public boolean conectar(){
        try {
            String cadenaconexion = "jdbc:postgresql://localhost:5432/db_colegio";
            Class.forName("org.postgresql.Driver");
            
            cn = DriverManager.getConnection(cadenaconexion,"postgres","postgres");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean EjecutarSQL(String parametro){
        try {
            Statement stm;
            conectar();
            stm = cn.createStatement();
            stm.execute(parametro);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet RecuperarSQL(String cadena){
        try {
            Statement stm;
            ResultSet rs;
            conectar();
            stm = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(cadena);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
