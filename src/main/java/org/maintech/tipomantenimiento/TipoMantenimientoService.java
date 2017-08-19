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
		List<TipoMantenimiento> mantenimientos = new ArrayList<>();
		tipomantenimientoRepository.findAll().forEach(mantenimientos::add);
		return mantenimientos;
	}

	public TipoMantenimiento getMantenimiento(Integer id) {
		return tipomantenimientoRepository.findOne(id);
	}

	public void addMantenimiento(TipoMantenimiento mantenimiento) {
		tipomantenimientoRepository.save(mantenimiento);
	}

	public void updateMantenimiento(Integer id, TipoMantenimiento mantenimiento) {
		tipomantenimientoRepository.save(mantenimiento);
	}

	public void deleteMantenimiento(Integer id) {
		tipomantenimientoRepository.delete(id);
	}
}
