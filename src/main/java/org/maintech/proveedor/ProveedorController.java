package org.maintech.proveedor;

import java.security.Principal;

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
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;    
    
	@RequestMapping(value = "/proveedor", method = RequestMethod.GET)
	public String showAllProveedores(Model model) {

		model.addAttribute("proveedores", proveedorService.getAllProveedores());
		return "Proveedor/ProveedorRead";

	}
	
	@RequestMapping("/crearProveedor")
	public String crearProveedor(@ModelAttribute("crearModelProveedor") Proveedor proveedor, 
			BindingResult result, Model model, Principal principal){
				
		return "Proveedor/ProveedorCrear";
	}
	
	@RequestMapping("/proveedor/{idProveedor}")
	public String getProveedorUpdate(@PathVariable("idProveedor") Integer id,Model model){
		model.addAttribute("proveedor", proveedorService.getProveedor(id));
		return "Proveedor/ProveedorUpdate";
	}
	
    
	@RequestMapping(method=RequestMethod.POST, value="/proveedor") 	
	public ModelAndView addProveedor(Proveedor proveedor) {
		proveedor.setActive(true);
		proveedorService.addProveedor(proveedor);
		return new ModelAndView("redirect:/proveedor");
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateProveedor/{idProveedor}")
	public ModelAndView updateProveedor(Proveedor proveedor, @PathVariable("idProveedor") Integer id) {
		proveedor.setActive(true);
		proveedorService.updateProveedor(id, proveedor);
		return new ModelAndView("redirect:/proveedor");
	}
	
	@RequestMapping(value="/deleteProveedor/{idProveedor}")
	public ModelAndView deactiveProveedor(@PathVariable("idProveedor") Integer id) {
		proveedorService.softDeleteProveedor(id);
		return new ModelAndView("redirect:/proveedor");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/proveedor/{idProveedor}")
	public void deleteProveedor(@PathVariable Integer id){
		proveedorService.deleteProveedor(id);
	}
}
