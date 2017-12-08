package org.maintech.areaempresa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class AreaEmpresaController {
	
	@Autowired
	private AreaEmpresaService areaEmpresaService;
	
	
	@RequestMapping(value = "/areaEmpresa", method = RequestMethod.GET)
	public String showAllAreaEmpresa(Model model) {

		model.addAttribute("areaEmpresa", areaEmpresaService.getAllAreaEmpresa());
		return "AreaEmpresa/AreaEmpresaRead";

	}
	
	@RequestMapping("/areaEmpresa/{idAreaEmpresa}")
	public String getAreaEmpresaUpdate(@PathVariable("idAreaEmpresa") Integer id,Model model){
		model.addAttribute("ModelAreaEmpresa", areaEmpresaService.getAreaEmpresa(id));
		return "AreaEmpresa/AreaEmpresaUpdate";
	}
	
	@RequestMapping("/crearAreaEmpresa")
	public String crearAreaEmpresa(@ModelAttribute("crearModelAreaEmpresa") AreaEmpresa areaEmpresa,
			BindingResult result, Model model){
		return "AreaEmpresa/AreaEmpresaCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addAreaEmpresa")
	public ModelAndView addAreaEmpresa(AreaEmpresa areaEmpresa) {
		areaEmpresa.setActive(true);
		areaEmpresaService.addAreaEmpresa(areaEmpresa);
		return new ModelAndView("redirect:/areaEmpresa");
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/areaEmpresaUpdate/{idAreaEmpresa}")
	public ModelAndView updateAreaEmpresa(AreaEmpresa areaEmpresa, @PathVariable("idAreaEmpresa") Integer id) {
		areaEmpresa.setActive(true);
		areaEmpresaService.updateAreaEmpresa(id, areaEmpresa);
		return new ModelAndView("redirect:/areaEmpresa");
	}	
	
	@RequestMapping(value="/deleteAreaEmpresa/{idAreaEmpresa}")
	public ModelAndView deactiveAreaEmpresa(@PathVariable("idAreaEmpresa") Integer id) {
		areaEmpresaService.sofDeleteAreaEmpresa(id);
		return new ModelAndView("redirect:/areaEmpresa");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/areaEmpresa/{idMantenimiento}")
	public void deleteAreaEmpresa(@PathVariable Integer id){
		areaEmpresaService.deleteAreaEmpresa(id);
	}

}
