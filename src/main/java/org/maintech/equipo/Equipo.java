package org.maintech.equipo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.hibernate.annotations.Where;

@Entity
@Where(clause="is_active=1")
public class Equipo {

	@Id
	@GeneratedValue
	private Integer idEquipo;
	
	private String NombreEquipo;	
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;

	public Integer getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombreEquipo() {
		return NombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		NombreEquipo = nombreEquipo;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Equipo() {
		super();
	}

	public Equipo(Integer idEquipo, String nombreEquipo, Boolean active) {
		super();
		this.idEquipo = idEquipo;
		NombreEquipo = nombreEquipo;
		this.active = active;
	}
}
