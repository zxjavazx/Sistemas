package Negocios;

import AccesoDatos.adHorario;
import Beans.Horario;
import Conexion.Conexion;
import java.util.List;

public class nHorario {
    public String ObtenerIdHorario() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adHorario adhorario = new adHorario();
            id = Integer.toString(adhorario.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Horario> ConsultarHorario() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adHorario adhorario = new adHorario();
            List<Horario> lsthorarios = adhorario.ListarHorario();
            return lsthorarios;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarHorario(Horario horario) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adHorario adhorario = new adHorario();
            adhorario.RegistrarHorario(horario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarHorario(Horario horario) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adHorario adhorario = new adHorario();
            adhorario.ModificarHorario(horario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarHorario(Horario horario) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adHorario adhorario = new adHorario();
            adhorario.EliminarHorario(horario);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
