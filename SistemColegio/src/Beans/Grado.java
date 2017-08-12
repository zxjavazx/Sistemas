package Beans;
public class Grado {
    private Integer Idgrad;
    private String nomgrad;

    public Grado() {
    }

    public Grado(Integer Idgrad) {
        this.Idgrad = Idgrad;
    }

    public Grado(Integer Idgrad, String nomgrad) {
        this.Idgrad = Idgrad;
        this.nomgrad = nomgrad;
    }

    public Integer getIdgrad() {
        return Idgrad;
    }

    public void setIdgrad(Integer Idgrad) {
        this.Idgrad = Idgrad;
    }

    public String getNomgrad() {
        return nomgrad;
    }

    public void setNomgrad(String nomgrad) {
        this.nomgrad = nomgrad;
    }
    
    
}
