package org.maintech.estructura;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstructuraService {

	@Autowired
	private EstructuraRepository estructuraRepository;

	public List<Estructura> getAllEstructura() {
		List<Estructura> estructuras = new ArrayList<>();
		estructuraRepository.findAll().forEach(estructuras::add);
		return estructuras;
	}

	public Estructura getEstructura(Integer id) {
		return estructuraRepository.findOne(id);
	}

	public void addEstructura(Estructura color) {
		estructuraRepository.save(color);
	}

	public void updateEstructura(Integer id, Estructura color) { 
		estructuraRepository.save(color);
	}

	public void deleteEstructura(Integer id) {
		estructuraRepository.delete(id);
	}

	public void softDeleteEstructura(Integer id) {
		estructuraRepository.softDeleteEstructura(id);
		
	}
}
