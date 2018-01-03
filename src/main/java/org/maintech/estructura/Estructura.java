package org.maintech.estructura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Where;


@Entity
@Where(clause="is_active=1")
public class Estructura {

	@Id
	@GeneratedValue
	private Integer idEstructura;
	private String NombreEstructura;
	
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;


	public Integer getIdEstructura() {
		return idEstructura;
	}


	public void setIdEstructura(Integer idEstructura) {
		this.idEstructura = idEstructura;
	}


	public String getNombreEstructura() {
		return NombreEstructura;
	}


	public void setNombreEstructura(String nombreEstructura) {
		NombreEstructura = nombreEstructura;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}

	public Estructura() {
		super();
	}
	
	public Estructura(Integer idEstructura, String nombreEstructura, Boolean active) {
		super();
		this.idEstructura = idEstructura;
		NombreEstructura = nombreEstructura;
		this.active = active;
	}
}
