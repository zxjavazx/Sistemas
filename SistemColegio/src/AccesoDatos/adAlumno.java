package AccesoDatos;

import Beans.Alumno;
import Beans.Anio;
import Beans.Grado;
import Beans.Matricula;
import Beans.Seccion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adAlumno {
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
    
    public Integer proxId() throws Exception{
        try {
            String sql = "select last_value from alumno_idalum_seq;";
            
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
    
//    public String getCodigo() throws Exception{
//        try {
//            String sql = "select lpad(cast(case when max(cast(codalum as integer)) is null then 1 else (max(cast(codalum as integer)) + 1) end as character varying),14,'0') as codalum from alumno";
//            
//            String codigo = "";
//            
//            rs = con.RecuperarSQL(sql);
//            
//            rs.beforeFirst();
//            
//            if(rs.next()){
//                codigo = rs.getString("codalum");
//                
//                if(rs.wasNull()){
//                    codigo = "01";
//                }
//            }
//            return codigo;
//        } catch (Exception e) {
//            throw e;
//        }
//    }
    
    public List ListarAlumnos() throws Exception{
        try {
            List<Alumno> lstalumnos = new ArrayList<Alumno>();
            
            String sql = "select";
            sql = sql + " alumno.idalum";
            sql = sql + ",alumno.codalum";
            sql = sql + ",alumno.nomalum";
            sql = sql + ",alumno.apepatalum";
            sql = sql + ",alumno.apematalum";
            sql = sql + ",alumno.sexo";
            sql = sql + ",matricula.idmatr";
            sql = sql + ",matricula.fechmatr";
            sql = sql + ",año.idanio";
            sql = sql + ",año.anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",seccion.idsecc";
            sql = sql + ",seccion.nomsecc";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";
            sql = sql + " from";
            sql = sql + " alumno";
            sql = sql + " inner join matricula on alumno.idmatr = matricula.idmatr";
            sql = sql + " inner join año on matricula.idanio = año.idanio";
            sql = sql + " inner join seccion on matricula.idsecc = seccion.idsecc";
            sql = sql + " inner join grado on seccion.idgrad = grado.idgrad";
            sql = sql + " order by";
            sql = sql + " alumno.apepat asc";
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
//                obj.setMatricula(new Matricula(rs.getInt("idmatr")));
                obj.setMatricula(new Matricula((rs.getInt("idmatr")),(rs.getString("fechmatr")),new Anio((rs.getInt("idanio")),(rs.getString("anio")),(rs.getString("fechin")),(rs.getString("fechfin"))),new Seccion((rs.getInt("idsecc")),(rs.getString("nomsecc")),new Grado((rs.getInt("idgrad")),(rs.getString("nomgrad"))))));
                
//                Matricula matricula = new Matricula();
//                matricula.setIdmatr(rs.getInt("idmatr"));
//                matricula.setFechmatr(rs.getString("fechmatr"));
//                
//                Anio anio = new Anio();
//                anio.setIdanio(rs.getInt("idanio"));
//                anio.setFechin(rs.getString("fechin"));
//                anio.setFechfin(rs.getString("fechfin"));
//                
//                Seccion seccion = new Seccion();
//                seccion.setIdsecc(rs.getInt("idsecc"));
//                seccion.setNomsecc(rs.getString("nomsecc"));
//                
//                Grado grado = new Grado();
//                grado.setIdgrad(rs.getInt("idgrad"));
//                grado.setNomgrad(rs.getString("nomgrad"));
                
                lstalumnos.add(obj);
            }
            return lstalumnos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Alumno ConsultarCodigo(String codigo) throws Exception{
        try {
            List<Alumno> lstalumnos = new ArrayList<Alumno>();
            
            String sql = "select";
            sql = sql + " alumno.idalum";
            sql = sql + ",alumno.codalum";
            sql = sql + ",alumno.nomalum";
            sql = sql + ",alumno.apepatalum";
            sql = sql + ",alumno.apematalum";
            sql = sql + ",alumno.sexo";
            sql = sql + ",matricula.idmatr";
            sql = sql + ",matricula.fechmatr";
            sql = sql + ",año.idanio";
            sql = sql + ",año.anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",seccion.idsecc";
            sql = sql + ",seccion.nomsecc";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";
            sql = sql + " from";
            sql = sql + " alumno";
            sql = sql + " inner join matricula on alumno.idmatr = matricula.idmatr";
            sql = sql + " inner join año on matricula.idanio = año.idanio";
            sql = sql + " inner join seccion on matricula.idsecc = seccion.idsecc";
            sql = sql + " inner join grado on seccion.idgrad = grado.idgrad";
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
//                obj.setMatricula(new Matricula(rs.getInt("idmatr")));
                obj.setMatricula(new Matricula((rs.getInt("idmatr")),(rs.getString("fechmatr")),new Anio((rs.getInt("idanio")),(rs.getString("anio")),(rs.getString("fechin")),(rs.getString("fechfin"))),new Seccion((rs.getInt("idsecc")),(rs.getString("nomsecc")),new Grado((rs.getInt("idgrad")),(rs.getString("nomgrad"))))));
                
//                Matricula matricula = new Matricula();
//                matricula.setIdmatr(rs.getInt("idmatr"));
//                matricula.setFechmatr(rs.getString("fechmatr"));
//                
//                Anio anio = new Anio();
//                anio.setIdanio(rs.getInt("idanio"));
//                anio.setIdanio(rs.getInt("fechin"));
//                anio.setIdanio(rs.getInt("fechfin"));
//                
//                Seccion seccion = new Seccion();
//                seccion.setIdsecc(rs.getInt("idsecc"));
//                seccion.setNomsecc(rs.getString("nomsecc"));
//                
//                Grado grado = new Grado();
//                grado.setIdgrad(rs.getInt("idgrad"));
//                grado.setNomgrad(rs.getString("nomgrad"));
            }
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Alumno> ConsultarApepat(String apepat) throws Exception{
        try {
            
            String sql = "select";
            sql = sql + " alumno.idalum";
            sql = sql + ",alumno.codalum";
            sql = sql + ",alumno.nomalum";
            sql = sql + ",alumno.apepatalum";
            sql = sql + ",alumno.apematalum";
            sql = sql + ",alumno.sexo";
            sql = sql + ",matricula.idmatr";
            sql = sql + ",matricula.fechmatr";
            sql = sql + ",año.idanio";
            sql = sql + ",año.anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",seccion.idsecc";
            sql = sql + ",seccion.nomsecc";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";
            sql = sql + " from";
            sql = sql + " alumno";
            sql = sql + " inner join matricula on alumno.idmatr = matricula.idmatr";
            sql = sql + " inner join año on matricula.idanio = año.idanio";
            sql = sql + " inner join seccion on matricula.idsecc = seccion.idsecc";
            sql = sql + " inner join grado on seccion.idgrad = grado.idgrad";
            sql = sql + " from";
            sql = sql + " alumno";
            sql = sql + " inner join matricula on alumno.idmatr = matricula.idmatr";
            sql = sql + " inner join año on matricula.idanio = año.idanio";
            sql = sql + " inner join seccion on matricula.idsecc = seccion.idsecc";
            sql = sql + " inner join grado on seccion.idgrad = grado.idgrad";
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
//                obj.setMatricula(new Matricula(rs.getInt("idmatr")));
                obj.setMatricula(new Matricula((rs.getInt("idmatr")),(rs.getString("fechmatr")),new Anio((rs.getInt("idanio")),(rs.getString("anio")),(rs.getString("fechin")),(rs.getString("fechfin"))),new Seccion((rs.getInt("idsecc")),(rs.getString("nomsecc")),new Grado((rs.getInt("idgrad")),(rs.getString("nomgrad"))))));
                
//                Matricula matricula = new Matricula();
//                matricula.setIdmatr(rs.getInt("idmatr"));
//                matricula.setFechmatr(rs.getString("fechmatr"));
//                
//                Anio anio = new Anio();
//                anio.setIdanio(rs.getInt("idanio"));
//                anio.setIdanio(rs.getInt("fechin"));
//                anio.setIdanio(rs.getInt("fechfin"));
//                
//                Seccion seccion = new Seccion();
//                seccion.setIdsecc(rs.getInt("idsecc"));
//                seccion.setNomsecc(rs.getString("nomsecc"));
//                
//                Grado grado = new Grado();
//                grado.setIdgrad(rs.getInt("idgrad"));
//                grado.setNomgrad(rs.getString("nomgrad"));
                
                lstalumno.add(obj);
            }
            return lstalumno;
        } catch (Exception e) {
            throw e;
        }
    }    
    
    public Alumno ConsultarMatricula(String matri) throws Exception{
        try {
            
            String sql = "select";
            sql = sql + " alumno.idalum";
            sql = sql + ",alumno.codalum";
            sql = sql + ",alumno.nomalum";
            sql = sql + ",alumno.apepatalum";
            sql = sql + ",alumno.apematalum";
            sql = sql + ",alumno.sexo";
            sql = sql + ",matricula.idmatr";
            sql = sql + ",matricula.fechmatr";
            sql = sql + ",año.idanio";
            sql = sql + ",año.anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",seccion.idsecc";
            sql = sql + ",seccion.nomsecc";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";
            sql = sql + " from";
            sql = sql + " alumno";
            sql = sql + " inner join matricula on alumno.idmatr = matricula.idmatr";
            sql = sql + " inner join año on matricula.idanio = año.idanio";
            sql = sql + " inner join seccion on matricula.idsecc = seccion.idsecc";
            sql = sql + " inner join grado on seccion.idgrad = grado.idgrad";
            sql = sql + " from";
            sql = sql + " alumno";
            sql = sql + " inner join matricula on alumno.idmatr = matricula.idmatr";
            sql = sql + " inner join año on matricula.idanio = año.idanio";
            sql = sql + " inner join seccion on matricula.idsecc = seccion.idsecc";
            sql = sql + " inner join grado on seccion.idgrad = grado.idgrad";
            sql = sql + " where";
            sql = sql + " idmatricula = '" + matri + "%'";
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
//                obj.setMatricula(new Matricula(rs.getInt("idmatr")));
                obj.setMatricula(new Matricula((rs.getInt("idmatr")),(rs.getString("fechmatr")),new Anio((rs.getInt("idanio")),(rs.getString("anio")),(rs.getString("fechin")),(rs.getString("fechfin"))),new Seccion((rs.getInt("idsecc")),(rs.getString("nomsecc")),new Grado((rs.getInt("idgrad")),(rs.getString("nomgrad"))))));
                
//                Matricula matricula = new Matricula();
//                matricula.setIdmatr(rs.getInt("idmatr"));
//                matricula.setFechmatr(rs.getString("fechmatr"));
//                
//                Anio anio = new Anio();
//                anio.setIdanio(rs.getInt("idanio"));
//                anio.setIdanio(rs.getInt("fechin"));
//                anio.setIdanio(rs.getInt("fechfin"));
//                
//                Seccion seccion = new Seccion();
//                seccion.setIdsecc(rs.getInt("idsecc"));
//                seccion.setNomsecc(rs.getString("nomsecc"));
//                
//                Grado grado = new Grado();
//                grado.setIdgrad(rs.getInt("idgrad"));
//                grado.setNomgrad(rs.getString("nomgrad"));
                
            }
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }    
    
    public void RegistrarAlumno(Alumno obj) throws Exception{
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
            throw e;
        }
    }
    
    public void ModificarAlumno(Alumno obj) throws Exception{
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
            throw e;
        }
    }
    
    public void EliminarAlumno(Alumno obj) throws Exception{
        try {
            String sql = "delete from alumno";
            sql = sql + " where";
            sql = sql + " idalum = "+obj.getIdalum().toString();
            
            rs = con.RecuperarSQL(sql);
                    
        } catch (Exception e) {
            throw e;
        }
    }
    
//    public static void main(String[] args) {
//        try {
//            adAlumno adalumno = new adAlumno();
//            adalumno.getCodigo();
//            System.out.println(adalumno.getCodigo());
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//        
//    }
}
