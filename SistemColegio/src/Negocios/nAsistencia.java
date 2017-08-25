package Negocios;

import Beans.Alumno;
import Beans.Anio;
import Beans.Asistencia;
import Beans.Horario;
import Beans.Matricula;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nAsistencia {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
        try {
            String sql = "select nextval('asistencia_idasist_seq') as idasist;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idasist");
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
    
    public List ListarAsistencia(){
        try {
            List<Asistencia> lstasistencias = new ArrayList<Asistencia>();
            String sql = "select";
            sql = sql + " idasist";
            sql = sql + ",condicion";
            sql = sql + ",fechasist";
            sql = sql + ",idhora";
            sql = sql + ",idalum";
            sql = sql + " from asistencia";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Asistencia obj = new Asistencia();
                obj.setIdasist(rs.getInt("idasist"));
                obj.setCondicion(rs.getString("condicion"));
                obj.setFechasist(rs.getString("fechasist"));
                obj.setHorario(new Horario(rs.getInt("idhora")));
                obj.setAlumno(new Alumno(rs.getInt("idalum")));
                lstasistencias.add(obj);
            }
            return lstasistencias;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarAsistencia(Asistencia obj){
        try {
            obj.setIdasist(getId());
            
            String sql = "insert into asistencia(";
            sql = sql + " idasist";
            sql = sql + ",condicion";
            sql = sql + ",fechasist";
            sql = sql + ",idhora";
            sql = sql + ",idalum";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdasist()+"'";
            sql = sql + ",'"+obj.getCondicion() + "'";
            sql = sql + ",'"+obj.getFechasist() + "'";
            sql = sql + ",'"+obj.getHorario().getIdhora() + "'";
            sql = sql + ",'"+obj.getAlumno().getIdalum() + "'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ModificarAsistencia(Asistencia obj){
        try {
            
            String sql = "update asistencia set(";
            sql = sql + " condicion = '"+obj.getCondicion() + "'";
            sql = sql + ",fechasist = '"+obj.getFechasist() + "'";
            sql = sql + ",idhora = '"+obj.getHorario().getIdhora() + "'";
            sql = sql + ",idalum = '"+obj.getAlumno().getIdalum() + "'";
            sql = sql + " where";
            sql = sql + " idasist = '"+obj.getIdasist()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarAsistencia(Asistencia obj){
        try {
            String sql = "delete from asistencia";
            sql = sql + " where";
            sql = sql + " idasist = "+obj.getIdasist().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
