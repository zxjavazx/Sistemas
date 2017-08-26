package AccesoDatos;

import Beans.Alumno;
import Beans.Anio;
import Beans.Boleta;
import Beans.Evaluacion;
import Beans.Grado;
import Beans.Matricula;
import Beans.Seccion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adEvaluacion {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('evaluacion_ideval_seq') as ideval;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("ideval");
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
            String sql = "select last_value from evaluacion_ideval_seq;";
            
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
    
    public List ListarEvaluacion() throws Exception{
        try {
            List<Evaluacion> lstevaluacions = new ArrayList<Evaluacion>();
            String sql = "select";
            sql = sql + " evaluacion.ideval";
            sql = sql + ",evaluacion.fecheval";
            sql = sql + ",evaluacion.nota";
            sql = sql + ",boleta.idbol";
            sql = sql + ",boleta.pritri";
            sql = sql + ",boleta.segtri";
            sql = sql + ",boleta.tertri";
            sql = sql + ",año.idanio";
            sql = sql + ",año.anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",matricula.idmatr";
            sql = sql + ",matricula.fechmatr";
            sql = sql + ",seccion.idsecc";
            sql = sql + ",seccion.nomsecc";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";
            sql = sql + ",alumno.idalum";
            sql = sql + ",alumno.codalum";
            sql = sql + ",alumno.nomalum";
            sql = sql + ",alumno.apepatalum";
            sql = sql + ",alumno.apematalum";
            sql = sql + ",alumno.sexo";
            sql = sql + " from evaluacion";
            sql = sql + " inner join boleta on evaluacion.idbol = boleta.idbol";
            sql = sql + " inner join año on boleta.idanio = año.idanio";
            sql = sql + " inner join matricula on boleta.idmatr = matricula.idmatr";
            sql = sql + " inner join alumno on evaluacion.idalum = alumno.idalum";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Evaluacion obj = new Evaluacion();
                obj.setIdeval(rs.getInt("ideval"));
                obj.setFecheval(rs.getString("fecheval"));
                obj.setNota(rs.getInt("nota"));
                obj.setBoleta(new Boleta(rs.getInt("idbol"),rs.getInt("pritri"),rs.getInt("segtri"),rs.getInt("tertri"),new Anio((rs.getInt("idanio")),(rs.getString("anio")),(rs.getString("fechin")),(rs.getString("fechfin"))),new Matricula((rs.getInt("idmatr")),(rs.getString("fechmatr")),new Anio((rs.getInt("idanio")),(rs.getString("anio")),(rs.getString("fechin")),(rs.getString("fechfin"))),new Seccion((rs.getInt("idsecc")),(rs.getString("nomsecc")),new Grado((rs.getInt("idgrad")),(rs.getString("nomgrad")))))));
                obj.setAlumno(new Alumno(rs.getInt("idalum"),rs.getString("codalum"),rs.getString("nomalum"),rs.getString("apepatalum"),rs.getString("apematalum"),rs.getString("sexo"), new Matricula(rs.getInt("idmatr"),rs.getString("fechmatr"),new Anio(rs.getInt("idanio"),(rs.getString("anio")),rs.getString("fechin"),rs.getString("fechfin")),new Seccion(rs.getInt("idsecc"),rs.getString("nomsecc"),new Grado(rs.getInt("idgrad"),rs.getString("nomgrad"))))));
                lstevaluacions.add(obj);
            }
            return lstevaluacions;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void RegistrarEvaluacion(Evaluacion obj) throws Exception{
        try {
            obj.setIdeval(getId());
            
            String sql = "insert into evaluacion(";
            sql = sql + " ideval";
            sql = sql + ",fecheval";
            sql = sql + ",nota";
            sql = sql + ",idbol";
            sql = sql + ",idalum";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdeval()+"'";
            sql = sql + ",'"+obj.getFecheval() + "'";
            sql = sql + ",'"+obj.getNota() + "'";
            sql = sql + ",'"+obj.getBoleta().getIdbol() + "'";
            sql = sql + ",'"+obj.getAlumno().getIdalum() + "'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ModificarEvaluacion(Evaluacion obj){
        try {
            
            String sql = "update evaluacion set(";
            sql = sql + " fecheval = '"+obj.getFecheval() + "'";
            sql = sql + ",nota = '"+obj.getNota() + "'";
            sql = sql + ",idbol = '"+obj.getBoleta().getIdbol() + "'";
            sql = sql + ",idalum = '"+obj.getAlumno().getIdalum() + "'";
            sql = sql + " where";
            sql = sql + " ideval = '"+obj.getIdeval()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarEvaluacion(Evaluacion obj){
        try {
            String sql = "delete from evaluacion";
            sql = sql + " where";
            sql = sql + " ideval = "+obj.getIdeval().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
}
