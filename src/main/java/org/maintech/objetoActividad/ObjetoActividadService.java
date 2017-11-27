package org.maintech.objetoActividad;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetoActividadService {

	@Autowired
	private ObjetoActividadRepository objetoActividadRepository;

	public List<ObjetoActividad> getAllObjetoActividad() {
		List<ObjetoActividad> objetosactividad = new ArrayList<>();
		objetoActividadRepository.findAll().forEach(objetosactividad::add);
		return objetosactividad;
	}

	public ObjetoActividad getObjetoActividad(Integer id) {
		return objetoActividadRepository.findOne(id);
	}

	public void addObjetoActividad(ObjetoActividad objetoActividad) {
		objetoActividadRepository.save(objetoActividad);
	}

	public void updateObjetoActividad(Integer id, ObjetoActividad objetoActividad) {
		objetoActividadRepository.save(objetoActividad);
	}
	
	public void sofDeleteObjetoActividad(Integer id) {
		objetoActividadRepository.softDeleteObjetoActividad(id);
	}

	public void deleteObjetoActividad(Integer id) {
		objetoActividadRepository.delete(id);
	}

}
