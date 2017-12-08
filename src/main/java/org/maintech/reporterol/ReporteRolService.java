package org.maintech.reporterol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteRolService {

	@Autowired
	private ReporteRolRepository reporteRolRepository;

	public List<ReporteRol> getAllReporteRol() {
		List<ReporteRol> reportesRol = new ArrayList<>();
		reporteRolRepository.findAll().forEach(reportesRol::add);
		return reportesRol;
	}

	public ReporteRol getReporteRol(Integer id) {
		return reporteRolRepository.findOne(id);
	}

	public void addReporteRol(ReporteRol reporteRol) {
		reporteRolRepository.save(reporteRol);
	}

	public void updateReporteRol(Integer id, ReporteRol reporteRol) { 
		reporteRolRepository.save(reporteRol);
	}

	public void deleteReporteRol(Integer id) {
		reporteRolRepository.delete(id);
	}
	
	public String[] getAllCorreos(String reporte){
		return reporteRolRepository.getAllCorreos(reporte);
	}
}
