package Negocios;

import AccesoDatos.adEvaluacion;
import Beans.Evaluacion;
import Conexion.Conexion;
import java.util.List;

public class nEvaluacion {
    public String ObtenerIdEvaluacion() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adEvaluacion adevaluacion = new adEvaluacion();
            id = Integer.toString(adevaluacion.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Evaluacion> ConsultarEvaluacion() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adEvaluacion adevaluacion = new adEvaluacion();
            List<Evaluacion> lstevaluaciones = adevaluacion.ListarEvaluacion();
            return lstevaluaciones;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarEvaluacion(Evaluacion evaluacion) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adEvaluacion adevaluacion = new adEvaluacion();
            adevaluacion.RegistrarEvaluacion(evaluacion);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarEvaluacion(Evaluacion evaluacion) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adEvaluacion adevaluacion = new adEvaluacion();
            adevaluacion.ModificarEvaluacion(evaluacion);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarEvaluacion(Evaluacion evaluacion) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adEvaluacion adevaluacion = new adEvaluacion();
            adevaluacion.EliminarEvaluacion(evaluacion);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
