package AccesoDatos;

import Beans.Area;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adArea {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('area_idarea_seq') as idarea;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idarea");
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
            String sql = "select last_value from area_idarea_seq;";
            
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
    
    public List ListarArea() throws Exception{
        try {
            List<Area> lstareas = new ArrayList<Area>();
            String sql = "select";
            sql = sql + " idarea";
            sql = sql + ",nomarea";
            sql = sql + " from area";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Area obj = new Area();
                obj.setIdarea(rs.getInt("idarea"));
                obj.setNomarea(rs.getString("nomarea"));
                lstareas.add(obj);
            }
            return lstareas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarArea(Area obj) throws Exception{
        try {
            obj.setIdarea(getId());
            
            String sql = "insert into area(";
            sql = sql + " idarea";
            sql = sql + ",nomarea";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdarea()+"'";
            sql = sql + ",'"+obj.getNomarea() + "'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ModificarArea(Area obj) throws Exception{
        try {
            
            String sql = "update area set(";
            sql = sql + " nomarea = '"+obj.getNomarea() + "'";
            sql = sql + " where";
            sql = sql + " idarea = '"+obj.getIdarea()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarArea(Area obj) throws Exception{
        try {
            String sql = "delete from area";
            sql = sql + " where";
            sql = sql + " idarea = " + obj.getIdarea().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
}
