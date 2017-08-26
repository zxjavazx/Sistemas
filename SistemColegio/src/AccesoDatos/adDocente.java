package AccesoDatos;

import Beans.Anio;
import Beans.Area;
import Beans.Coordinador;
import Beans.Docente;
import Beans.Especialidad;
import Beans.Grado;
import Beans.Seccion;
import Beans.Tutor;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adDocente {
    Conexion con = new Conexion();
    ResultSet rs;
    public Integer getId() throws Exception{
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
            throw e;
        }
    }
    
    public Integer proxId() throws Exception{
        try {
            String sql = "select last_value from docente_iddoc_seq;";
            
            Integer id = 0;
            
            rs = con.RecuperarSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("last_value");
                
                if(rs.wasNull()){
                    id = 0;
                }
                
                if(id==1){
                    id = 0;
                }
            }
            id = id+1;
            
            return id;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List ListarDocente() throws Exception{
        try {
            List<Docente> lstdocentes = new ArrayList<Docente>();
            String sql = "select";
            sql = sql + " docente.iddoc";
            sql = sql + ",docente.coddoc";
            sql = sql + ",docente.nomdoc";
            sql = sql + ",docente.apepatdoc";
            sql = sql + ",docente.apematdoc";
            sql = sql + ",tutor.idtut";
            sql = sql + ",tutor.descripcion";
            sql = sql + ",año.idanio";
            sql = sql + ",año.anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",seccion.idsecc";
            sql = sql + ",seccion.nomsecc";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";        
            sql = sql + ",coordinador.idcoor";
            sql = sql + ",coordinador.descoor";
            sql = sql + ",area.idarea";
            sql = sql + ",area.nomarea";
            sql = sql + ",especialidad.idesp";
            sql = sql + ",especialidad.codesp";
            sql = sql + ",especialidad.nomesp";
            sql = sql + " from docente";
            sql = sql + " inner join tutor on docente.idtut = tutor.idtut";
            sql = sql + " inner join año on tutor.idanio = año.idanio";
            sql = sql + " inner join seccion on tutor.idsecc = seccion.idsecc";
            sql = sql + " inner join grado on seccion.idgrad = grado.idgrad";
            sql = sql + " inner join coordinador on docente.idcoor = coordinador.idcoor";
            sql = sql + " inner join area on coordinador.idarea = area.idarea";
            sql = sql + " inner join especialidad on docente.idesp = especialidad.idesp";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Docente obj = new Docente();
                obj.setIddoc(rs.getInt("iddoc"));
                obj.setCoddoc(rs.getString("coddoc"));
                obj.setNomdoc(rs.getString("nomdoc"));
                obj.setApepatdoc(rs.getString("apepatdoc"));
                obj.setApematdoc(rs.getString("apematdoc"));
                obj.setIdtut(new Tutor(rs.getInt("idtut"),rs.getString("descripcion"),new Anio(rs.getInt("idanio"),(rs.getString("anio")),rs.getString("fechin"),rs.getString("fechfin")),new Seccion((rs.getInt("idsecc")),(rs.getString("nomsecc")),new Grado((rs.getInt("idgrad")),(rs.getString("nomgrad"))))));
                obj.setIdcoor(new Coordinador(rs.getInt("idcoor"),rs.getString("descoor"),new Area(rs.getInt("idarea"),rs.getString("nomarea")),new Anio(rs.getInt("idanio"),(rs.getString("anio")),rs.getString("fechin"),rs.getString("fechfin"))));
                obj.setIdesp(new Especialidad(rs.getInt("idesp"),rs.getString("codesp"),rs.getString("nomesp")));
                lstdocentes.add(obj);
            }
            return lstdocentes;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void RegistrarDocente(Docente obj) throws Exception{
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
            sql = sql + " '"+obj.getIddoc().toString()+"'";
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
            throw e;
        }
    }
    
    public void ModificarDocente(Docente obj){
        try {
            
            String sql = "update docente set(";
            sql = sql + " coddoc = '"+obj.getCoddoc() + "'";
            sql = sql + ",nomdoc = '"+obj.getNomdoc() + "'";
            sql = sql + ",apepatdoc = '"+obj.getApepatdoc() + "'";
            sql = sql + ",apematdoc = '"+obj.getApematdoc() + "'";
            sql = sql + ",idtut = '"+obj.getIdtut().toString() + "'";
            sql = sql + ",idcoor = '"+obj.getIdcoor().toString() + "'";
            sql = sql + ",idtut = '"+obj.getIdesp().toString() + "'";
            sql = sql + " where";
            sql = sql + " iddoc = '"+obj.getIddoc().toString()+"'";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
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
            throw e;
        }
    }
}
