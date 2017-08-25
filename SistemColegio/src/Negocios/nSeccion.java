package Negocios;

import Beans.Grado;
import Beans.Seccion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nSeccion {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
        try {
            String sql = "select nextval('seccion_idsecc_seq') as idsecc;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idsecc");
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
    
    public List ListarSeccion(){
        try {
            List<Seccion> lstseccions = new ArrayList<Seccion>();
            String sql = "select";
            sql = sql + " idsecc";
            sql = sql + ",nomsecc";
            sql = sql + ",idgrad";
            sql = sql + " from seccion";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Seccion obj = new Seccion();
                obj.setIdsecc(rs.getInt("idsecc"));
                obj.setNomsecc(rs.getString("nomsecc"));
                obj.setGrado(new Grado(rs.getInt("idgrad")));
                lstseccions.add(obj);
            }
            return lstseccions;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarSeccion(Seccion obj){
        try {
            obj.setIdsecc(getId());
            
            String sql = "insert into seccion(";
            sql = sql + " idsecc";
            sql = sql + ",nomsecc";
            sql = sql + ",idgrad";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdsecc()+"'";
            sql = sql + ",'"+obj.getNomsecc() + "'";
            sql = sql + ",'"+obj.getGrado().toString()+"'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ModificarSeccion(Seccion obj){
        try {
            
            String sql = "update seccion set(";
            sql = sql + " nomsecc = '"+obj.getNomsecc() + "'";
            sql = sql + ",idgrad = '"+obj.getGrado().toString() + "'";
            sql = sql + " where";
            sql = sql + " idsecc = '"+obj.getIdsecc()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarSeccion(Seccion obj){
        try {
            String sql = "delete from seccion";
            sql = sql + " where";
            sql = sql + " idsecc = " + obj.getIdsecc().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
