package Negocios;

import Beans.Alumno;
import Beans.Area;
import Beans.Boleta;
import Beans.Evaluacion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nEvaluacion {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
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
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List ListarEvaluacion(){
        try {
            List<Evaluacion> lstevaluacions = new ArrayList<Evaluacion>();
            String sql = "select";
            sql = sql + " ideval";
            sql = sql + ",fecheval";
            sql = sql + ",nota";
            sql = sql + ",idbol";
            sql = sql + ",idalum";
            sql = sql + " from evaluacion";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Evaluacion obj = new Evaluacion();
                obj.setIdeval(rs.getInt("ideval"));
                obj.setFecheval(rs.getString("fecheval"));
                obj.setNota(rs.getInt("nota"));
                obj.setBoleta(new Boleta(rs.getInt("idbol")));
                obj.setAlumno(new Alumno(rs.getInt("idalum")));
                lstevaluacions.add(obj);
            }
            return lstevaluacions;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarEvaluacion(Evaluacion obj){
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }
}
