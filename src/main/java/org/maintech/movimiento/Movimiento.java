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
	private Date FechaMovimiento;
	private String DescripcionMovimiento;
	private Integer CantidadMovimiento;

	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;
	
	@ManyToOne
	private TipoMovimiento tipoMovimiento;

	@ManyToOne
	private Objeto objeto;
	

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
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

	public Integer getCantidadMovimiento() {
		return CantidadMovimiento;
	}

	public void setCantidadMovimiento(Integer cantidadMovimiento) {
		CantidadMovimiento = cantidadMovimiento;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public Movimiento(Integer idMovimiento, Date fechaMovimiento, String descripcionMovimiento,
			Integer cantidadMovimiento, Boolean active, TipoMovimiento tipoMovimiento, Objeto objeto) {
		super();
		this.idMovimiento = idMovimiento;
		FechaMovimiento = fechaMovimiento;
		DescripcionMovimiento = descripcionMovimiento;
		CantidadMovimiento = cantidadMovimiento;
		this.active = active;
		this.tipoMovimiento = tipoMovimiento;
		this.objeto = objeto;
	}

	public Movimiento() {

	}
	

	
}
