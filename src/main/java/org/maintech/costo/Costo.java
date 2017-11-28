package org.maintech.costo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Where(clause="is_active=1")
public class Costo {
	
	@Id
	@GeneratedValue
	private Integer idCosto;
	private Double Costo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaInicioCosto;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaFinCosto;

	@Column(name="is_active", columnDefinition="tinyint(1) default 1")	
	private Boolean active;

	public Integer getIdCosto() {
		return idCosto;
	}

	public void setIdCosto(Integer idCosto) {
		this.idCosto = idCosto;
	}

	public Double getCosto() {
		return Costo;
	}

	public void setCosto(Double costo) {
		Costo = costo;
	}

	public Date getFechaInicioCosto() {
		return FechaInicioCosto;
	}

	public void setFechaInicioCosto(Date fechaInicioCosto) {
		FechaInicioCosto = fechaInicioCosto;
	}

	public Date getFechaFinCosto() {
		return FechaFinCosto;
	}

	public void setFechaFinCosto(Date fechaFinCosto) {
		FechaFinCosto = fechaFinCosto;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Costo() {
		super();
	}

	public Costo(Integer idCosto, Double costo, Date fechaInicioCosto, Date fechaFinCosto) {
		super();
		this.idCosto = idCosto;
		Costo = costo;
		FechaInicioCosto = fechaInicioCosto;
		FechaFinCosto = fechaFinCosto;
	}	
	
}
