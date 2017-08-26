package AccesoDatos;

import Beans.Grado;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adGrado {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId() throws Exception{
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
            throw e;
        }
    }
    
    public Integer proxId() throws Exception{
        try {
            String sql = "select last_value from grado_idgrad_seq;";
            
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
    
    public List ListarGrado() throws Exception{
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
            throw e;
        }
        
    }
    
    public void RegistrarGrado(Grado obj) throws Exception{
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
            throw e;
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
            throw e;
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
            throw e;
        }
    }
}
