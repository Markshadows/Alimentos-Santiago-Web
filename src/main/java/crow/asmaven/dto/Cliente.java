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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByClienteId", query = "SELECT c FROM Cliente c WHERE c.clienteId = :clienteId")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByAppaterno", query = "SELECT c FROM Cliente c WHERE c.appaterno = :appaterno")
    , @NamedQuery(name = "Cliente.findByApmaterno", query = "SELECT c FROM Cliente c WHERE c.apmaterno = :apmaterno")
    , @NamedQuery(name = "Cliente.findByRut", query = "SELECT c FROM Cliente c WHERE c.rut = :rut")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENTE_ID")
    private Short clienteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APPATERNO")
    private String appaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APMATERNO")
    private String apmaterno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT")
    private int rut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Cuenta> cuentaList;
    @JoinColumns({
        @JoinColumn(name = "TIPO_USUARIO_ID", referencedColumnName = "TIPO_USUARIO_ID")
        , @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID")})
    @ManyToOne(optional = false)
    private UsuarioTipoUsuario usuarioTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private List<ClientePedido> clientePedidoList;

    public Cliente() {
    }

    public Cliente(Short clienteId) {
        this.clienteId = clienteId;
    }

    public Cliente(Short clienteId, String nombre, String appaterno, String apmaterno, int rut) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.rut = rut;
    }

    public Short getClienteId() {
        return clienteId;
    }

    public void setClienteId(Short clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    public UsuarioTipoUsuario getUsuarioTipoUsuario() {
        return usuarioTipoUsuario;
    }

    public void setUsuarioTipoUsuario(UsuarioTipoUsuario usuarioTipoUsuario) {
        this.usuarioTipoUsuario = usuarioTipoUsuario;
    }

    @XmlTransient
    public List<ClientePedido> getClientePedidoList() {
        return clientePedidoList;
    }

    public void setClientePedidoList(List<ClientePedido> clientePedidoList) {
        this.clientePedidoList = clientePedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteId != null ? clienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clienteId == null && other.clienteId != null) || (this.clienteId != null && !this.clienteId.equals(other.clienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.Cliente[ clienteId=" + clienteId + " ]";
    }
    
}
