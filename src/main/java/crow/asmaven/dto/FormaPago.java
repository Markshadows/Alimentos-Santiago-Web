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
@Table(name = "FORMA_PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPago.findAll", query = "SELECT f FROM FormaPago f")
    , @NamedQuery(name = "FormaPago.findByFormaPagoId", query = "SELECT f FROM FormaPago f WHERE f.formaPagoId = :formaPagoId")
    , @NamedQuery(name = "FormaPago.findByDescripcion", query = "SELECT f FROM FormaPago f WHERE f.descripcion = :descripcion")})
public class FormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FORMA_PAGO_ID")
    private Short formaPagoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPagoId")
    private List<Pedido> pedidoList;

    public FormaPago() {
    }

    public FormaPago(Short formaPagoId) {
        this.formaPagoId = formaPagoId;
    }

    public FormaPago(Short formaPagoId, String descripcion) {
        this.formaPagoId = formaPagoId;
        this.descripcion = descripcion;
    }

    public Short getFormaPagoId() {
        return formaPagoId;
    }

    public void setFormaPagoId(Short formaPagoId) {
        this.formaPagoId = formaPagoId;
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
        hash += (formaPagoId != null ? formaPagoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.formaPagoId == null && other.formaPagoId != null) || (this.formaPagoId != null && !this.formaPagoId.equals(other.formaPagoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.FormaPago[ formaPagoId=" + formaPagoId + " ]";
    }
    
}
