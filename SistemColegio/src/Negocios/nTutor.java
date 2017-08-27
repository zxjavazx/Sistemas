package Negocios;

import AccesoDatos.adTutor;
import Beans.Tutor;
import Conexion.Conexion;
import java.util.List;

public class nTutor {
    public String ObtenerIdTutor() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adTutor adtutor = new adTutor();
            id = Integer.toString(adtutor.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Tutor> ConsultarTutor() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adTutor adtutor = new adTutor();
            List<Tutor> lsttutors = adtutor.ListarTutores();
            return lsttutors;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarTutor(Tutor tutor) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adTutor adtutor = new adTutor();
            adtutor.RegistrarTutor(tutor);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarTutor(Tutor tutor) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adTutor adtutor = new adTutor();
            adtutor.ModificarTutor(tutor);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarTutor(Tutor tutor) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adTutor adtutor = new adTutor();
            adtutor.EliminarTutor(tutor);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
