package org.maintech.mantenimiento;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@ManyToOne
	private Objeto objeto;
	
	//@ManyToMany(cascade = CascadeType.ALL)
	//@ManyToMany(mappedBy = "Mantenimiento_has_Actividad")
//	@JoinTable(
//		        name="Mantenimiento_has_Actividad",
//		        joinColumns=@JoinColumn(name="id_mantenimiento", referencedColumnName="id_mantenimiento"),
//		        inverseJoinColumns=@JoinColumn(name="id_actividad", referencedColumnName="id_actividad"))
	//private Set<Actividad> actividad = new HashSet<Actividad>();
	
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
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}


	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
/*
	public Set<Actividad> getActividad() {
		return actividad;
	}

	public void setActividad(Set<Actividad> actividad) {
		this.actividad = actividad;
	}*/

	public Mantenimiento() {
		super();
	}

	public Mantenimiento(Integer idMantenimiento, String nombreMantenimiento, Date fechaMantenimiento,
			String descripcionMantenimiento, Objeto objeto, Set<Actividad> actividad, Boolean active) {
		super();
		this.idMantenimiento = idMantenimiento;
		NombreMantenimiento = nombreMantenimiento;
		FechaMantenimiento = fechaMantenimiento;
		DescripcionMantenimiento = descripcionMantenimiento;
		this.objeto = objeto;
		//this.actividad = actividad;
		this.active = active;
	}
	
	
	
	
}
