package Beans;

import java.sql.Date;

public class Anio {
    private Integer idanio;
    private Date Fechin;
    private Date Fechfin;

    public Anio() {
    }

    public Anio(Integer idanio) {
        this.idanio = idanio;
    }

    public Anio(Integer idanio, Date Fechin, Date Fechfin) {
        this.idanio = idanio;
        this.Fechin = Fechin;
        this.Fechfin = Fechfin;
    }

    public Integer getIdanio() {
        return idanio;
    }

    public void setIdanio(Integer idanio) {
        this.idanio = idanio;
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
