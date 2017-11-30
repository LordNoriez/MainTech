package org.maintech.MantenimientoObjetoActividad;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.maintech.actividad.Actividad;
import org.maintech.mantenimiento.Mantenimiento;
import org.maintech.objeto.Objeto;
import org.maintech.proveedor.Proveedor;

@Embeddable
public class MantenimientoObjetoActividadId implements java.io.Serializable {

	private Mantenimiento mantenimiento;
	private Objeto objeto;
    private Actividad actividad;
    private Proveedor proveedor;
    
	@ManyToOne
	public Mantenimiento getMantenimiento () {
		return mantenimiento;
	}

	public void setMantenimiento (Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
    
	@ManyToOne
	public Objeto getObjeto () {
		return objeto;
	}

	public void setObjeto (Objeto objeto) {
		this.objeto = objeto;
	}
	
	@ManyToOne
	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	@ManyToOne
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actividad == null) ? 0 : actividad.hashCode());
		result = prime * result + ((mantenimiento == null) ? 0 : mantenimiento.hashCode());
		result = prime * result + ((objeto == null) ? 0 : objeto.hashCode());
		result = prime * result + ((proveedor == null) ? 0 : proveedor.hashCode());
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
		MantenimientoObjetoActividadId other = (MantenimientoObjetoActividadId) obj;
		if (actividad == null) {
			if (other.actividad != null)
				return false;
		} else if (!actividad.equals(other.actividad))
			return false;
		if (mantenimiento == null) {
			if (other.mantenimiento != null)
				return false;
		} else if (!mantenimiento.equals(other.mantenimiento))
			return false;
		if (objeto == null) {
			if (other.objeto != null)
				return false;
		} else if (!objeto.equals(other.objeto))
			return false;
		if (proveedor == null) {
			if (other.proveedor != null)
				return false;
		} else if (!proveedor.equals(other.proveedor))
			return false;
		return true;
	}

//	public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        MantenimientoObjetoActividadId that = (MantenimientoObjetoActividadId) o;
//        
//        if (mantenimiento != null ? !mantenimiento.equals(that.mantenimiento) : that.mantenimiento != null) return false;
//        if (actividad != null ? !actividad.equals(that.actividad) : that.actividad != null) return false;
//        if (objeto != null ? !objeto.equals(that.objeto) : that.objeto != null) return false;
//        if (proveedor != null ? !proveedor.equals(that.proveedor) : that.proveedor != null) return false;
//
//        return true;
//    }
	
	
	
//    public int hashCode() {
//        int result;
//        result = (actividad != null ? actividad.hashCode() : 0);
//        result = 31 * result + (objeto != null ? objeto.hashCode() : 0);
//        return result;
//    }

}