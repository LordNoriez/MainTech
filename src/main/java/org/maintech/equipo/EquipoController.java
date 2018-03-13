package org.maintech.equipo;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.maintech.areaempresa.AreaEmpresaService;
import org.maintech.rol.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EquipoController {
	
	@Autowired
	private EquipoService equipoService;

	@Autowired
	private RolService rolService;
	
	@Autowired
	private AreaEmpresaService areaEmpresaService;
	
	@RequestMapping(value = "/equipo", method = RequestMethod.GET)
	public String showAllEquipo(Model model) {
		model.addAttribute("Equipos", equipoService.getAllEquipo());
		return "Equipo/EquipoRead";
	}
		
	@RequestMapping("/equipo/{idEquipo}")
	public String getEquipo(@PathVariable("idEquipo") Integer id, Model model){		
		model.addAttribute("equipo", equipoService.getEquipo(id));
		return "Equipo/EquipoUpdate";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addEquipo")
	public ModelAndView addEquipo(Equipo equipo) {
		equipo.setActive(true);
		equipoService.addEquipo(equipo);
		return new ModelAndView("redirect:/equipo");
	}

	@RequestMapping(method=RequestMethod.PUT, value="/equipoUpdate/{idEquipo}")
	public ModelAndView updateEquipo(Equipo usuario, @PathVariable("idEquipo") Integer id) {
		usuario.setActive(true);
		equipoService.updateEquipo(id, usuario);
		return new ModelAndView("redirect:/equipo");
	}
		
	@RequestMapping(value="/deleteEquipo/{idEquipo}")
	public ModelAndView deactiveEquipo(@PathVariable("idEquipo") Integer id) {
		equipoService.softDeleteEquipo(id);
		return new ModelAndView("redirect:/equipo");
	}

	@RequestMapping("/crearEquipo")
	public String crearEquipo(@ModelAttribute("crearModelEquipo") Equipo equipo,
			BindingResult result, Model model){	
		return "Equipo/EquipoCrear";
	}
}
