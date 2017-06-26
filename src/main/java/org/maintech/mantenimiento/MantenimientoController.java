package org.maintech.mantenimiento;

import java.util.Date;
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
	
	@RequestMapping(method=RequestMethod.POST, value="/cMantenimiento")
	public void addMantnmailProvider(@RequestBody Mantenimiento mantenimiento) {
		mantenimiento.setNombreMantenimiento(null);
		mantenimiento.setFechaMantenimiento(null);
		mantenimiento.setDescripcionMantenimiento(null);
		mantenimiento.setActive(true);
		mantenimientoService.addMantenimiento(mantenimiento);
	}
	

	@RequestMapping("/addMantenimiento/{nombre}/{descripcion}")
	public String urlAddMantenimiento(@PathVariable("nombre") String nombre, @PathVariable("descripcion") String descripcion) {
		Mantenimiento mat = new Mantenimiento();
		mat.setNombreMantenimiento(nombre);
		mat.setDescripcionMantenimiento(descripcion);
		mat.setFechaMantenimiento(new Date());
		mat.setActive(true);
		mantenimientoService.addMantenimiento(mat);
		return "Mantenimiento Creado!";
	}

	@RequestMapping(method=RequestMethod.PUT, value="/mantenimiento/{idMantenimiento}")
	public void updateMantenimiento(@RequestBody Mantenimiento mantenimiento, @PathVariable("idMantenimiento") Integer id) {
		mantenimientoService.updateMantenimiento(id, mantenimiento);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/mantenimiento/{idMantenimiento}")
	public void deleteMantenimiento(@PathVariable Integer id){
		mantenimientoService.deleteMantenimiento(id);
	}

	@RequestMapping("/mantenimientoDelete/{id}")
	public String urlDeleteMantenimiento(@PathVariable("id") Integer id){
		mantenimientoService.deleteMantenimiento(id);
		return "Mantenimiento Eliminado!";
	}
}
