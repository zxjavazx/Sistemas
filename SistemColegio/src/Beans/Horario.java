
package Beans;

import java.sql.Date;


public class Horario {
    private Integer Idhora;
    private String Diasemana;
    private  Date Horini;
    private  Date  Horfin;
    private Anio Anio;
    private Grado Grado;

    public Horario() {
    }

    public Horario(Integer Idhora) {
        this.Idhora = Idhora;
    }

    public Horario(Integer Idhora, String Diasemana, Date Horini, Date Horfin, Anio Anio, Grado Grado) {
        this.Idhora = Idhora;
        this.Diasemana = Diasemana;
        this.Horini = Horini;
        this.Horfin = Horfin;
        this.Anio = Anio;
        this.Grado = Grado;
    }

    public Integer getIdhora() {
        return Idhora;
    }

    public void setIdhora(Integer Idhora) {
        this.Idhora = Idhora;
    }

    public String getDiasemana() {
        return Diasemana;
    }

    public void setDiasemana(String Diasemana) {
        this.Diasemana = Diasemana;
    }

    public Date getHorini() {
        return Horini;
    }

    public void setHorini(Date Horini) {
        this.Horini = Horini;
    }

    public Date getHorfin() {
        return Horfin;
    }

    public void setHorfin(Date Horfin) {
        this.Horfin = Horfin;
    }

    public Anio getAnio() {
        return Anio;
    }

    public void setAnio(Anio Anio) {
        this.Anio = Anio;
    }

    public Grado getGrado() {
        return Grado;
    }

    public void setGrado(Grado Grado) {
        this.Grado = Grado;
    }

    
}

