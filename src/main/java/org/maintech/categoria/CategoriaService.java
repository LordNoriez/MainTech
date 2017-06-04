package org.maintech.categoria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAllCategoria(){
		List<Categoria> categorias = new ArrayList<>();
		categoriaRepository.findAll()
		.forEach(categorias::add);
		return categorias;
	}
	
	public Categoria getCategoria (Integer id) {
		return categoriaRepository.findOne(id);
	}

	public void addCategoria(Categoria topic) {		
		categoriaRepository.save(topic);
	}

	public void updateCategoria(Integer id, Categoria topic) {		
		categoriaRepository.save(topic);
	}

	public void deleteCategoria(Integer id) {
		categoriaRepository.delete(id);
	}
}
