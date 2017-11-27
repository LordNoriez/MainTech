package org.maintech.proveedor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	public List<Proveedor> getAllProveedores(){
		List<Proveedor> proveedores = new ArrayList<>();
		proveedorRepository.findAll()
		.forEach(proveedores::add);
		return proveedores;
	}
	
	public Proveedor getProveedor (Integer id) {
		return proveedorRepository.findOne(id);
	}

	public void addProveedor(Proveedor proveedor) {		
		proveedorRepository.save(proveedor);
	}

	public void updateProveedor(Integer id, Proveedor proveedor) {		
		proveedorRepository.save(proveedor);		
	}

	public void deleteProveedor(Integer id) {
		proveedorRepository.delete(id);
	}

	public void softDeleteProveedor(Integer id) {
		proveedorRepository.softDeleteProveedor(id);
	}
	
}
