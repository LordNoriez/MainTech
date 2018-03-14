package org.maintech.mantenimientoEquipo;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.maintech.equipo.Equipo;
import org.maintech.mantenimiento.Mantenimiento;


@Embeddable
public class MantenimientoEquipoId implements java.io.Serializable {
	
	
	private Mantenimiento mantenimiento;
	
	private Equipo equipo;
	
	@ManyToOne
	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}
	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
	
	@ManyToOne
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + ((mantenimiento == null) ? 0 : mantenimiento.hashCode());
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
		MantenimientoEquipoId other = (MantenimientoEquipoId) obj;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		if (mantenimiento == null) {
			if (other.mantenimiento != null)
				return false;
		} else if (!mantenimiento.equals(other.mantenimiento))
			return false;
		return true;
	}
}