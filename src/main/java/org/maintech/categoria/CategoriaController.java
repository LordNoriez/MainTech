package org.maintech.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	/*@RequestMapping("/categoria")
	public List<Categoria> getAllCategoria() {
		return categoriaService.getAllCategoria();
	}*/
	
	@RequestMapping(value = "/categoria", method = RequestMethod.GET)
	public String showAllCategoria(Model model) {

		model.addAttribute("categorias", categoriaService.getAllCategoria());
		return "Categoria/CategoriaRead";
	}
		
	@RequestMapping("/categoria/{idCategoria}")
	public String getCategoria(@PathVariable("idCategoria") Integer id, Model model){		
		model.addAttribute("categoria", categoriaService.getCategoria(id));
		return "Categoria/CategoriaUpdate";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addCategoria")
	public ModelAndView addCategoria(Categoria categoria) {
		categoria.setActive(true);
		categoriaService.addCategoria(categoria);
		return new ModelAndView("redirect:/categoria");
	}

	@RequestMapping(method=RequestMethod.PUT, value="/updateCategoria/{idCategoria}")
	public ModelAndView updateCategoria(Categoria categoria, @PathVariable("idCategoria") Integer id) {
		categoria.setActive(true);
		categoriaService.updateCategoria(id, categoria);
		return new ModelAndView("redirect:/categoria");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/categoria/{idCategoria}")
	public void deleteCategoria(@PathVariable Integer id){
		categoriaService.deleteCategoria(id);
	}
	
	@RequestMapping(value="/deleteCategoria/{idCategoria}")
	public ModelAndView deactiveCategoria(@PathVariable("idCategoria") Integer id) {
		categoriaService.softDeleteCategoria(id);
		return new ModelAndView("redirect:/categoria");
	}

	@RequestMapping("/crearCategoria")
	public String crearCategoria(@ModelAttribute("crearModelCategoria") Categoria categoria,
			BindingResult result, Model model){
		return "Categoria/CategoriaCrear";
	}
}
