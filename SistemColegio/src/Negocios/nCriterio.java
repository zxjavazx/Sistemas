package Negocios;

import Beans.Area;
import Beans.Criterio;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nCriterio {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
        try {
            String sql = "select nextval('criterio_idcrit_seq') as idcrit;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idcrit");
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
    
    public List ListarCriterio(){
        try {
            List<Criterio> lstcriterios = new ArrayList<Criterio>();
            String sql = "select";
            sql = sql + " idcrit";
            sql = sql + ",nomcrit";
            sql = sql + ",idarea";
            sql = sql + " from criterio";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Criterio obj = new Criterio();
                obj.setIdcrit(rs.getInt("idcrit"));
                obj.setNomcrit(rs.getString("nomcrit"));
                obj.setArea(new Area(rs.getInt("idarea")));
                lstcriterios.add(obj);
            }
            return lstcriterios;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarCriterio(Criterio obj){
        try {
            obj.setIdcrit(getId());
            
            String sql = "insert into criterio(";
            sql = sql + " idcrit";
            sql = sql + ",nomcrit";
            sql = sql + ",idarea";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdcrit()+"'";
            sql = sql + ",'"+obj.getNomcrit() + "'";
            sql = sql + ",'"+obj.getArea().getIdarea() + "'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ModificarCriterio(Criterio obj){
        try {
            
            String sql = "update criterio set(";
            sql = sql + " nomcrit = '"+obj.getNomcrit() + "'";
            sql = sql + ",idarea = '"+obj.getArea().getIdarea() + "'";
            sql = sql + " where";
            sql = sql + " idcrit = '"+obj.getIdcrit()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarCriterio(Criterio obj){
        try {
            String sql = "delete from criterio";
            sql = sql + " where";
            sql = sql + " idcrit = "+obj.getIdcrit().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
