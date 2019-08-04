/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author M_arc
 */
@Entity
@Table(name = "USUARIO_TIPO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioTipoUsuario.findAll", query = "SELECT u FROM UsuarioTipoUsuario u")
    , @NamedQuery(name = "UsuarioTipoUsuario.findByTipoUsuarioId", query = "SELECT u FROM UsuarioTipoUsuario u WHERE u.usuarioTipoUsuarioPK.tipoUsuarioId = :tipoUsuarioId")
    , @NamedQuery(name = "UsuarioTipoUsuario.findByUsuarioId", query = "SELECT u FROM UsuarioTipoUsuario u WHERE u.usuarioTipoUsuarioPK.usuarioId = :usuarioId")})
public class UsuarioTipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioTipoUsuarioPK usuarioTipoUsuarioPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioTipoUsuario")
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioTipoUsuario")
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioTipoUsuario")
    private List<Empleador> empleadorList;
    @JoinColumn(name = "TIPO_USUARIO_ID", referencedColumnName = "TIPO_USUARIO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoUsuario tipoUsuario;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioTipoUsuario() {
    }

    public UsuarioTipoUsuario(UsuarioTipoUsuarioPK usuarioTipoUsuarioPK) {
        this.usuarioTipoUsuarioPK = usuarioTipoUsuarioPK;
    }

    public UsuarioTipoUsuario(short tipoUsuarioId, short usuarioId) {
        this.usuarioTipoUsuarioPK = new UsuarioTipoUsuarioPK(tipoUsuarioId, usuarioId);
    }

    public UsuarioTipoUsuarioPK getUsuarioTipoUsuarioPK() {
        return usuarioTipoUsuarioPK;
    }

    public void setUsuarioTipoUsuarioPK(UsuarioTipoUsuarioPK usuarioTipoUsuarioPK) {
        this.usuarioTipoUsuarioPK = usuarioTipoUsuarioPK;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Empleador> getEmpleadorList() {
        return empleadorList;
    }

    public void setEmpleadorList(List<Empleador> empleadorList) {
        this.empleadorList = empleadorList;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioTipoUsuarioPK != null ? usuarioTipoUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTipoUsuario)) {
            return false;
        }
        UsuarioTipoUsuario other = (UsuarioTipoUsuario) object;
        if ((this.usuarioTipoUsuarioPK == null && other.usuarioTipoUsuarioPK != null) || (this.usuarioTipoUsuarioPK != null && !this.usuarioTipoUsuarioPK.equals(other.usuarioTipoUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.UsuarioTipoUsuario[ usuarioTipoUsuarioPK=" + usuarioTipoUsuarioPK + " ]";
    }
    
}
