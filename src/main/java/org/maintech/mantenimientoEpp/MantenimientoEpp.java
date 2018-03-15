package org.maintech.mantenimientoEpp;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.maintech.epp.Epp;
import org.maintech.mantenimiento.Mantenimiento;


@Entity
//@Table(name = "actividad_proveedor", catalog = "DBClassdummy")
@AssociationOverrides({
		@AssociationOverride(name = "pk.mantenimiento",
			joinColumns = @JoinColumn(name = "id_mantenimiento")),
		@AssociationOverride(name = "pk.epp",
			joinColumns = @JoinColumn(name = "id_epp")) })


public class MantenimientoEpp implements java.io.Serializable {

	private MantenimientoEppId pk = new MantenimientoEppId();

	@EmbeddedId
	public MantenimientoEppId getPk() {
		return pk;
	}
	
	public void setPk(MantenimientoEppId pk) {
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
	public Epp getEpp () {
		return getPk().getEpp();
	}

	public void setEpp (Epp epp) {
		getPk().setEpp(epp);
	}

	public MantenimientoEpp() {
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
		MantenimientoEpp other = (MantenimientoEpp) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}
}