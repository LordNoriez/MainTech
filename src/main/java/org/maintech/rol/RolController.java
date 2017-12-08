package org.maintech.rol;

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
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@RequestMapping(value = "/rol", method = RequestMethod.GET)
	public String showAllRol(Model model) {

		model.addAttribute("roles", rolService.getAllRol());
		return "Rol/RolRead";
	}
		
	@RequestMapping("/rol/{idRol}")
	public String getRolUpdate(@PathVariable("idRol") Integer id, Model model){		
		model.addAttribute("rol", rolService.getRol(id));
		return "Rol/RolUpdate";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addRol")
	public ModelAndView addRol(Rol rol) {
		rol.setActive(true);
		rolService.addRol(rol);
		return new ModelAndView("redirect:/rol");
	}

	@RequestMapping(method=RequestMethod.PUT, value="/updateRol/{idRol}")
	public ModelAndView updateRol(Rol rol, @PathVariable("idRol") Integer id) {
		rol.setActive(true);
		rolService.updateRol(id, rol);
		return new ModelAndView("redirect:/rol");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/rol/{idRol}")
	public void deleteRol(@PathVariable Integer id){
		rolService.deleteRol(id);
	}
	
	@RequestMapping(value="/deleteRol/{idRol}")
	public ModelAndView deactiveRol(@PathVariable("idRol") Integer id) {
		rolService.softDeleteRol(id);
		return new ModelAndView("redirect:/rol");
	}

	@RequestMapping("/crearRol")
	public String crearRol(@ModelAttribute("crearModelRol") Rol rol,
			BindingResult result, Model model){
		return "Rol/RolCrear";
	}
}
