package org.maintech.mantenimiento;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;
import org.maintech.actividad.Actividad;
import org.maintech.objeto.Objeto;
import org.maintech.tipomantenimiento.TipoMantenimiento;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Where(clause="is_active=1")
public class Mantenimiento {

	@Id
	@GeneratedValue
	private Integer idMantenimiento;
	private String NombreMantenimiento;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaMantenimiento;
	private String DescripcionMantenimiento;
	private String Observaciones;
	@Column(columnDefinition="tinyint(1) default 0")
	private Boolean  isProgramadoMantenimiento;
	private Integer FrecuenciaMantenimiento;
	@Column(columnDefinition="tinyint(1) default 0")
	private Boolean isAceptadoMantenimiento;
	@Column(columnDefinition="tinyint(1) default 0")
	private Boolean isEnProcesoMantenimiento;
	@Column(columnDefinition="tinyint(1) default 0")
	private Boolean isTerminadoMantenimiento;
	
	@ManyToOne
	private TipoMantenimiento objTipoMantenimiento;

	//@ManyToMany(cascade = CascadeType.ALL)
	//@ManyToMany(mappedBy = "Mantenimiento_has_Actividad")
//	@JoinTable(
//		        name="Mantenimiento_has_Actividad",
//		        joinColumns=@JoinColumn(name="id_mantenimiento", referencedColumnName="id_mantenimiento"),
//		        inverseJoinColumns=@JoinColumn(name="id_actividad", referencedColumnName="id_actividad"))
	//private Set<Actividad> actividad = new HashSet<Actividad>();

	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;
	

	public Integer getIdMantenimiento() {
		return idMantenimiento;
	}

	public void setIdMantenimiento(Integer idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	public String getNombreMantenimiento() {
		return NombreMantenimiento;
	}

	public void setNombreMantenimiento(String nombreMantenimiento) {
		NombreMantenimiento = nombreMantenimiento;
	}

	public Date getFechaMantenimiento() {
		return FechaMantenimiento;
	}

	public void setFechaMantenimiento(Date fechaMantenimiento) {
		FechaMantenimiento = fechaMantenimiento;
	}

	public String getDescripcionMantenimiento() {
		return DescripcionMantenimiento;
	}

	public void setDescripcionMantenimiento(String descripcionMantenimiento) {
		DescripcionMantenimiento = descripcionMantenimiento;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Integer getFrecuenciaMantenimiento() {
		return FrecuenciaMantenimiento;
	}

	public void setFrecuenciaMantenimiento(Integer frecuenciaMantenimiento) {
		FrecuenciaMantenimiento = frecuenciaMantenimiento;
	}

	public Boolean getIsProgramadoMantenimiento() {
		return isProgramadoMantenimiento;
	}

	public void setIsProgramadoMantenimiento(Boolean isProgramadoMantenimiento) {
		this.isProgramadoMantenimiento = isProgramadoMantenimiento;
	}
		
	public TipoMantenimiento getObjTipoMantenimiento() {
		return objTipoMantenimiento;
	}

	public void setObjTipoMantenimiento(TipoMantenimiento objTipoMantenimiento) {
		this.objTipoMantenimiento = objTipoMantenimiento;
	}

	public Boolean getIsAceptadoMantenimiento() {
		return isAceptadoMantenimiento;
	}

	public void setIsAceptadoMantenimiento(Boolean isAceptadoMantenimiento) {
		this.isAceptadoMantenimiento = isAceptadoMantenimiento;
	}

	public Boolean getIsEnProcesoMantenimiento() {
		return isEnProcesoMantenimiento;
	}

	public void setIsEnProcesoMantenimiento(Boolean isEnProcesoMantenimiento) {
		this.isEnProcesoMantenimiento = isEnProcesoMantenimiento;
	}

	public Boolean getIsTerminadoMantenimiento() {
		return isTerminadoMantenimiento;
	}

	public void setIsTerminadoMantenimiento(Boolean isTerminadoMantenimiento) {
		this.isTerminadoMantenimiento = isTerminadoMantenimiento;
	}
	
	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

	public Mantenimiento() {
		super();
		this.active = true;
	}

	public Mantenimiento(Integer idMantenimiento, String nombreMantenimiento, Date fechaMantenimiento,
			String descripcionMantenimiento, String observaciones, Boolean isProgramadoMantenimiento,
			Integer frecuenciaMantenimiento, Boolean isAceptadoMantenimiento, Boolean isEnProcesoMantenimiento,
			Boolean isTerminadoMantenimiento, TipoMantenimiento objTipoMantenimiento, Boolean active) {
		super();
		this.idMantenimiento = idMantenimiento;
		NombreMantenimiento = nombreMantenimiento;
		FechaMantenimiento = fechaMantenimiento;
		DescripcionMantenimiento = descripcionMantenimiento;
		Observaciones = observaciones;
		this.isProgramadoMantenimiento = isProgramadoMantenimiento;
		FrecuenciaMantenimiento = frecuenciaMantenimiento;
		this.isAceptadoMantenimiento = isAceptadoMantenimiento;
		this.isEnProcesoMantenimiento = isEnProcesoMantenimiento;
		this.isTerminadoMantenimiento = isTerminadoMantenimiento;
		this.objTipoMantenimiento = objTipoMantenimiento;
		this.active = active;
	}
}
