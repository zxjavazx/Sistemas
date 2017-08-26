package AccesoDatos;

import Beans.Anio;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adAnio {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId() throws Exception{
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
            throw e;
        }
    }
    
    public Integer proxId() throws Exception{
        try {
            String sql = "select last_value from año_idanio_seq;";
            
            Integer id = 0;
            
            rs = con.RecuperarSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("last_value");
                
                if(rs.wasNull()){
                    id = 0;
                }
                
                if(id==1){
                    id = 0;
                }
            }
            id = id+1;
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
        
    public List ListarAnio() throws Exception{
        try {
            List<Anio> lstalumnos = new ArrayList<Anio>();
            String sql = "select";
            sql = sql + " idanio";
            sql = sql + ",fechin";
            sql = sql + ",fechfin";
            sql = sql + " from anio";
            sql = sql + ";";
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
            throw e;
        }
        
    }
    
    public void RegistrarAnio(Anio obj)throws Exception{
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
    
    public void ModificarAnio(Anio obj) throws Exception{
        try {
            
            String sql = "update año set(";
            sql = sql + ",fechin = '"+obj.getFechin() + "'";
            sql = sql + ",fechfin = '"+obj.getFechfin() + "'";
            sql = sql + " where";
            sql = sql + " idanio = '"+obj.getIdanio()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
}
