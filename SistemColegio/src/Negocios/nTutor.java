package Negocios;

import Beans.Anio;
import Beans.Tutor;
import Beans.Seccion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nTutor {
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
    
    public List ListarTutores(){
        try {
            List<Tutor> lsttutors = new ArrayList<Tutor>();
            
            String sql = "select * from tutor";
            rs = con.RecuperarSQL(sql);
            Tutor obj = null;
            
            while(rs.next()){
                
                obj = new Tutor();
                obj.setIdtut(rs.getInt("idtut"));
                obj.setDescripcion(rs.getString("descripcion"));
                obj.setAnio(new Anio(rs.getInt("idanio")));
                obj.setSeccion(new Seccion(rs.getInt("idsecc")));
                lsttutors.add(obj);
            }
            return lsttutors;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void RegistrarTutor(Tutor obj){
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarArea(Tutor obj){
        try {
            String sql = "delete from tutor";
            sql = sql + " where";
            sql = sql + " idtut = "+obj.getIdtut().toString();
            
            rs = con.RecuperarSQL(sql);
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
