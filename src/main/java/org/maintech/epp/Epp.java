package org.maintech.epp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.hibernate.annotations.Where;

@Entity
@Where(clause="is_active=1")
public class Epp {

	@Id
	@GeneratedValue
	private Integer idEpp;
	
	private String NombreEpp;	
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;
	
	public Integer getIdEpp() {
		return idEpp;
	}



	public void setIdEpp(Integer idEpp) {
		this.idEpp = idEpp;
	}



	public String getNombreEpp() {
		return NombreEpp;
	}



	public void setNombreEpp(String nombreEpp) {
		NombreEpp = nombreEpp;
	}



	public Boolean getActive() {
		return active;
	}



	public void setActive(Boolean active) {
		this.active = active;
	}

	public Epp() {
		super();
	}



	public Epp(Integer idEpp, String nombreEpp, Boolean active) {
		super();
		this.idEpp = idEpp;
		NombreEpp = nombreEpp;
		this.active = active;
	}
}
