package org.maintech.actividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActividadController {
	
	@Autowired
	private ActividadService ActividadService;
	
	@RequestMapping("/actividad")
	public List<Actividad> getAllActividad() {
		return ActividadService.getAllActividad();
	}
		
	@RequestMapping("/actividad/{idActividad}")
	public Actividad getActividad(@PathVariable("idActividad") Integer id){
		return ActividadService.getActividad(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/actividad")
	public void addActividad(@RequestBody Actividad actividad) {
		ActividadService.addActividad(actividad);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/actividad/{idActividad}")
	public void updateActividad(@RequestBody Actividad actividad, @PathVariable("idActividad") Integer id) {
		ActividadService.updateActividad(id, actividad);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/actividad/{idActividad}")
	public void deleteActividad(@PathVariable Integer id){
		ActividadService.deleteActividad(id);
	}
}
