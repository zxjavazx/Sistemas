package Negocios;

import AccesoDatos.adBoleta;
import Beans.Boleta;
import Conexion.Conexion;
import java.util.List;

public class nBoleta {
    public String ObtenerIdBoleta() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adBoleta adboleta = new adBoleta();
            id = Integer.toString(adboleta.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Boleta> ConsultarBoleta() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adBoleta adboleta = new adBoleta();
            List<Boleta> lstboletas = adboleta.ListarBoleta();
            return lstboletas;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarBoleta(Boleta boleta) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adBoleta adboleta = new adBoleta();
            adboleta.RegistrarBoleta(boleta);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarBoleta(Boleta boleta) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adBoleta adboleta = new adBoleta();
            adboleta.ModificarBoleta(boleta);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarBoleta(Boleta boleta) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adBoleta adboleta = new adBoleta();
            adboleta.EliminarBoleta(boleta);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
