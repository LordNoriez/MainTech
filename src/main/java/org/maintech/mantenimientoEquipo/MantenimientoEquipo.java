package org.maintech.mantenimientoEquipo;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.maintech.equipo.Equipo;
import org.maintech.mantenimiento.Mantenimiento;


@Entity
//@Table(name = "actividad_proveedor", catalog = "DBClassdummy")
@AssociationOverrides({
		@AssociationOverride(name = "pk.mantenimiento",
			joinColumns = @JoinColumn(name = "id_mantenimiento")),
		@AssociationOverride(name = "pk.equipo",
			joinColumns = @JoinColumn(name = "id_equipo")) })


public class MantenimientoEquipo implements java.io.Serializable {

	private MantenimientoEquipoId pk = new MantenimientoEquipoId();

	@EmbeddedId
	public MantenimientoEquipoId getPk() {
		return pk;
	}
	
	public void setPk(MantenimientoEquipoId pk) {
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
	public Equipo getEquipo () {
		return getPk().getEquipo();
	}

	public void setUsuario (Equipo equipo) {
		getPk().setEquipo(equipo);
	}

	public MantenimientoEquipo() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		MantenimientoEquipo other = (MantenimientoEquipo) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}
}