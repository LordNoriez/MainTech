package org.maintech.actividad;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Where;
import org.maintech.mantenimiento.Mantenimiento;



@Entity
@Where(clause="is_active=1")
public class Actividad {
	
	@Id
	@GeneratedValue
	private Integer idActividad;
	private String NombreActividad;
	private Double CostoActividad;
	private String DescripcionActividad;
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;

	//@ManyToMany(mappedBy = "Mantenimiento_has_Actividad")
//	  @JoinTable(
//		        name="Mantenimiento_has_Actividad",
//		        joinColumns=@JoinColumn(name="id_mantenimiento", referencedColumnName="id_mantenimiento"),
//		        inverseJoinColumns=@JoinColumn(name="id_actividad", referencedColumnName="id_actividad"))
	//private Set<Mantenimiento> mantenimiento = new HashSet<Mantenimiento>();

	@ManyToMany
	private Set<Mantenimiento> mantenimientos;

	

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public String getNombreActividad() {
		return NombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		NombreActividad = nombreActividad;
	}

	public Double getCostoActividad() {
		return CostoActividad;
	}

	public void setCostoActividad(Double costoActividad) {
		CostoActividad = costoActividad;
	}

	public String getDescripcionActividad() {
		return DescripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		DescripcionActividad = descripcionActividad;
	}


	
/*
	public Set<Mantenimiento> getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(Set<Mantenimiento> mantenimiento) {
		this.mantenimiento = mantenimiento;
	}*/

	public Set<Mantenimiento> getMantenimiento() {
		return mantenimientos;
	}

	public void setMantenimiento(Set<Mantenimiento> mantenimiento) {
		this.mantenimientos = mantenimiento;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Actividad() {
		super();
	}

	public Actividad(Integer idActividad, String nombreActividad, Double costoActividad, String descripcionActividad,
			Boolean active, Set<Mantenimiento> mantenimientos) {
		super();
		this.idActividad = idActividad;
		NombreActividad = nombreActividad;
		CostoActividad = costoActividad;
		DescripcionActividad = descripcionActividad;
		this.active = active;
		this.mantenimientos = mantenimientos;
	}	
}
