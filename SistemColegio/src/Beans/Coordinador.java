package Beans;
public class Coordinador {
    private Integer Idcoor;
    private String Descoor;
    private Area area;
    private Anio anio;
    private Docente docente;

    public Coordinador() {
    }

    public Coordinador(Integer Idcoor) {
        this.Idcoor = Idcoor;
    }

    public Coordinador(Integer Idcoor, String Descoor, Area area, Anio anio, Docente docente) {
        this.Idcoor = Idcoor;
        this.Descoor = Descoor;
        this.area = area;
        this.anio = anio;
        this.docente = docente;
    }

    public Integer getIdcoor() {
        return Idcoor;
    }

    public void setIdcoor(Integer Idcoor) {
        this.Idcoor = Idcoor;
    }

    public String getDescoor() {
        return Descoor;
    }

    public void setDescoor(String Descoor) {
        this.Descoor = Descoor;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Anio getAnio() {
        return anio;
    }

    public void setAnio(Anio anio) {
        this.anio = anio;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    
}
