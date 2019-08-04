/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crow.asmaven.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author M_arc
 */
@Entity
@Table(name = "PLANILLA_TRABAJADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanillaTrabajadores.findAll", query = "SELECT p FROM PlanillaTrabajadores p")
    , @NamedQuery(name = "PlanillaTrabajadores.findByPlanillaId", query = "SELECT p FROM PlanillaTrabajadores p WHERE p.planillaId = :planillaId")
    , @NamedQuery(name = "PlanillaTrabajadores.findByFechaSubida", query = "SELECT p FROM PlanillaTrabajadores p WHERE p.fechaSubida = :fechaSubida")
    , @NamedQuery(name = "PlanillaTrabajadores.findByNombreArchivo", query = "SELECT p FROM PlanillaTrabajadores p WHERE p.nombreArchivo = :nombreArchivo")})
@NamedStoredProcedureQuery(
	name = "PROCEDURE_INSERT_PLANILLA", 
	procedureName = "PROCEDURE_INSERT_PLANILLA", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_convenio_id"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_ruta"), 
	})
public class PlanillaTrabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLANILLA_ID")
    private Short planillaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SUBIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSubida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;
    @JoinColumn(name = "CONVENIO_EMPRESA_ID", referencedColumnName = "CONVENIO_EMPRESA_ID")
    @ManyToOne(optional = false)
    private ConvenioEmpresa convenioEmpresaId;

    public PlanillaTrabajadores() {
    }

    public PlanillaTrabajadores(Short planillaId) {
        this.planillaId = planillaId;
    }

    public PlanillaTrabajadores(Short planillaId, Date fechaSubida, String nombreArchivo) {
        this.planillaId = planillaId;
        this.fechaSubida = fechaSubida;
        this.nombreArchivo = nombreArchivo;
    }

    public Short getPlanillaId() {
        return planillaId;
    }

    public void setPlanillaId(Short planillaId) {
        this.planillaId = planillaId;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public ConvenioEmpresa getConvenioEmpresaId() {
        return convenioEmpresaId;
    }

    public void setConvenioEmpresaId(ConvenioEmpresa convenioEmpresaId) {
        this.convenioEmpresaId = convenioEmpresaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planillaId != null ? planillaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanillaTrabajadores)) {
            return false;
        }
        PlanillaTrabajadores other = (PlanillaTrabajadores) object;
        if ((this.planillaId == null && other.planillaId != null) || (this.planillaId != null && !this.planillaId.equals(other.planillaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crow.asmaven.dto.PlanillaTrabajadores[ planillaId=" + planillaId + " ]";
    }
    
}
