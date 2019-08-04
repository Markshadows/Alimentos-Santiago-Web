/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author M_arc
 */
@Entity
@Table(name = "DETALLE_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d")
    , @NamedQuery(name = "DetalleVenta.findByVentaId", query = "SELECT d FROM DetalleVenta d WHERE d.ventaId = :ventaId")
    , @NamedQuery(name = "DetalleVenta.findByTotal", query = "SELECT d FROM DetalleVenta d WHERE d.total = :total")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VENTA_ID")
    private Integer ventaId;
    @Column(name = "TOTAL")
    private Long total;
    @JoinColumn(name = "CLIENTE_PEDIDO_ID", referencedColumnName = "CLIENTE_PEDIDO_ID")
    @ManyToOne(optional = false)
    private ClientePedido clientePedidoId;
    @JoinColumn(name = "VENTA_ID", referencedColumnName = "VENTA_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Venta venta;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public ClientePedido getClientePedidoId() {
        return clientePedidoId;
    }

    public void setClientePedidoId(ClientePedido clientePedidoId) {
        this.clientePedidoId = clientePedidoId;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaId != null ? ventaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.ventaId == null && other.ventaId != null) || (this.ventaId != null && !this.ventaId.equals(other.ventaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.DetalleVenta[ ventaId=" + ventaId + " ]";
    }
    
}
