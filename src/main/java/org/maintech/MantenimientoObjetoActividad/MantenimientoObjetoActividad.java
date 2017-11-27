package org.maintech.MantenimientoObjetoActividad;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.maintech.actividad.Actividad;
import org.maintech.mantenimiento.Mantenimiento;
import org.maintech.objeto.Objeto;

@Entity
//@Table(name = "actividad_proveedor", catalog = "DBClassdummy")
@AssociationOverrides({
		@AssociationOverride(name = "pk.mantenimiento",
			joinColumns = @JoinColumn(name = "id_mantenimiento")),
		@AssociationOverride(name = "pk.actividad",
			joinColumns = @JoinColumn(name = "id_actividad")),
		@AssociationOverride(name = "pk.proveedor",
			joinColumns = @JoinColumn(name = "id_proveedor")) })


public class MantenimientoObjetoActividad implements java.io.Serializable {

	private MantenimientoObjetoActividadId pk = new MantenimientoObjetoActividadId();

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

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MantenimientoObjetoActividad that = (MantenimientoObjetoActividad) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}