package org.maintech.movimiento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoService {
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	public List<Movimiento> getAllMovimiento(){
		List<Movimiento> movimientos = new ArrayList<>();
		movimientoRepository.findAll()
		.forEach(movimientos::add);
		return movimientos;
	}
	
	public Movimiento getMovimiento(Integer id) {
		return movimientoRepository.findOne(id);
	}

	public void addMovimiento(Movimiento movimiento) {		
		movimientoRepository.save(movimiento);
	}

	public void updateMovimiento(Integer id, Movimiento movimiento) {		
		movimientoRepository.save(movimiento);
	}
	
	
	public void sofDeleteMovimiento(Integer id) {
		movimientoRepository.softDeleteMovimiento(id);
	}

	public void deleteMovimiento(Integer id) {
		movimientoRepository.delete(id);
	}

	public Integer getCantidadInventario(Integer categoryId) {
		return	movimientoRepository.CantidadInventario(categoryId);
		
	}
	
	public List<Object[]> getFullMovimiento () {
		return movimientoRepository.getFullMovimiento();
	}
}
