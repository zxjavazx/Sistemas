

package Beans;


public class Criterio {
  
    
private Integer idcrit;
private String nomcrit;
private Area area;

    public Criterio() {
    }

    public Criterio(Integer idcrit) {
        this.idcrit = idcrit;
    }

    public Criterio(Integer idcrit, String nomcrit, Area area) {
        this.idcrit = idcrit;
        this.nomcrit = nomcrit;
        this.area = area;
    }

    public Integer getIdcrit() {
        return idcrit;
    }

    public void setIdcrit(Integer idcrit) {
        this.idcrit = idcrit;
    }

    public String getNomcrit() {
        return nomcrit;
    }

    public void setNomcrit(String nomcrit) {
        this.nomcrit = nomcrit;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    


    
}
