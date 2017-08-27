package Negocios;

import AccesoDatos.adGrado;
import Beans.Grado;
import Conexion.Conexion;
import java.util.List;

public class nGrado {
    public String ObtenerIdGrado() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adGrado adgrado = new adGrado();
            id = Integer.toString(adgrado.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Grado> ConsultarGrado() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adGrado adgrado = new adGrado();
            List<Grado> lstgrados = adgrado.ListarGrado();
            return lstgrados;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarGrado(Grado grado) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adGrado adgrado = new adGrado();
            adgrado.RegistrarGrado(grado);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarGrado(Grado grado) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adGrado adgrado = new adGrado();
            adgrado.ModificarGrado(grado);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarGrado(Grado grado) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adGrado adgrado = new adGrado();
            adgrado.EliminarGrado(grado);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
