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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario")})
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "PROCEDURE_CREAR_CUENTA", 
            procedureName = "PROCEDURE_CREAR_CUENTA", 
            parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_nombre_usuario"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_contrasena"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_tipo_usuario"), 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "P_NOMBRE"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "P_APPATERNO"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "P_APMATERNO"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "P_RUT"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "P_RETORNO")}
    )
})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID")
    private Short usuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_USUARIO")
    private short tipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioTipoUsuario> usuarioTipoUsuarioList;

    public Usuario() {
    }

    public Usuario(Short usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario(Short usuarioId, String nombre, String contrasena, short tipoUsuario) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    public Short getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Short usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public short getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(short tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
