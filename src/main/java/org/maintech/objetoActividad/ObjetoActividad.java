package org.maintech.objetoactividad;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.maintech.actividad.Actividad;
import org.maintech.objeto.Objeto;

@Entity
//@Table(name = "actividad_proveedor", catalog = "DBClassdummy")
@AssociationOverrides({
		@AssociationOverride(name = "pk.actividad",
			joinColumns = @JoinColumn(name = "id_actividad")),
		@AssociationOverride(name = "pk.proveedor",
			joinColumns = @JoinColumn(name = "id_proveedor")) })
public class ObjetoActividad implements java.io.Serializable {

	private ObjetoActividadId pk = new ObjetoActividadId();

	public ObjetoActividad() {
	}

	@EmbeddedId
	public ObjetoActividadId getPk() {
		return pk;
	}

	public void setPk(ObjetoActividadId pk) {
		this.pk = pk;
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

		ObjetoActividad that = (ObjetoActividad) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}