package org.maintech.actividadproveedor;

import java.security.Principal;

import org.maintech.actividad.ActividadService;
import org.maintech.costo.CostoService;
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
public class ActividadProveedorController {
	
	@Autowired
	private ActividadProveedorService actividadProveedorService;
	
	@Autowired
	private ActividadService actividadService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private CostoService costoService;
    
	@RequestMapping(value = "/actividadProveedor", method = RequestMethod.GET)
	public String showAllActividadProveedores(Model model) {

		model.addAttribute("actividadProveedores", actividadProveedorService.getAllActividadProveedor());
		model.addAttribute("actividades", actividadService.getAllActividad());
		model.addAttribute("proveedores", proveedorService.getAllProveedores());
		model.addAttribute("costos", costoService.getAllCostos());
		return "ActividadProveedor/ActividadProveedorRead";
	}
	
	@RequestMapping("/crearActividadProveedor")
	public String crearActividadProveedor(@ModelAttribute("crearModelActividadProveedor") ActividadProveedor actividadProveedor, 
			BindingResult result, Model model, Principal principal){

		model.addAttribute("actividades", actividadService.getAllActividad());
		model.addAttribute("proveedores", proveedorService.getAllProveedores());
		model.addAttribute("costos", costoService.getAllCostos());
		 
		return "ActividadProveedor/ActividadProveedorCrear";
	}
	
	@RequestMapping("/actividadProveedor/{idActividadProveedor}")
	public String getActividadProveedorUpdate(@PathVariable("idActividadProveedor") Integer id,Model model){

		model.addAttribute("actividadProveedores", actividadProveedorService.getAllActividadProveedor());
		model.addAttribute("actividades", actividadService.getAllActividad());
		model.addAttribute("proveedores", proveedorService.getAllProveedores());
		model.addAttribute("costos", costoService.getAllCostos());
		 
		return "ActividadProveedor/ActividadProveedorUpdate";
	}
    
	@RequestMapping(method=RequestMethod.POST, value="/addActividadProveedor")
	public ModelAndView addActividadProveedor(ActividadProveedor actividadProveedor) {
		
		actividadProveedorService.addActividadProveedor(actividadProveedor);
		return new ModelAndView("redirect:/actividad");
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateActividadProveedor/{idActividadProveedor}")
	public ModelAndView updateObjeto(ActividadProveedor actividadProveedor, @PathVariable("idActividadProveedor") Integer id) {
		
		actividadProveedorService.updateActividadProveedor(id, actividadProveedor);
		return new ModelAndView("redirect:/actividadProveedor");
	}
	
	@RequestMapping(value="/deleteActividadProveedor/{idActividadProveedor}")
	public ModelAndView deactiveObjeto(@PathVariable("idActividadProveedor") Integer id) {
		actividadProveedorService.softDeleteActividadProveedor(id);
		return new ModelAndView("redirect:/actividadProveedor");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/actividadProveedor/{idActividadProveedor}")
	public void deleteObjeto(@PathVariable Integer id){
		actividadProveedorService.deleteActividadProveedor(id);
	}

}
