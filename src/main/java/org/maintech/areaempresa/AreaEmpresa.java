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
	private Integer idAreaEmpresa;
	private String NombreAreaEmpresa;	
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;

	public Integer getIdAreaEmpresa() {
		return idAreaEmpresa;
	}

	public void setIdAreaEmpresa(Integer idAreaEmpresa) {
		this.idAreaEmpresa = idAreaEmpresa;
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

	public AreaEmpresa(Integer idAreaEmpresa, String nombreAreaEmpresa, Boolean active) {
		super();
		this.idAreaEmpresa = idAreaEmpresa;
		NombreAreaEmpresa = nombreAreaEmpresa;
		this.active = active;
	}	
	
}
