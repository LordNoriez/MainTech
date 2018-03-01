package org.maintech.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;
import org.maintech.areaempresa.AreaEmpresa;
import org.maintech.rol.Rol;

@Entity
@Where(clause="is_active=1")
public class Usuario {

	@Id
	@GeneratedValue
	private Integer idUsuario;
	
	private String NombreUsuario;	
	
	private String CorreoUsuario;
	
	@ManyToOne
	private Rol rol;
	
	@ManyToOne
	private AreaEmpresa areaEmpresa;

	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public String getCorreoUsuario() {
		return CorreoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		CorreoUsuario = correoUsuario;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public AreaEmpresa getAreaEmpresa() {
		return areaEmpresa;
	}

	public void setAreaEmpresa(AreaEmpresa areaEmpresa) {
		this.areaEmpresa = areaEmpresa;
	}

	public Usuario() {
		super();
	}

	public Usuario(Integer idUsuario, String nombreUsuario, String correoUsuario, Rol rol, AreaEmpresa areaEmpresa) {
		super();
		this.idUsuario = idUsuario;
		NombreUsuario = nombreUsuario;
		CorreoUsuario = correoUsuario;
		this.rol = rol;
		this.areaEmpresa = areaEmpresa;
		this.active = true;
	}
}
