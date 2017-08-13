package Negocios;

import Beans.Alumno;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nAlumno {
    Conexion con = new Conexion();
    ResultSet rs;
    
    public Integer getId() throws Exception {
        try {
            String sql = "select nextval('alumno_idalum_seq') as idalum;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idalum");
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
    
    public List ListarAlumnos(){
        try {
            List<Alumno> lstalumnos = new ArrayList<Alumno>();
            
            String sql = "select * from alumno";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Alumno obj = new Alumno();
                obj.setIdalum(rs.getInt("idalum"));
                obj.setCodalum(rs.getString("codalum"));
                obj.setNomalum(rs.getString("nomalum"));
                obj.setApepatalum(rs.getString("apepatalum"));
                obj.setApematalum(rs.getString("apematalum"));
                obj.setSexo(rs.getString("sexo"));
                obj.setApepatalum(rs.getString("apepatalum"));
            }
        } catch (Exception e) {
        }
    }
    
}
