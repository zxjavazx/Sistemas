package Negocios;

import AccesoDatos.adCriterio;
import Beans.Criterio;
import Conexion.Conexion;
import java.util.List;

public class nCriterio {
    public String ObtenerIdCriterio() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adCriterio adcriterio = new adCriterio();
            id = Integer.toString(adcriterio.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Criterio> ConsultarCriterio() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adCriterio adcriterio = new adCriterio();
            List<Criterio> lstcriterios = adcriterio.ListarCriterio();
            return lstcriterios;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarCriterio(Criterio criterio) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adCriterio adcriterio = new adCriterio();
            adcriterio.RegistrarCriterio(criterio);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarCriterio(Criterio criterio) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adCriterio adcriterio = new adCriterio();
            adcriterio.ModificarCriterio(criterio);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarCriterio(Criterio criterio) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adCriterio adcriterio = new adCriterio();
            adcriterio.EliminarCriterio(criterio);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
