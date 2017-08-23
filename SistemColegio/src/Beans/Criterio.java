

package Beans;


public class Criterio {
    private Integer Idcrit;
    private String Nomcrit;
    private Area Area;

    public Criterio() {
    }

    public Criterio(Integer Idcrit) {
        this.Idcrit = Idcrit;
    }

    public Criterio(Integer Idcrit, String Nomcrit, Area Area) {
        this.Idcrit = Idcrit;
        this.Nomcrit = Nomcrit;
        this.Area = Area;
    }

    public Integer getIdcrit() {
        return Idcrit;
    }

    public void setIdcrit(Integer Idcrit) {
        this.Idcrit = Idcrit;
    }

    public String getNomcrit() {
        return Nomcrit;
    }

    public void setNomcrit(String Nomcrit) {
        this.Nomcrit = Nomcrit;
    }

    public Area getArea() {
        return Area;
    }

    public void setArea(Area Area) {
        this.Area = Area;
    }

    
}
