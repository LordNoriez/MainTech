package org.maintech.costo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostoService {
	
	@Autowired
	private CostoRepository costoRepository;
	
	public List<Costo> getAllCostos(){
		List<Costo> costos = new ArrayList<>();
		costoRepository.findAll()
		.forEach(costos::add);
		return costos;
	}
	
	public Costo getCosto (Integer id) {
		return costoRepository.findOne(id);
	}

	public void addCosto (Costo costo) {		
		costoRepository.save(costo);
	}

	public void updateCosto (Integer id, Costo costo) {		
		costoRepository.save(costo);		
	}

	public void deleteCosto (Integer id) {
		costoRepository.delete(id);
	}

	public void softDeleteCosto (Integer id) {
		costoRepository.softDeleteCosto(id);
	}
	
}
