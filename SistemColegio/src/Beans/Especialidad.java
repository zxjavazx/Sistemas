package Beans;

public class Especialidad {
    private Integer Idesp;
    private String Codesp;
    private String Nomesp;

    public Especialidad() {
    }

    public Especialidad(Integer Idesp) {
        this.Idesp = Idesp;
    }

    public Especialidad(Integer Idesp, String Codesp, String Nomesp) {
        this.Idesp = Idesp;
        this.Codesp = Codesp;
        this.Nomesp = Nomesp;
    }

    public Integer getIdesp() {
        return Idesp;
    }

    public void setIdesp(Integer Idesp) {
        this.Idesp = Idesp;
    }

    public String getCodesp() {
        return Codesp;
    }

    public void setCodesp(String Codesp) {
        this.Codesp = Codesp;
    }

    public String getNomesp() {
        return Nomesp;
    }

    public void setNomesp(String Nomesp) {
        this.Nomesp = Nomesp;
    }

    
}
