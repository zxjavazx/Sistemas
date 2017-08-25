package Beans;
public class Area {
    private Integer Idarea;
    private String Nomarea;
    
    public Area() {
    }

    public Area(Integer Idarea) {
        this.Idarea = Idarea;
    }

    public Area(Integer Idarea, String Nomarea) {
        this.Idarea = Idarea;
        this.Nomarea = Nomarea;
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


}
