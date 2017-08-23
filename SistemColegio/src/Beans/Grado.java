package Beans;
public class Grado {
    private Integer Idgrad;
    private String Nomgrad;

    public Grado() {
    }

    public Grado(Integer Idgrad) {
        this.Idgrad = Idgrad;
    }

    public Grado(Integer Idgrad, String Nomgrad) {
        this.Idgrad = Idgrad;
        this.Nomgrad = Nomgrad;
    }

    public Integer getIdgrad() {
        return Idgrad;
    }

    public void setIdgrad(Integer Idgrad) {
        this.Idgrad = Idgrad;
    }

    public String getNomgrad() {
        return Nomgrad;
    }

    public void setNomgrad(String Nomgrad) {
        this.Nomgrad = Nomgrad;
    }

    
}
