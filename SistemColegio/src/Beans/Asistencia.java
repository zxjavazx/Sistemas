
package Beans;

import java.sql.Date;


public class Asistencia {
    
 
private Integer idasist;
private String condicion;
private Date  fechasist;
private Integer idhora; 
private Integer idalum ;

    public Asistencia() {
    }

    public Asistencia(Integer idasist) {
        this.idasist = idasist;
    }

    public Asistencia(Integer idasist, String condicion, Date fechasist, Integer idhora, Integer idalum) {
        this.idasist = idasist;
        this.condicion = condicion;
        this.fechasist = fechasist;
        this.idhora = idhora;
        this.idalum = idalum;
    }

    public Integer getIdasist() {
        return idasist;
    }

    public void setIdasist(Integer idasist) {
        this.idasist = idasist;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Date getFechasist() {
        return fechasist;
    }

    public void setFechasist(Date fechasist) {
        this.fechasist = fechasist;
    }

    public Integer getIdhora() {
        return idhora;
    }

    public void setIdhora(Integer idhora) {
        this.idhora = idhora;
    }

    public Integer getIdalum() {
        return idalum;
    }

    public void setIdalum(Integer idalum) {
        this.idalum = idalum;
    }


    
}
