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
		List<Mantenimiento> mantenimientos = new ArrayList<>();
		mantenimientoRepository.findByIsProgramadoMantenimientoFalse().forEach(mantenimientos::add);
		return mantenimientos;
	}
	
	public List<Object[]> MantenimientoRevisionFrecuenciaxTiempo() {

		List<Object[]> mantenimientos = new ArrayList<>();
		mantenimientoRepository.MantenimientoxTiempo().forEach(mantenimientos::add);
		return mantenimientos;
	}
	
	public List<Mantenimiento> MantenimientoxAceptar() {
		List<Mantenimiento> mantenimientos = new ArrayList<>();
		mantenimientoRepository.MantexAceptar().forEach(mantenimientos::add);
		return mantenimientos;
	}
	
	public Integer IdUltimoMante() {
	
		return mantenimientoRepository.UltimoMantenimientoId();
		
	}
	
	public void LinkActividad_mantenimiento(Integer idActividad, Integer idMantenimiento) {
		mantenimientoRepository.LinkActividad_mantenimiento(idActividad, idMantenimiento);
	}
	
	public void DeleteLinkActividad_mantenimiento(Integer idMantenimiento) {
		mantenimientoRepository.DeleteLinkActividad_mantenimiento(idMantenimiento);
	}
	
	public void Acept_mantenimiento(Integer id) {
		mantenimientoRepository.Acept_mantenimiento(id);
	}

}
