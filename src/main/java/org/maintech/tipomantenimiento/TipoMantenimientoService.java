package org.maintech.tipomantenimiento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoMantenimientoService {

	@Autowired
	private TipoMantenimientoRepository mantenimientoRepository;

	public List<TipoMantenimiento> getAllMantenimiento() {
		List<TipoMantenimiento> mantenimientos = new ArrayList<>();
		mantenimientoRepository.findAll().forEach(mantenimientos::add);
		return mantenimientos;
	}

	public TipoMantenimiento getMantenimiento(Integer id) {
		return mantenimientoRepository.findOne(id);
	}

	public void addMantenimiento(TipoMantenimiento mantenimiento) {
		mantenimientoRepository.save(mantenimiento);
	}

	public void updateMantenimiento(Integer id, TipoMantenimiento mantenimiento) {
		mantenimientoRepository.save(mantenimiento);
	}

	public void deleteMantenimiento(Integer id) {
		mantenimientoRepository.delete(id);
	}
}
