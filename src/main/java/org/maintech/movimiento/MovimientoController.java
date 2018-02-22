package org.maintech.movimiento;


import java.security.Principal;
import java.util.Date;

import org.maintech.objeto.Objeto;
import org.maintech.objeto.ObjetoService;
import org.maintech.tipomovimiento.TipoMovimiento;
import org.maintech.tipomovimiento.TipoMovimientoService;
import org.maintech.usuario.UsuarioController;
import org.maintech.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovimientoController {
	
	@Autowired
	private ObjetoService objetoService;
	
	@Autowired
	private MovimientoService movimientoService;
	
	@Autowired
	private TipoMovimientoService tipoMovimientoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioController usuarioController;
	
	@RequestMapping(value = "/movimiento", method = RequestMethod.GET)
	public String getAllMovimiento(Model model) {
		model.addAttribute("movimientos", movimientoService.getFullMovimiento());
		return "Movimiento/MovimientoRead";
	}
	
	@RequestMapping("/movimiento/{idMovimiento}")
	public String getMovimientoUpdate(@PathVariable("idMovimiento") Integer id,Model model){
		model.addAttribute("movimiento", movimientoService.getMovimiento(id));
		return "Movimiento/MovimientoUpdate";
	}
	
	@RequestMapping("/crearMovimientoIngreso")
	public String crearMovimientoIngreso(@ModelAttribute("crearModelMovimiento") Movimiento movimiento,
			BindingResult result, Model model){
		model.addAttribute("objetos", objetoService.returnAllObjeto());
		return "Movimiento/MovimientoCrearIngreso";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addMovimientoIngreso")
	public ModelAndView addMovimientoIngreso(Movimiento movimiento) {
		movimiento.setActive(true);
		Date now = new Date();
		movimiento.setFechaMovimiento(now);
		TipoMovimiento tm = tipoMovimientoService.getTipoMovimiento(1);
		movimiento.setTipoMovimiento(tm);
		movimientoService.addMovimiento(movimiento);
		return new ModelAndView("redirect:/movimiento");
	}
	
	@RequestMapping("/crearMovimientoSalida")
	public String crearMovimientoSalida(@ModelAttribute("crearModelMovimiento") Movimiento movimiento,
			BindingResult result, Model model, Principal principal){
		model.addAttribute("objetos", objetoService.getAllObjeto(usuarioService.getAreaByMail(usuarioController.mailUsuario(principal))));
		return "Movimiento/MovimientoCrearSalida";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addMovimientoSalida")
	public ModelAndView addMovimientoSalida(Movimiento movimiento) {
		movimiento.setActive(true);
		Date now = new Date();
		movimiento.setFechaMovimiento(now);
		TipoMovimiento tm = tipoMovimientoService.getTipoMovimiento(2);
		movimiento.setTipoMovimiento(tm);
		movimientoService.addMovimiento(movimiento);
		return new ModelAndView("redirect:/movimiento");
	}
	
	@RequestMapping("/verifCantSalida/{cant}/{idObj}")
	public Boolean verifCantSalida(@PathVariable("cant") Integer cant, @PathVariable("idObj") Integer idObj, Principal principal){
		System.out.println("HM");
		Boolean retorno=false;
		
		for (Object[] ob : objetoService.getAllObjeto(usuarioService.getAreaByMail(usuarioController.mailUsuario(principal)))) {
			if (ob[1] == idObj) {
				if (Integer.parseInt(ob[0].toString()) < cant) {
					retorno = false;
				} else { 
					retorno = true;
				}
			}
		}
		
		System.out.println(retorno.toString());
		return retorno;
		
	} 
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateMovimiento/{idMovimiento}")
	public ModelAndView updateMovimiento(Movimiento movimiento, @PathVariable("idMovimiento") Integer id) {
		movimiento.setActive(true);
		movimientoService.updateMovimiento(id, movimiento);
		return new ModelAndView("redirect:/movimiento");
	}
	
	@RequestMapping(value="/movimientoDelete/{idMovimiento}")
	public ModelAndView deactiveMovimiento(@PathVariable("idMovimiento") Integer id) {
		movimientoService.sofDeleteMovimiento(id);
		return new ModelAndView("redirect:/movimiento");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Movimiento/{idMovimiento}")
	public void deleteMovimiento(@PathVariable Integer id){
		movimientoService.deleteMovimiento(id);
	}
}
