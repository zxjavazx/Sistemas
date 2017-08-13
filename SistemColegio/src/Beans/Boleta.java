
package Beans;


public class Boleta {
    
 private Integer idbol;
 private Integer  pritri;
 private Integer  segtri;
 private Integer  tertri;
 private Anio  anio;
 private Matricula matricula;

    public Boleta() {
    }

    public Boleta(Integer idbol) {
        this.idbol = idbol;
    }

    public Boleta(Integer idbol, Integer pritri, Integer segtri, Integer tertri, Anio anio, Matricula matricula) {
        this.idbol = idbol;
        this.pritri = pritri;
        this.segtri = segtri;
        this.tertri = tertri;
        this.anio = anio;
        this.matricula = matricula;
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

    public Anio getAnio() {
        return anio;
    }

    public void setAnio(Anio anio) {
        this.anio = anio;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    
}
