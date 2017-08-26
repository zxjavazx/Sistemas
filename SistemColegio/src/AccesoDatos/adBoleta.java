package AccesoDatos;

import Beans.Anio;
import Beans.Boleta;
import Beans.Grado;
import Beans.Matricula;
import Beans.Seccion;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class adBoleta {
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
    
    public Integer proxId() throws Exception{
        try {
            String sql = "select last_value from boleta_idbol_seq;";
            
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
    
    public List ListarBoleta() throws Exception{
        try {
            List<Boleta> lstboletas = new ArrayList<Boleta>();
            String sql = "select";
            sql = sql + " boleta.idbol";
            sql = sql + ",boleta.pritri";
            sql = sql + ",boleta.segtri";
            sql = sql + ",boleta.tertri";
            sql = sql + ",año.idanio";
            sql = sql + ",año,anio";
            sql = sql + ",año.fechin";
            sql = sql + ",año.fechfin";
            sql = sql + ",matricula.idmatr";
            sql = sql + ",matricula.fechmatr";
            sql = sql + ",seccion.idsecc";
            sql = sql + ",seccion.nomsecc";
            sql = sql + ",grado.idgrad";
            sql = sql + ",grado.nomgrad";
            sql = sql + " from boleta";
            sql = sql + " inner join año on boleta.idbol = año.idbol";
            sql = sql + " inner join matricula on boleta.idmatr = matricula.idmatr";
            sql = sql + " inner join seccion on matricula.idsecc = seccion.idsecc";
            sql = sql + " inner join grado on seccion.idgrad = grado.idgrad";
            sql = sql + ";";
            rs = con.RecuperarSQL(sql);
            
            while(rs.next()){
                Boleta obj = new Boleta();
                obj.setIdbol(rs.getInt("idbol"));
                obj.setPritri(rs.getInt("pritri"));
                obj.setSegtri(rs.getInt("segtri"));
                obj.setTertri(rs.getInt("tertri"));
                obj.setAnio(new Anio(rs.getInt("idanio"),(rs.getString("anio")), rs.getString("fechin"),rs.getString("fechfin")));
                obj.setMatricula(new Matricula(rs.getInt("idmatr"),rs.getString("fechmatr"),new Anio(rs.getInt("idanio"),(rs.getString("anio")), rs.getString("fechin"),rs.getString("fechfin")),new Seccion(rs.getInt("idsecc"),rs.getString("nomsecc"),new Grado(rs.getInt("idgrad"),rs.getString("nomgrad")))));
                lstboletas.add(obj);
            }
            return lstboletas;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void RegistrarBoleta(Boleta obj) throws Exception{
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
            throw e;
        }
    }
    
    public void ModificarBoleta(Boleta obj) throws Exception{
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
            throw e;
        }
    }
    
    public void EliminarBoleta(Boleta obj) throws Exception{
        try {
            String sql = "delete from boleta";
            sql = sql + " where";
            sql = sql + " idbol = "+obj.getIdbol().toString();
            sql = sql + ";";
            
            rs = con.RecuperarSQL(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }
}
