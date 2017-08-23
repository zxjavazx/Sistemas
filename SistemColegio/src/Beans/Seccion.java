package Beans;
public class Seccion {
    private Integer Idsecc;
    private String Nomsecc;
    private Tutor Tutor;
    private Grado Grado;

    public Seccion() {
    }

    public Seccion(Integer Idsecc) {
        this.Idsecc = Idsecc;
    }

    public Seccion(Integer Idsecc, String Nomsecc, Tutor Tutor, Grado Grado) {
        this.Idsecc = Idsecc;
        this.Nomsecc = Nomsecc;
        this.Tutor = Tutor;
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

    public Tutor getTutor() {
        return Tutor;
    }

    public void setTutor(Tutor Tutor) {
        this.Tutor = Tutor;
    }

    public Grado getGrado() {
        return Grado;
    }

    public void setGrado(Grado Grado) {
        this.Grado = Grado;
    }

        
}
