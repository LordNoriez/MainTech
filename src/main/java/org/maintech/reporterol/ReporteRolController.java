package org.maintech.reporterol;

import org.maintech.reporte.ReporteService;
import org.maintech.rol.RolService;
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
public class ReporteRolController {
	
	@Autowired
	private ReporteRolService reporteRolService;

	@Autowired
	private ReporteService reporteService;

	@Autowired
	private RolService rolService;
	
	//Funciones CRUD 
	@RequestMapping(value = "/reporteRol", method = RequestMethod.GET)
	public String showAllReporteRol(Model model) {
		model.addAttribute("reportesRol", reporteRolService.getAllReporteRol());
		return "ReporteRol/ReporteRolRead";

	}
	
	@RequestMapping("/crearReporteRol")
	public String crearReporteRol(@ModelAttribute("crearModelReporteRol") ReporteRol reporteRol,
			BindingResult result, Model model){

		model.addAttribute("reportes", reporteService.getAllReporte());
		model.addAttribute("roles", rolService.getAllRol());
		return "ReporteRol/ReporteRolCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addReporteRol")
	public ModelAndView addReporteRol(ReporteRol reporteRol) {
		
		reporteRolService.addReporteRol(reporteRol);
		return new ModelAndView("redirect:/reporteRol");
	}
			
	@RequestMapping("/reporteRol/{idReporteRol}")
	public String getReporteRolUpdate(@PathVariable("idReporteRol") Integer id,Model model){
		model.addAttribute("reportesRol", reporteRolService.getReporteRol(id));
		return "ReporteRol/ReporteRolUpdate";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/reporteRolUpdate/{idReporteRol}")
	public ModelAndView updateReporteRol(ReporteRol reporteRol, @PathVariable("idReporteRol") Integer id) {
		
		reporteRolService.updateReporteRol(id, reporteRol);
		return new ModelAndView("redirect:/reporteRol");
	}
	
	@RequestMapping(value="/reporteRolDelete/{idReporteRol}")
	public ModelAndView deactiveReporteRol(@PathVariable("idReporteRol") Integer id) {
		reporteRolService.deleteReporteRol(id);
		return new ModelAndView("redirect:/reporteRol");
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/reporteRol/{idReporteRol}")
	public void deleteReporte(@PathVariable Integer id){
		reporteRolService.deleteReporteRol(id);
	}
}
