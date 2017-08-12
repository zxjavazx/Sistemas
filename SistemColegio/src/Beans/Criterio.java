

package Beans;


public class Criterio {
  
    
private Integer idcrit;
private String nomcrit;
private Integer idarea;

    public Criterio() {
    }

    public Criterio(Integer idcrit) {
        this.idcrit = idcrit;
    }

    public Criterio(Integer idcrit, String nomcrit, Integer idarea) {
        this.idcrit = idcrit;
        this.nomcrit = nomcrit;
        this.idarea = idarea;
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

    public Integer getIdarea() {
        return idarea;
    }

    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }


    
}
