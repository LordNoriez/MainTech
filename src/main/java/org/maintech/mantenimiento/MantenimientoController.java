package org.maintech.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MantenimientoController {
	
	@Autowired
	private MantenimientoService mantenimientoService;
	
	@RequestMapping("/mantenimiento")
	public List<Mantenimiento> getAllObjeto() {
		return mantenimientoService.getAllMantenimiento();
	}
		
	@RequestMapping("/mantenimiento/{idMantenimiento}")
	public Mantenimiento getMantenimiento(@PathVariable("idMantenimiento") Integer id){
		return mantenimientoService.getMantenimiento(id);
	}
	
	@RequestMapping("/crearMantenimiento")
	public ModelAndView crearMantenimiento(){
		return new ModelAndView("MantenimientoCrear.xhtml", "Crear Mantenimiento", "Crear Mantenimiento");
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addMantenimiento")
	public void addMantenimiento(@RequestBody Mantenimiento mantenimiento) {
		mantenimientoService.addMantenimiento(mantenimiento);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/mantenimiento/{idMantenimiento}")
	public void updateMantenimiento(@RequestBody Mantenimiento mantenimiento, @PathVariable("idMantenimiento") Integer id) {
		mantenimientoService.updateMantenimiento(id, mantenimiento);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/mantenimiento/{idMantenimiento}")
	public void deleteMantenimiento(@PathVariable Integer id){
		mantenimientoService.deleteMantenimiento(id);
	}
}
