
package Beans;


public class Boleta {
    
 private Integer idbol;
 private Integer  pritri;
 private Integer  segtri;
 private Integer  tertri;
 private Integer  idanio;
 private Integer  idmatr;

    public Boleta() {
    }

    public Boleta(Integer idbol) {
        this.idbol = idbol;
    }

    public Boleta(Integer idbol, Integer pritri, Integer segtri, Integer tertri, Integer idanio, Integer idmatr) {
        this.idbol = idbol;
        this.pritri = pritri;
        this.segtri = segtri;
        this.tertri = tertri;
        this.idanio = idanio;
        this.idmatr = idmatr;
    }

    public Integer getIdbol() {
        return idbol;
    }

    public void setIdbol(Integer idbol) {
        this.idbol = idbol;
    }

    public Integer getPritri() {
        return pritri;
    }

    public void setPritri(Integer pritri) {
        this.pritri = pritri;
    }

    public Integer getSegtri() {
        return segtri;
    }

    public void setSegtri(Integer segtri) {
        this.segtri = segtri;
    }

    public Integer getTertri() {
        return tertri;
    }

    public void setTertri(Integer tertri) {
        this.tertri = tertri;
    }

    public Integer getIdanio() {
        return idanio;
    }

    public void setIdanio(Integer idanio) {
        this.idanio = idanio;
    }

    public Integer getIdmatr() {
        return idmatr;
    }

    public void setIdmatr(Integer idmatr) {
        this.idmatr = idmatr;
    }
 
 
 
 
}
