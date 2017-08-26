package AccesoDatos;

import Beans.Area;
import Beans.Criterio;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adCriterio {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId() throws Exception{
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
            throw e;
        }
    }
    
    public Integer proxId() throws Exception{
        try {
            String sql = "select last_value from criterio_idcrit_seq;";
            
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
    
    public List ListarCriterio() throws Exception{
        try {
            List<Criterio> lstcriterios = new ArrayList<Criterio>();
            String sql = "select";
            sql = sql + " criterio.idcrit";
            sql = sql + ",criterio.nomcrit";
            sql = sql + ",area.idarea";
            sql = sql + ",area.nomarea";
            sql = sql + " from criterio";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Criterio obj = new Criterio();
                obj.setIdcrit(rs.getInt("idcrit"));
                obj.setNomcrit(rs.getString("nomcrit"));
                obj.setArea(new Area(rs.getInt("idarea"),rs.getString("nomarea")));
                lstcriterios.add(obj);
            }
            return lstcriterios;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void RegistrarCriterio(Criterio obj) throws Exception{
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
            throw e;
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
            throw e;
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
            throw e;
        }
    }
}
