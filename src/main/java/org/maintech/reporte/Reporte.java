package org.maintech.reporte;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.hibernate.annotations.Where;



@Entity
@Where(clause="is_active=1")
public class Reporte {

	@Id
	@GeneratedValue
	private Integer idReporte;
	private String NombreReporte;
	
	private Integer FrecuenciaDias;	
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;
	public Integer getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}
	public String getNombreReporte() {
		return NombreReporte;
	}
	public void setNombreReporte(String nombreReporte) {
		NombreReporte = nombreReporte;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Integer getFrecuenciaDias() {
		return FrecuenciaDias;
	}
	public void setFrecuenciaDias(Integer frecuenciaDias) {
		this.FrecuenciaDias = frecuenciaDias;
	}
	public Reporte(Integer idReporte, String nombreReporte, Integer frecuenciaDias) {
		super();
		this.idReporte = idReporte;
		NombreReporte = nombreReporte;
		this.FrecuenciaDias = frecuenciaDias;
		this.active = true;
	}
	public Reporte() {
		super();
	}
	
}
