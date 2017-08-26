package AccesoDatos;

import Beans.Anio;
import Beans.Grado;
import Beans.Matricula;
import Beans.Seccion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adMatricula {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('matricula_idmatr_seq') as idmatr;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idmatr");
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
            String sql = "select last_value from matricula_idmatr_seq;";
            
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
    
    public List ListarMatricula() throws Exception{
        try {
            List<Matricula> lstmatriculas = new ArrayList<Matricula>();
            String sql = "select";
            sql = sql + " matricula.idmatr";
            sql = sql + ",matricula.fechmatr";
            sql = sql + ",año.idanio";
            sql = sql + ",año.anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",seccion.idsecc";
            sql = sql + ",seccion.nomsecc";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";
            sql = sql + " from matricula";
            sql = sql + " inner join año on matricula.idanio = año.idanio";
            sql = sql + " inner join seccion on matricula.idsecc = seccion.idsecc";
            sql = sql + " inner join grado on seccion.idgrad = grado.idgrad";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Matricula obj = new Matricula();
                obj.setIdmatr(rs.getInt("idmatr"));
                obj.setFechmatr(rs.getString("fechmatr"));
                obj.setAnio(new Anio(rs.getInt("idanio"),(rs.getString("anio")),rs.getString("fechin"),rs.getString("fechfin")));
                obj.setSeccion(new Seccion(rs.getInt("idsecc"),rs.getString("nomsecc"),new Grado(rs.getInt("idgrad"),rs.getString("nomgrad"))));
                lstmatriculas.add(obj);
            }
            return lstmatriculas;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void RegistrarMatricula(Matricula obj) throws Exception{
        try {
            obj.setIdmatr(getId());
            
            String sql = "insert into matricula(";
            sql = sql + " idmatr";
            sql = sql + ",fechmatr";
            sql = sql + ",idanio";
            sql = sql + ",idsecc";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdmatr().toString()+"'";
            sql = sql + ",'"+obj.getFechmatr() + "'";
            sql = sql + ",'"+obj.getAnio().getIdanio().toString() + "'";
            sql = sql + ",'"+obj.getSeccion().getIdsecc().toString() + "'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ModificarMatricula(Matricula obj){
        try {
            
            String sql = "update matricula set(";
            sql = sql + " fechmatr = '"+obj.getFechmatr() + "'";
            sql = sql + ",idanio = '"+obj.getAnio().getIdanio().toString() + "'";
            sql = sql + ",idsecc = '"+obj.getSeccion().getIdsecc().toString() + "'";
            sql = sql + " where";
            sql = sql + " idmatr = '"+obj.getIdmatr().toString()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarMatricula(Matricula obj){
        try {
            String sql = "delete from matricula";
            sql = sql + " where";
            sql = sql + " idmatr = "+obj.getIdmatr().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
}
