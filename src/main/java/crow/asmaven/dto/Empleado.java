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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author M_arc
 */
@Entity
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByEmpleadoId", query = "SELECT e FROM Empleado e WHERE e.empleadoId = :empleadoId")
    , @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleado.findByAppaterno", query = "SELECT e FROM Empleado e WHERE e.appaterno = :appaterno")
    , @NamedQuery(name = "Empleado.findByApmaterno", query = "SELECT e FROM Empleado e WHERE e.apmaterno = :apmaterno")
    , @NamedQuery(name = "Empleado.findByRut", query = "SELECT e FROM Empleado e WHERE e.rut = :rut")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLEADO_ID")
    private Short empleadoId;
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
    @JoinColumns({
        @JoinColumn(name = "TIPO_USUARIO_ID", referencedColumnName = "TIPO_USUARIO_ID")
        , @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID")})
    @ManyToOne(optional = false)
    private UsuarioTipoUsuario usuarioTipoUsuario;

    public Empleado() {
    }

    public Empleado(Short empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Empleado(Short empleadoId, String nombre, String appaterno, String apmaterno, int rut) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.rut = rut;
    }

    public Short getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Short empleadoId) {
        this.empleadoId = empleadoId;
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

    public UsuarioTipoUsuario getUsuarioTipoUsuario() {
        return usuarioTipoUsuario;
    }

    public void setUsuarioTipoUsuario(UsuarioTipoUsuario usuarioTipoUsuario) {
        this.usuarioTipoUsuario = usuarioTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoId != null ? empleadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empleadoId == null && other.empleadoId != null) || (this.empleadoId != null && !this.empleadoId.equals(other.empleadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.Empleado[ empleadoId=" + empleadoId + " ]";
    }
    
}
