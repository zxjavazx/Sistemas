package AccesoDatos;

import Beans.Alumno;
import Beans.Anio;
import Beans.Asistencia;
import Beans.Grado;
import Beans.Horario;
import Beans.Matricula;
import Beans.Seccion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adAsistencia {
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
    
    public Integer proxId() throws Exception{
        try {
            String sql = "select last_value from asistencia_idasist_seq;";
            
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
    
    public List ListarAsistencia(){
        try {
            List<Asistencia> lstasistencias = new ArrayList<Asistencia>();
            String sql = "select";
            sql = sql + " asistencia.idasist";
            sql = sql + ",asistencia.condicion";
            sql = sql + ",asistencia.fechasist";
            sql = sql + ",horario.idhora";
            sql = sql + ",horario.diasemana";
            sql = sql + ",horario.horini";
            sql = sql + ",horario.horfin";
            sql = sql + ",año.idanio";
            sql = sql + ",año.anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";
            sql = sql + ",alumno.idalum";
            sql = sql + ",alumno.codalum";
            sql = sql + ",alumno.nomalum";
            sql = sql + ",alumno.apepatalum";
            sql = sql + ",alumno.apematalum";
            sql = sql + ",alumno.sexo";
            sql = sql + ",matricula.idmatr";
            sql = sql + ",matricula.fechmatr";
            sql = sql + ",seccion.idsecc";
            sql = sql + ",seccion.nomsecc";
            sql = sql + " from ";
            sql = sql + " asistencia";
            sql = sql + " inner join horario on asistencia.idhora = horario.idhora";
            sql = sql + " inner join año on horario.idanio = año.idanio";
            sql = sql + " inner join grado on horario.idgrad = grado.idgrad";
            sql = sql + " inner join alumno on asistencia.idalum = alumno.idalum";
            sql = sql + " inner join matricula on alumno.idmatr = matricula.idmatr";
            sql = sql + " inner join seccion on matricula.idsecc = seccion.idsecc";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Asistencia obj = new Asistencia();
                obj.setIdasist(rs.getInt("idasist"));
                obj.setCondicion(rs.getString("condicion"));
                obj.setFechasist(rs.getString("fechasist"));
//                obj.setHorario(new Horario(rs.getInt("idhora")));
//                obj.setAlumno(new Alumno(rs.getInt("idalum")));
                obj.setHorario(new Horario((rs.getInt("idhora")),(rs.getString("diasemana")),(rs.getDate("horini")),(rs.getDate("horfin")), new Anio((rs.getInt("idanio")),(rs.getString("anio")),(rs.getString("fechin")),(rs.getString("fechfin"))),new Grado((rs.getInt("idgrad")),(rs.getString("nomgrad")))));
                obj.setAlumno(new Alumno((rs.getInt("idalum")),(rs.getString("codalum")),(rs.getString("nomalum")),(rs.getString("apepatalum")),(rs.getString("apematalum")),(rs.getString("sexo")),new Matricula((rs.getInt("idmatr")),(rs.getString("fechmatr")),new Anio((rs.getInt("idanio")),(rs.getString("anio")),(rs.getString("fechin")),(rs.getString("fechfin"))),new Seccion((rs.getInt("idsecc")),(rs.getString("nomsecc")),new Grado((rs.getInt("idgrad")),(rs.getString("nomgrad")))))));
//                Horario horario = new Horario();
//                horario.setIdhora(rs.getInt("idhora"));
//                horario.setDiasemana(rs.getString("diasemana"));
//                horario.setHorini(rs.getDate("horini"));
//                horario.setHorfin(rs.getDate("horfin"));
//                
//                Anio anio = new Anio();
//                anio.setIdanio(rs.getInt("idanio"));
//                anio.setFechin(rs.getString("fechin"));
//                anio.setFechfin(rs.getString("fechfin"));
//                
//                Grado grado = new Grado();
//                grado.setIdgrad(rs.getInt("idgrad"));
//                grado.setNomgrad(rs.getString("nomgrad"));
//                
//                Alumno alumno = new Alumno();
//                alumno.setIdalum(rs.getInt("idalum"));
//                alumno.setCodalum(rs.getString("codalum"));
//                alumno.setNomalum(rs.getString("nomalum"));
//                alumno.setApepatalum(rs.getString("apepatalum"));
//                alumno.setApematalum(rs.getString("apematalum"));
//                alumno.setSexo(rs.getString("sexo"));
//                
//                Matricula matricula = new Matricula();
//                matricula.setIdmatr(rs.getInt("idmatr"));
//                matricula.setFechmatr(rs.getString("fechmatr"));
//                
//                Seccion seccion = new Seccion();
//                seccion.setIdsecc(rs.getInt("idsecc"));
//                seccion.setNomsecc(rs.getString("nomsecc"));
                
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
