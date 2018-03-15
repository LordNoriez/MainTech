package org.maintech.mantenimientoEpp;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.maintech.epp.Epp;
import org.maintech.mantenimiento.Mantenimiento;


@Embeddable
public class MantenimientoEppId implements java.io.Serializable {
	
	
	private Mantenimiento mantenimiento;
	
	private Epp epp;
	
	@ManyToOne
	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}
	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
	
	@ManyToOne
	public Epp getEpp() {
		return epp;
	}
	public void setEpp(Epp equipo) {
		this.epp = equipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((epp == null) ? 0 : epp.hashCode());
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
		MantenimientoEppId other = (MantenimientoEppId) obj;
		if (epp == null) {
			if (other.epp != null)
				return false;
		} else if (!epp.equals(other.epp))
			return false;
		if (mantenimiento == null) {
			if (other.mantenimiento != null)
				return false;
		} else if (!mantenimiento.equals(other.mantenimiento))
			return false;
		return true;
	}
}