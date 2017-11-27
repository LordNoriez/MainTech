package org.maintech.MantenimientoObjetoActividad;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.maintech.actividad.Actividad;
import org.maintech.mantenimiento.Mantenimiento;
import org.maintech.objeto.Objeto;

@Embeddable
public class MantenimientoObjetoActividadId implements java.io.Serializable {

	private Mantenimiento mantenimiento;
	private Objeto objeto;
    private Actividad actividad;
    
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

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MantenimientoObjetoActividadId that = (MantenimientoObjetoActividadId) o;
        
        if (mantenimiento != null ? !mantenimiento.equals(that.mantenimiento) : that.mantenimiento != null) return false;
        if (actividad != null ? !actividad.equals(that.actividad) : that.actividad != null) return false;
        if (objeto != null ? !objeto.equals(that.objeto) : that.objeto != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (actividad != null ? actividad.hashCode() : 0);
        result = 31 * result + (objeto != null ? objeto.hashCode() : 0);
        return result;
    }

}