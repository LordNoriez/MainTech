package org.maintech.tipomantenimiento;

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
public class TipoMantenimientoController {
	
	@Autowired
	private TipoMantenimientoService tipoMantenimientoService;
	
	//Funciones CRUD 
	@RequestMapping(value = "/tipoMantenimiento", method = RequestMethod.GET)
	public String showAllTipoMantenimiento(Model model) {
		model.addAttribute("tipomantenimientos", tipoMantenimientoService.getAllMantenimiento());
		return "TipoMantenimiento/TipoMantenimientoRead";

	}
	
	@RequestMapping("/crearTipoMantenimiento")
	public String crearTipoMantenimiento(@ModelAttribute("crearModelTipoMantenimiento") TipoMantenimiento tipomantenimiento,
			BindingResult result, Model model){
		return "TipoMantenimiento/TipoMantenimientoCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addTipoMantenimiento")
	public ModelAndView addTipomantenimiento(TipoMantenimiento tipomantenimiento) {
		tipomantenimiento.setActive(true);
		tipoMantenimientoService.addMantenimiento(tipomantenimiento);;
		return new ModelAndView("redirect:/tipoMantenimiento");
	}
			
	@RequestMapping("/tipoMantenimiento/{idtipomantenimiento}")
	public String getTipoMantenimientoUpdate(@PathVariable("idtipomantenimiento") Integer id,Model model){
		model.addAttribute("tipoMantenimiento", tipoMantenimientoService.getMantenimiento(id));
		return "TipoMantenimiento/TipoMantenimientoUpdate";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/tipomantenimientoupdate/{idtipomantenimiento}")
	public ModelAndView updateTipoMantenimiento(TipoMantenimiento tipomantenimiento, @PathVariable("idtipomantenimiento") Integer id) {
		tipomantenimiento.setIdTipoMantenimiento(id);
		tipomantenimiento.setActive(true);
		tipoMantenimientoService.updateTipoMantenimiento(id, tipomantenimiento);
		return new ModelAndView("redirect:/tipoMantenimiento");
	}
	
	@RequestMapping(value="/tipomantenimientodelete/{idtipomantenimiento}")
	public ModelAndView deactiveTipoMantenimiento(@PathVariable("idtipomantenimiento") Integer id) {
		tipoMantenimientoService.softDeleteTipoMantenimiento(id);
		return new ModelAndView("redirect:/tipoMantenimiento");
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/tipoMantenimiento/{idMantenimiento}")
	public void deleteMantenimiento(@PathVariable Integer id){
		tipoMantenimientoService.deleteMantenimiento(id);
	}
}
