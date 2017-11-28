package org.maintech.tipomovimiento;

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
public class TipoMovimientoController {
	
	@Autowired
	private TipoMovimientoService tipoMovimientoService;
	
	//Funciones CRUD 
	@RequestMapping(value = "/TipoMovimiento", method = RequestMethod.GET)
	public String showAllTipoMovimiento(Model model) {
		model.addAttribute("tipomovimientos", tipoMovimientoService.getAllTipoMovimiento());
		return "tipomovimiento/TipoMovimientoRead";

	}
	
	@RequestMapping("/crearTipoMovimiento")
	public String crearTipoMovimiento(@ModelAttribute("crearModelTipoMovimiento") TipoMovimiento tipoMovimiento,
			BindingResult result, Model model){
		return "tipomovimiento/TipoMovimientoCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addTipoMovimiento")
	public ModelAndView addTipoMovimiento(TipoMovimiento tipoMovimiento) {
		tipoMovimiento.setActive(true);
		tipoMovimientoService.addTipoMovimiento(tipoMovimiento);
		return new ModelAndView("redirect:/TipoMovimiento");
	}
			
	@RequestMapping("/TipoMovimiento/{idTipoMovimiento}")
	public String getTipoMovimientoUpdate(@PathVariable("idTipoMovimiento") Integer id,Model model){
		model.addAttribute("TipoMovimiento", tipoMovimientoService.getTipoMovimiento(id));
		return "tipomovimiento/TipoMovimientoUpdate";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/tipomovimientoupdate/{idtipomovimiento}")
	public ModelAndView updateTipoMovimiento(TipoMovimiento tipoMovimiento, @PathVariable("idtipomovimiento") Integer id) {
		tipoMovimiento.setIdTipoMovimiento(id);
		tipoMovimiento.setActive(true);
		tipoMovimientoService.updateTipoMovimiento(id, tipoMovimiento);
		return new ModelAndView("redirect:/TipoMovimiento");
	}
	
	@RequestMapping(value="/tipomovimientodelete/{idtipomovimiento}")
	public ModelAndView deactiveTipoMovimiento(@PathVariable("idtipomovimiento") Integer id) {
		tipoMovimientoService.softDeleteTipoMantenimiento(id);
		return new ModelAndView("redirect:/TipoMovimiento");
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/TipoMovimiento/{idTipoMovimiento}")
	public void deleteTipoMovimiento(@PathVariable Integer id){
		tipoMovimientoService.deleteMantenimiento(id);
	}
}
