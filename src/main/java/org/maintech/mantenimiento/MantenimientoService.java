package org.maintech.mantenimiento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MantenimientoService {

	@Autowired
	private MantenimientoRepository mantenimientoRepository;

	public List<Mantenimiento> getAllMantenimiento() {
		List<Mantenimiento> mantenimientos = new ArrayList<>();
		mantenimientoRepository.findAll().forEach(mantenimientos::add);
		return mantenimientos;
	}

	public Mantenimiento getMantenimiento(Integer id) {
		return mantenimientoRepository.findOne(id);
	}

	public void addMantenimiento(Mantenimiento topic) {
		mantenimientoRepository.save(topic);
	}

	public void updateMantenimiento(Integer id, Mantenimiento topic) {
		mantenimientoRepository.save(topic);
	}

	public void deleteMantenimiento(Integer id) {
		mantenimientoRepository.delete(id);
	}
}
