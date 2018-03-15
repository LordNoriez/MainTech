package org.maintech.epp;

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
public class EppController {
	
	@Autowired
	private EppService eppService;

	@Autowired
	private RolService rolService;
	
	@Autowired
	private AreaEmpresaService areaEmpresaService;
	
	@RequestMapping(value = "/epp", method = RequestMethod.GET)
	public String showAllEpp(Model model) {
		model.addAttribute("Epps", eppService.getAllEpp());
		return "Epp/EppRead";
	}
		
	@RequestMapping("/epp/{idEpp}")
	public String getEquipo(@PathVariable("idEpp") Integer id, Model model){		
		model.addAttribute("Epps", eppService.getEpp(id));
		return "Epp/EppUpdate";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addEpp")
	public ModelAndView addEpp(Epp epp) {
		epp.setActive(true);
		eppService.addEpp(epp);
		return new ModelAndView("redirect:/epp");
	}

	@RequestMapping(method=RequestMethod.PUT, value="/eppUpdate/{idEpp}")
	public ModelAndView updateEpp(Epp epp, @PathVariable("idEpp") Integer id) {
		epp.setActive(true);
		eppService.updateEpp(id, epp);
		return new ModelAndView("redirect:/epp");
	}
		
	@RequestMapping(value="/deleteEpp/{idEpp}")
	public ModelAndView deactiveEquipo(@PathVariable("idEpp") Integer id) {
		eppService.softDeleteEpp(id);
		return new ModelAndView("redirect:/epp");
	}

	@RequestMapping("/crearEpp")
	public String crearEquipo(@ModelAttribute("crearModelEpp") Epp epp,
			BindingResult result, Model model){	
		return "Epp/EppCrear";
	}
}
