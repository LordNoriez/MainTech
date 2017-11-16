package org.maintech.mantenimiento;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

	public void addMantenimiento(Mantenimiento mantenimiento) {
		mantenimientoRepository.save(mantenimiento);
	}

	public void updateMantenimiento(Integer id, Mantenimiento mantenimiento) {
		mantenimientoRepository.save(mantenimiento);
	}
	
	public void sofDeleteMantenimiento(Integer id) {
		mantenimientoRepository.softDeleteMantenimiento(id);
	}

	public void deleteMantenimiento(Integer id) {
		mantenimientoRepository.delete(id);
	}
	
	public List<Object[]> CostoMantenimiento() {
		List<Object[]> mantenimientos = new ArrayList<>();
		mantenimientoRepository.CostosMantenimiento().forEach(mantenimientos::add);
		return mantenimientos;
	}
	
	public List<Mantenimiento> MantenimientoEmergente() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date fechaHoy = new Date();
		List<Mantenimiento> mantenimientos = new ArrayList<>();
		mantenimientoRepository.findByIsProgramadoMantenimientoFalse().forEach(mantenimientos::add);
		return mantenimientos;
	}
	
	public List<Object[]> MantenimientoRevisionFrecuenciaxTiempo() {

		List<Object[]> mantenimientos = new ArrayList<>();
		mantenimientoRepository.MantenimientoxTiempo().forEach(mantenimientos::add);
		return mantenimientos;
	}
}
