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

	public void addObjeto(Objeto topic) {		
		objetoRepository.save(topic);
	}

	public void updateObjeto(Integer id, Objeto topic) {		
		objetoRepository.save(topic);
	}

	public void deleteObjeto(Integer id) {
		objetoRepository.delete(id);
	}
}
