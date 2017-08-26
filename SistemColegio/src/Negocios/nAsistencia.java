package Negocios;

import AccesoDatos.adAsistencia;
import Beans.Asistencia;
import Conexion.Conexion;
import java.util.List;

public class nAsistencia {
    public String ObtenerIdAsistencia() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adAsistencia adasistencia = new adAsistencia();
            id = Integer.toString(adasistencia.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Asistencia> ConsultarAsistencia() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAsistencia adasistencia = new adAsistencia();
            List<Asistencia> lstasistencias = adasistencia.ListarAsistencia();
            return lstasistencias;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarAsistencia(Asistencia asistencia) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAsistencia adasistencia = new adAsistencia();
            adasistencia.RegistrarAsistencia(asistencia);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarAsistencia(Asistencia asistencia) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAsistencia adasistencia = new adAsistencia();
            adasistencia.ModificarAsistencia(asistencia);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarAsistencia(Asistencia asistencia) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAsistencia adasistencia = new adAsistencia();
            adasistencia.EliminarAsistencia(asistencia);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
