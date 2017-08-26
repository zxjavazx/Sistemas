package Negocios;

import AccesoDatos.adEspecialidad;
import Beans.Especialidad;
import Conexion.Conexion;
import java.util.List;

public class nEspecialidad {
    public String ObtenerIdEspecialidad() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adEspecialidad adespecialidad = new adEspecialidad();
            id = Integer.toString(adespecialidad.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Especialidad> ConsultarEspecialidad() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adEspecialidad adespecialidad = new adEspecialidad();
            List<Especialidad> lstespecialidads = adespecialidad.ListarEspecialidad();
            return lstespecialidads;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarEspecialidad(Especialidad especialidad) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adEspecialidad adespecialidad = new adEspecialidad();
            adespecialidad.RegistrarEspecialidad(especialidad);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarEspecialidad(Especialidad especialidad) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adEspecialidad adespecialidad = new adEspecialidad();
            adespecialidad.ModificarEspecialidad(especialidad);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarEspecialidad(Especialidad especialidad) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adEspecialidad adespecialidad = new adEspecialidad();
            adespecialidad.EliminarEspecialidad(especialidad);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
