package org.maintech.rol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	public List<Rol> getAllRol() {
		List<Rol> rols = new ArrayList<>();
		rolRepository.findAll().forEach(rols::add);
		return rols;
	}
	
	public Rol getRol(Integer id) {
		return rolRepository.findOne(id);
	}

	public void addRol(Rol topic) {		
		rolRepository.save(topic);
	}

	public void updateRol(Integer id, Rol topic) {		
		rolRepository.save(topic);
	}

	public void deleteRol(Integer id) {
		rolRepository.delete(id);
	}
	
	public void softDeleteRol(Integer id) {
		rolRepository.softDeleteRol(id);
	}
}
