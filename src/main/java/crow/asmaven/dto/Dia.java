/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author M_arc
 */
@Entity
@Table(name = "DIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dia.findAll", query = "SELECT d FROM Dia d")
    , @NamedQuery(name = "Dia.findByDiaId", query = "SELECT d FROM Dia d WHERE d.diaId = :diaId")
    , @NamedQuery(name = "Dia.findByNombre", query = "SELECT d FROM Dia d WHERE d.nombre = :nombre")})
public class Dia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIA_ID")
    private Short diaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dia1")
    private List<DiaPlatillo> diaPlatilloList;

    public Dia() {
    }

    public Dia(Short diaId) {
        this.diaId = diaId;
    }

    public Dia(Short diaId, String nombre) {
        this.diaId = diaId;
        this.nombre = nombre;
    }

    public Short getDiaId() {
        return diaId;
    }

    public void setDiaId(Short diaId) {
        this.diaId = diaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<DiaPlatillo> getDiaPlatilloList() {
        return diaPlatilloList;
    }

    public void setDiaPlatilloList(List<DiaPlatillo> diaPlatilloList) {
        this.diaPlatilloList = diaPlatilloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diaId != null ? diaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dia)) {
            return false;
        }
        Dia other = (Dia) object;
        if ((this.diaId == null && other.diaId != null) || (this.diaId != null && !this.diaId.equals(other.diaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.Dia[ diaId=" + diaId + " ]";
    }
    
}
