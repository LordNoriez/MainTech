package org.maintech.movimiento;


import org.maintech.objeto.ObjetoService;
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
public class MovimientoController {
	
	@Autowired
	private ObjetoService objetoService;
	
	@Autowired
	private MovimientoService movimientoService;
	
	@RequestMapping(value = "/Movimiento", method = RequestMethod.GET)
	public String getAllMovimiento(Model model) {
		model.addAttribute("movimientos", movimientoService.getAllMovimiento());
		return "Movimiento/MovimientoRead";
	}
	
	@RequestMapping("/Movimiento/{idMovimiento}")
	public String getMovimientoUpdate(@PathVariable("idMovimiento") Integer id,Model model){
		model.addAttribute("movimiento", movimientoService.getMovimiento(id));
		return "Movimiento/MovimientoUpdate";
	}
	
	@RequestMapping("/crearMovimiento")
	public String crearMovimiento(@ModelAttribute("crearModelMovimiento") Movimiento movimiento,
			BindingResult result, Model model){
		model.addAttribute("objetosPadre", objetoService.getAllObjeto());
		return "Movimiento/MovimientoCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addMovimiento")
	public ModelAndView addMovimiento(Movimiento movimiento) {
		movimiento.setActive(true);
		movimientoService.addMovimiento(movimiento);
		return new ModelAndView("redirect:/Movimiento");
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateMovimiento/{idMovimiento}")
	public ModelAndView updateMovimiento(Movimiento movimiento, @PathVariable("idMovimiento") Integer id) {
		movimiento.setActive(true);
		movimientoService.updateMovimiento(id, movimiento);
		return new ModelAndView("redirect:/Movimiento");
	}
	
	@RequestMapping(value="/deleteMovimiento/{idMovimiento}")
	public ModelAndView deactiveMovimiento(@PathVariable("idMovimiento") Integer id) {
		movimientoService.sofDeleteMovimiento(id);
		return new ModelAndView("redirect:/Movimiento");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Movimiento/{idMovimiento}")
	public void deleteMovimiento(@PathVariable Integer id){
		movimientoService.deleteMovimiento(id);
	}
}
