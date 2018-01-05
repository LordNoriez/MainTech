package org.maintech.reporterol;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;
import org.maintech.reporte.Reporte;
import org.maintech.rol.Rol;

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "pk.reporte",
			joinColumns = @JoinColumn(name = "id_reporte")),
		@AssociationOverride(name = "pk.rol",
			joinColumns = @JoinColumn(name = "id_rol")) })
public class ReporteRol implements java.io.Serializable {
	
	private ReporteRolId pk = new ReporteRolId();

	public ReporteRol() {
	}

	@EmbeddedId
	public ReporteRolId getPk() {
		return pk;
	}

	public void setPk(ReporteRolId pk) {
		this.pk = pk;
	}

	@Transient
	public Reporte getReporte () {
		return getPk().getReporte();
	}

	public void setReporte (Reporte reporte) {
		getPk().setReporte(reporte);
	}
	
	@Transient
	public Rol getRol () {
		return getPk().getRol();
	}

	public void setRol (Rol rol) {
		getPk().setRol(rol);
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
		ReporteRol other = (ReporteRol) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}
		
}