package org.maintech.areaempresa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaEmpresaService {

	@Autowired
	private AreaEmpresaRepository areaEmpresaRepository;

	public List<AreaEmpresa> getAllAreaEmpresa() {
		List<AreaEmpresa> mantenimientos = new ArrayList<>();
		areaEmpresaRepository.findAll().forEach(mantenimientos::add);
		return mantenimientos;
	}

	public AreaEmpresa getAreaEmpresa(Integer id) {
		return areaEmpresaRepository.findOne(id);
	}

	public void addAreaEmpresa(AreaEmpresa mantenimiento) {
		areaEmpresaRepository.save(mantenimiento);
	}

	public void updateAreaEmpresa(Integer id, AreaEmpresa areaEmpresa) {
		areaEmpresaRepository.save(areaEmpresa);
	}
	
	public void sofDeleteAreaEmpresa(Integer id) {
		areaEmpresaRepository.softDeleteAreaEmpresa(id);
	}

	public void deleteAreaEmpresa(Integer id) {
		areaEmpresaRepository.delete(id);
	}
}
