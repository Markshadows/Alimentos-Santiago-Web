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
@Table(name = "CLIENTE_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientePedido.findAll", query = "SELECT c FROM ClientePedido c")
    , @NamedQuery(name = "ClientePedido.findByClientePedidoId", query = "SELECT c FROM ClientePedido c WHERE c.clientePedidoId = :clientePedidoId")})
public class ClientePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENTE_PEDIDO_ID")
    private Short clientePedidoId;
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "CLIENTE_ID")
    @ManyToOne(optional = false)
    private Cliente clienteId;
    @JoinColumn(name = "PEDIDO_ID", referencedColumnName = "PEDIDO_PLATILLO_ID")
    @ManyToOne(optional = false)
    private PedidoPlatillo pedidoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientePedidoId")
    private List<DetalleVenta> detalleVentaList;

    public ClientePedido() {
    }

    public ClientePedido(Short clientePedidoId) {
        this.clientePedidoId = clientePedidoId;
    }

    public Short getClientePedidoId() {
        return clientePedidoId;
    }

    public void setClientePedidoId(Short clientePedidoId) {
        this.clientePedidoId = clientePedidoId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public PedidoPlatillo getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(PedidoPlatillo pedidoId) {
        this.pedidoId = pedidoId;
    }

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientePedidoId != null ? clientePedidoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePedido)) {
            return false;
        }
        ClientePedido other = (ClientePedido) object;
        if ((this.clientePedidoId == null && other.clientePedidoId != null) || (this.clientePedidoId != null && !this.clientePedidoId.equals(other.clientePedidoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.ClientePedido[ clientePedidoId=" + clientePedidoId + " ]";
    }
    
}
