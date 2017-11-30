package org.maintech.objetoactividad;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.maintech.actividad.Actividad;
import org.maintech.objeto.Objeto;

@Embeddable
public class ObjetoActividadId implements java.io.Serializable {

	private Objeto objeto;
    private Actividad actividad;
    
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

        ObjetoActividadId that = (ObjetoActividadId) o;

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