package org.maintech.reporterol;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.maintech.reporte.Reporte;
import org.maintech.rol.Rol;

@Embeddable
public class ReporteRolId implements java.io.Serializable {

	private Reporte reporte;
    private Rol rol;
    
    
    @ManyToOne
	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}
	
	@ManyToOne
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reporte == null) ? 0 : reporte.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
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
		ReporteRolId other = (ReporteRolId) obj;
		if (reporte == null) {
			if (other.reporte != null)
				return false;
		} else if (!reporte.equals(other.reporte))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}
}