

package Beans;

import java.sql.Date;


public class Matricula {
    private Integer Idmatr;
    private Date Fechmatr;
    private Anio Anio;
    private Seccion Seccion;
    
    public Matricula() {
    }

    public Matricula(Integer Idmatr) {
        this.Idmatr = Idmatr;
    }

    public Matricula(Integer Idmatr, Date Fechmatr, Anio Anio, Seccion Seccion) {
        this.Idmatr = Idmatr;
        this.Fechmatr = Fechmatr;
        this.Anio = Anio;
        this.Seccion = Seccion;
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

    
}
