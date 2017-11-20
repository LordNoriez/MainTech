package org.maintech.rol;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Where;

@Entity
@Where(clause="is_active=1")
public class Rol {

	@Id
	@GeneratedValue
	private Integer idRol;
	
	private String mail;
	
	private String NombreRol;	
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Rol(Integer idRol, String nombreRol) {
		super();
		this.idRol = idRol;
		NombreRol = nombreRol;
		this.active = true;
	}
		
	
}
