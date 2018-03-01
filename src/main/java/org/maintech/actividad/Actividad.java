package org.maintech.actividad;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;
import org.maintech.areaempresa.AreaEmpresa;
import org.maintech.mantenimiento.Mantenimiento;



@Entity
@Where(clause="is_active=1")
public class Actividad {
	
	@Id
	@GeneratedValue
	private Integer idActividad;
	private String NombreActividad;
	private String DescripcionActividad;
	
	@ManyToOne
	private AreaEmpresa areaEmpresa;
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;

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
	
	
	public String getDescripcionActividad() {
		return DescripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		DescripcionActividad = descripcionActividad;
	}

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

	public AreaEmpresa getAreaEmpresa() {
		return areaEmpresa;
	}

	public void setAreaEmpresa(AreaEmpresa areaEmpresa) {
		this.areaEmpresa = areaEmpresa;
	}

	public Actividad() {
		super();
	}

	public Actividad(Integer idActividad, String nombreActividad, String descripcionActividad, AreaEmpresa areaEmpresa,
			Boolean active, Set<Mantenimiento> mantenimientos) {
		super();
		this.idActividad = idActividad;
		NombreActividad = nombreActividad;
		DescripcionActividad = descripcionActividad;
		this.areaEmpresa = areaEmpresa;
		this.active = active;
		this.mantenimientos = mantenimientos;
	}
}
