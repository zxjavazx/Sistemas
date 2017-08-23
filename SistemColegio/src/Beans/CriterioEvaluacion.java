
package Beans;


public class CriterioEvaluacion {
    private  Criterio Criterio ;
    private  Evaluacion Evaluacion;

    public CriterioEvaluacion() {
    }

    public CriterioEvaluacion(Criterio Criterio, Evaluacion Evaluacion) {
        this.Criterio = Criterio;
        this.Evaluacion = Evaluacion;
    }

    public Criterio getCriterio() {
        return Criterio;
    }

    public void setCriterio(Criterio Criterio) {
        this.Criterio = Criterio;
    }

    public Evaluacion getEvaluacion() {
        return Evaluacion;
    }

    public void setEvaluacion(Evaluacion Evaluacion) {
        this.Evaluacion = Evaluacion;
    }

    
}
