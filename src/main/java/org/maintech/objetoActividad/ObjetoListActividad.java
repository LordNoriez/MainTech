package org.maintech.objetoActividad;


import java.util.List;

import org.maintech.actividad.Actividad;

public class ObjetoListActividad {


	private List<Actividad> actividades;

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public ObjetoListActividad(List<Actividad> actividades) {
		super();
		this.actividades = actividades;
	}
	
	public ObjetoListActividad() {

	}
}