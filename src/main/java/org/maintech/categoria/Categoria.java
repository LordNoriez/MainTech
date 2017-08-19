package org.maintech.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Where;

@Entity
@Where(clause="is_active=1")
public class Categoria {

	@Id
	@GeneratedValue
	private Integer idCategoria;
	private String NombreCategoria;
	private String DescripcionCategoria;
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;
	
	
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Categoria() {
		super();
	}

	public Categoria(Integer idCategoria, String nombreCategoria, String descripcionCategoria, Boolean active) {
		super();
		this.idCategoria = idCategoria;
		NombreCategoria = nombreCategoria;
		DescripcionCategoria = descripcionCategoria;
		this.active = active;
	}
}
