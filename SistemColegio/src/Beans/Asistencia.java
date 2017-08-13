
package Beans;

import java.sql.Date;


public class Asistencia {
    
 
private Integer idasist;
private String condicion;
private Date  fechasist;
private Horario horario;
private Alumno Alumno;

    public Asistencia() {
    }

    public Asistencia(Integer idasist) {
        this.idasist = idasist;
    }

    public Asistencia(Integer idasist, String condicion, Date fechasist, Horario horario, Alumno Alumno) {
        this.idasist = idasist;
        this.condicion = condicion;
        this.fechasist = fechasist;
        this.horario = horario;
        this.Alumno = Alumno;
    }

    public Integer getIdasist() {
        return idasist;
    }

    public void setIdasist(Integer idasist) {
        this.idasist = idasist;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Date getFechasist() {
        return fechasist;
    }

    public void setFechasist(Date fechasist) {
        this.fechasist = fechasist;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Alumno getAlumno() {
        return Alumno;
    }

    public void setAlumno(Alumno Alumno) {
        this.Alumno = Alumno;
    }

   

    
}
