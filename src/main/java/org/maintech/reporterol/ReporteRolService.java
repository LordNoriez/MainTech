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

	public void deleteReporteRol(Integer idReporte, Integer idRol) {
		reporteRolRepository.delete(reporteRolRepository.findByIds(idReporte, idRol));		
	}
	
	public String[] getAllCorreos(String reporte){
		
		List<String> corrs = reporteRolRepository.getAllCorreos(reporte);
		
		String[] correos = new String[corrs.size()];
		
		int i = 0;

		for (String correo : corrs) {
			correos[i] = correo;
			i++;
		}
		return correos;
	}
}
