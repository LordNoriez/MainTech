package org.maintech.mantenimiento;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.maintech.objeto.Objeto;
import org.maintech.objeto.ObjetoController;
import org.maintech.objeto.ObjetoService;
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
	
	@Autowired
	private ObjetoController objetoController;
	
	@RequestMapping("/mantenimiento")
	public List<Mantenimiento> getAllMantenimiento() {
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
	

	@RequestMapping(value="/cMantenimiento")
	public List<Mantenimiento>  addMantnmailProvider() {
		
		
		Mantenimiento mat = new Mantenimiento();
				
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 1); //minus number would decrement the days
		
		
		for (Objeto objeto : objetoController.checkTimeObject()) {
			System.out.println(objeto.getTiempoMante().toString());
			mat.setNombreMantenimiento("Limpieza");
			mat.setObjeto(objeto);
			mat.setDescripcionMantenimiento("Limpieza exterior");
			mat.setFechaMantenimiento(cal.getTime());
			mat.setActive(true);
			mantenimientoService.addMantenimiento(mat);			
		}

		return mantenimientoService.getAllMantenimiento();
	
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
