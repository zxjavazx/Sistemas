

package Beans;

import java.sql.Date;


public class Matricula {


private Integer idmatr;
private Date fechmatr;
private Anio anio;
private Seccion seccion;
private Boleta boleta;
private Alumno alumno;

    public Matricula() {
    }

    public Matricula(Integer idmatr) {
        this.idmatr = idmatr;
    }

    public Matricula(Integer idmatr, Date fechmatr, Anio anio, Seccion seccion, Boleta boleta, Alumno alumno) {
        this.idmatr = idmatr;
        this.fechmatr = fechmatr;
        this.anio = anio;
        this.seccion = seccion;
        this.boleta = boleta;
        this.alumno = alumno;
    }

    public Integer getIdmatr() {
        return idmatr;
    }

    public void setIdmatr(Integer idmatr) {
        this.idmatr = idmatr;
    }

    public Date getFechmatr() {
        return fechmatr;
    }

    public void setFechmatr(Date fechmatr) {
        this.fechmatr = fechmatr;
    }

    public Anio getAnio() {
        return anio;
    }

    public void setAnio(Anio anio) {
        this.anio = anio;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
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
