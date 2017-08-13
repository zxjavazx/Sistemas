package Negocios;

import Beans.Anio;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nAnio {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
        try {
            String sql = "select nextval('año_idanio_seq') as idanio;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idanio");
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
    
    public List ListarAnio(){
        try {
            List<Anio> lstalumnos = new ArrayList<Anio>();
            String sql = "select * from año";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Anio obj = new Anio();
                obj.setIdanio(rs.getInt("idanio"));
                obj.setFechin(rs.getString("fechin"));
                obj.setFechfin(rs.getString("fechfin"));
                lstalumnos.add(obj);
            }
            return lstalumnos;
        } catch (Exception e) {
            
            return null;
        }
        
    }
    
    public void RegistrarAnio(Anio obj){
        try {
            obj.setIdanio(getId());
            
            String sql = "insert into año(";
            sql = sql + " idanio";
            sql = sql + ",fechin";
            sql = sql + ",fechfin";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdanio()+"'";
            sql = sql + ",'"+obj.getFechin() + "'";
            sql = sql + ",'"+obj.getFechfin() + "'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ModificarAnio(Anio obj){
        try {
            obj.setIdanio(getId());
            
            String sql = "update año set(";
            sql = sql + ",fechin = '"+obj.getFechin() + "'";
            sql = sql + ",fechfin = '"+obj.getFechfin() + "'";
            sql = sql + " where";
            sql = sql + " idanio = '"+obj.getIdanio()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        nAnio nanio = new nAnio();
        Anio anio = new Anio();
        anio.setFechin("02/01/2017");
        anio.setFechfin("02/12/2017");
        nanio.RegistrarAnio(anio);
    }
}
