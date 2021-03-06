package org.maintech.mantenimientoObjetoActividad;

import java.util.List;

import javax.persistence.Column;

import org.maintech.actividad.Actividad;
import org.maintech.proveedor.Proveedor;

public class GroupMantenimientoObjeto {
	
	private Integer mantenimientos;
	private Integer idobjeto;
	//private List<ActividadProveedor> actividadesProveedores;
	private List<Actividad> actividades;
	private List<Proveedor> Proveedores;
	private List<Integer> ListIdActividades;
	private Integer ListIdProveedor;
	private List<String> ListIdActividadProveedor;

	@Column(columnDefinition="tinyint(1) default 0")
	private Integer CantidadMantenimiento;

	public Integer getCantidadMantenimiento() {
		return CantidadMantenimiento;
	}

	public void setCantidadMantenimiento(Integer cantidadMantenimiento) {
		CantidadMantenimiento = cantidadMantenimiento;
	}
	
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

	public List<Integer> getListIdActividades() {
		return ListIdActividades;
	}

	public void setListIdActividades(List<Integer> listIdActividades) {
		ListIdActividades = listIdActividades;
	}

	public Integer getListIdProveedor() {
		return ListIdProveedor;
	}

	public void setListIdProveedor(Integer listIdProveedor) {
		ListIdProveedor = listIdProveedor;
	}

	public List<String> getListIdActividadProveedor() {
		return ListIdActividadProveedor;
	}

	public void setListIdActividadProveedor(List<String> listIdActividadProveedor) {
		ListIdActividadProveedor = listIdActividadProveedor;
	}

	public GroupMantenimientoObjeto(Integer mantenimientos, Integer idobjeto, List<Actividad> actividades,
			List<Proveedor> proveedores, List<Integer> listIdActividades, Integer listIdProveedor,
			List<String> listIdActividadProveedor, Integer cantidadMantenimiento) {
		super();
		this.mantenimientos = mantenimientos;
		this.idobjeto = idobjeto;
		this.actividades = actividades;
		Proveedores = proveedores;
		ListIdActividades = listIdActividades;
		ListIdProveedor = listIdProveedor;
		ListIdActividadProveedor = listIdActividadProveedor;
		this.CantidadMantenimiento = cantidadMantenimiento;
	}
}
