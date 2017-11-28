package org.maintech.reporte;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteService {

	@Autowired
	private ReporteRepository reporteRepository;

	public List<Reporte> getAllReporte() {
		List<Reporte> reportes = new ArrayList<>();
		reporteRepository.findAll().forEach(reportes::add);
		return reportes;
	}

	public Reporte getReporte(Integer id) {
		return reporteRepository.findOne(id);
	}

	public void addReporte(Reporte reporte) {
		reporteRepository.save(reporte);
	}

	public void updateReporte(Integer id, Reporte reporte) { 
		reporteRepository.save(reporte);
	}

	public void deleteReporte(Integer id) {
		reporteRepository.delete(id);
	}

	public void softDeleteReporte(Integer id) {
		reporteRepository.softDeleteReporte(id);
		
	}
}
