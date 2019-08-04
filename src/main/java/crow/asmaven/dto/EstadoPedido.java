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
@Table(name = "ESTADO_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPedido.findAll", query = "SELECT e FROM EstadoPedido e")
    , @NamedQuery(name = "EstadoPedido.findByEstadoId", query = "SELECT e FROM EstadoPedido e WHERE e.estadoId = :estadoId")
    , @NamedQuery(name = "EstadoPedido.findByDescripcion", query = "SELECT e FROM EstadoPedido e WHERE e.descripcion = :descripcion")})
public class EstadoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_ID")
    private Short estadoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoId")
    private List<Pedido> pedidoList;

    public EstadoPedido() {
    }

    public EstadoPedido(Short estadoId) {
        this.estadoId = estadoId;
    }

    public EstadoPedido(Short estadoId, String descripcion) {
        this.estadoId = estadoId;
        this.descripcion = descripcion;
    }

    public Short getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Short estadoId) {
        this.estadoId = estadoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoId != null ? estadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPedido)) {
            return false;
        }
        EstadoPedido other = (EstadoPedido) object;
        if ((this.estadoId == null && other.estadoId != null) || (this.estadoId != null && !this.estadoId.equals(other.estadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.EstadoPedido[ estadoId=" + estadoId + " ]";
    }
    
}
