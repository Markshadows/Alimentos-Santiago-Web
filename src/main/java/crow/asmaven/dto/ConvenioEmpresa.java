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
import javax.persistence.OneToMany;
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
@Table(name = "CONVENIO_EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConvenioEmpresa.findAll", query = "SELECT c FROM ConvenioEmpresa c")
    , @NamedQuery(name = "ConvenioEmpresa.findByConvenioEmpresaId", query = "SELECT c FROM ConvenioEmpresa c WHERE c.convenioEmpresaId = :convenioEmpresaId")
    , @NamedQuery(name = "ConvenioEmpresa.findByNombre", query = "SELECT c FROM ConvenioEmpresa c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ConvenioEmpresa.findByRut", query = "SELECT c FROM ConvenioEmpresa c WHERE c.rut = :rut")
    , @NamedQuery(name = "ConvenioEmpresa.findByDireccion", query = "SELECT c FROM ConvenioEmpresa c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "ConvenioEmpresa.findByFechaInicio", query = "SELECT c FROM ConvenioEmpresa c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "ConvenioEmpresa.findByFechaTermino", query = "SELECT c FROM ConvenioEmpresa c WHERE c.fechaTermino = :fechaTermino")})
public class ConvenioEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONVENIO_EMPRESA_ID")
    private Short convenioEmpresaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT")
    private int rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_TERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @JoinColumn(name = "EMPLEADOR", referencedColumnName = "EMPLEADOR_ID")
    @ManyToOne
    private Empleador empleador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "convenioEmpresaId")
    private List<PlanillaTrabajadores> planillaTrabajadoresList;

    public ConvenioEmpresa() {
    }

    public ConvenioEmpresa(Short convenioEmpresaId) {
        this.convenioEmpresaId = convenioEmpresaId;
    }

    public ConvenioEmpresa(Short convenioEmpresaId, String nombre, int rut, String direccion) {
        this.convenioEmpresaId = convenioEmpresaId;
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    public Short getConvenioEmpresaId() {
        return convenioEmpresaId;
    }

    public void setConvenioEmpresaId(Short convenioEmpresaId) {
        this.convenioEmpresaId = convenioEmpresaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Empleador getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Empleador empleador) {
        this.empleador = empleador;
    }

    @XmlTransient
    public List<PlanillaTrabajadores> getPlanillaTrabajadoresList() {
        return planillaTrabajadoresList;
    }

    public void setPlanillaTrabajadoresList(List<PlanillaTrabajadores> planillaTrabajadoresList) {
        this.planillaTrabajadoresList = planillaTrabajadoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (convenioEmpresaId != null ? convenioEmpresaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConvenioEmpresa)) {
            return false;
        }
        ConvenioEmpresa other = (ConvenioEmpresa) object;
        if ((this.convenioEmpresaId == null && other.convenioEmpresaId != null) || (this.convenioEmpresaId != null && !this.convenioEmpresaId.equals(other.convenioEmpresaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.ConvenioEmpresa[ convenioEmpresaId=" + convenioEmpresaId + " ]";
    }
    
}
