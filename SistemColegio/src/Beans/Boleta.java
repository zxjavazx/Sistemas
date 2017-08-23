
package Beans;


public class Boleta {
    
 private Integer Idbol;
 private Integer  Pritri;
 private Integer  Segtri;
 private Integer  Tertri;
 private Anio  Anio;
 private Matricula matricula;

    public Boleta() {
    }

    public Boleta(Integer Idbol) {
        this.Idbol = Idbol;
    }

    public Boleta(Integer Idbol, Integer Pritri, Integer Segtri, Integer Tertri, Anio Anio, Matricula matricula) {
        this.Idbol = Idbol;
        this.Pritri = Pritri;
        this.Segtri = Segtri;
        this.Tertri = Tertri;
        this.Anio = Anio;
        this.matricula = matricula;
    }

    public Integer getIdbol() {
        return Idbol;
    }

    public void setIdbol(Integer Idbol) {
        this.Idbol = Idbol;
    }

    public Integer getPritri() {
        return Pritri;
    }

    public void setPritri(Integer Pritri) {
        this.Pritri = Pritri;
    }

    public Integer getSegtri() {
        return Segtri;
    }

    public void setSegtri(Integer Segtri) {
        this.Segtri = Segtri;
    }

    public Integer getTertri() {
        return Tertri;
    }

    public void setTertri(Integer Tertri) {
        this.Tertri = Tertri;
    }

    public Anio getAnio() {
        return Anio;
    }

    public void setAnio(Anio Anio) {
        this.Anio = Anio;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

}
