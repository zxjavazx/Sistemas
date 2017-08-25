
package Beans;

import java.sql.Date;


public class Evaluacion {
    private  Integer Ideval;
    private String Fecheval;
    private Integer Nota;
    private Boleta Boleta;
    private Alumno Alumno;  

    public Evaluacion() {
    }

    public Evaluacion(Integer Ideval) {
        this.Ideval = Ideval;
    }

    public Evaluacion(Integer Ideval, String Fecheval, Integer Nota, Boleta Boleta, Alumno Alumno) {
        this.Ideval = Ideval;
        this.Fecheval = Fecheval;
        this.Nota = Nota;
        this.Boleta = Boleta;
        this.Alumno = Alumno;
    }

    public Integer getIdeval() {
        return Ideval;
    }

    public void setIdeval(Integer Ideval) {
        this.Ideval = Ideval;
    }

    public String getFecheval() {
        return Fecheval;
    }

    public void setFecheval(String Fecheval) {
        this.Fecheval = Fecheval;
    }

    public Integer getNota() {
        return Nota;
    }

    public void setNota(Integer Nota) {
        this.Nota = Nota;
    }

    public Boleta getBoleta() {
        return Boleta;
    }

    public void setBoleta(Boleta Boleta) {
        this.Boleta = Boleta;
    }

    public Alumno getAlumno() {
        return Alumno;
    }

    public void setAlumno(Alumno Alumno) {
        this.Alumno = Alumno;
    }

    
}
