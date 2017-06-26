package org.maintech.objeto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/objeto")
public class ObjetoController {
	
	@Autowired
	private ObjetoService objetoService;
	
	//@RequestMapping(value="/", method=RequestMethod.GET)
	@RequestMapping("/objeto")
	public List<Objeto> getAllObjeto() {
		return objetoService.getAllObjeto();
	}
	
	@RequestMapping("/crearObjeto")
	public ModelAndView crearMantenimiento(){
		return new ModelAndView("ObjetoCrear.html", "Crear Mantenimiento", "Crear Mantenimiento");
	}
	
	@RequestMapping("/objeto/{idObjeto}")
	public Objeto getObjeto(@PathVariable("idObjeto") Integer id){
		return objetoService.getObjeto(id);
	}
	
    @PostMapping("/objeto")
    public String addObjeto(@ModelAttribute Objeto objeto) {
    	objetoService.addObjeto(objeto);
        return "Se Ingreso Correctamente el Objeto";
    }

	@RequestMapping(method=RequestMethod.PUT, value="/objeto/{idObjeto}")
	public void updateObjeto(@RequestBody Objeto objeto, @PathVariable("idObjeto") Integer id) {
		objetoService.updateObjeto(id, objeto);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/objeto/{idObjeto}")
	public void deleteObjeto(@PathVariable Integer id){
		objetoService.deleteObjeto(id);
	}
	
	public List<Objeto> checkTimeObject () {
		List<Objeto> objetos = objetoService.getAllObjeto();
		List<Objeto> proximos = new ArrayList<Objeto>();
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		for(Objeto obj : objetos){
			try {
				if (obj.getTiempoMante() != null) {
					if (formatter.parse(obj.getTiempoMante()).getTime() < System.currentTimeMillis()) {
						proximos.add(obj);
					}
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return proximos;
				
	}
}
