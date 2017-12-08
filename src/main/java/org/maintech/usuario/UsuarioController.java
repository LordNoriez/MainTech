package org.maintech.usuario;

import org.maintech.areaempresa.AreaEmpresaService;
import org.maintech.rol.RolService;
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
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RolService rolService;
	
	@Autowired
	private AreaEmpresaService areaEmpresaService;
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String showAllUsuario(Model model) {

		model.addAttribute("usuarios", usuarioService.getAllUsuario());
		return "Usuario/UsuarioRead";
	}
		
	@RequestMapping("/usuario/{idUsuario}")
	public String getUsuario(@PathVariable("idUsuario") Integer id, Model model){		
		model.addAttribute("usuario", usuarioService.getUsuario(id));
		model.addAttribute("roles", rolService.getAllRol());
		model.addAttribute("areaEmpresas", areaEmpresaService.getAllAreaEmpresa());		
		return "Usuario/UsuarioUpdate";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addUsuario")
	public ModelAndView addUsuario(Usuario usuario) {
		usuario.setActive(true);
		usuarioService.addUsuario(usuario);
		return new ModelAndView("redirect:/usuario");
	}

	@RequestMapping(method=RequestMethod.PUT, value="/usuarioUpdate/{idUsuario}")
	public ModelAndView updateUsuario(Usuario usuario, @PathVariable("idUsuario") Integer id) {
		usuario.setActive(true);
		usuarioService.updateUsuario(id, usuario);
		return new ModelAndView("redirect:/usuario");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/usuario/{idUsuario}")
	public void deleteUsuario(@PathVariable Integer id){
		usuarioService.deleteUsuario(id);
	}
	
	@RequestMapping(value="/deleteUsuario/{idUsuario}")
	public ModelAndView deactiveUsuario(@PathVariable("idUsuario") Integer id) {
		usuarioService.softDeleteUsuario(id);
		return new ModelAndView("redirect:/usuario");
	}

	@RequestMapping("/crearUsuario")
	public String crearUsuario(@ModelAttribute("crearModelUsuario") Usuario usuario,
			BindingResult result, Model model){
		model.addAttribute("roles", rolService.getAllRol());
		model.addAttribute("areaEmpresas", areaEmpresaService.getAllAreaEmpresa());		
		return "Usuario/UsuarioCrear";
	}
}
