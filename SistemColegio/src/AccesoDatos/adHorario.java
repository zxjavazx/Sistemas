package AccesoDatos;

import Beans.Anio;
import Beans.Grado;
import Beans.Horario;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adHorario {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('horario_idhora_seq') as idhora;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idhora");
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
            String sql = "select last_value from horario_idhora_seq;";
            
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
    
    public List ListarHorario() throws Exception{
        try {
            List<Horario> lsthorarios = new ArrayList<Horario>();
            String sql = "select";
            sql = sql + " horario.idhora";
            sql = sql + ",horario.diasemana";
            sql = sql + ",horario.horini";
            sql = sql + ",horario.horfin";
            sql = sql + ",año.idanio";
            sql = sql + ",año.anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";
            sql = sql + " from horario";
            sql = sql + " inner join año on horario.idañio = año.idanio";
            sql = sql + " inner join grado on horario.idgrad = grado.idgrad";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Horario obj = new Horario();
                obj.setIdhora(rs.getInt("idhora"));
                obj.setDiasemana(rs.getString("diasemana"));
                obj.setHorini(rs.getDate("horini"));
                obj.setHorfin(rs.getDate("horfin"));
                obj.setAnio(new Anio(rs.getInt("idanio"),(rs.getString("anio")),rs.getString("fechin"),rs.getString("fechfin")));
                obj.setGrado(new Grado(rs.getInt("idgrad"),rs.getString("nomgrad")));
                lsthorarios.add(obj);
            }
            return lsthorarios;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void RegistrarHorario(Horario obj) throws Exception{
        try {
            obj.setIdhora(getId());
            
            String sql = "insert into horario(";
            sql = sql + " idhora";
            sql = sql + ",diasemana";
            sql = sql + ",horini";
            sql = sql + ",horfin";
            sql = sql + ",idanio";
            sql = sql + ",idgrad";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdhora().toString()+"'";
            sql = sql + ",'"+obj.getDiasemana() + "'";
            sql = sql + ",'"+obj.getHorini() + "'";
            sql = sql + ",'"+obj.getHorfin() + "'";
            sql = sql + ",'"+obj.getAnio().getIdanio().toString() + "'";
            sql = sql + ",'"+obj.getGrado().getIdgrad().toString() + "'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ModificarHorario(Horario obj){
        try {
            
            String sql = "update horario set(";
            sql = sql + " diasemana = '"+obj.getDiasemana() + "'";
            sql = sql + ",horini = '"+obj.getHorini() + "'";
            sql = sql + ",horfin = '"+obj.getHorini() + "'";
            sql = sql + ",idanio = '"+obj.getAnio().getIdanio().toString() + "'";
            sql = sql + ",idgrad = '"+obj.getGrado().getIdgrad().toString() + "'";
            sql = sql + " where";
            sql = sql + " idhora = '"+obj.getIdhora().toString()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarHorario(Horario obj){
        try {
            String sql = "delete from horario";
            sql = sql + " where";
            sql = sql + " idhora = "+obj.getIdhora().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
}
