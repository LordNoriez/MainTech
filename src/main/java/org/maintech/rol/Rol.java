package org.maintech.rol;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;
import org.maintech.areaempresa.AreaEmpresa;

@Entity
@Where(clause="is_active=1")
public class Rol {

	@Id
	@GeneratedValue
	private Integer idRol;
	
	private String NombreRol;	
	
	@ManyToOne
	private AreaEmpresa areaEmpresa;
	
	public Rol() {
		super();
	}

	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return NombreRol;
	}

	public void setNombreRol(String nombreRol) {
		NombreRol = nombreRol;
	}
	
	public AreaEmpresa getAreaEmpresa() {
		return areaEmpresa;
	}

	public void setAreaEmpresa(AreaEmpresa areaEmpresa) {
		this.areaEmpresa = areaEmpresa;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Rol(Integer idRol, String nombreRol, AreaEmpresa areaEmpresa, Boolean active) {
		super();
		this.idRol = idRol;
		NombreRol = nombreRol;
		this.areaEmpresa = areaEmpresa;
		this.active = active;
	}		
	
}
