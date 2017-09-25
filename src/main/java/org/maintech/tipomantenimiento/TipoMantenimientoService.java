package org.maintech.tipomantenimiento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoMantenimientoService {

	@Autowired
	private TipoMantenimientoRepository tipomantenimientoRepository;

	public List<TipoMantenimiento> getAllMantenimiento() {
		List<TipoMantenimiento> tipomantenimientos = new ArrayList<>();
		tipomantenimientoRepository.findAll().forEach(tipomantenimientos::add);
		return tipomantenimientos;
	}

	public TipoMantenimiento getMantenimiento(Integer id) {
		return tipomantenimientoRepository.findOne(id);
	}

	public void addMantenimiento(TipoMantenimiento tipomantenimiento) {
		tipomantenimientoRepository.save(tipomantenimiento);
	}

	public void updateTipoMantenimiento(Integer id, TipoMantenimiento tipomantenimiento) { 
		tipomantenimientoRepository.save(tipomantenimiento);
	}

	public void deleteMantenimiento(Integer id) {
		tipomantenimientoRepository.delete(id);
	}

	public void softDeleteTipoMantenimiento(Integer id) {
		tipomantenimientoRepository.softDeleteTipoMantenimiento(id);
		
	}
}
