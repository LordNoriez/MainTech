package org.maintech.actividadproveedor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.maintech.actividad.Actividad;
import org.maintech.costo.Costo;
import org.maintech.proveedor.Proveedor;

@Embeddable
public class ActividadProveedorId implements java.io.Serializable {

	private Actividad actividad;
    private Proveedor proveedor;
    private Costo costo;

	@ManyToOne
	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	@ManyToOne
	public Proveedor getProveedor () {
		return proveedor;
	}

	public void setProveedor (Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@ManyToOne
	public Costo getCosto () {
		return costo;
	}

	public void setCosto (Costo costo) {
		this.costo = costo;
	}

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActividadProveedorId that = (ActividadProveedorId) o;

        if (actividad != null ? !actividad.equals(that.actividad) : that.actividad != null) return false;
        if (proveedor != null ? !proveedor.equals(that.proveedor) : that.proveedor != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (actividad != null ? actividad.hashCode() : 0);
        result = 31 * result + (proveedor != null ? proveedor.hashCode() : 0);
        return result;
    }

}