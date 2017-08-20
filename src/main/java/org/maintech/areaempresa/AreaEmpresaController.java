package org.maintech.areaempresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AreaEmpresaController {
	
	@Autowired
	private AreaEmpresaService mantenimientoService;
	
	
	@RequestMapping("/areaEmpresa")
	public List<AreaEmpresa> getAllMantenimiento() {
		return mantenimientoService.getAllMantenimiento();
	}
		
	@RequestMapping("/areaEmpresa/{idMantenimiento}")
	public AreaEmpresa getMantenimiento(@PathVariable("idMantenimiento") Integer id){
		return mantenimientoService.getMantenimiento(id);
	}
	
	@RequestMapping("/crearAreaEmpresa")
	public String crearMantenimiento(){
		return "MantenimientoCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addAreaEmpresa")
	public void addMantenimiento(@RequestBody AreaEmpresa mantenimiento) {
		mantenimientoService.addMantenimiento(mantenimiento);
	}
	


	@RequestMapping(method=RequestMethod.PUT, value="/areaEmpresa/{idMantenimiento}")
	public void updateMantenimiento(@RequestBody AreaEmpresa mantenimiento, @PathVariable("idMantenimiento") Integer id) {
		mantenimientoService.updateMantenimiento(id, mantenimiento);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/areaEmpresa/{idMantenimiento}")
	public void deleteMantenimiento(@PathVariable Integer id){
		mantenimientoService.deleteMantenimiento(id);
	}

	@RequestMapping("/eliminarAreaEmpresa/{id}")
	public String urlDeleteMantenimiento(@PathVariable("id") Integer id){
		mantenimientoService.deleteMantenimiento(id);
		return "Área Empresa Eliminado!";
	}
}
