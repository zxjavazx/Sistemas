package Negocios;

import AccesoDatos.adMatricula;
import Beans.Matricula;
import Conexion.Conexion;
import java.util.List;

public class nMatricula {
    public String ObtenerIdMatricula() throws Exception{
        Conexion con = null;
        String id;
        try {
            con = new Conexion();
            
            adMatricula admatricula = new adMatricula();
            id = Integer.toString(admatricula.proxId());
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Matricula> ConsultarMatricula() throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adMatricula admatricula = new adMatricula();
            List<Matricula> lstmatriculas = admatricula.ListarMatricula();
            return lstmatriculas;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarMatricula(Matricula matricula) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adMatricula admatricula = new adMatricula();
            admatricula.RegistrarMatricula(matricula);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarMatricula(Matricula matricula) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adMatricula admatricula = new adMatricula();
            admatricula.ModificarMatricula(matricula);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarMatricula(Matricula matricula) throws Exception{
        Conexion con = null;
        try {
            con = new Conexion();
            
            adMatricula admatricula = new adMatricula();
            admatricula.EliminarMatricula(matricula);
                    
        } catch (Exception e) {
            throw e;
        }
    }
}
