package Beans;
public class Area {
    private Integer Idarea;
    private String Nomarea;
    private Coordinador Coordinador;

    public Area() {
    }

    public Area(Integer Idarea) {
        this.Idarea = Idarea;
    }

    public Area(Integer Idarea, String Nomarea, Coordinador Coordinador) {
        this.Idarea = Idarea;
        this.Nomarea = Nomarea;
        this.Coordinador = Coordinador;
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
        return Coordinador;
    }

    public void setCoordinador(Coordinador Coordinador) {
        this.Coordinador = Coordinador;
    }

    
}
