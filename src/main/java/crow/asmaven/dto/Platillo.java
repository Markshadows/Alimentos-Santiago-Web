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
@Table(name = "PLATILLO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platillo.findAll", query = "SELECT p FROM Platillo p")
    , @NamedQuery(name = "Platillo.findByPlatilloId", query = "SELECT p FROM Platillo p WHERE p.platilloId = :platilloId")
    , @NamedQuery(name = "Platillo.findByValor", query = "SELECT p FROM Platillo p WHERE p.valor = :valor")
    , @NamedQuery(name = "Platillo.findByPromedioPreparacion", query = "SELECT p FROM Platillo p WHERE p.promedioPreparacion = :promedioPreparacion")
    , @NamedQuery(name = "Platillo.findByDescripcion", query = "SELECT p FROM Platillo p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Platillo.findBySrc", query = "SELECT p FROM Platillo p WHERE p.src = :src")
    , @NamedQuery(name = "Platillo.findByNombre", query = "SELECT p FROM Platillo p WHERE p.nombre = :nombre")})
public class Platillo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLATILLO_ID")
    private Short platilloId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private int valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROMEDIO_PREPARACION")
    private short promedioPreparacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 20)
    @Column(name = "SRC")
    private String src;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platillo1")
    private List<DiaPlatillo> diaPlatilloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platilloId")
    private List<PedidoPlatillo> pedidoPlatilloList;

    public Platillo() {
    }

    public Platillo(Short platilloId) {
        this.platilloId = platilloId;
    }

    public Platillo(Short platilloId, int valor, short promedioPreparacion, String descripcion) {
        this.platilloId = platilloId;
        this.valor = valor;
        this.promedioPreparacion = promedioPreparacion;
        this.descripcion = descripcion;
    }

    public Short getPlatilloId() {
        return platilloId;
    }

    public void setPlatilloId(Short platilloId) {
        this.platilloId = platilloId;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public short getPromedioPreparacion() {
        return promedioPreparacion;
    }

    public void setPromedioPreparacion(short promedioPreparacion) {
        this.promedioPreparacion = promedioPreparacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
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

    @XmlTransient
    public List<PedidoPlatillo> getPedidoPlatilloList() {
        return pedidoPlatilloList;
    }

    public void setPedidoPlatilloList(List<PedidoPlatillo> pedidoPlatilloList) {
        this.pedidoPlatilloList = pedidoPlatilloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (platilloId != null ? platilloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platillo)) {
            return false;
        }
        Platillo other = (Platillo) object;
        if ((this.platilloId == null && other.platilloId != null) || (this.platilloId != null && !this.platilloId.equals(other.platilloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.Platillo[ platilloId=" + platilloId + " ]";
    }
    
}
