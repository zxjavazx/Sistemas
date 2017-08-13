
package Beans;


public class CriterioEvaluacion {
 
 private  Criterio criterio ;
  private  Evaluacion evaluacion;

    public CriterioEvaluacion() {
    }

    public CriterioEvaluacion(Criterio criterio, Evaluacion evaluacion) {
        this.criterio = criterio;
        this.evaluacion = evaluacion;
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

 

  
  
  
    
}
