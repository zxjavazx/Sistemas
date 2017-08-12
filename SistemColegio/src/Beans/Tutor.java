package Beans;
public class Tutor {
    private Integer Idtut;
    private String Descripcion;
    private Anio anio;
    private Seccion seccion;
    private Docente docente;

    public Tutor() {
    }

    public Tutor(Integer Idtut) {
        this.Idtut = Idtut;
    }

    public Tutor(Integer Idtut, String Descripcion, Anio anio, Seccion seccion, Docente docente) {
        this.Idtut = Idtut;
        this.Descripcion = Descripcion;
        this.anio = anio;
        this.seccion = seccion;
        this.docente = docente;
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
        return anio;
    }

    public void setAnio(Anio anio) {
        this.anio = anio;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    
}
