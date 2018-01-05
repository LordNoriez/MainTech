package org.maintech.mantenimientoObjetoActividad;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.maintech.actividad.Actividad;
import org.maintech.mantenimiento.Mantenimiento;
import org.maintech.objeto.Objeto;
import org.maintech.proveedor.Proveedor;

@Entity
//@Table(name = "actividad_proveedor", catalog = "DBClassdummy")
@AssociationOverrides({
		@AssociationOverride(name = "pk.mantenimiento",
			joinColumns = @JoinColumn(name = "id_mantenimiento")),
		@AssociationOverride(name = "pk.objeto",
			joinColumns = @JoinColumn(name = "id_objeto")),
		@AssociationOverride(name = "pk.actividad",
			joinColumns = @JoinColumn(name = "id_actividad")),
		@AssociationOverride(name = "pk.proveedor",
			joinColumns = @JoinColumn(name = "id_proveedor")), })


public class MantenimientoObjetoActividad implements java.io.Serializable {

	private MantenimientoObjetoActividadId pk = new MantenimientoObjetoActividadId();
	@Column(name="costo",columnDefinition="double(10,2) default 0")
	private Double costo;

	@Column(columnDefinition="tinyint(1) default 0")
	private Integer cantidadMantenimiento;

	public Integer getCantidadMantenimiento() {
		return cantidadMantenimiento;
	}

	public void setCantidadMantenimiento(Integer cantidadMantenimiento) {
		this.cantidadMantenimiento = cantidadMantenimiento;
	}

	public MantenimientoObjetoActividad() {
	}

	@EmbeddedId
	public MantenimientoObjetoActividadId getPk() {
		return pk;
	}

	public void setPk(MantenimientoObjetoActividadId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Mantenimiento getMantenimiento () {
		return getPk().getMantenimiento();
	}

	public void setMantenimiento (Mantenimiento mantenimiento) {
		getPk().setMantenimiento(mantenimiento);
	}

	@Transient
	public Objeto getObjeto () {
		return getPk().getObjeto();
	}

	public void setObjeto (Objeto objeto) {
		getPk().setObjeto(objeto);
	}
		
	@Transient
	public Actividad getActividad () {
		return getPk().getActividad();
	}

	public void setActividad (Actividad stock) {
		getPk().setActividad(stock);
	}	
	
	@Transient
	public Proveedor getProveedor () {
		return getPk().getProveedor();
	}

	public void setActividad (Proveedor proveedor) {
		getPk().setProveedor(proveedor);
	}	
	
	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costo == null) ? 0 : costo.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MantenimientoObjetoActividad other = (MantenimientoObjetoActividad) obj;
		if (costo == null) {
			if (other.costo != null)
				return false;
		} else if (!costo.equals(other.costo))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}
	
	

//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//
//		MantenimientoObjetoActividad that = (MantenimientoObjetoActividad) o;
//
//		if (getPk() != null ? !getPk().equals(that.getPk())
//				: that.getPk() != null)
//			return false;
//
//		return true;
//	}
//
//	public int hashCode() {
//		return (getPk() != null ? getPk().hashCode() : 0);
//	}
}