package org.maintech.reporte;

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
public class ReporteController {
	
	@Autowired
	private ReporteService reporteService;
	
	//Funciones CRUD 
	@RequestMapping(value = "/Reporte", method = RequestMethod.GET)
	public String showAllReporte(Model model) {
		model.addAttribute("Reportes", reporteService.getAllReporte());
		return "reporte/ReporteRead";

	}
	
	@RequestMapping("/crearReporte")
	public String crearReporte(@ModelAttribute("crearModelReporte") Reporte reporte,
			BindingResult result, Model model){
		return "reporte/ReporteCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addReporte")
	public ModelAndView addReporte(Reporte reporte) {
		reporte.setActive(true);
		reporteService.addReporte(reporte);
		return new ModelAndView("redirect:/Reporte");
	}
			
	@RequestMapping("/Reporte/{idReporte}")
	public String getReporteUpdate(@PathVariable("idReporte") Integer id,Model model){
		model.addAttribute("Reportes", reporteService.getReporte(id));
		return "reporte/ReporteUpdate";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Reporteupdate/{idReporte}")
	public ModelAndView updateReporte(Reporte reporte, @PathVariable("idReporte") Integer id) {
		reporte.setIdReporte(id);
		reporte.setActive(true);
		reporteService.updateReporte(id, reporte);
		return new ModelAndView("redirect:/Reporte");
	}
	
	@RequestMapping(value="/Reportedelete/{idReporte}")
	public ModelAndView deactiveTipoMovimiento(@PathVariable("idReporte") Integer id) {
		reporteService.softDeleteReporte(id);
		return new ModelAndView("redirect:/Reporte");
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/Reporte/{idReporte}")
	public void deleteReporte(@PathVariable Integer id){
		reporteService.deleteReporte(id);
	}
}
