

package Beans;

import java.sql.Date;


public class Matricula {
    private Integer Idmatr;
    private Date Fechmatr;
    private Anio Anio;
    private Seccion Seccion;
    private Boleta Boleta;
    private Alumno Alumno;

    public Matricula() {
    }

    public Matricula(Integer Idmatr) {
        this.Idmatr = Idmatr;
    }

    public Matricula(Integer Idmatr, Date Fechmatr, Anio Anio, Seccion Seccion, Boleta Boleta, Alumno Alumno) {
        this.Idmatr = Idmatr;
        this.Fechmatr = Fechmatr;
        this.Anio = Anio;
        this.Seccion = Seccion;
        this.Boleta = Boleta;
        this.Alumno = Alumno;
    }

    public Integer getIdmatr() {
        return Idmatr;
    }

    public void setIdmatr(Integer Idmatr) {
        this.Idmatr = Idmatr;
    }

    public Date getFechmatr() {
        return Fechmatr;
    }

    public void setFechmatr(Date Fechmatr) {
        this.Fechmatr = Fechmatr;
    }

    public Anio getAnio() {
        return Anio;
    }

    public void setAnio(Anio Anio) {
        this.Anio = Anio;
    }

    public Seccion getSeccion() {
        return Seccion;
    }

    public void setSeccion(Seccion Seccion) {
        this.Seccion = Seccion;
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
