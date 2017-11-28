package org.maintech.tipomovimiento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoMovimientoService {

	@Autowired
	private TipoMovimientoRepository tipomovimientoRepository;

	public List<TipoMovimiento> getAllTipoMovimiento() {
		List<TipoMovimiento> tipoMovimientos = new ArrayList<>();
		tipomovimientoRepository.findAll().forEach(tipoMovimientos::add);
		return tipoMovimientos;
	}

	public TipoMovimiento getTipoMovimiento(Integer id) {
		return tipomovimientoRepository.findOne(id);
	}

	public void addTipoMovimiento(TipoMovimiento tipoMovimiento) {
		tipomovimientoRepository.save(tipoMovimiento);
	}

	public void updateTipoMovimiento(Integer id, TipoMovimiento tipoMovimiento) { 
		tipomovimientoRepository.save(tipoMovimiento);
	}

	public void deleteMantenimiento(Integer id) {
		tipomovimientoRepository.delete(id);
	}

	public void softDeleteTipoMantenimiento(Integer id) {
		tipomovimientoRepository.softDeleteTipoMovimiento(id);
		
	}
}
