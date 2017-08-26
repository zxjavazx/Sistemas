package Negocios;

import AccesoDatos.adArea;
import Beans.Area;
import Conexion.Conexion;
import java.util.List;

public class nArea {
    public String ObtenerIdArea() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adArea adarea = new adArea();
            id = Integer.toString(adarea.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Area> ConsultarArea() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adArea adarea = new adArea();
            List<Area> lstareas = adarea.ListarArea();
            return lstareas;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarArea(Area area) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adArea adarea = new adArea();
            adarea.RegistrarArea(area);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarArea(Area area) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adArea adarea = new adArea();
            adarea.ModificarArea(area);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarArea(Area area) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adArea adarea = new adArea();
            adarea.EliminarArea(area);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
