package org.maintech.tipomovimiento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.hibernate.annotations.Where;



@Entity
@Where(clause="is_active=1")
public class TipoMovimiento {

	@Id
	@GeneratedValue
	private Integer idTipoMovimiento;
	private String NombreTipoMovimiento;
;
	
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;
	
	
	
	public Integer getIdTipoMovimiento() {
		return idTipoMovimiento;
	}



	public void setIdTipoMovimiento(Integer idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}



	public String getNombreTipoMovimiento() {
		return NombreTipoMovimiento;
	}



	public void setNombreTipoMovimiento(String nombreTipoMovimiento) {
		NombreTipoMovimiento = nombreTipoMovimiento;
	}



	public Boolean getActive() {
		return active;
	}



	public void setActive(Boolean active) {
		this.active = active;
	}



	public TipoMovimiento() {
		super();
	}



	public TipoMovimiento(Integer idTipoMovimiento, String nombreTipoMovimiento, Boolean active) {
		super();
		this.idTipoMovimiento = idTipoMovimiento;
		NombreTipoMovimiento = nombreTipoMovimiento;
		this.active = active;
	}
	
}
