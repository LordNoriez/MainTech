package org.maintech.categoria;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	private Integer idCategoria;
	private String NombreCategoria;
	private String DescripcionCategoria;
	
	
	
	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
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

	public Categoria() {
		super();
	}
	
	public Categoria(Integer idCategoria, String nombreCategoria, String descripcionCategoria) {
		super();
		this.idCategoria = idCategoria;
		NombreCategoria = nombreCategoria;
		DescripcionCategoria = descripcionCategoria;
	}
	
	
	
}
