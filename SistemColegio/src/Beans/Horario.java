
package Beans;

import java.sql.Date;


public class Horario {
 
private Integer idhora;
private String diasemana;
private  Date horini;
private  Date  horfin;
private Anio anio;
private Grado grado;

    public Horario() {
    }

    public Horario(Integer idhora) {
        this.idhora = idhora;
    }

    public Horario(Integer idhora, String diasemana, Date horini, Date horfin, Anio anio, Grado grado) {
        this.idhora = idhora;
        this.diasemana = diasemana;
        this.horini = horini;
        this.horfin = horfin;
        this.anio = anio;
        this.grado = grado;
    }

    public Integer getIdhora() {
        return idhora;
    }

    public void setIdhora(Integer idhora) {
        this.idhora = idhora;
    }

    public String getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(String diasemana) {
        this.diasemana = diasemana;
    }

    public Date getHorini() {
        return horini;
    }

    public void setHorini(Date horini) {
        this.horini = horini;
    }

    public Date getHorfin() {
        return horfin;
    }

    public void setHorfin(Date horfin) {
        this.horfin = horfin;
    }

    public Anio getAnio() {
        return anio;
    }

    public void setAnio(Anio anio) {
        this.anio = anio;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

   
    
}

