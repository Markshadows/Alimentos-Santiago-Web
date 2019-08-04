/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author M_arc
 */
@Embeddable
public class DiaPlatilloPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DIA")
    private short dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLATILLO")
    private short platillo;

    public DiaPlatilloPK() {
    }

    public DiaPlatilloPK(short dia, short platillo) {
        this.dia = dia;
        this.platillo = platillo;
    }

    public short getDia() {
        return dia;
    }

    public void setDia(short dia) {
        this.dia = dia;
    }

    public short getPlatillo() {
        return platillo;
    }

    public void setPlatillo(short platillo) {
        this.platillo = platillo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dia;
        hash += (int) platillo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaPlatilloPK)) {
            return false;
        }
        DiaPlatilloPK other = (DiaPlatilloPK) object;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.platillo != other.platillo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.DiaPlatilloPK[ dia=" + dia + ", platillo=" + platillo + " ]";
    }
    
}
