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
public class ObjetoController {
	
	@Autowired
	private ObjetoService topicService;
	
	@RequestMapping("/objeto")
	public List<Objeto> getAllObjeto() {
		return topicService.getAllObjeto();
	}
	
	@RequestMapping("/objeto/crear")
	public ModelAndView objetoCrear() {
		
		return new ModelAndView("pagObjetoCrear.xhtml","WelcomeMessage","Message");
	}
		
	@RequestMapping("/objeto/{idObjeto}")
	public Objeto getObjeto(@PathVariable("idObjeto") Integer id){
		return topicService.getObjeto(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/objeto")
	public void addObjeto(@RequestBody Objeto topic) {
		topicService.addObjeto(topic);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/objeto/{idObjeto}")
	public void updateObjeto(@RequestBody Objeto topic, @PathVariable("idObjeto") Integer id) {
		topicService.updateObjeto(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/objeto/{idObjeto}")
	public void deleteObjeto(@PathVariable Integer id){
		topicService.deleteObjeto(id);
	}
}
