package Beans;

import java.sql.Date;

public class Anio {
    private Integer Idanio;
    private Date Fechin;
    private Date Fechfin;

    public Anio() {
    }

    public Anio(Integer Idanio) {
        this.Idanio = Idanio;
    }

    public Anio(Integer Idanio, Date Fechin, Date Fechfin) {
        this.Idanio = Idanio;
        this.Fechin = Fechin;
        this.Fechfin = Fechfin;
    }

    public Integer getIdanio() {
        return Idanio;
    }

    public void setIdanio(Integer Idanio) {
        this.Idanio = Idanio;
    }

    public Date getFechin() {
        return Fechin;
    }

    public void setFechin(Date Fechin) {
        this.Fechin = Fechin;
    }

    public Date getFechfin() {
        return Fechfin;
    }

    public void setFechfin(Date Fechfin) {
        this.Fechfin = Fechfin;
    }

    
}
