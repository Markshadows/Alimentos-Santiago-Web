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
@Table(name = "TIPO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t")
    , @NamedQuery(name = "TipoUsuario.findByTipoUsuarioId", query = "SELECT t FROM TipoUsuario t WHERE t.tipoUsuarioId = :tipoUsuarioId")
    , @NamedQuery(name = "TipoUsuario.findByDescripcion", query = "SELECT t FROM TipoUsuario t WHERE t.descripcion = :descripcion")})
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_USUARIO_ID")
    private Short tipoUsuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuario")
    private List<UsuarioTipoUsuario> usuarioTipoUsuarioList;

    public TipoUsuario() {
    }

    public TipoUsuario(Short tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public TipoUsuario(Short tipoUsuarioId, String descripcion) {
        this.tipoUsuarioId = tipoUsuarioId;
        this.descripcion = descripcion;
    }

    public Short getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Short tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<UsuarioTipoUsuario> getUsuarioTipoUsuarioList() {
        return usuarioTipoUsuarioList;
    }

    public void setUsuarioTipoUsuarioList(List<UsuarioTipoUsuario> usuarioTipoUsuarioList) {
        this.usuarioTipoUsuarioList = usuarioTipoUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoUsuarioId != null ? tipoUsuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.tipoUsuarioId == null && other.tipoUsuarioId != null) || (this.tipoUsuarioId != null && !this.tipoUsuarioId.equals(other.tipoUsuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.TipoUsuario[ tipoUsuarioId=" + tipoUsuarioId + " ]";
    }
    
}
