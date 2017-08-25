package Negocios;

import Beans.Anio;
import Beans.Area;
import Beans.Boleta;
import Beans.Matricula;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nBoleta {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
        try {
            String sql = "select nextval('boleta_idbol_seq') as idbol;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("idbol");
                if(rs.wasNull()) {
                    id = 0;
                }
            }
            return id;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List ListarBoleta(){
        try {
            List<Boleta> lstboletas = new ArrayList<Boleta>();
            String sql = "select";
            sql = sql + " idbol";
            sql = sql + ",pritri";
            sql = sql + ",segtri";
            sql = sql + ",tertri";
            sql = sql + ",idanio";
            sql = sql + ",idmatr";
            sql = sql + " from boleta";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Boleta obj = new Boleta();
                obj.setIdbol(rs.getInt("idbol"));
                obj.setPritri(rs.getInt("pritri"));
                obj.setSegtri(rs.getInt("segtri"));
                obj.setTertri(rs.getInt("tertri"));
                obj.setAnio(new Anio(rs.getInt("idanio")));
                obj.setMatricula(new Matricula(rs.getInt("idmatr")));
                lstboletas.add(obj);
            }
            return lstboletas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarBoleta(Boleta obj){
        try {
            obj.setIdbol(getId());
            
            String sql = "insert into boleta(";
            sql = sql + " idbol";
            sql = sql + ",pritri";
            sql = sql + ",segtri";
            sql = sql + ",tertri";
            sql = sql + ",idanio";
            sql = sql + ",idmatr";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIdbol()+"'";
            sql = sql + ",'"+obj.getPritri() + "'";
            sql = sql + ",'"+obj.getSegtri() + "'";
            sql = sql + ",'"+obj.getTertri() + "'";
            sql = sql + ",'"+obj.getAnio().getIdanio() + "'";
            sql = sql + ",'"+obj.getMatricula().getIdmatr() + "'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ModificarBoleta(Boleta obj){
        try {
            
            String sql = "update boleta set(";
            sql = sql + " pritri = '"+obj.getPritri() + "'";
            sql = sql + ",segtri = '"+obj.getSegtri() + "'";
            sql = sql + ",tertri = '"+obj.getTertri() + "'";
            sql = sql + ",idanio = '"+obj.getAnio().getIdanio() + "'";
            sql = sql + ",idmatr = '"+obj.getMatricula().getIdmatr() + "'";
            sql = sql + " where";
            sql = sql + " idbol = '"+obj.getIdbol()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarBoleta(Boleta obj){
        try {
            String sql = "delete from boleta";
            sql = sql + " where";
            sql = sql + " idbol = "+obj.getIdbol().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
