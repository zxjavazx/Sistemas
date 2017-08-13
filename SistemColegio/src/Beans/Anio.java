package Beans;

public class Anio {
    private Integer Idanio;
    private String Fechin;
    private String Fechfin;

    public Anio() {
    }

    public Anio(Integer Idanio) {
        this.Idanio = Idanio;
    }

    public Anio(Integer Idanio, String Fechin, String Fechfin) {
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

    public String getFechin() {
        return Fechin;
    }

    public void setFechin(String Fechin) {
        this.Fechin = Fechin;
    }

    public String getFechfin() {
        return Fechfin;
    }

    public void setFechfin(String Fechfin) {
        this.Fechfin = Fechfin;
    }

    
}
