package org.maintech.objetoActividad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.maintech.actividad.Actividad;
import org.maintech.objeto.Objeto;


@Embeddable
public class ObjetoActividadId implements Serializable { 
 
    private Objeto objeto;
 
    private Actividad actividad;

    @ManyToOne(cascade = CascadeType.ALL)
	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
}
