/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author M_arc
 */
@Embeddable
public class UsuarioTipoUsuarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_USUARIO_ID")
    private short tipoUsuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID")
    private short usuarioId;

    public UsuarioTipoUsuarioPK() {
    }

    public UsuarioTipoUsuarioPK(short tipoUsuarioId, short usuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
        this.usuarioId = usuarioId;
    }

    public short getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(short tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public short getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(short usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tipoUsuarioId;
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTipoUsuarioPK)) {
            return false;
        }
        UsuarioTipoUsuarioPK other = (UsuarioTipoUsuarioPK) object;
        if (this.tipoUsuarioId != other.tipoUsuarioId) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.UsuarioTipoUsuarioPK[ tipoUsuarioId=" + tipoUsuarioId + ", usuarioId=" + usuarioId + " ]";
    }
    
}
