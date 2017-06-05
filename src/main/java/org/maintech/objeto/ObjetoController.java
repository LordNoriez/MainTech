package org.maintech.objeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/objeto")
public class ObjetoController {
	
	@Autowired
	private ObjetoService objetoService;
	
	//@RequestMapping(value="/", method=RequestMethod.GET)
	@RequestMapping("/objeto")
	public List<Objeto> getAllObjeto() {
		return objetoService.getAllObjeto();
	}
	
	@RequestMapping("/crearObjeto")
	public ModelAndView objetoCrear() {
		
		return new ModelAndView("ObjetoCrear.xhtml","Crear Objeto","Crear Objeto");
	}
		
	@RequestMapping("/objeto/{idObjeto}")
	public Objeto getObjeto(@PathVariable("idObjeto") Integer id){
		return objetoService.getObjeto(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/objeto")
	public void addObjeto(@RequestBody Objeto objeto) {
		objetoService.addObjeto(objeto);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/objeto/{idObjeto}")
	public void updateObjeto(@RequestBody Objeto objeto, @PathVariable("idObjeto") Integer id) {
		objetoService.updateObjeto(id, objeto);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/objeto/{idObjeto}")
	public void deleteObjeto(@PathVariable Integer id){
		objetoService.deleteObjeto(id);
	}
}
