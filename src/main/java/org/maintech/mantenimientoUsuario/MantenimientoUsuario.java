package org.maintech.mantenimientoUsuario;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.maintech.mantenimiento.Mantenimiento;
import org.maintech.objeto.Objeto;
import org.maintech.usuario.Usuario;


@Entity
//@Table(name = "actividad_proveedor", catalog = "DBClassdummy")
@AssociationOverrides({
		@AssociationOverride(name = "pk.mantenimiento",
			joinColumns = @JoinColumn(name = "id_mantenimiento")),
		@AssociationOverride(name = "pk.usuario",
			joinColumns = @JoinColumn(name = "id_usuario")) })


public class MantenimientoUsuario implements java.io.Serializable {

	private MantenimientoUsuarioId pk = new MantenimientoUsuarioId();
	
	@Column(columnDefinition="tinyint(1) default 0")
	private Boolean isAutorizadoMantenimiento;

	@Column(columnDefinition="tinyint(1) default 0")
	private Boolean isLiberadoMantenimiento;

	@EmbeddedId
	public MantenimientoUsuarioId getPk() {
		return pk;
	}
	
	public void setPk(MantenimientoUsuarioId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Mantenimiento getMantenimiento () {
		return getPk().getMantenimiento();
	}
	
	public void setMantenimiento (Mantenimiento mantenimiento) {
		getPk().setMantenimiento(mantenimiento);
	}
	
	@Transient
	public Usuario getUsuario () {
		return getPk().getUsuario();
	}

	public void setUsuario (Usuario usuario) {
		getPk().setUsuario(usuario);
	}
	
	public Boolean getIsAutorizadoMantenimiento() {
		return isAutorizadoMantenimiento;
	}

	public void setIsAutorizadoMantenimiento(Boolean isAutorizadoMantenimiento) {
		this.isAutorizadoMantenimiento = isAutorizadoMantenimiento;
	}

	
	public Boolean getIsLiberadoMantenimiento() {
		return isLiberadoMantenimiento;
	}

	public void setIsLiberadoMantenimiento(Boolean isLiberadoMantenimiento) {
		this.isLiberadoMantenimiento = isLiberadoMantenimiento;
	}

	public MantenimientoUsuario() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isAutorizadoMantenimiento == null) ? 0 : isAutorizadoMantenimiento.hashCode());
		result = prime * result + ((isLiberadoMantenimiento == null) ? 0 : isLiberadoMantenimiento.hashCode());
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
		MantenimientoUsuario other = (MantenimientoUsuario) obj;
		if (isAutorizadoMantenimiento == null) {
			if (other.isAutorizadoMantenimiento != null)
				return false;
		} else if (!isAutorizadoMantenimiento.equals(other.isAutorizadoMantenimiento))
			return false;
		if (isLiberadoMantenimiento == null) {
			if (other.isLiberadoMantenimiento != null)
				return false;
		} else if (!isLiberadoMantenimiento.equals(other.isLiberadoMantenimiento))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}
}