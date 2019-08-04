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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author M_arc
 */
@Entity
@Table(name = "PEDIDO_PLATILLO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoPlatillo.findAll", query = "SELECT p FROM PedidoPlatillo p")
    , @NamedQuery(name = "PedidoPlatillo.findByPedidoPlatilloId", query = "SELECT p FROM PedidoPlatillo p WHERE p.pedidoPlatilloId = :pedidoPlatilloId")
    , @NamedQuery(name = "PedidoPlatillo.findByCantidad", query = "SELECT p FROM PedidoPlatillo p WHERE p.cantidad = :cantidad")})
public class PedidoPlatillo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEDIDO_PLATILLO_ID")
    private Short pedidoPlatilloId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private short cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoId")
    private List<ClientePedido> clientePedidoList;
    @JoinColumn(name = "PEDIDO_ID", referencedColumnName = "PEDIDO_ID")
    @ManyToOne(optional = false)
    private Pedido pedidoId;
    @JoinColumn(name = "PLATILLO_ID", referencedColumnName = "PLATILLO_ID")
    @ManyToOne(optional = false)
    private Platillo platilloId;

    public PedidoPlatillo() {
    }

    public PedidoPlatillo(Short pedidoPlatilloId) {
        this.pedidoPlatilloId = pedidoPlatilloId;
    }

    public PedidoPlatillo(Short pedidoPlatilloId, short cantidad) {
        this.pedidoPlatilloId = pedidoPlatilloId;
        this.cantidad = cantidad;
    }

    public Short getPedidoPlatilloId() {
        return pedidoPlatilloId;
    }

    public void setPedidoPlatilloId(Short pedidoPlatilloId) {
        this.pedidoPlatilloId = pedidoPlatilloId;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<ClientePedido> getClientePedidoList() {
        return clientePedidoList;
    }

    public void setClientePedidoList(List<ClientePedido> clientePedidoList) {
        this.clientePedidoList = clientePedidoList;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Platillo getPlatilloId() {
        return platilloId;
    }

    public void setPlatilloId(Platillo platilloId) {
        this.platilloId = platilloId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoPlatilloId != null ? pedidoPlatilloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoPlatillo)) {
            return false;
        }
        PedidoPlatillo other = (PedidoPlatillo) object;
        if ((this.pedidoPlatilloId == null && other.pedidoPlatilloId != null) || (this.pedidoPlatilloId != null && !this.pedidoPlatilloId.equals(other.pedidoPlatilloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.PedidoPlatillo[ pedidoPlatilloId=" + pedidoPlatilloId + " ]";
    }
    
}
