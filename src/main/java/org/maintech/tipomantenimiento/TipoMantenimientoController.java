package org.maintech.tipomantenimiento;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.maintech.objeto.Objeto;
import org.maintech.objeto.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TipoMantenimientoController {
	
	@Autowired
	private TipoMantenimientoService mantenimientoService;
	
	
	@RequestMapping("/tipomantenimiento")
	public List<TipoMantenimiento> getAllMantenimiento() {
		return mantenimientoService.getAllMantenimiento();
	}
		
	@RequestMapping("/tipomantenimiento/{idMantenimiento}")
	public TipoMantenimiento getMantenimiento(@PathVariable("idMantenimiento") Integer id){
		return mantenimientoService.getMantenimiento(id);
	}
	
	@RequestMapping("/creartipoMantenimiento")
	public ModelAndView crearMantenimiento(){
		return new ModelAndView("MantenimientoCrear.xhtml", "Crear Mantenimiento", "Crear Mantenimiento");
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addTipoMantenimiento")
	public void addMantenimiento(@RequestBody TipoMantenimiento mantenimiento) {
		mantenimientoService.addMantenimiento(mantenimiento);
	}
	


	@RequestMapping(method=RequestMethod.PUT, value="/Tipomantenimiento/{idMantenimiento}")
	public void updateMantenimiento(@RequestBody TipoMantenimiento mantenimiento, @PathVariable("idMantenimiento") Integer id) {
		mantenimientoService.updateMantenimiento(id, mantenimiento);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Tipomantenimiento/{idMantenimiento}")
	public void deleteMantenimiento(@PathVariable Integer id){
		mantenimientoService.deleteMantenimiento(id);
	}

	@RequestMapping("/TipomantenimientoDelete/{id}")
	public String urlDeleteMantenimiento(@PathVariable("id") Integer id){
		mantenimientoService.deleteMantenimiento(id);
		return "Mantenimiento Eliminado!";
	}
}
