
package Beans;

import java.sql.Date;


public class Asistencia {
    
 
private Integer Idasist;
private String Condicion;
private String  Fechasist;
private Horario Horario;
private Alumno Alumno;

    public Asistencia() {
    }

    public Asistencia(Integer Idasist) {
        this.Idasist = Idasist;
    }

    public Asistencia(Integer Idasist, String Condicion, String Fechasist, Horario Horario, Alumno Alumno) {
        this.Idasist = Idasist;
        this.Condicion = Condicion;
        this.Fechasist = Fechasist;
        this.Horario = Horario;
        this.Alumno = Alumno;
    }

    public Integer getIdasist() {
        return Idasist;
    }

    public void setIdasist(Integer Idasist) {
        this.Idasist = Idasist;
    }

    public String getCondicion() {
        return Condicion;
    }

    public void setCondicion(String Condicion) {
        this.Condicion = Condicion;
    }

    public String getFechasist() {
        return Fechasist;
    }

    public void setFechasist(String Fechasist) {
        this.Fechasist = Fechasist;
    }

    public Horario getHorario() {
        return Horario;
    }

    public void setHorario(Horario Horario) {
        this.Horario = Horario;
    }

    public Alumno getAlumno() {
        return Alumno;
    }

    public void setAlumno(Alumno Alumno) {
        this.Alumno = Alumno;
    }

    
}
