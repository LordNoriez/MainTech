package org.maintech.actividadproveedor;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.maintech.actividad.Actividad;
import org.maintech.costo.Costo;
import org.maintech.proveedor.Proveedor;

@Entity
//@Table(name = "actividad_proveedor", catalog = "DBClassdummy")
@AssociationOverrides({
		@AssociationOverride(name = "pk.actividad",
			joinColumns = @JoinColumn(name = "id_actividad")),
		@AssociationOverride(name = "pk.proveedor",
			joinColumns = @JoinColumn(name = "id_proveedor")),
		@AssociationOverride(name = "pk.costo",
			joinColumns = @JoinColumn(name = "id_costo")) })
public class ActividadProveedor implements java.io.Serializable {

	private ActividadProveedorId pk = new ActividadProveedorId();

	public ActividadProveedor() {
	}

	@EmbeddedId
	public ActividadProveedorId getPk() {
		return pk;
	}

	public void setPk(ActividadProveedorId pk) {
		this.pk = pk;
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

	public void setProveedor (Proveedor proveedor) {
		getPk().setProveedor(proveedor);
	}
	
	@Transient
	public Costo getCosto() {
		return getPk().getCosto();
	}

	public void setCosto(Costo costo) {
		getPk().setCosto(costo);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ActividadProveedor that = (ActividadProveedor) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}