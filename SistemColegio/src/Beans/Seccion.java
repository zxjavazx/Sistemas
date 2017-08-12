package Beans;
public class Seccion {
    private Integer Idsecc;
    private String nomsecc;
    private Tutor tutor;
    private Grado grado;

    public Seccion() {
    }

    public Seccion(Integer Idsecc) {
        this.Idsecc = Idsecc;
    }

    public Seccion(Integer Idsecc, String nomsecc, Tutor tutor, Grado grado) {
        this.Idsecc = Idsecc;
        this.nomsecc = nomsecc;
        this.tutor = tutor;
        this.grado = grado;
    }

    public Integer getIdsecc() {
        return Idsecc;
    }

    public void setIdsecc(Integer Idsecc) {
        this.Idsecc = Idsecc;
    }

    public String getNomsecc() {
        return nomsecc;
    }

    public void setNomsecc(String nomsecc) {
        this.nomsecc = nomsecc;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }
    
    
}
