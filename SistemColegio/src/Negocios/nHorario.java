package Negocios;

import Beans.Anio;
import Beans.Area;
import Beans.Grado;
import Beans.Horario;
import Beans.Horario;
import Beans.Seccion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nHorario {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
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
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List ListarHorario(){
        try {
            List<Horario> lsthorarios = new ArrayList<Horario>();
            String sql = "select";
            sql = sql + " idhora";
            sql = sql + ",diasemana";
            sql = sql + ",horini";
            sql = sql + ",horfin";
            sql = sql + ",idanio";
            sql = sql + ",idgrad";
            sql = sql + " from horario";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Horario obj = new Horario();
                obj.setIdhora(rs.getInt("idhora"));
                obj.setDiasemana(rs.getString("diasemana"));
                obj.setHorini(rs.getDate("horini"));
                obj.setHorfin(rs.getDate("horfin"));
                obj.setAnio(new Anio(rs.getInt("idanio")));
                obj.setGrado(new Grado(rs.getInt("idgrad")));
                lsthorarios.add(obj);
            }
            return lsthorarios;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarHorario(Horario obj){
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }
}
