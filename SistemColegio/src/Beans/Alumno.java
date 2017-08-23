

package Beans;


public class Alumno {
    
 private  Integer Idalum;
 private  String Codalum;
 private  String Nomalum;
 private String Apepatalum;
 private String Apematalum;
 private String Sexo;
 private Matricula Matricula;

    public Alumno() {
    }

    public Alumno(Integer Idalum) {
        this.Idalum = Idalum;
    }

    public Alumno(Integer Idalum, String Codalum, String Nomalum, String Apepatalum, String Apematalum, String Sexo, Matricula Matricula) {
        this.Idalum = Idalum;
        this.Codalum = Codalum;
        this.Nomalum = Nomalum;
        this.Apepatalum = Apepatalum;
        this.Apematalum = Apematalum;
        this.Sexo = Sexo;
        this.Matricula = Matricula;
    }

    public Integer getIdalum() {
        return Idalum;
    }

    public void setIdalum(Integer Idalum) {
        this.Idalum = Idalum;
    }

    public String getCodalum() {
        return Codalum;
    }

    public void setCodalum(String Codalum) {
        this.Codalum = Codalum;
    }

    public String getNomalum() {
        return Nomalum;
    }

    public void setNomalum(String Nomalum) {
        this.Nomalum = Nomalum;
    }

    public String getApepatalum() {
        return Apepatalum;
    }

    public void setApepatalum(String Apepatalum) {
        this.Apepatalum = Apepatalum;
    }

    public String getApematalum() {
        return Apematalum;
    }

    public void setApematalum(String Apematalum) {
        this.Apematalum = Apematalum;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Matricula getMatricula() {
        return Matricula;
    }

    public void setMatricula(Matricula Matricula) {
        this.Matricula = Matricula;
    }

    
}