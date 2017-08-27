package AccesoDatos;

import Beans.Anio;
import Beans.Grado;
import Beans.Tutor;
import Beans.Seccion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adTutor {
    Conexion con = new Conexion();
    ResultSet rs;
    
    public Integer getId() throws Exception {
        try {
            String sql = "select nextval('tutor_idtut_seq') as idtut;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idtut");
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
            String sql = "select last_value from tutor_idtut_seq;";
            
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
    public List ListarTutores() throws Exception{
        try {
            List<Tutor> lsttutors = new ArrayList<Tutor>();
            
            String sql = "select";
            sql = sql + " tutor.idtutor";
            sql = sql + ",tutor.descripcion";
            sql = sql + ",año.idanio";
            sql = sql + ",año.anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",seccion.idsecc";
            sql = sql + ",seccion.nomsecc";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";
            sql = sql + " from tutor";
            sql = sql + " inner join año on tutor.idanio = año.idanio";
            sql = sql + " inner join seccion on tutor.idsecc = seccion.idsecc";
            sql = sql + " inner join grado on seccion.idgrad = grado.idgrad";
            rs = con.RecuperarSQL(sql);
            Tutor obj = null;
            
            while(rs.next()){
                
                obj = new Tutor();
                obj.setIdtut(rs.getInt("idtut"));
                obj.setDescripcion(rs.getString("descripcion"));
                obj.setAnio(new Anio(rs.getInt("idanio"),(rs.getString("anio")),rs.getString("fechin"),rs.getString("fecfin")));
                obj.setSeccion(new Seccion(rs.getInt("idsecc"),rs.getString("nomsecc"),new Grado(rs.getInt("idgrad"),rs.getString("nomgrad"))));
                lsttutors.add(obj);
            }
            return lsttutors;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarTutor(Tutor obj) throws Exception{
        try {
            obj.setIdtut(getId());
            
            String sql = "insert into tutor(";
            sql = sql + " idtut";
            sql = sql + ",descripcion";
            sql = sql + ",idanio";
            sql = sql + ",idsecc";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdtut()+"'";
            sql = sql + ",'"+obj.getDescripcion()+"'";
            sql = sql + ",'"+obj.getAnio()+"'";
            sql = sql + ",'"+obj.getSeccion()+"'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ModificarTutor(Tutor obj){
        try {
            String sql = "update tutor set(";
            sql = sql + " descripcion = '"+obj.getDescripcion()+"'";
            sql = sql + ",idanio = '"+obj.getAnio().getIdanio()+"'";
            sql = sql + ",idsecc = '"+obj.getSeccion().getIdsecc()+"'";
            sql = sql + " where";
            sql = sql + " idtut = '"+obj.getIdtut()+"'";
            
            rs = con.RecuperarSQL(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarTutor(Tutor obj){
        try {
            String sql = "delete from tutor";
            sql = sql + " where";
            sql = sql + " idtut = "+obj.getIdtut().toString();
            
            rs = con.RecuperarSQL(sql);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
