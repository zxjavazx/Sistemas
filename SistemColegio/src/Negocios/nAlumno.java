package Negocios;

import AccesoDatos.adAlumno;
import Beans.Alumno;
import Conexion.Conexion;
import java.util.List;

public class nAlumno {
    public String ObtenerIdAlumno() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adAlumno adalumno = new adAlumno();
            id = Integer.toString(adalumno.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Alumno> ConsultarAlumno() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAlumno adalumno = new adAlumno();
            List<Alumno> lstalumnos = adalumno.ListarAlumnos();
            
            return lstalumnos;
                    
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Alumno ConsultarCodigo(String codigo) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAlumno adalumno = new adAlumno();
            Alumno alumno = adalumno.ConsultarCodigo(codigo);
            
            return alumno;
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Alumno> ConsultarApepat(String apepat) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAlumno adalumno = new adAlumno();
            List<Alumno> lstalumnos = adalumno.ConsultarApepat(apepat);
            
            return lstalumnos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Alumno ConsultarMatricula(String matri) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAlumno adalumno = new adAlumno();
            Alumno alumno = adalumno.ConsultarMatricula(matri);
            
            return alumno;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarAlumno(Alumno alumno) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAlumno adalumno = new adAlumno();
            adalumno.RegistrarAlumno(alumno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarAlumno(Alumno alumno) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAlumno adalumno = new adAlumno();
            adalumno.ModificarAlumno(alumno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarAlumno(Alumno alumno) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAlumno adalumno = new adAlumno();
            adalumno.EliminarAlumno(alumno);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
