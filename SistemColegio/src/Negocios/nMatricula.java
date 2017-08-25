package Negocios;

import Beans.Anio;
import Beans.Area;
import Beans.Matricula;
import Beans.Matricula;
import Beans.Seccion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nMatricula {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
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
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List ListarMatricula(){
        try {
            List<Matricula> lstmatriculas = new ArrayList<Matricula>();
            String sql = "select";
            sql = sql + " idmatr";
            sql = sql + ",fechmatr";
            sql = sql + ",idanio";
            sql = sql + ",idsecc";
            sql = sql + " from matricula";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Matricula obj = new Matricula();
                obj.setIdmatr(rs.getInt("idmatr"));
                obj.setFechmatr(rs.getString("fechmatr"));
                obj.setAnio(new Anio(rs.getInt("idanio")));
                obj.setSeccion(new Seccion(rs.getInt("idsecc")));
                lstmatriculas.add(obj);
            }
            return lstmatriculas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarMatricula(Matricula obj){
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }
}
