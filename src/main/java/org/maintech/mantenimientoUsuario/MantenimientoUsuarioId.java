package org.maintech.mantenimientoUsuario;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.maintech.mantenimiento.Mantenimiento;
import org.maintech.usuario.Usuario;

@Embeddable
public class MantenimientoUsuarioId implements java.io.Serializable {
	
	
	private Mantenimiento mantenimiento;
	
	private Usuario usuario;
	
	@ManyToOne
	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}
	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
	
	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mantenimiento == null) ? 0 : mantenimiento.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		MantenimientoUsuarioId other = (MantenimientoUsuarioId) obj;
		if (mantenimiento == null) {
			if (other.mantenimiento != null)
				return false;
		} else if (!mantenimiento.equals(other.mantenimiento))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}