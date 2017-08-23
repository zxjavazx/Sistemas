package Beans;
public class Tutor {
    private Integer Idtut;
    private String Descripcion;
    private Anio Anio;
    private Seccion Seccion;
    private Docente Docente;

    public Tutor() {
    }

    public Tutor(Integer Idtut) {
        this.Idtut = Idtut;
    }

    public Tutor(Integer Idtut, String Descripcion, Anio Anio, Seccion Seccion, Docente Docente) {
        this.Idtut = Idtut;
        this.Descripcion = Descripcion;
        this.Anio = Anio;
        this.Seccion = Seccion;
        this.Docente = Docente;
    }

    public Integer getIdtut() {
        return Idtut;
    }

    public void setIdtut(Integer Idtut) {
        this.Idtut = Idtut;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Anio getAnio() {
        return Anio;
    }

    public void setAnio(Anio Anio) {
        this.Anio = Anio;
    }

    public Seccion getSeccion() {
        return Seccion;
    }

    public void setSeccion(Seccion Seccion) {
        this.Seccion = Seccion;
    }

    public Docente getDocente() {
        return Docente;
    }

    public void setDocente(Docente Docente) {
        this.Docente = Docente;
    }

    
}
