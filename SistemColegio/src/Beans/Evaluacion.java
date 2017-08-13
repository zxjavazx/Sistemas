
package Beans;

import java.sql.Date;


public class Evaluacion {
    
private  Integer ideval;
private Date fecheval;
private Integer nota;
private Boleta boleta;
private Alumno alumno;  

    public Evaluacion() {
    }

    public Evaluacion(Integer ideval) {
        this.ideval = ideval;
    }

    public Evaluacion(Integer ideval, Date fecheval, Integer nota, Boleta boleta, Alumno alumno) {
        this.ideval = ideval;
        this.fecheval = fecheval;
        this.nota = nota;
        this.boleta = boleta;
        this.alumno = alumno;
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

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

  
    
    
}
