package AccesoDatos;

import Beans.Anio;
import Beans.Area;
import Beans.Coordinador;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adCoordinador {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId() throws Exception{
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
            throw e;
        }
    }
    
    public Integer proxId() throws Exception{
        try {
            String sql = "select last_value from coordinador_idcoor_seq;";
            
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
    
    public List ListarCoordinador() throws Exception{
        try {
            List<Coordinador> lstcoordinadors = new ArrayList<Coordinador>();
            String sql = "select";
            sql = sql + " coordinador.idcoor";
            sql = sql + ",coordinadore.descoor";
            sql = sql + ",area.idarea";
            sql = sql + ",area.nomarea";
            sql = sql + ",año.idanio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + " from coordinador";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Coordinador obj = new Coordinador();
                obj.setIdcoor(rs.getInt("idcoor"));
                obj.setDescoor(rs.getString("descoor"));
                obj.setArea(new Area(rs.getInt("idarea"),rs.getString("nomarea")));
                obj.setAnio(new Anio(rs.getInt("idanio"),(rs.getString("anio")),rs.getString("fechin"),rs.getString("fechfin")));
                lstcoordinadors.add(obj);
            }
            return lstcoordinadors;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void RegistrarCoordinador(Coordinador obj) throws Exception{
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
            throw e;
        }
    }
    
    public void ModificarCoordinador(Coordinador obj){
        try {
            
            String sql = "update coordinador set(";
            sql = sql + " descoor = '"+obj.getDescoor() + "'";
            sql = sql + ",idarea = '"+obj.getArea().getIdarea().toString() + "'";
            sql = sql + ",idanio = '"+obj.getAnio().getIdanio().toString() + "'";
            sql = sql + " where";
            sql = sql + " idcoor = '"+obj.getIdcoor().toString()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
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
            throw e;
        }
    }
}
