package org.maintech.objetoActividad;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ObjetoActividadController {
		
	@Autowired
	private ObjetoActividadService objetoActividadService;
		
//	@RequestMapping(value = "/mantenimiento", method = RequestMethod.GET)
//	public String showAllMantenimientos(Model model) {
//
//		model.addAttribute("mantenimientos", objetoActividadService.getAllMantenimiento());
//		return "Mantenimiento/MantenimientoRead";
//
//	}
		

	
//	@RequestMapping("/mantenimiento/{idMantenimiento}")
//	public String getMantenimientoUpdate(@PathVariable("idMantenimiento") Integer id,Model model){
//		model.addAttribute("varMantenmiento", objetoActividadService.getMantenimiento(id));
//		model.addAttribute("Itemobjeto", objetoService.getAllObjeto());
//		model.addAttribute("ItemActividad", actividadService.getAllActividad());
//		model.addAttribute("tipos", tipoMantenimientoService.getAllMantenimiento());
//		
//		return "Mantenimiento/MantenimientoUpdate";
//	}
	
	
//	@RequestMapping("/crearMantenimiento")
//	public String crearMantenimiento(@ModelAttribute("crearModelMantenimiento") Mantenimiento mantenimiento,
//			BindingResult result, Model model){
//		model.addAttribute("Itemobjeto", objetoService.getAllObjeto());
//		model.addAttribute("ItemActividad", actividadService.getAllActividad());
//		model.addAttribute("tipos", tipoMantenimientoService.getAllMantenimiento());
//		
//		return "Mantenimiento/MantenimientoCrear";
//	}


	@RequestMapping(method=RequestMethod.POST, value="/addObjetoActividad")
	public ModelAndView addObjetoActividad(ObjetoActividad objetoActividad) {
		//objetoActividad.setActive(true);
		objetoActividadService.addObjetoActividad(objetoActividad);
		return new ModelAndView("redirect:/mantenimiento");
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateObjetoActividad/{idObjetoActividad}")
	public ModelAndView updateObjetoActividad(ObjetoActividad objetoActividad, @PathVariable("idObjetoActividad") Integer id) {
		//objetoActividad.setActive(true);
		objetoActividadService.updateObjetoActividad(id, objetoActividad);

		
		return new ModelAndView("redirect:/mantenimiento");
	}
	
	@RequestMapping(value="/deleteObjetoActividad/{idObjetoActividad}")
	public ModelAndView deactiveMantenimiento(@PathVariable("idObjetoActividad") Integer id) {
		objetoActividadService.sofDeleteObjetoActividad(id);
		return new ModelAndView("redirect:/mantenimiento");
	}

	@RequestMapping("/eliminarObjetoActividad/{id}")
	public String urlDeleteObjetoActividad(@PathVariable("id") Integer id){
		objetoActividadService.deleteObjetoActividad(id);
		return "Mantenimiento Eliminado!";
	}
	    
}
