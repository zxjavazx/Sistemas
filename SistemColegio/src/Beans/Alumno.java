

package Beans;


public class Alumno {
    
 private  Integer idalum;
 private  String codalum;
 private  String nomalum;
 private String apepatalum;
 private String apematalum;
 private String sexo;

    public Alumno() {
    }

    public Alumno(Integer idalum) {
        this.idalum = idalum;
    }

    public Alumno(Integer idalum, String codalum, String nomalum, String apepatalum, String apematalum, String sexo) {
        this.idalum = idalum;
        this.codalum = codalum;
        this.nomalum = nomalum;
        this.apepatalum = apepatalum;
        this.apematalum = apematalum;
        this.sexo = sexo;
    }

    public Integer getIdalum() {
        return idalum;
    }

    public void setIdalum(Integer idalum) {
        this.idalum = idalum;
    }

    public String getCodalum() {
        return codalum;
    }

    public void setCodalum(String codalum) {
        this.codalum = codalum;
    }

    public String getNomalum() {
        return nomalum;
    }

    public void setNomalum(String nomalum) {
        this.nomalum = nomalum;
    }

    public String getApepatalum() {
        return apepatalum;
    }

    public void setApepatalum(String apepatalum) {
        this.apepatalum = apepatalum;
    }

    public String getApematalum() {
        return apematalum;
    }

    public void setApematalum(String apematalum) {
        this.apematalum = apematalum;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

   
 
 
 
    
    
}
