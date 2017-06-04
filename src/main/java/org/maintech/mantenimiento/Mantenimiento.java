package org.maintech.mantenimiento;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Mantenimiento {

	@Id
	private Integer idMantenimiento;
	private String NombreCategoria;
	private String DescripcionCategoria;
	
	
	
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

	public Mantenimiento() {
		super();
	}
	
	public Mantenimiento(Integer idMantenimiento, String nombreCategoria, String descripcionCategoria) {
		super();
		this.idMantenimiento = idMantenimiento;
		NombreCategoria = nombreCategoria;
		DescripcionCategoria = descripcionCategoria;
	}
	
	
	
}
