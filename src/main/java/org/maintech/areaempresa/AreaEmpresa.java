package org.maintech.areaempresa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Where;


@Entity
@Where(clause="is_active=1")
public class AreaEmpresa {

	@Id
	@GeneratedValue
	private Integer idTipoMantenimiento;
	private String NombreAreaEmpresa;	
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;

	public Integer getIdTipoMantenimiento() {
		return idTipoMantenimiento;
	}

	public void setIdTipoMantenimiento(Integer idTipoMantenimiento) {
		this.idTipoMantenimiento = idTipoMantenimiento;
	}

	public String getNombreAreaEmpresa() {
		return NombreAreaEmpresa;
	}

	public void setNombreAreaEmpresa(String nombreAreaEmpresa) {
		NombreAreaEmpresa = nombreAreaEmpresa;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public AreaEmpresa() {
		super();
	}
	

	public AreaEmpresa(Integer idTipoMantenimiento, String nombreAreaEmpresa, Boolean active) {
		super();
		this.idTipoMantenimiento = idTipoMantenimiento;
		NombreAreaEmpresa = nombreAreaEmpresa;
		this.active = active;
	}
	
	
}
