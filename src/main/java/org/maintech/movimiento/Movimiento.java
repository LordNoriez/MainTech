package org.maintech.movimiento;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;
import org.maintech.objeto.Objeto;
import org.maintech.tipomovimiento.TipoMovimiento;



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
	private TipoMovimiento tipomovimiento;

	@ManyToOne
	private Objeto objeto;
	
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

	public TipoMovimiento getTipomovimiento() {
		return tipomovimiento;
	}

	public void setTipomovimiento(TipoMovimiento tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public Movimiento(Integer idMovimiento, String nombreMovimiento, Date fechaMovimiento, String descripcionMovimiento,
			Boolean active, TipoMovimiento tipomovimiento, Objeto objeto) {
		super();
		this.idMovimiento = idMovimiento;
		NombreMovimiento = nombreMovimiento;
		FechaMovimiento = fechaMovimiento;
		DescripcionMovimiento = descripcionMovimiento;
		this.active = active;
		this.tipomovimiento = tipomovimiento;
		this.objeto = objeto;
	}

	public Movimiento() {

	}
	

	
}
