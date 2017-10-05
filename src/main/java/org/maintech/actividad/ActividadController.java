package org.maintech.actividad;


import org.maintech.objeto.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActividadController {
	
	@Autowired
	private ObjetoService objetoService;
	
	@Autowired
	private ActividadService ActividadService;
		
	@RequestMapping(value = "/actividad", method = RequestMethod.GET)
	public String getAllActividad(Model model) {

		model.addAttribute("actividades", ActividadService.getAllActividad());
		return "Actividad/ActividadRead";

	}
	
	@RequestMapping("/actividad/{idActividad}")
	public String getMantenimientoUpdate(@PathVariable("idActividad") Integer id,Model model){
		model.addAttribute("VarActividad", ActividadService.getActividad(id));
		return "Actividad/ActividadUpdate";
	}
	
	@RequestMapping("/crearActividad")
	public String crearActividad(@ModelAttribute("crearModelActividad") Actividad actividad,
			BindingResult result, Model model){
		model.addAttribute("objetosPadre", objetoService.getAllObjeto());
		return "Actividad/ActividadCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addActividad")
	public ModelAndView addActividad(Actividad actividad) {
		actividad.setActive(true);
		ActividadService.addActividad(actividad);
		return new ModelAndView("redirect:/actividad");
	}

	@RequestMapping(method=RequestMethod.PUT, value="/actividad/{idActividad}")
	public void updateActividad(@RequestBody Actividad actividad, @PathVariable("idActividad") Integer id) {
		ActividadService.updateActividad(id, actividad);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateActividad/{idActividad}")
	public ModelAndView updateMantenimiento(Actividad actividad, @PathVariable("idActividad") Integer id) {
		actividad.setActive(true);
		ActividadService.updateActividad(id, actividad);
		return new ModelAndView("redirect:/actividad");
	}
	
	@RequestMapping(value="/deleteActividad/{idActividad}")
	public ModelAndView deactiveMantenimiento(@PathVariable("idActividad") Integer id) {
		ActividadService.sofDeleteActividad(id);
		return new ModelAndView("redirect:/actividad");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/actividad/{idActividad}")
	public void deleteActividad(@PathVariable Integer id){
		ActividadService.deleteActividad(id);
	}
}
