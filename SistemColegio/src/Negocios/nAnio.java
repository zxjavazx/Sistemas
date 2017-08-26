package Negocios;

import AccesoDatos.adAnio;
import Beans.Anio;
import Conexion.Conexion;
import java.util.List;

public class nAnio {
    public String ObtenerIdAnio() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adAnio adanio = new adAnio();
            id = Integer.toString(adanio.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Anio> ConsultarAnio() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAnio adanio = new adAnio();
            List<Anio> lstanios = adanio.ListarAnio();
            
            return lstanios;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarAnio(Anio anio) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAnio adanio = new adAnio();
            adanio.RegistrarAnio(anio);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarAnio(Anio anio) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adAnio adanio = new adAnio();
            adanio.ModificarAnio(anio);
        } catch (Exception e) {
            throw e;
        }
    }
}
