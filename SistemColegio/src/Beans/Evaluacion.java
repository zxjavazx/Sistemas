
package Beans;

import java.sql.Date;


public class Evaluacion {
    
private  Integer ideval;
private Date fecheval;
private Integer nota;
private Integer  idbol;
private Integer idalum ;  

    public Evaluacion() {
    }

    public Evaluacion(Integer ideval) {
        this.ideval = ideval;
    }

    public Evaluacion(Integer ideval, Date fecheval, Integer nota, Integer idbol, Integer idalum) {
        this.ideval = ideval;
        this.fecheval = fecheval;
        this.nota = nota;
        this.idbol = idbol;
        this.idalum = idalum;
    }

    public Integer getIdeval() {
        return ideval;
    }

    public void setIdeval(Integer ideval) {
        this.ideval = ideval;
    }

    public Date getFecheval() {
        return fecheval;
    }

    public void setFecheval(Date fecheval) {
        this.fecheval = fecheval;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getIdbol() {
        return idbol;
    }

    public void setIdbol(Integer idbol) {
        this.idbol = idbol;
    }

    public Integer getIdalum() {
        return idalum;
    }

    public void setIdalum(Integer idalum) {
        this.idalum = idalum;
    }
    
    
}
