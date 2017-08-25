package Negocios;

import Beans.Anio;
import Beans.Area;
import Beans.Coordinador;
import Beans.Coordinador;
import Beans.Especialidad;
import Beans.Tutor;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nCoordinador {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
        try {
            String sql = "select nextval('coordinador_idcoor_seq') as idcoor;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idcoor");
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
    
    public List ListarCoordinador(){
        try {
            List<Coordinador> lstcoordinadors = new ArrayList<Coordinador>();
            String sql = "select";
            sql = sql + " idcoor";
            sql = sql + ",descoor";
            sql = sql + ",idarea";
            sql = sql + ",idanio";
            sql = sql + " from coordinador";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Coordinador obj = new Coordinador();
                obj.setIdcoor(rs.getInt("idcoor"));
                obj.setDescoor(rs.getString("descoor"));
                obj.setArea(new Area(rs.getInt("idarea")));
                obj.setAnio(new Anio(rs.getInt("idanio")));
                lstcoordinadors.add(obj);
            }
            return lstcoordinadors;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarCoordinador(Coordinador obj){
        try {
            obj.setIdcoor(getId());
            
            String sql = "insert into coordinador(";
            sql = sql + " idcoor";
            sql = sql + ",descoor";
            sql = sql + ",idarea";
            sql = sql + ",idanio";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdcoor().toString()+"'";
            sql = sql + ",'"+obj.getDescoor() + "'";
            sql = sql + ",'"+obj.getArea().toString()+"'";
            sql = sql + ",'"+obj.getAnio().toString()+"'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ModificarCoordinador(Coordinador obj){
        try {
            
            String sql = "update coordinador set(";
            sql = sql + " descoor = '"+obj.getDescoor() + "'";
            sql = sql + " idarea = '"+obj.getArea().getIdarea().toString() + "'";
            sql = sql + " idanio = '"+obj.getAnio().getIdanio().toString() + "'";
            sql = sql + " where";
            sql = sql + " idcoor = '"+obj.getIdcoor().toString()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarCoordinador(Coordinador obj){
        try {
            String sql = "delete from coordinador";
            sql = sql + " where";
            sql = sql + " idcoor = " + obj.getIdcoor().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
