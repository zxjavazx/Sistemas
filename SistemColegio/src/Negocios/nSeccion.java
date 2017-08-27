package Negocios;

import AccesoDatos.adSeccion;
import Beans.Seccion;
import Conexion.Conexion;
import java.util.List;

public class nSeccion {
    public String ObtenerIdSeccion() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adSeccion adseccion = new adSeccion();
            id = Integer.toString(adseccion.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Seccion> ConsultarSeccion() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adSeccion adseccion = new adSeccion();
            List<Seccion> lstseccions = adseccion.ListarSeccion();
            return lstseccions;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarSeccion(Seccion seccion) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adSeccion adseccion = new adSeccion();
            adseccion.RegistrarSeccion(seccion);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarSeccion(Seccion seccion) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adSeccion adseccion = new adSeccion();
            adseccion.ModificarSeccion(seccion);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarSeccion(Seccion seccion) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adSeccion adseccion = new adSeccion();
            adseccion.EliminarSeccion(seccion);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
