package Negocios;

import AccesoDatos.adDocente;
import Beans.Docente;
import Conexion.Conexion;
import java.util.List;

public class nDocente {
    public String ObtenerIdDocente() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adDocente addocente = new adDocente();
            id = Integer.toString(addocente.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Docente> ConsultarDocente() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adDocente addocente = new adDocente();
            List<Docente> lstdocentes = addocente.ListarDocente();
            return lstdocentes;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarDocente(Docente docente) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adDocente addocente = new adDocente();
            addocente.RegistrarDocente(docente);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarDocente(Docente docente) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adDocente addocente = new adDocente();
            addocente.ModificarDocente(docente);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarDocente(Docente docente) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adDocente addocente = new adDocente();
            addocente.EliminarDocente(docente);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
