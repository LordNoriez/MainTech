package org.maintech.objetoActividad;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.Where;
import org.maintech.actividad.Actividad;
import org.maintech.objeto.Objeto;

@Entity
@Where(clause="is_active=1")
public class ObjetoActividad {
 
    @EmbeddedId
    private ObjetoActividadId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("objeto_id")
    private Objeto objetoMantenimiento;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("actividad_id")
    private Actividad objActividad;
 
    @Column(name = "created_on")
    private String createdOn = new String();
  
    
    
    public ObjetoActividadId getId() {
		return id;
	}

	public void setId(ObjetoActividadId id) {
		this.id = id;
	}

	public Objeto getObjetoMantenimiento() {
		return objetoMantenimiento;
	}

	public void setObjetoMantenimiento(Objeto objetoMantenimiento) {
		this.objetoMantenimiento = objetoMantenimiento;
	}

	public Actividad getObjActividad() {
		return objActividad;
	}

	public void setObjActividad(Actividad objActividad) {
		this.objActividad = objActividad;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	public ObjetoActividad() {
	}

	public ObjetoActividad(ObjetoActividadId id, Objeto objetoMantenimiento, Actividad objActividad, String createdOn) {
		super();
		this.id = id;
		this.objetoMantenimiento = objetoMantenimiento;
		this.objActividad = objActividad;
		this.createdOn = createdOn;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        ObjetoActividad that = (ObjetoActividad) o;
        return Objects.equals(objetoMantenimiento, that.objetoMantenimiento) &&
               Objects.equals(objActividad, that.objActividad);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(objetoMantenimiento, objActividad);
    }
}