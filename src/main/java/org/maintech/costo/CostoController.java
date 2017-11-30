package org.maintech.costo;

import java.security.Principal;

import org.maintech.actividad.Actividad;
import org.maintech.actividad.ActividadService;
import org.maintech.actividadproveedor.ActividadProveedor;
import org.maintech.proveedor.ProveedorService;
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
public class CostoController {
	
	@Autowired
	private CostoService costoService;    

	@Autowired
	private ActividadService actividadService;   
	
	@Autowired
	private ProveedorService proveedorService;
    
	@RequestMapping(value = "/costo", method = RequestMethod.GET)
	public String showAllCostos(Model model) {

		model.addAttribute("costos", costoService.getAllCostos());
		return "Costo/CostoRead";

	}
	
	@RequestMapping("/crearCosto")
	public String crearCosto(@ModelAttribute("crearModelCosto") Costo costo, 
			BindingResult result, Model model, Principal principal){
				
		return "Costo/CostoCrear";
	}
	
	@RequestMapping("/costo/{idCosto}")
	public String getCostoUpdate(@PathVariable("idCosto") Integer id,Model model){
		model.addAttribute("costo", costoService.getCosto(id));
		return "Costo/CostoUpdate";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addCosto") 	
	public String addCosto(Costo costo, @ModelAttribute("crearModelActividadProveedor") ActividadProveedor actividadProveedor, 
			BindingResult result, Model model, Principal principal) {
		
		costo.setActive(true);
		costoService.addCosto(costo);
		model.addAttribute("costo", costo);
		model.addAttribute("actividad", actividadService.getLastActividad());
		model.addAttribute("proveedores", proveedorService.getAllProveedores());
		return "ActividadProveedor/ActividadProveedorCrear";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateCosto/{idCosto}")
	public ModelAndView updateCosto(Costo costo, @PathVariable("idCosto") Integer id) {
		costo.setActive(true);
		costoService.updateCosto(id, costo);
		return new ModelAndView("redirect:/costo");
	}
	
	@RequestMapping(value="/deleteCosto/{idCosto}")
	public ModelAndView deactiveCosto(@PathVariable("idCosto") Integer id) {
		costoService.softDeleteCosto(id);
		return new ModelAndView("redirect:/costo");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/costo/{idCosto}")
	public void deleteCosto(@PathVariable Integer id){
		costoService.deleteCosto(id);
	}
}
