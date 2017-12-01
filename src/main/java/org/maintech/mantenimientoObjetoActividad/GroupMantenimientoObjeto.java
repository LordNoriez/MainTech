package org.maintech.mantenimientoObjetoActividad;

import java.util.List;

import org.maintech.actividad.Actividad;
import org.maintech.actividadproveedor.ActividadProveedor;
import org.maintech.proveedor.Proveedor;

public class GroupMantenimientoObjeto {
	
	private Integer mantenimientos;
	private Integer idobjeto;
	//private List<ActividadProveedor> actividadesProveedores;
	private List<Actividad> actividades;
	private List<Proveedor> Proveedores;
	
	public Integer getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(Integer mantenimientos) {
		this.mantenimientos = mantenimientos;
	}
	
	public Integer getIdobjeto() {
		return idobjeto;
	}

	public void setIdobjeto(Integer idobjeto) {
		this.idobjeto = idobjeto;
	}
	

//	public List<ActividadProveedor> getActividadesProveedores() {
//		return actividadesProveedores;
//	}
//
//	public void setActividadesProveedores(List<ActividadProveedor> actividadesProveedores) {
//		this.actividadesProveedores = actividadesProveedores;
//	}
	
	

	public GroupMantenimientoObjeto() {
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public List<Proveedor> getProveedores() {
		return Proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		Proveedores = proveedores;
	}

	public GroupMantenimientoObjeto(Integer mantenimientos, Integer idobjeto, List<Actividad> actividades,
			List<Proveedor> proveedores) {
		super();
		this.mantenimientos = mantenimientos;
		this.idobjeto = idobjeto;
		this.actividades = actividades;
		Proveedores = proveedores;
	}

//	public GroupMantenimientoObjeto(Integer mantenimientos, Integer idobjeto,
//			List<ActividadProveedor> actividadesProveedores) {
//		super();
//		this.mantenimientos = mantenimientos;
//		this.idobjeto = idobjeto;
//		this.actividadesProveedores = actividadesProveedores;
//	}

	

	
	
}
