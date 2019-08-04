/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dto;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author M_arc
 */
@Entity
@Table(name = "PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByPedidoId", query = "SELECT p FROM Pedido p WHERE p.pedidoId = :pedidoId")
    , @NamedQuery(name = "Pedido.findByDireccion", query = "SELECT p FROM Pedido p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Pedido.findByHoraPedido", query = "SELECT p FROM Pedido p WHERE p.horaPedido = :horaPedido")
    , @NamedQuery(name = "Pedido.findByHoraEntrega", query = "SELECT p FROM Pedido p WHERE p.horaEntrega = :horaEntrega")})
@NamedStoredProcedureQuery(
	name = "PROCEDURE_REALIZAR_PEDIDO", 
	procedureName = "PROCEDURE_REALIZAR_PEDIDO", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_varios_platos"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_pedido_id"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_detalle_venta_id"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_forma_pago"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_cantidad_platillos"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_pedido_direccion"), 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_platillo_id"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_cliente_id"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "P_RETORNO"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "P_RETORNO2")
	})

public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEDIDO_ID")
    private Short pedidoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_PEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_ENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEntrega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoId")
    private List<PedidoPlatillo> pedidoPlatilloList;
    @JoinColumn(name = "ESTADO_ID", referencedColumnName = "ESTADO_ID")
    @ManyToOne(optional = false)
    private EstadoPedido estadoId;
    @JoinColumn(name = "FORMA_PAGO_ID", referencedColumnName = "FORMA_PAGO_ID")
    @ManyToOne(optional = false)
    private FormaPago formaPagoId;

    public Pedido() {
    }

    public Pedido(Short pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Pedido(Short pedidoId, String direccion, Date horaPedido, Date horaEntrega) {
        this.pedidoId = pedidoId;
        this.direccion = direccion;
        this.horaPedido = horaPedido;
        this.horaEntrega = horaEntrega;
    }

    public Short getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Short pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Date horaPedido) {
        this.horaPedido = horaPedido;
    }

    public Date getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Date horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    @XmlTransient
    public List<PedidoPlatillo> getPedidoPlatilloList() {
        return pedidoPlatilloList;
    }

    public void setPedidoPlatilloList(List<PedidoPlatillo> pedidoPlatilloList) {
        this.pedidoPlatilloList = pedidoPlatilloList;
    }

    public EstadoPedido getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(EstadoPedido estadoId) {
        this.estadoId = estadoId;
    }

    public FormaPago getFormaPagoId() {
        return formaPagoId;
    }

    public void setFormaPagoId(FormaPago formaPagoId) {
        this.formaPagoId = formaPagoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoId != null ? pedidoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pedidoId == null && other.pedidoId != null) || (this.pedidoId != null && !this.pedidoId.equals(other.pedidoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.Pedido[ pedidoId=" + pedidoId + " ]";
    }
    
}
