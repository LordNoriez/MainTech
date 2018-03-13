package org.maintech.equipo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	public List<Equipo> getAllEquipo() {
		List<Equipo> equipos = new ArrayList<>();
		equipoRepository.findAll().forEach(equipos::add);
		return equipos;
	}
	
	public Equipo getEquipo(Integer id) {
		return equipoRepository.findOne(id);
	}

	public void addEquipo(Equipo topic) {		
		equipoRepository.save(topic);
	}

	public void updateEquipo(Integer id, Equipo topic) {		
		equipoRepository.save(topic);
	}

	public void deleteEquipo(Integer id) {
		equipoRepository.delete(id);
	}
	
	public void softDeleteEquipo(Integer id) {
		equipoRepository.softDeleteEquipo(id);
	}
}
