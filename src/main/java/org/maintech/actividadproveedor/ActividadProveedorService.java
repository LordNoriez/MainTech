package org.maintech.actividadproveedor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadProveedorService {
	
	@Autowired
	private ActividadProveedorRepository actividadProveedorRepository;
	
	public List<ActividadProveedor> getAllActividadProveedor(){
		List<ActividadProveedor> actividadProveedores = new ArrayList<>();
		actividadProveedorRepository.findAll()
		.forEach(actividadProveedores::add);
		return actividadProveedores;
	}
	
	public ActividadProveedor getActividadProveedor (Integer id) {
		return actividadProveedorRepository.findOne(id);
	}

	public void addActividadProveedor (ActividadProveedor actividadProveedor) {		
		actividadProveedorRepository.save(actividadProveedor);
	}

	public void updateActividadProveedor (Integer id, ActividadProveedor actividadProveedor) {		
		actividadProveedorRepository.save(actividadProveedor);		
	}

	public void deleteActividadProveedor (Integer id) {
		actividadProveedorRepository.delete(id);
	}

	public void softDeleteActividadProveedor (Integer id) {
		actividadProveedorRepository.softDeleteActividadProveedor(id);
	}
	
	public List<Object[]> getActividadProveedorCosto(){
		return actividadProveedorRepository.getActividadProveedorCosto();
	}

	public Object[] getProvCostxAct(Integer id) {
		return actividadProveedorRepository.getProvCostxAct(id);
		 
	}
		
}
