package Beans;
public class Seccion {
    private Integer Idsecc;
    private String Nomsecc;
    private Grado Grado;

    public Seccion() {
    }

    public Seccion(Integer Idsecc) {
        this.Idsecc = Idsecc;
    }

    public Seccion(Integer Idsecc, String Nomsecc, Grado Grado) {
        this.Idsecc = Idsecc;
        this.Nomsecc = Nomsecc;
        this.Grado = Grado;
    }

    public Integer getIdsecc() {
        return Idsecc;
    }

    public void setIdsecc(Integer Idsecc) {
        this.Idsecc = Idsecc;
    }

    public String getNomsecc() {
        return Nomsecc;
    }

    public void setNomsecc(String Nomsecc) {
        this.Nomsecc = Nomsecc;
    }

    public Grado getGrado() {
        return Grado;
    }

    public void setGrado(Grado Grado) {
        this.Grado = Grado;
    }

    
}
