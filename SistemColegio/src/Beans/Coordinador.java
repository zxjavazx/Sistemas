package Beans;
public class Coordinador {
    private Integer Idcoor;
    private String Descoor;
    private Area Area;
    private Anio Anio;
    
    public Coordinador() {
    }

    public Coordinador(Integer Idcoor) {
        this.Idcoor = Idcoor;
    }

    public Coordinador(Integer Idcoor, String Descoor, Area Area, Anio Anio) {
        this.Idcoor = Idcoor;
        this.Descoor = Descoor;
        this.Area = Area;
        this.Anio = Anio;
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
        return Area;
    }

    public void setArea(Area Area) {
        this.Area = Area;
    }

    public Anio getAnio() {
        return Anio;
    }

    public void setAnio(Anio Anio) {
        this.Anio = Anio;
    }

    
}
