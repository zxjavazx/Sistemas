package Negocios;

import Beans.Alumno;
import Beans.Matricula;
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
            Alumno obj = null;
            
            while(rs.next()){
                
                obj = new Alumno();
                obj.setIdalum(rs.getInt("idalum"));
                obj.setCodalum(rs.getString("codalum"));
                obj.setNomalum(rs.getString("nomalum"));
                obj.setApepatalum(rs.getString("apepatalum"));
                obj.setApematalum(rs.getString("apematalum"));
                obj.setSexo(rs.getString("sexo"));
                obj.setMatricula(new Matricula(rs.getInt("idmatr")));
                lstalumnos.add(obj);
            }
            return lstalumnos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Alumno ConsultarCodigo(String codigo){
        try {
            List<Alumno> lstalumnos = new ArrayList<Alumno>();
            
            String sql = "select";
            sql = sql + " idalum";
            sql = sql + ",codalum";
            sql = sql + ",nomalum";
            sql = sql + ",apepatalum";
            sql = sql + ",apematalum";
            sql = sql + ",sexo";
            sql = sql + ",idmatr";
            sql = sql + " from";
            sql = sql + " alumno";
            sql = sql + " where";
            sql = sql + " codalum = '" + codigo + "'";
            sql = sql + " order by";
            sql = sql + " apepat asc";
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            Alumno obj = null;
            while(rs.next()){
                obj = new Alumno();
                obj.setIdalum(rs.getInt("idalum"));
                obj.setCodalum(rs.getString("codalum"));
                obj.setNomalum(rs.getString("nomalum"));
                obj.setApepatalum(rs.getString("apepatalum"));
                obj.setApematalum(rs.getString("apematalum"));
                obj.setSexo(rs.getString("sexo"));
                obj.setMatricula(new Matricula(rs.getInt("idmatr")));
            }
            return obj;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Alumno> ConsultarApepat(String apepat){
        try {
            
            String sql = "select";
            sql = sql + " idalum";
            sql = sql + ",codalum";
            sql = sql + ",nomalum";
            sql = sql + ",apepatalum";
            sql = sql + ",apematalum";
            sql = sql + ",sexo";
            sql = sql + ",idmatr";
            sql = sql + " from";
            sql = sql + " alumno";
            sql = sql + " where";
            sql = sql + " codalum like '" + apepat + "%'";
            sql = sql + " order by";
            sql = sql + " apepat asc";
            sql = sql + ";";
            
            
            rs = con.RecuperarSQL(sql);
            List<Alumno> lstalumno = new ArrayList<>();
            Alumno obj = null;
            while(rs.next()){
                obj = new Alumno();
                obj.setIdalum(rs.getInt("idalum"));
                obj.setCodalum(rs.getString("codalum"));
                obj.setNomalum(rs.getString("nomalum"));
                obj.setApepatalum(rs.getString("apepatalum"));
                obj.setApematalum(rs.getString("apematalum"));
                obj.setSexo(rs.getString("sexo"));
                obj.setMatricula(new Matricula(rs.getInt("idmatr")));
                lstalumno.add(obj);
            }
            return lstalumno;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }    
    
    public Alumno ConsultarMatricula(String matricula){
        try {
            
            String sql = "select";
            sql = sql + " idalum";
            sql = sql + ",codalum";
            sql = sql + ",nomalum";
            sql = sql + ",apepatalum";
            sql = sql + ",apematalum";
            sql = sql + ",sexo";
            sql = sql + ",idmatr";
            sql = sql + " from";
            sql = sql + " alumno";
            sql = sql + " where";
            sql = sql + " idmatricula = '" + matricula + "%'";
            sql = sql + " order by";
            sql = sql + " apepat asc";
            sql = sql + ";";
            
            
            rs = con.RecuperarSQL(sql);
            Alumno obj = null;
            while(rs.next()){
                obj = new Alumno();
                obj.setIdalum(rs.getInt("idalum"));
                obj.setCodalum(rs.getString("codalum"));
                obj.setNomalum(rs.getString("nomalum"));
                obj.setApepatalum(rs.getString("apepatalum"));
                obj.setApematalum(rs.getString("apematalum"));
                obj.setSexo(rs.getString("sexo"));
                obj.setMatricula(new Matricula(rs.getInt("idmatr")));
                
            }
            return obj;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }    
    
    public void RegistrarAlumno(Alumno obj){
        try {
            obj.setIdalum(getId());
            
            String sql = "insert into alumno(";
            sql = sql + " idalum";
            sql = sql + ",codalum";
            sql = sql + ",nomalum";
            sql = sql + ",apepatalum";
            sql = sql + ",apematalum";
            sql = sql + ",sexo";
            sql = sql + ",idmatr";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdalum()+"'";
            sql = sql + ",'"+obj.getCodalum()+"'";
            sql = sql + ",'"+obj.getNomalum()+"'";
            sql = sql + ",'"+obj.getApepatalum()+"'";
            sql = sql + ",'"+obj.getApematalum()+"'";
            sql = sql + ",'"+obj.getSexo()+"'";
            sql = sql + ",'"+obj.getMatricula()+"'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ModificarAlumno(Alumno obj){
        try {
            String sql = "update alumno set(";
            sql = sql + " codalum = '"+obj.getCodalum()+"'";
            sql = sql + ",nomalum = '"+obj.getNomalum()+"'";
            sql = sql + ",apepatalum = '"+obj.getApepatalum()+"'";
            sql = sql + ",apematalum = '"+obj.getApematalum()+"'";
            sql = sql + ",sexo = '"+obj.getSexo()+"'";
            sql = sql + ",idmat = '"+obj.getMatricula().getIdmatr()+"'";
            sql = sql + " where";
            sql = sql + " idalum = '"+obj.getIdalum()+"'";
            
            rs = con.RecuperarSQL(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarArea(Alumno obj){
        try {
            String sql = "delete from alumno";
            sql = sql + " where";
            sql = sql + " idalum = "+obj.getIdalum().toString();
            
            rs = con.RecuperarSQL(sql);
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
