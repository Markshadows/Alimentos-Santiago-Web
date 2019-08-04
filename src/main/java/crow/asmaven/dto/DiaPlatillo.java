/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author M_arc
 */
@Entity
@Table(name = "DIA_PLATILLO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiaPlatillo.findAll", query = "SELECT d FROM DiaPlatillo d")
    , @NamedQuery(name = "DiaPlatillo.findByDia", query = "SELECT d FROM DiaPlatillo d WHERE d.diaPlatilloPK.dia = :dia")
    , @NamedQuery(name = "DiaPlatillo.findByPlatillo", query = "SELECT d FROM DiaPlatillo d WHERE d.diaPlatilloPK.platillo = :platillo")
    , @NamedQuery(name = "DiaPlatillo.findByModificacion", query = "SELECT d FROM DiaPlatillo d WHERE d.modificacion = :modificacion")})
public class DiaPlatillo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiaPlatilloPK diaPlatilloPK;
    @Column(name = "MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;
    @JoinColumn(name = "DIA", referencedColumnName = "DIA_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dia dia1;
    @JoinColumn(name = "PLATILLO", referencedColumnName = "PLATILLO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Platillo platillo1;

    public DiaPlatillo() {
    }

    public DiaPlatillo(DiaPlatilloPK diaPlatilloPK) {
        this.diaPlatilloPK = diaPlatilloPK;
    }

    public DiaPlatillo(short dia, short platillo) {
        this.diaPlatilloPK = new DiaPlatilloPK(dia, platillo);
    }

    public DiaPlatilloPK getDiaPlatilloPK() {
        return diaPlatilloPK;
    }

    public void setDiaPlatilloPK(DiaPlatilloPK diaPlatilloPK) {
        this.diaPlatilloPK = diaPlatilloPK;
    }

    public Date getModificacion() {
        return modificacion;
    }

    public void setModificacion(Date modificacion) {
        this.modificacion = modificacion;
    }

    public Dia getDia1() {
        return dia1;
    }

    public void setDia1(Dia dia1) {
        this.dia1 = dia1;
    }

    public Platillo getPlatillo1() {
        return platillo1;
    }

    public void setPlatillo1(Platillo platillo1) {
        this.platillo1 = platillo1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diaPlatilloPK != null ? diaPlatilloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaPlatillo)) {
            return false;
        }
        DiaPlatillo other = (DiaPlatillo) object;
        if ((this.diaPlatilloPK == null && other.diaPlatilloPK != null) || (this.diaPlatilloPK != null && !this.diaPlatilloPK.equals(other.diaPlatilloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.DiaPlatillo[ diaPlatilloPK=" + diaPlatilloPK + " ]";
    }
    
}
