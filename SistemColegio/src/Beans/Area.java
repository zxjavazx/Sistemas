package Beans;
public class Area {
    private Integer Idarea;
    private String Nomarea;
    private Coordinador coordinador;

    public Area() {
    }

    public Area(Integer Idarea) {
        this.Idarea = Idarea;
    }

    public Area(Integer Idarea, String Nomarea, Coordinador coordinador) {
        this.Idarea = Idarea;
        this.Nomarea = Nomarea;
        this.coordinador = coordinador;
    }

    public Integer getIdarea() {
        return Idarea;
    }

    public void setIdarea(Integer Idarea) {
        this.Idarea = Idarea;
    }

    public String getNomarea() {
        return Nomarea;
    }

    public void setNomarea(String Nomarea) {
        this.Nomarea = Nomarea;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    
}
