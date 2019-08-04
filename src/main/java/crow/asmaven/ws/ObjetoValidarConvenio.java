/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.ws;

/**
 *
 * @author M_arc
 */
public class ObjetoValidarConvenio {
    
    private int convenioId, vigente, saldoDisponible, empleado;

    public ObjetoValidarConvenio() {
    }

    public ObjetoValidarConvenio(int convenioId,  int saldoDisponible, int vigente, int empleado) {
        this.convenioId = convenioId;
        this.vigente = vigente;
        this.saldoDisponible = saldoDisponible;
        this.empleado = empleado;
    }
    
    

    public int getConvenioId() {
        return convenioId;
    }

    public void setConvenioId(int convenioId) {
        this.convenioId = convenioId;
    }

    public int getVigente() {
        return vigente;
    }

    public void setVigente(int vigente) {
        this.vigente = vigente;
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "ObjetoValidarConvenio{" + "convenioId=" + convenioId + ", vigente=" + vigente + ", saldoDisponible=" + saldoDisponible + ", empleado=" + empleado + '}';
    }
    
    
}
