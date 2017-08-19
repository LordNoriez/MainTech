package org.maintech.areaempresa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaEmpresaService {

	@Autowired
	private AreaEmpresaRepository areaEmpresaRepository;

	public List<AreaEmpresa> getAllMantenimiento() {
		List<AreaEmpresa> mantenimientos = new ArrayList<>();
		areaEmpresaRepository.findAll().forEach(mantenimientos::add);
		return mantenimientos;
	}

	public AreaEmpresa getMantenimiento(Integer id) {
		return areaEmpresaRepository.findOne(id);
	}

	public void addMantenimiento(AreaEmpresa mantenimiento) {
		areaEmpresaRepository.save(mantenimiento);
	}

	public void updateMantenimiento(Integer id, AreaEmpresa mantenimiento) {
		areaEmpresaRepository.save(mantenimiento);
	}

	public void deleteMantenimiento(Integer id) {
		areaEmpresaRepository.delete(id);
	}
}
