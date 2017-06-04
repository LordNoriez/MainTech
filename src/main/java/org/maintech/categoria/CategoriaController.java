package org.maintech.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/categoria")
	public List<Categoria> getAllCategoria() {
		return categoriaService.getAllCategoria();
	}
		
	@RequestMapping("/categoria/{idObjeto}")
	public Categoria getCategoria(@PathVariable("idCategoria") Integer id){
		return categoriaService.getCategoria(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/categoria")
	public void addCategoria(@RequestBody Categoria categoria) {
		categoriaService.addCategoria(categoria);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/categoria/{idCategoria}")
	public void updateCategoria(@RequestBody Categoria categoria, @PathVariable("idCategoria") Integer id) {
		categoriaService.updateCategoria(id, categoria);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/categoria/{idCategoria}")
	public void deleteCategoria(@PathVariable Integer id){
		categoriaService.deleteCategoria(id);
	}
}
