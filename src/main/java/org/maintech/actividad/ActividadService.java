package org.maintech.actividad;

import java.util.ArrayList;
import java.util.List;

import org.maintech.actividadproveedor.ActividadProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadService {
	
	@Autowired
	private ActividadRepository actividadRepository;
	
	public List<Actividad> getAllActividad(){
		List<Actividad> actividades = new ArrayList<>();
		actividadRepository.findAll()
		.forEach(actividades::add);
		return actividades;
	}
	
	public Actividad getActividad (Integer id) {
		return actividadRepository.findOne(id);
	}

	public void addActividad(Actividad actividad) {		
		actividadRepository.save(actividad);
	}

	public void updateActividad(Integer id, Actividad actividad) {		
		actividadRepository.save(actividad);
	}
	
	
	public void sofDeleteActividad(Integer id) {
		actividadRepository.softDeleteActividad(id);
	}

	public void deleteActividad(Integer id) {
		actividadRepository.delete(id);
	}
	
	public Actividad getLastActividad () {
		return actividadRepository.findLast();
	}
	
	public List<Object> getActividadesProveedores(){
		return actividadRepository.getActividadesProveedores();
	}
	
	public Integer getCostoActividad(Integer id){
		return actividadRepository.getCostoActividad(id);
	}
	
	public Integer getProveedorActividad(Integer id) {
		return actividadRepository.getProveedorActividad(id);
	}
	
	public ActividadProveedor getActividadProveedor(Integer idAct, Integer idProv, Integer idControl) {
		return actividadRepository.getActividadProveedor(idAct, idProv, idControl);
	}
}
