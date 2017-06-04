package org.maintech.mantenimiento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Where;

@Entity
@Where(clause="is_active=1")
public class Mantenimiento {

	@Id
	private Integer idMantenimiento;
	private String NombreCategoria;
	private String DescripcionCategoria;
	
	@Column(name="is_active")
	private Boolean active;
	
	
	public Integer getIdMantenimiento() {
		return idMantenimiento;
	}

	public void setIdMantenimiento(Integer idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	public String getNombreCategoria() {
		return NombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		NombreCategoria = nombreCategoria;
	}

	public String getDescripcionCategoria() {
		return DescripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		DescripcionCategoria = descripcionCategoria;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Mantenimiento() {
		super();
	}

	public Mantenimiento(Integer idMantenimiento, String nombreCategoria, String descripcionCategoria, Boolean active) {
		super();
		this.idMantenimiento = idMantenimiento;
		NombreCategoria = nombreCategoria;
		DescripcionCategoria = descripcionCategoria;
		this.active = active;
	}
	
}
