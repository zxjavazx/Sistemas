
package Beans;

import java.sql.Date;


public class Horario {
 
private Integer idhora;
private String diasemana;
private  Date horini;
private  Date  horfin;
private Integer idanio;
private Integer  idgrad;

    public Horario() {
    }

    public Horario(Integer idhora) {
        this.idhora = idhora;
    }

    public Horario(Integer idhora, String diasemana, Date horini, Date horfin, Integer idanio, Integer idgrad) {
        this.idhora = idhora;
        this.diasemana = diasemana;
        this.horini = horini;
        this.horfin = horfin;
        this.idanio = idanio;
        this.idgrad = idgrad;
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

    public Integer getIdanio() {
        return idanio;
    }

    public void setIdanio(Integer idanio) {
        this.idanio = idanio;
    }

    public Integer getIdgrad() {
        return idgrad;
    }

    public void setIdgrad(Integer idgrad) {
        this.idgrad = idgrad;
    }
   


    
}

