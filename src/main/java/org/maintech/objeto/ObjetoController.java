package org.maintech.objeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjetoController {
	
	@Autowired
	private ObjetoService topicService;
	
	@RequestMapping("/Objeto")
	public List<Objeto> getAllObjeto() {
		return topicService.getAllObjeto();
	}
	
	@RequestMapping("/Objeto/{idObjeto}")
	public Objeto getObjeto(@PathVariable("idObjeto") Integer id){
		return topicService.getObjeto(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Objeto")
	public void addObjeto(@RequestBody Objeto topic) {
		topicService.addObjeto(topic);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/Objeto/{idObjeto}")
	public void updateObjeto(@RequestBody Objeto topic, @PathVariable("idObjeto") Integer id) {
		topicService.updateObjeto(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Objeto/{idObjeto}")
	public void deleteObjeto(@PathVariable Integer id){
		topicService.deleteObjeto(id);
	}
}
