package org.maintech.mantenimiento;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.maintech.objeto.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MantenimientoController {
	
	@Autowired
	private ObjetoService objetoService;
	
	Integer aux = 0;
	
	@Autowired
	private MantenimientoService mantenimientoService;
		
    @Autowired
    private JavaMailSender mailSender;
	
//	@Autowired
//	private ObjetoController objetoController;
	
	@RequestMapping(value = "/mantenimiento", method = RequestMethod.GET)
	public String showAllUsers(Model model) {

		//logger.debug("showAllUsers()");
		model.addAttribute("mantenimientos", mantenimientoService.getAllMantenimiento());
		return "Mantenimiento/MantenimientoRead";

	}
		
//	@RequestMapping("/mantenimiento/{idMantenimiento}")
//	public Mantenimiento getMantenimiento(@PathVariable("idMantenimiento") Integer id){
//		return mantenimientoService.getMantenimiento(id);
//	}
	
	@RequestMapping("/mantenimiento/{idMantenimiento}")
	public String getMantenimientoUpdate(@PathVariable("idMantenimiento") Integer id,Model model){
		model.addAttribute("varMantenmiento", mantenimientoService.getMantenimiento(id));
		model.addAttribute("Itemobjeto", objetoService.getAllObjeto());
		return "Mantenimiento/MantenimientoUpdate";
	}
	
	@RequestMapping("/crearMantenimiento")
	public String crearMantenimiento(@ModelAttribute("crearModelMantenimiento") Mantenimiento mantenimiento,
			BindingResult result, Model model){
		model.addAttribute("Itemobjeto", objetoService.getAllObjeto());
		return "Mantenimiento/MantenimientoCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addMantenimiento")
	public ModelAndView addMantenimiento(Mantenimiento mantenimiento) {
		mantenimiento.setActive(true);
		mantenimientoService.addMantenimiento(mantenimiento);
		return new ModelAndView("redirect:/mantenimiento");
	}
	
// done for project crocker :D
	@RequestMapping(value="/cMantenimiento")
	public ModelAndView  addMantnmailProvider() {
		
		
		Mantenimiento mat = new Mantenimiento();
				
		Date now = new Date();
		
			mat.setNombreMantenimiento("Limpieza ");
			mat.setDescripcionMantenimiento("Limpieza exterior");
			mat.setFechaMantenimiento(now);
			mat.setActive(true);
			mantenimientoService.addMantenimiento(mat);		
				
			return new ModelAndView("redirect:/mantenimiento");
	}
	
	/*@Scheduled(fixedRate=1000)
	public void Rep2(){
			aux = aux + 1;
		System.out.println(aux.toString());
	}*/

	@RequestMapping(method=RequestMethod.PUT, value="/updateMantenimiento/{idMantenimiento}")
	public ModelAndView updateMantenimiento(Mantenimiento mantenimiento, @PathVariable("idMantenimiento") Integer id) {
		mantenimiento.setActive(true);
		mantenimientoService.updateMantenimiento(id, mantenimiento);
		return new ModelAndView("redirect:/mantenimiento");
	}
	
	@RequestMapping(value="/deleteMantenimiento/{idMantenimiento}")
	public ModelAndView deactiveMantenimiento(@PathVariable("idMantenimiento") Integer id) {
		mantenimientoService.sofDeleteMantenimiento(id);
		return new ModelAndView("redirect:/mantenimiento");
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
	
	@Scheduled(fixedRate=240000)
	public void Rep(){
		this.home();
	}
	
	
	// ------------- send mail
	
	@RequestMapping("/simpleemail")
    @ResponseBody
    String home() {
        try {
            sendEmail();
            return "Email Sent!";
        }catch(Exception ex) {
            return "Error in sending email: "+ex;
        }
    } 

    private void sendEmail() throws Exception{
    	
    	String[] address = {"osdavidm3@gmail.com", "leninronquillo@gmail.com"};
    	
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(address);
        /*helper.setText("<html><body><form action='http://localhost:8080/cMantenimiento'><input type='submit' value='Aceptar Mantenimiento de Hoy' /></form>  "
        		+ "<br><body></html>", true);*/
        String texto1 = "<html> " 
    			+"<head><form action='http://localhost:8080/cMantenimiento'><input type='submit' value='Aceptar Mantenimiento de Hoy' /></form>"
    			+"<link href='<c:url value='/resources/css/style.css' />"
    			+"<script src='<c:url value='/resources/Js/scripts.js' />'></script>"
    			+"</head><body>"
    			+"<div class='container'>"
    			+"<h1>Ver Mantenimientos</h1>"
    			+"<tble class='table table-striped'>"
    			+"<thead>"
    			+"<tr>"
    			+"<th>ID</th>"
    			+"<th>Nombre</th>"
    			+"<th>Fecha</th>"
    			+"<th>Es Programado ?</th>"
    			+"<th>Frecuencia</th>"
    			+"<th>Objeto</th>"
    			+"</tr></thead>"
    			+"<tr>";
        
        String texto2="";
        
        for (Mantenimiento mantenimiento: mantenimientoService.getAllMantenimiento()) {
        	if (mantenimiento.getIsProgramadoMantenimiento()){
	        	texto2 = texto2 + "<td>" + mantenimiento.getIdMantenimiento() + "</td>"
					+"<td>" + mantenimiento.getNombreMantenimiento() + "</td>"
					+"<td>" + mantenimiento.getFechaMantenimiento() + "</td>"
					+"<td>" + mantenimiento.getIsProgramadoMantenimiento() + "</td>"
					+"<td>" + mantenimiento.getFrecuenciaMantenimiento() + "</td>"
					+"<td>" + mantenimiento.getObjetoMantenimiento().getDescripcionObjeto() + "</td>";
        	};
        };
        		
        
        helper.setText(texto1
			+ texto2                                                                                                                 
			+"</tr></table></div></body></html>", true);
        //<a href='http://localhost:8080/cMantenimiento'><img src='https://c24e867c169a525707e0-bfbd62e61283d807ee2359a795242ecb.ssl.cf3.rackcdn.com/imagenes/gato/etapas-clave-de-su-vida/gatitos/nuevo-gatito-en-casa/gatito-tumbado-lamiendo-sus-patitas.jpg'/></a>
        helper.setSubject("Confirmar Mantenimiento");
        mailSender.send(message);
    }
	
}
