

package Beans;

import java.sql.Date;


public class Matricula {


private Integer idmatr;
private Date fechmatr;
private Integer idanio;
private Integer idsecc;
private Integer idbol;
private Integer  idalum;

    public Matricula() {
    }

    public Matricula(Integer idmatr) {
        this.idmatr = idmatr;
    }

    public Matricula(Integer idmatr, Date fechmatr, Integer idanio, Integer idsecc, Integer idbol, Integer idalum) {
        this.idmatr = idmatr;
        this.fechmatr = fechmatr;
        this.idanio = idanio;
        this.idsecc = idsecc;
        this.idbol = idbol;
        this.idalum = idalum;
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

    public Integer getIdanio() {
        return idanio;
    }

    public void setIdanio(Integer idanio) {
        this.idanio = idanio;
    }

    public Integer getIdsecc() {
        return idsecc;
    }

    public void setIdsecc(Integer idsecc) {
        this.idsecc = idsecc;
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
