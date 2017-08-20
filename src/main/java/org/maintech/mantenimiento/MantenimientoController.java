package org.maintech.mantenimiento;

import java.util.List;

import org.maintech.objeto.ObjetoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
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
	public String crearMantenimiento(){
		return "MantenimientoCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addMantenimiento")
	public void addMantenimiento(@RequestBody Mantenimiento mantenimiento) {
		mantenimientoService.addMantenimiento(mantenimiento);
	}
	
// done for project crocker :D
//	@RequestMapping(value="/cMantenimiento")
//	public List<Mantenimiento>  addMantnmailProvider() {
//		
//		
//		Mantenimiento mat = new Mantenimiento();
//				
//		Date now = new Date();
//		
//        System.out.println(" 7 ");
//        Integer x= 8;
//		for (Objeto objeto : objetoController.checkTimeObject(1)) {
//			System.out.println(objeto.getMarcaObjeto() + " " + objeto.getDescripcionObjeto() + " " + objeto.getTiempoMante());
//			mat.setNombreMantenimiento("Limpieza " + x);
//			mat.setObjeto(objeto);
//			mat.setDescripcionMantenimiento("Limpieza exterior");
//			mat.setFechaMantenimiento(now);
//			mat.setActive(true);
//			mantenimientoService.addMantenimiento(mat);		
//			System.out.println(x);
//			x++;
//		}
//
//		return mantenimientoService.getAllMantenimiento();
//	
//	}

	@RequestMapping(method=RequestMethod.PUT, value="/mantenimiento/{idMantenimiento}")
	public void updateMantenimiento(@RequestBody Mantenimiento mantenimiento, @PathVariable("idMantenimiento") Integer id) {
		mantenimientoService.updateMantenimiento(id, mantenimiento);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/mantenimiento/{idMantenimiento}")
	public void deleteMantenimiento(@PathVariable Integer id){
		mantenimientoService.deleteMantenimiento(id);
	}

	@RequestMapping("/eliminarMantenimiento/{id}")
	public String urlDeleteMantenimiento(@PathVariable("id") Integer id){
		mantenimientoService.deleteMantenimiento(id);
		return "Mantenimiento Eliminado!";
	}
}
