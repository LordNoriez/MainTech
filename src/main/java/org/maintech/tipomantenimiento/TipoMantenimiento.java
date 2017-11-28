package org.maintech.tipomantenimiento;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Where;
import org.maintech.actividad.Actividad;
import org.maintech.mantenimiento.Mantenimiento;


@Entity
@Where(clause="is_active=1")
public class TipoMantenimiento {

	@Id
	@GeneratedValue
	private Integer idTipoMantenimiento;
	private String NombreTipoMantenimiento;
	
//	@ManyToOne
//	private Mantenimiento objetoMantenimiento;
	
	
	@Column(name="is_active",columnDefinition="tinyint(1) default 1")
	private Boolean active;
	
	public Integer getIdTipoMantenimiento() {
		return idTipoMantenimiento;
	}

	public void setIdTipoMantenimiento(Integer idTipoMantenimiento) {
		this.idTipoMantenimiento = idTipoMantenimiento;
	}

	public String getNombreTipoMantenimiento() {
		return NombreTipoMantenimiento;
	}

	public void setNombreTipoMantenimiento(String nombreTipoMantenimiento) {
		NombreTipoMantenimiento = nombreTipoMantenimiento;
	}

/*	public Mantenimiento getObjetoMantenimiento() {
		return objetoMantenimiento;
	}

	public void setObjetoMantenimiento(Mantenimiento objetoMantenimiento) {
		this.objetoMantenimiento = objetoMantenimiento;
	}*/


	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public TipoMantenimiento() {
		super();
	}
	

	public TipoMantenimiento(Integer idTipoMantenimiento, String nombreTipoMantenimiento, Mantenimiento objetoMantenimiento,
			Collection<Actividad> actividad, Boolean active) {
		super();
		this.idTipoMantenimiento = idTipoMantenimiento;
		NombreTipoMantenimiento = nombreTipoMantenimiento;
//		this.objetoMantenimiento = objetoMantenimiento;
		this.active = active;
	}	
}
