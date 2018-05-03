package org.maintech.actividad;


import java.security.Principal;
import java.util.List;

import org.maintech.actividadproveedor.ActividadProveedorService;
import org.maintech.costo.Costo;
import org.maintech.costo.CostoService;
import org.maintech.objeto.ObjetoService;
import org.maintech.proveedor.ProveedorService;
import org.maintech.usuario.UsuarioController;
import org.maintech.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActividadController {
	
	@Autowired
	private ObjetoService objetoService;
	
	@Autowired
	private ActividadService ActividadService;
	
	@Autowired
	private CostoService costoService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private ActividadProveedorService actividadProveedorService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioController usuarioController;
	
	@RequestMapping(value = "/actividad", method = RequestMethod.GET)
	public String getAllActividad(Model model) {
		model.addAttribute("actividades", ActividadService.getActividadesProveedores());
		return "Actividad/ActividadRead";
	}
	
	@RequestMapping("/actualizarActividad/{idActividad}")
	public String getMantenimientoUpdate(@PathVariable("idActividad") Integer id,Model model){
		model.addAttribute("actividad", ActividadService.getActividad(id));
		model.addAttribute("Proveedores", proveedorService.getAllProveedores());
		//model.addAttribute("AllCostos", ActividadService.getHistCosto(id));
		model.addAttribute("ProvedorxCosto", actividadProveedorService.getProvCostxAct(id));	
		return "Actividad/ActividadUpdate";
	}
	
	@RequestMapping("/crearActividad")
	public String crearActividad(@ModelAttribute("crearModelActividad") Actividad actividad,
			BindingResult result, Model model, Principal principal){
		model.addAttribute("objetosPadre", objetoService.getAllObjeto(usuarioService.getAreaByMail(usuarioController.mailUsuario(principal))));
		return "Actividad/ActividadCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addActividad")
	public String addActividad(Actividad actividad,  @ModelAttribute("crearModelCosto") Costo costo, 
			BindingResult result, Model model, Principal principal) {
		actividad.setActive(true);
		ActividadService.addActividad(actividad);
		model.addAttribute("actividad", actividad);
		model.addAttribute("objetos", objetoService.returnAllObjeto());
		return "Costo/CostoCrear";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateActividad/{idActividad}")
	public ModelAndView updateActividad(Actividad actividad, @PathVariable("idActividad") Integer id){

		actividad.setActive(true);
		ActividadService.updateActividad(id, actividad);
		
		return new ModelAndView("redirect:/actividad");
	}
	
	@RequestMapping(value="/deleteActividad/{idActividad}")
	public ModelAndView deactiveActividad(@PathVariable("idActividad") Integer id) {
		ActividadService.sofDeleteActividad(id);
		return new ModelAndView("redirect:/actividad");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/actividad/{idActividad}")
	public void deleteActividad(@PathVariable Integer id){
		ActividadService.deleteActividad(id);
	}
	
	@RequestMapping(value = "/actcostxprov", method = RequestMethod.POST)
	public @ResponseBody
	List<Object[]> deleteUser(@RequestBody String idProveedor) {
	    // fetch the userid to be deleted from the userDetails
	    // remebmer the id of user to be deleted will be set in the ajax call

	    // again populate the user list to display on page
	    return ActividadService.getidActCostidProve(Integer.parseInt(idProveedor));
	    
	    
	}
	
	@RequestMapping(value = "/costousedxProve", method = RequestMethod.POST)
	public @ResponseBody
	List<Object[]> TblCostosUsados(@RequestParam(value = "idProveedorList") String idProveedor,
			@RequestParam(value = "idActividadList") String idActividad) {
	    // fetch the userid to be deleted from the userDetails
	    // remebmer the id of user to be deleted will be set in the ajax call

	    // again populate the user list to display on page
	    return ActividadService.getHistCosto(Integer.parseInt(idProveedor),Integer.parseInt(idActividad));
	    
	}
	
	@RequestMapping(value = "/costousedxProvedefault", method = RequestMethod.POST)
	public @ResponseBody
	List<Object[]> TblCostosUsadosDefault(@RequestParam(value = "idActividadList") String idActividad) {
	    
	    return actividadProveedorService.getProvCostxAct(Integer.parseInt(idActividad));
	    
	}
	
	
	
}
