package Negocios;

import AccesoDatos.adCoordinador;
import Beans.Coordinador;
import Conexion.Conexion;
import java.util.List;

public class nCoordinador {
    public String ObtenerIdCoordinador() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adCoordinador adcoordinador = new adCoordinador();
            id = Integer.toString(adcoordinador.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Coordinador> ConsultarCoordinador() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adCoordinador adcoordinador = new adCoordinador();
            List<Coordinador> lstcoordinadores = adcoordinador.ListarCoordinador();
            return lstcoordinadores;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarCoordinador(Coordinador coordinador) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adCoordinador adcoordinador = new adCoordinador();
            adcoordinador.RegistrarCoordinador(coordinador);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarCoordinador(Coordinador coordinador) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adCoordinador adcoordinador = new adCoordinador();
            adcoordinador.ModificarCoordinador(coordinador);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarCoordinador(Coordinador coordinador) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adCoordinador adcoordinador = new adCoordinador();
            adcoordinador.EliminarCoordinador(coordinador);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
