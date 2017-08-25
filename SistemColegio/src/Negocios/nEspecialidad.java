package Negocios;

import Beans.Grado;
import Beans.Especialidad;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nEspecialidad {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
        try {
            String sql = "select nextval('especialidad_idesp_seq') as idesp;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idesp");
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
    
    public List ListarEspecialidad(){
        try {
            List<Especialidad> lstespecialidads = new ArrayList<Especialidad>();
            String sql = "select";
            sql = sql + " idesp";
            sql = sql + ",codesp";
            sql = sql + ",nomesp";
            sql = sql + " from especialidad";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Especialidad obj = new Especialidad();
                obj.setIdesp(rs.getInt("idesp"));
                obj.setCodesp(rs.getString("codesp"));
                obj.setNomesp(rs.getString("nomesp"));
                lstespecialidads.add(obj);
            }
            return lstespecialidads;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarEspecialidad(Especialidad obj){
        try {
            obj.setIdesp(getId());
            
            String sql = "insert into especialidad(";
            sql = sql + " idesp";
            sql = sql + ",codesp";
            sql = sql + ",nomesp";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdesp()+"'";
            sql = sql + ",'"+obj.getCodesp() + "'";
            sql = sql + ",'"+obj.getNomesp().toString()+"'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ModificarEspecialidad(Especialidad obj){
        try {
            
            String sql = "update especialidad set(";
            sql = sql + " codesp = '"+obj.getCodesp() + "'";
            sql = sql + " nomesp = '"+obj.getNomesp() + "'";
            sql = sql + " where";
            sql = sql + " idesp = '"+obj.getIdesp()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarEspecialidad(Especialidad obj){
        try {
            String sql = "delete from especialidad";
            sql = sql + " where";
            sql = sql + " idesp = " + obj.getIdesp().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
