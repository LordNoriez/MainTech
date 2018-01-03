package org.maintech.color;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Where;


@Entity
@Where(clause="is_active=1")
public class Color {

	@Id
	@GeneratedValue
	private Integer idColor;
	private String NombreColor;
	
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;


	public Integer getIdColor() {
		return idColor;
	}


	public void setIdColor(Integer idColor) {
		this.idColor = idColor;
	}


	public String getNombreColor() {
		return NombreColor;
	}


	public void setNombreColor(String nombreColor) {
		NombreColor = nombreColor;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}

	public Color() {
		super();
	}
	
	public Color(Integer idColor, String nombreColor, Boolean active) {
		super();
		this.idColor = idColor;
		NombreColor = nombreColor;
		this.active = active;
	}	
}
