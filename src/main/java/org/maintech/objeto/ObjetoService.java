package org.maintech.objeto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetoService {
	
	@Autowired
	private ObjetoRepository objetoRepository;
	
	public List<Objeto> getAllObjeto(){
		List<Objeto> objetos = new ArrayList<>();
		objetoRepository.findAll()
		.forEach(objetos::add);
		return objetos;
	}
	
	public Objeto getObjeto (Integer id) {
		return objetoRepository.findOne(id);
	}

	public void addObjeto(Objeto objeto) {		
		objetoRepository.save(objeto);
	}

	public void updateObjeto(Integer id, Objeto objeto) {		
		objetoRepository.save(objeto);		
	}

	public void deleteObjeto(Integer id) {
		objetoRepository.delete(id);
	}

	public void softDeleteObjeto(Integer id) {
		objetoRepository.softDeleteObjeto(id);
	}
	
	public Integer UltimoObjetoId() {
		return objetoRepository.UltimoObjetoId();
	}
	
	public void Link(Integer idActividad, Integer idObjeto){
		objetoRepository.LinkActividad_objeto(idActividad, idObjeto);
	}
}
