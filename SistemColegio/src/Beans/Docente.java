package Beans;
public class Docente {
    private Integer Iddoc;
    private String Coddoc;
    private String Nomdoc;
    private String Apepatdoc;
    private String Apematdoc;
    private Tutor Idtut;
    private Coordinador Idcoor;
    private Especialidad Idesp;

    public Docente() {
    }

    public Docente(Integer Iddoc) {
        this.Iddoc = Iddoc;
    }

    public Docente(Integer Iddoc, String Coddoc, String Nomdoc, String Apepatdoc, String Apematdoc, Tutor Idtut, Coordinador Idcoor, Especialidad Idesp) {
        this.Iddoc = Iddoc;
        this.Coddoc = Coddoc;
        this.Nomdoc = Nomdoc;
        this.Apepatdoc = Apepatdoc;
        this.Apematdoc = Apematdoc;
        this.Idtut = Idtut;
        this.Idcoor = Idcoor;
        this.Idesp = Idesp;
    }

    public Integer getIddoc() {
        return Iddoc;
    }

    public void setIddoc(Integer Iddoc) {
        this.Iddoc = Iddoc;
    }

    public String getCoddoc() {
        return Coddoc;
    }

    public void setCoddoc(String Coddoc) {
        this.Coddoc = Coddoc;
    }

    public String getNomdoc() {
        return Nomdoc;
    }

    public void setNomdoc(String Nomdoc) {
        this.Nomdoc = Nomdoc;
    }

    public String getApepatdoc() {
        return Apepatdoc;
    }

    public void setApepatdoc(String Apepatdoc) {
        this.Apepatdoc = Apepatdoc;
    }

    public String getApematdoc() {
        return Apematdoc;
    }

    public void setApematdoc(String Apematdoc) {
        this.Apematdoc = Apematdoc;
    }

    public Tutor getIdtut() {
        return Idtut;
    }

    public void setIdtut(Tutor Idtut) {
        this.Idtut = Idtut;
    }

    public Coordinador getIdcoor() {
        return Idcoor;
    }

    public void setIdcoor(Coordinador Idcoor) {
        this.Idcoor = Idcoor;
    }

    public Especialidad getIdesp() {
        return Idesp;
    }

    public void setIdesp(Especialidad Idesp) {
        this.Idesp = Idesp;
    }
    
    
    
}
