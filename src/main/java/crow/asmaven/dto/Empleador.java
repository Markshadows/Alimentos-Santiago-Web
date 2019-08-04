/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "EMPLEADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleador.findAll", query = "SELECT e FROM Empleador e")
    , @NamedQuery(name = "Empleador.findByEmpleadorId", query = "SELECT e FROM Empleador e WHERE e.empleadorId = :empleadorId")
    , @NamedQuery(name = "Empleador.findByNombre", query = "SELECT e FROM Empleador e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleador.findByAppaterno", query = "SELECT e FROM Empleador e WHERE e.appaterno = :appaterno")
    , @NamedQuery(name = "Empleador.findByApmaterno", query = "SELECT e FROM Empleador e WHERE e.apmaterno = :apmaterno")
    , @NamedQuery(name = "Empleador.findByRut", query = "SELECT e FROM Empleador e WHERE e.rut = :rut")})
public class Empleador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLEADOR_ID")
    private Short empleadorId;
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
    @OneToMany(mappedBy = "empleador")
    private List<ConvenioEmpresa> convenioEmpresaList;
    @JoinColumns({
        @JoinColumn(name = "TIPO_USUARIO_ID", referencedColumnName = "TIPO_USUARIO_ID")
        , @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID")})
    @ManyToOne(optional = false)
    private UsuarioTipoUsuario usuarioTipoUsuario;

    public Empleador() {
    }

    public Empleador(Short empleadorId) {
        this.empleadorId = empleadorId;
    }

    public Empleador(Short empleadorId, String nombre, String appaterno, String apmaterno, int rut) {
        this.empleadorId = empleadorId;
        this.nombre = nombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.rut = rut;
    }

    public Short getEmpleadorId() {
        return empleadorId;
    }

    public void setEmpleadorId(Short empleadorId) {
        this.empleadorId = empleadorId;
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
    public List<ConvenioEmpresa> getConvenioEmpresaList() {
        return convenioEmpresaList;
    }

    public void setConvenioEmpresaList(List<ConvenioEmpresa> convenioEmpresaList) {
        this.convenioEmpresaList = convenioEmpresaList;
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
        hash += (empleadorId != null ? empleadorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleador)) {
            return false;
        }
        Empleador other = (Empleador) object;
        if ((this.empleadorId == null && other.empleadorId != null) || (this.empleadorId != null && !this.empleadorId.equals(other.empleadorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.Empleador[ empleadorId=" + empleadorId + " ]";
    }
    
}
