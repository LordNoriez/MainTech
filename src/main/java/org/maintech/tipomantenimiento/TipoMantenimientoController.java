package org.maintech.tipomantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TipoMantenimientoController {
	
	@Autowired
	private TipoMantenimientoService mantenimientoService;
	
	
	@RequestMapping("/tipoMantenimiento")
	public List<TipoMantenimiento> getAllMantenimiento() {
		return mantenimientoService.getAllMantenimiento();
	}
		
	@RequestMapping("/tipoMantenimiento/{idMantenimiento}")
	public TipoMantenimiento getMantenimiento(@PathVariable("idMantenimiento") Integer id){
		return mantenimientoService.getMantenimiento(id);
	}
	
	@RequestMapping("/crearTipoMantenimiento")
	public String crearMantenimiento(){
		return "MantenimientoCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addTipoMantenimiento")
	public void addMantenimiento(@RequestBody TipoMantenimiento mantenimiento) {
		mantenimientoService.addMantenimiento(mantenimiento);
	}
	


	@RequestMapping(method=RequestMethod.PUT, value="/tipoMantenimiento/{idMantenimiento}")
	public void updateMantenimiento(@RequestBody TipoMantenimiento mantenimiento, @PathVariable("idMantenimiento") Integer id) {
		mantenimientoService.updateMantenimiento(id, mantenimiento);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/tipoMantenimiento/{idMantenimiento}")
	public void deleteMantenimiento(@PathVariable Integer id){
		mantenimientoService.deleteMantenimiento(id);
	}

	@RequestMapping("/eliminarTipoMantenimiento/{id}")
	public String urlDeleteMantenimiento(@PathVariable("id") Integer id){
		mantenimientoService.deleteMantenimiento(id);
		return "Mantenimiento Eliminado!";
	}
}
