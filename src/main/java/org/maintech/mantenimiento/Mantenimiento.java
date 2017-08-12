package org.maintech.mantenimiento;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;
import org.maintech.actividad.Actividad;
import org.maintech.objeto.Objeto;

@Entity
@Where(clause="is_active=1")
public class Mantenimiento {

	@Id
	@GeneratedValue
	private Integer idMantenimiento;
	private String NombreMantenimiento;
	private Date FechaMantenimiento;
	private String DescripcionMantenimiento;
	@Column(columnDefinition="tinyint(1) default 1")
	private Boolean  isProgramadoMantenimiento;
	private String FrecuenciaMantenimiento;
	
	@ManyToOne
	private Objeto objetoMantenimiento;
	

	//@ManyToMany(cascade = CascadeType.ALL)
	//@ManyToMany(mappedBy = "Mantenimiento_has_Actividad")
//	@JoinTable(
//		        name="Mantenimiento_has_Actividad",
//		        joinColumns=@JoinColumn(name="id_mantenimiento", referencedColumnName="id_mantenimiento"),
//		        inverseJoinColumns=@JoinColumn(name="id_actividad", referencedColumnName="id_actividad"))
	//private Set<Actividad> actividad = new HashSet<Actividad>();

	
	@ManyToMany(mappedBy="mantenimientos")//mantenimientos is the objetc from Actividad that i created
	private Collection<Actividad> actividad;

	
	@Column(name="is_active")
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

	public Objeto getObjeto() {
		return objetoMantenimiento;
	}

	public void setObjeto(Objeto objeto) {
		this.objetoMantenimiento = objeto;
	}


	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public String getFrecuenciaMantenimiento() {
		return FrecuenciaMantenimiento;
	}

	public void setFrecuenciaMantenimiento(String frecuenciaMantenimiento) {
		FrecuenciaMantenimiento = frecuenciaMantenimiento;
	}

	public Boolean getIsProgramadoMantenimiento() {
		return isProgramadoMantenimiento;
	}

	public void setIsProgramadoMantenimiento(Boolean isProgramadoMantenimiento) {
		this.isProgramadoMantenimiento = isProgramadoMantenimiento;
	}

	public Mantenimiento() {
		super();
	}

	public Mantenimiento(Integer idMantenimiento, String nombreMantenimiento, Date fechaMantenimiento,
			String descripcionMantenimiento, Boolean isProgramadoMantenimiento, String frecuenciaMantenimiento,
			Objeto objetoMantenimiento, Collection<Actividad> actividad, Boolean active) {
		super();
		this.idMantenimiento = idMantenimiento;
		NombreMantenimiento = nombreMantenimiento;
		FechaMantenimiento = fechaMantenimiento;
		DescripcionMantenimiento = descripcionMantenimiento;
		this.isProgramadoMantenimiento = isProgramadoMantenimiento;
		FrecuenciaMantenimiento = frecuenciaMantenimiento;
		this.objetoMantenimiento = objetoMantenimiento;
		this.actividad = actividad;
		this.active = active;
	}

	

	
	
	
	
	
}
