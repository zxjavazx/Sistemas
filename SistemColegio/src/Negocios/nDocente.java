package Negocios;

import Beans.Coordinador;
import Beans.Grado;
import Beans.Docente;
import Beans.Especialidad;
import Beans.Tutor;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class nDocente {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId(){
        try {
            String sql = "select nextval('docente_iddoc_seq') as iddoc;";
            
            Integer id = 0;

            rs = con.RecuperarSQL(sql);

            rs.beforeFirst();
            
            if(rs.next()) {
                id = rs.getInt("iddoc");
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
    
    public List ListarDocente(){
        try {
            List<Docente> lstdocentes = new ArrayList<Docente>();
            String sql = "select";
            sql = sql + " iddoc";
            sql = sql + ",coddoc";
            sql = sql + ",nomdoc";
            sql = sql + ",apepatdoc";
            sql = sql + ",apematdoc";
            sql = sql + ",idtut";
            sql = sql + ",idcoor";
            sql = sql + ",idesp";
            sql = sql + " from docente";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Docente obj = new Docente();
                obj.setIddoc(rs.getInt("iddoc"));
                obj.setCoddoc(rs.getString("coddoc"));
                obj.setNomdoc(rs.getString("nomdoc"));
                obj.setApepatdoc(rs.getString("apepatdoc"));
                obj.setApematdoc(rs.getString("apematdoc"));
                obj.setIdtut(new Tutor(rs.getInt("idtut")));
                obj.setIdcoor(new Coordinador(rs.getInt("idcoor")));
                obj.setIdesp(new Especialidad(rs.getInt("idesp")));
                lstdocentes.add(obj);
            }
            return lstdocentes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void RegistrarDocente(Docente obj){
        try {
            obj.setIddoc(getId());
            
            String sql = "insert into docente(";
            sql = sql + " iddoc";
            sql = sql + ",coddoc";
            sql = sql + ",nomdoc";
            sql = sql + ",apepatdoc";
            sql = sql + ",apematdoc";
            sql = sql + ",idtut";
            sql = sql + ",idcoor";
            sql = sql + ",idesp";
            sql = sql + ")values(";
            sql = sql + "'"+obj.getIddoc().toString()+"'";
            sql = sql + ",'"+obj.getCoddoc() + "'";
            sql = sql + ",'"+obj.getNomdoc()+"'";
            sql = sql + ",'"+obj.getApepatdoc()+"'";
            sql = sql + ",'"+obj.getApematdoc()+"'";
            sql = sql + ",'"+obj.getIdtut().toString()+"'";
            sql = sql + ",'"+obj.getIdcoor().toString()+"'";
            sql = sql + ",'"+obj.getIdesp().toString()+"'";
            sql = sql + ");";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ModificarDocente(Docente obj){
        try {
            
            String sql = "update docente set(";
            sql = sql + " coddoc = '"+obj.getCoddoc() + "'";
            sql = sql + " nomdoc = '"+obj.getNomdoc() + "'";
            sql = sql + " apepatdoc = '"+obj.getApepatdoc() + "'";
            sql = sql + " apematdoc = '"+obj.getApematdoc() + "'";
            sql = sql + " idtut = '"+obj.getIdtut().toString() + "'";
            sql = sql + " idcoor = '"+obj.getIdcoor().toString() + "'";
            sql = sql + " idtut = '"+obj.getIdesp().toString() + "'";
            sql = sql + " where";
            sql = sql + " iddoc = '"+obj.getIddoc().toString()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarDocente(Docente obj){
        try {
            String sql = "delete from docente";
            sql = sql + " where";
            sql = sql + " iddoc = " + obj.getIddoc().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
