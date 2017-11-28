package org.maintech.movimiento;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;
import org.maintech.tipomantenimiento.TipoMantenimiento;



@Entity
@Where(clause="is_active=1")
public class Movimiento {
	
	@Id
	@GeneratedValue
	private Integer idMovimiento;
	private String NombreMovimiento;
	private Date FechaMovimiento;
	private String DescripcionMovimiento;
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;
	
	@ManyToOne
	private TipoMantenimiento objTipoMantenimiento;

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getNombreMovimiento() {
		return NombreMovimiento;
	}

	public void setNombreMovimiento(String nombreMovimiento) {
		NombreMovimiento = nombreMovimiento;
	}

	public Date getFechaMovimiento() {
		return FechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		FechaMovimiento = fechaMovimiento;
	}

	public String getDescripcionMovimiento() {
		return DescripcionMovimiento;
	}

	public void setDescripcionMovimiento(String descripcionMovimiento) {
		DescripcionMovimiento = descripcionMovimiento;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public TipoMantenimiento getObjTipoMantenimiento() {
		return objTipoMantenimiento;
	}

	public void setObjTipoMantenimiento(TipoMantenimiento objTipoMantenimiento) {
		this.objTipoMantenimiento = objTipoMantenimiento;
	}

	public Movimiento(Integer idMovimiento, String nombreMovimiento, Date fechaMovimiento, String descripcionMovimiento,
			Boolean active, TipoMantenimiento objTipoMantenimiento) {
		super();
		this.idMovimiento = idMovimiento;
		NombreMovimiento = nombreMovimiento;
		FechaMovimiento = fechaMovimiento;
		DescripcionMovimiento = descripcionMovimiento;
		this.active = active;
		this.objTipoMantenimiento = objTipoMantenimiento;
	}

	public Movimiento() {

	}
	

	
}
