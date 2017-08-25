package Negocios;

import Beans.Grado;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nGrado {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
        try {
            String sql = "select nextval('grado_idgrad_seq') as idgrad;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idgrad");
                if(rs.wasNull()) {
                    id = 0;
                }
            }
            return id;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List ListarGrado(){
        try {
            List<Grado> lstgrados = new ArrayList<Grado>();
            String sql = "select";
            sql = sql + " idgrad";
            sql = sql + ",nomgrad";
            sql = sql + " from grado";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Grado obj = new Grado();
                obj.setIdgrad(rs.getInt("idgrad"));
                obj.setNomgrad(rs.getString("nomgrad"));
                lstgrados.add(obj);
            }
            return lstgrados;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarGrado(Grado obj){
        try {
            obj.setIdgrad(getId());
            
            String sql = "insert into grado(";
            sql = sql + " idgrad";
            sql = sql + ",nomgrad";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdgrad()+"'";
            sql = sql + ",'"+obj.getNomgrad() + "'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ModificarGrado(Grado obj){
        try {
            
            String sql = "update grado set(";
            sql = sql + " nomgrad = '"+obj.getNomgrad() + "'";
            sql = sql + " where";
            sql = sql + " idgrad = '"+obj.getIdgrad()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarGrado(Grado obj){
        try {
            String sql = "delete from grado";
            sql = sql + " where";
            sql = sql + " idgrad = " + obj.getIdgrad().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
