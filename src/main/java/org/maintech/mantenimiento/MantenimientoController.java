package org.maintech.mantenimiento;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.dom4j.Branch;
import org.maintech.actividad.ActividadService;
import org.maintech.mantenimientoObjetoActividad.GroupMantenimientoObjeto;
import org.maintech.movimiento.MovimientoService;
import org.maintech.objeto.Objeto;
import org.maintech.objeto.ObjetoService;
import org.maintech.proveedor.ProveedorService;
import org.maintech.reporterol.ReporteRolService;
import org.maintech.tipomantenimiento.TipoMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MantenimientoController {
	
	@Autowired
	private ObjetoService objetoService;
	
	@Autowired
	private ActividadService actividadService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private MovimientoService movimientoService;
	
	Integer aux = 0;
	
	@Autowired
	private MantenimientoService mantenimientoService;
	
	@Autowired
	private TipoMantenimientoService tipoMantenimientoService;
	
	@Autowired
	private ReporteRolService reporteRolService;
		
    @Autowired
    private JavaMailSender mailSender;
	
	@RequestMapping(value = "/mantenimiento", method = RequestMethod.GET)
	public String showAllMantenimientos(Model model) {

		model.addAttribute("mantenimientos", mantenimientoService.getFullMantenimientos());
		return "Mantenimiento/MantenimientoRead";

	}
		
	@RequestMapping("/mantenimiento/{idMantenimiento}")
	public String getMantenimientoUpdate(@PathVariable("idMantenimiento") Integer id,Model model){
		model.addAttribute("varMantenmiento", mantenimientoService.getMantenimiento(id));
		model.addAttribute("Itemobjeto", objetoService.getAllObjeto());
		model.addAttribute("ItemActividad", actividadService.getAllActividad());
		model.addAttribute("tipos", tipoMantenimientoService.getAllMantenimiento());
		
		return "Mantenimiento/MantenimientoUpdate";
	}
	
	@RequestMapping("/emailAcepted/{idMantenimiento}")
	public ModelAndView AceptMantenimientoEmail(@PathVariable("idMantenimiento") Integer id,Model model){

		mantenimientoService.Acept_mantenimiento(id);
		return new ModelAndView("redirect:/mantenimiento");
	}
	
	@RequestMapping("/crearMantenimiento")
	public String crearMantenimiento(@ModelAttribute("crearModelMantenimiento") Mantenimiento mantenimiento,
			BindingResult result, Model model){
		//model.addAttribute("Itemobjeto", objetoService.getAllObjeto());
		//model.addAttribute("ItemActividad", actividadService.getAllActividad());
		model.addAttribute("tipos", tipoMantenimientoService.getAllMantenimiento());
		
		return "Mantenimiento/MantenimientoCrear";
	}
		
	@RequestMapping(method=RequestMethod.POST, value="/addMantenimiento")
	public String crearobjmantenimientoObjetoActividad(Mantenimiento mantenimiento, @ModelAttribute("crearModelGroupMantenimientoObjeto") GroupMantenimientoObjeto groupMantenimientoObjeto,
			BindingResult result, Model model){
		mantenimiento.setActive(true);
		mantenimiento.setIsAceptadoMantenimiento(true);
		mantenimiento.setIsEnProcesoMantenimiento(false);
		mantenimiento.setIsTerminadoMantenimiento(false);
		if (mantenimiento.getIsProgramadoMantenimiento() == false)  {
			mantenimiento.setFrecuenciaMantenimiento(0);
		}
		mantenimientoService.addMantenimiento(mantenimiento);
		
		model.addAttribute("mantenimiento",  mantenimiento);
		model.addAttribute("itemobjeto", objetoService.returnAllObjeto());
		model.addAttribute("actividades", actividadService.getAllActividad());
		model.addAttribute("proveedores",  proveedorService.getAllProveedores());
		return "MantenimientoObjetoActividad/MantenimientoObjetoActividadCrear";
		//return "/";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/LinkMantObjeto")
	public String addMantObjeto(GroupMantenimientoObjeto groupMantenimientoObjeto,
			@ModelAttribute("crearModelMantenimiento") GroupMantenimientoObjeto groupMantObjNew,
			BindingResult result, Model model) {

		model.addAttribute("groupMant", mantenimientoService.getMantenimiento(groupMantenimientoObjeto.getMantenimientos()));
		model.addAttribute("idobjeto", objetoService.getObjeto(groupMantenimientoObjeto.getIdobjeto()));
		
		model.addAttribute("Proveedores", mantenimientoService.getProvXObj(groupMantenimientoObjeto.getIdobjeto()));
		return "MantenimientoObjetoActividad/MantenimientoProveedorLink";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/LinkMantActividad")
	public String addprovedor(GroupMantenimientoObjeto groupMantenimientoObjeto,
			@ModelAttribute("crearModelMantenimiento") GroupMantenimientoObjeto groupMantObjNew,
			BindingResult result, Model model) {

		List<Object[]> Proveedor = new ArrayList<Object[]>() ;
			
		model.addAttribute("groupMant", mantenimientoService.getMantenimiento(groupMantenimientoObjeto.getMantenimientos()));
		model.addAttribute("idobjeto", objetoService.getObjeto(groupMantenimientoObjeto.getIdobjeto()));
		model.addAttribute("proveedores", proveedorService.getProveedor(groupMantenimientoObjeto.getListIdProveedor()));
		model.addAttribute("ActividadesxObjeto", actividadService.getidActividadProveedorxObjt(groupMantenimientoObjeto.getIdobjeto(),groupMantenimientoObjeto.getListIdProveedor()));
		
		return "MantenimientoObjetoActividad/MantenimientoObjetoActividadLink";

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/LinkEvrything")
	public ModelAndView addLinkEvrything(@ModelAttribute("crearModelMantenimiento") GroupMantenimientoObjeto groupMantenimientoObjeto,
			BindingResult result, Model model) {

		
		for (Integer ActividadId: groupMantenimientoObjeto.getListIdActividades()) {
			mantenimientoService.LinkMantenimiento_Actividad_Obj_Provee(ActividadId, groupMantenimientoObjeto.getMantenimientos()
			, groupMantenimientoObjeto.getListIdProveedor(), groupMantenimientoObjeto.getIdobjeto(), 
			actividadService.getCostoActividad(ActividadId, groupMantenimientoObjeto.getListIdProveedor()), groupMantenimientoObjeto.getCantidadMantenimiento());	
		}
		

		return new ModelAndView("redirect:/mantenimiento");
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/LinkMantObjeto1")
	public String zz(@ModelAttribute("crearModelMantenimiento") GroupMantenimientoObjeto groupMantenimientoObjeto,
			BindingResult result, Model model) {
		
		model.addAttribute("idmantenimiento", groupMantenimientoObjeto.getMantenimientos());
		model.addAttribute("idobjeto", groupMantenimientoObjeto.getIdobjeto());
		model.addAttribute("actividades",groupMantenimientoObjeto.getActividades());
		model.addAttribute("proveedor",groupMantenimientoObjeto.getProveedores());
		
		return "MantenimientoObjetoActividad/prueba";

	}
	
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
	public @ResponseBody 
	List getForm1(@ModelAttribute Branch branch, Model model,@RequestParam("districtId")    
	int districtId) {

	       List<Object[]> districtVillageList = mantenimientoService.getAct_ProvxObjt(districtId);


	    return districtVillageList;
	 }
	
	@RequestMapping(value="phcheck", method=RequestMethod.GET,
            produces="application/json")
	public @ResponseBody List<Object[]> pay(@RequestParam("empid") int empid) {
		List<Object[]> districtVillageList = mantenimientoService.getAct_ProvxObjt(empid);
	//get your employee list here
	return districtVillageList;
	}
	

	@RequestMapping(value="/contacts", produces = {
	        MediaType.APPLICATION_JSON_VALUE},
	        method = RequestMethod.GET)
	public ResponseEntity<List<Mantenimiento>> getContacts () {

	    List<Mantenimiento> contacts = mantenimientoService.getAllMantenimiento();

	    return new ResponseEntity<List<Mantenimiento>>(contacts, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllIndustries")
	@ResponseBody
	public List<Mantenimiento>getAllIndustries()
	{
	    return mantenimientoService.getAllMantenimiento();
	}
	
	@RequestMapping(value="/getCantidadInventario/{categoryId}")
	@ResponseBody
    public  Integer getAllSubcategories(@PathVariable("categoryId") Integer categoryId) {
        return movimientoService.getCantidadInventario(categoryId);
    }
	
    @RequestMapping(value = "/myPage")
    public void myController(HttpServletRequest request, HttpServletResponse response) throws IOException {

	    String myItem = request.getParameter("item");   
	 
	    response.getWriter().println(movimientoService.getCantidadInventario(Integer.parseInt(myItem)));
    }
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateMantenimiento/{idMantenimiento}")
	public ModelAndView updateMantenimiento(Mantenimiento mantenimiento, @PathVariable("idMantenimiento") Integer id) {
		mantenimiento.setActive(true);
		mantenimientoService.updateMantenimiento(id, mantenimiento);
		
		mantenimientoService.DeleteLinkActividad_mantenimiento(id);
		
//		for (Actividad activMante: mantenimiento.getActividad()) {
//			
//			mantenimientoService.LinkActividad_mantenimiento(activMante.getIdActividad(), id);
//		} 
 
		return new ModelAndView("redirect:/mantenimiento");
	}
	

	@RequestMapping(method=RequestMethod.GET, value="/mantenimientoAceptado/{idMantenimiento}")
	public ModelAndView updateMantenimientoAceptado(@PathVariable("idMantenimiento") Integer id) {
		
		Mantenimiento mantenimiento = mantenimientoService.getMantenimiento(id);
		
		if (mantenimiento.getIsAceptadoMantenimiento()) {
			mantenimiento.setIsAceptadoMantenimiento(false);
			mantenimiento.setIsEnProcesoMantenimiento(false);
			mantenimiento.setIsTerminadoMantenimiento(false);
		} else{
			mantenimiento.setIsAceptadoMantenimiento(true);
		}
		
		mantenimientoService.updateMantenimiento(id, mantenimiento);
		
		return new ModelAndView("redirect:/mantenimiento");
	}
	

	@RequestMapping(method=RequestMethod.GET, value="/mantenimientoProceso/{idMantenimiento}/{idObjeto}")
	public ModelAndView updateMantenimientoProceso(@PathVariable("idMantenimiento") Integer id, @PathVariable("idObjeto") Integer idObj) {
		
		Mantenimiento mantenimiento = mantenimientoService.getMantenimiento(id);
		if (mantenimiento.getIsAceptadoMantenimiento()) {
			if (mantenimiento.getIsEnProcesoMantenimiento()) {
				mantenimiento.setIsEnProcesoMantenimiento(false);
				mantenimiento.setIsTerminadoMantenimiento(false);
			} else{
				mantenimiento.setIsEnProcesoMantenimiento(true);
				// CAMBIAR
//				Objeto obj = objetoService.getObjeto(idObj);
//				obj.setCantidadMantenimiento(obj.getCantidadMantenimiento() + groupMantenimientoObjeto.getCantidadMantenimiento());
//				objetoService.updateObjeto(groupMantenimientoObjeto.getIdobjeto(), obj);
				
			}
			mantenimientoService.updateMantenimiento(id, mantenimiento);
		}		
		
		return new ModelAndView("redirect:/mantenimiento");
	}

	@RequestMapping(method=RequestMethod.GET, value="/mantenimientoTerminado/{idMantenimiento}")
	public ModelAndView updateMantenimientoTerminado(@PathVariable("idMantenimiento") Integer id) {
		
		Mantenimiento mantenimiento = mantenimientoService.getMantenimiento(id);
		if (mantenimiento.getIsAceptadoMantenimiento()) {
			if (mantenimiento.getIsEnProcesoMantenimiento()) {
				if (mantenimiento.getIsTerminadoMantenimiento()) {
					mantenimiento.setIsTerminadoMantenimiento(false);
				} else{
					mantenimiento.setIsTerminadoMantenimiento(true);
					if (mantenimiento.getIsProgramadoMantenimiento()) {
//						Mantenimiento mant = new Mantenimiento();
//						mant.setNombreMantenimiento(mantenimiento.getNombreMantenimiento());
//						mant.setDescripcionMantenimiento(mantenimiento.getDescripcionMantenimiento());
//						mant.setIsProgramadoMantenimiento(true);
//						mant.setFrecuenciaMantenimiento(mantenimiento.getFrecuenciaMantenimiento());
//						mant.setObjTipoMantenimiento(mantenimiento.getObjTipoMantenimiento());
//						mant.setActive(true);
//						mant.setIsAceptadoMantenimiento(false);
//						mant.setIsEnProcesoMantenimiento(false);
//						mant.setIsTerminadoMantenimiento(false);
//						
//						mant.setFechaMantenimiento(mantenimiento.getFechaMantenimiento());
//						mantenimientoService.addMantenimiento(mant);
					}
				}
				mantenimientoService.updateMantenimiento(id, mantenimiento);
			}
		}
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
	

	@Scheduled(fixedRate=30000)
	public void Rep(){
		this.home();
	}
	
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
    	
    	//String[] address = {"osdavidm3@gmail.com", "leninronquillo@gmail.com"};
    	String[] address = reporteRolService.getAllCorreos("Mantenimientos Emergentes");

    	if (!isEmptyStringArray(address)) {
    		
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        helper.setTo(address);
	        String texto1 = "<html> " 
	    			+"<head><form action='http://localhost:8080/cMantenimiento'></form>"
	    			+"<script src='http://code.jquery.com/jquery.js'></script>"
	    			+"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"
	    			+"<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>"
	        		+"<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"
	    			+"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"	    			
	    			+"</head><body>"
	    			+"<div class='container'>"
	    			+"<h1>Mantenimientos Por Aceptar</h1>"
	    			+"<table class='table table-striped table-hover'>"
	    			+"<thead>"
	    			+"<tr>"
	    			+"<th>ID</th>"
	    			+"<th>Nombre</th>"
	    			+"<th>Fecha</th>"
	    			+"<th>Es Programado ?</th>"
	    			+"<th>Frecuencia</th>"
	    			//+"<th>Equipo</th>"
	    			+"</tr></thead>";
	        
	        String texto2="";
			String frec = "";

	        if (mantenimientoService.MantenimientoxAceptar().size()!=0) {

	    		for (Mantenimiento mantenimiento: mantenimientoService.MantenimientoxAceptar()) {
		        		
	    			if (mantenimiento.getIsProgramadoMantenimiento() == true) {
	    				frec = "Sí";
	    			} else {
	    				frec = "No";
	    			}
			        	texto2 = texto2 + "<tr><td>" + mantenimiento.getIdMantenimiento().toString() + "</td>"
							+"<td>" + mantenimiento.getNombreMantenimiento() + "</td>"
							+"<td>" + mantenimiento.getFechaMantenimiento() + "</td>"
							+"<td>" + frec + "</td>"
							+"<td>" + mantenimiento.getFrecuenciaMantenimiento() + " Horas</td>"
							//+"<td>" + mantenimiento.getObjetoMantenimiento().getDescripcionObjeto() + "</td>"
							+"<a href=\"http://localhost:8080/emailAcepted/" + mantenimiento.getIdMantenimiento().toString() + "\">Aceptar Mantenimiento</a>"
							+ "</tr>";
		        };

		        helper.setText(texto1
					+ texto2                                                                                                                 
					+"</tr></table></div></body></html>", true);
		        //<a href='http://localhost:8080/cMantenimiento'><img src='https://c24e867c169a525707e0-bfbd62e61283d807ee2359a795242ecb.ssl.cf3.rackcdn.com/imagenes/gato/etapas-clave-de-su-vida/gatitos/nuevo-gatito-en-casa/gatito-tumbado-lamiendo-sus-patitas.jpg'/></a>
		        helper.setSubject("Confirmar Mantenimiento");
		        mailSender.send(message);
	        }
    	}
    }
    
    public boolean isEmptyStringArray(String [] array){
		 for(int i=0; i<array.length; i++){ 
		  if(array[i]!=null){
		   return false;
		  }
		  }
		  return true;
	}
	
    @RequestMapping("/reporteCostos")
    private void sendEmailCostsReport() throws Exception{
    	
    	String[] address = {"osdavidm3@gmail.com", "leninronquillo@gmail.com"};
    	
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(address);
        /*helper.setText("<html><body><form action='http://localhost:8080/cMantenimiento'><input type='submit' value='Aceptar Mantenimiento de Hoy' /></form>  "
        		+ "<br><body></html>", true);*/
        String texto1 = "<html> " 
    			+"<head>"
    			+"<link href='<c:url value='/resources/css/style.css' />"
    			+"<script src='<c:url value='/resources/Js/scripts.js' />'></script>"
    			+"</head><body>"
    			+"<div class='container'>"
    			+"<h1>Mantenimiento Costos Noviembre</h1>"
    			+"<table style=\"text-align: left;font-weight: 600;font-family: 'Raleway',sans-serif;font-size: 15px;color: #008080;\">"
    			+"<tr>"
    			//+"<th>ID</th>"
    			+"<th>Nombre Mantenimiento</th>"
    			//+"<th>Fecha</th>"
    			+"<th>Costos</th>"
    			//+"<th>Objeto</th>"
    			+"</tr>";
        
        String texto2="";
        
        for (Object[] mantenimiento: mantenimientoService.CostoMantenimiento()) {
        	
        	texto2 = texto2 + "<tr><td style=\"text-align: center;font-weight: 400;font-family: 'Raleway',sans-serif;font-size: 15px;border-style: dotted;border-width:"
        		+ "1px;border-color: #5F9EA0;\">" + mantenimiento[0].toString() + "</td>"
				+"<td style=\"text-align: center;font-weight: 400;font-family: 'Raleway',sans-serif;font-size: 15px;border-style: dotted;border-width:" 
				+"1px;border-color: #5F9EA0;\">" + mantenimiento[1].toString() + "</td></tr>";
//				+"<td>" + mantenimiento.getFechaMantenimiento() + "</td>"
//				+"<td>" + mantenimiento.getIsProgramadoMantenimiento() + "</td>"
//				+"<td>" + mantenimiento.getFrecuenciaMantenimiento() + "</td>"
//				+"<td>" + mantenimiento.getObjetoMantenimiento().getDescripcionObjeto() + "</td>";
    	
    };
        		
        
        helper.setText(texto1
			+ texto2                                                                                                                 
			+"</tr></table></div></body></html>", true);
        //<a href='http://localhost:8080/cMantenimiento'><img src='https://c24e867c169a525707e0-bfbd62e61283d807ee2359a795242ecb.ssl.cf3.rackcdn.com/imagenes/gato/etapas-clave-de-su-vida/gatitos/nuevo-gatito-en-casa/gatito-tumbado-lamiendo-sus-patitas.jpg'/></a>
        helper.setSubject("Confirmar Mantenimiento");
        mailSender.send(message);
    }
    
    @RequestMapping("/reporteEmergentes")
    private void sendEmailEmergenteReport() throws Exception{
    	
    	String[] address = {"osdavidm3@gmail.com", "leninronquillo@gmail.com"};
    	
    	String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    	
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(address);
        /*helper.setText("<html><body><form action='http://localhost:8080/cMantenimiento'><input type='submit' value='Aceptar Mantenimiento de Hoy' /></form>  "
        		+ "<br><body></html>", true);*/
        String texto1 = "<html> " 
    			+"<head>"
    			+"<link href='<c:url value='/resources/css/style.css' />"
    			+"<script src='<c:url value='/resources/Js/scripts.js' />'></script>"
    			+"</head><body>"
    			+"<div class='container'>"
    			+"<h1>Mantenimiento Emergentes "+ timeStamp  +"</h1>"
    			+"<table style=\"text-align: left;font-weight: 600;font-family: 'Raleway',sans-serif;font-size: 15px;color: #008080;\">"
    			+"<tr>"
    			//+"<th>ID</th>"
    			+"<th>Nombre Mantenimiento</th>"
    			+"<th>Fecha</th>"
    			+"<th>Objeto</th>"
    			+"<th>Descripción Mantenimiento</th>"
    			+"</tr>";
        
        String texto2="";
        
        for (Mantenimiento mantenimiento: mantenimientoService.MantenimientoEmergente()) {
        	
        	texto2 = texto2 + "<tr><td style=\"text-align: center;font-weight: 400;font-family: 'Raleway',sans-serif;font-size: 15px;border-style: dotted;border-width:"
        		+ "1px;border-color: #5F9EA0;\">" + mantenimiento.getNombreMantenimiento() + "</td>"
				+"<td style=\"text-align: center;font-weight: 400;font-family: 'Raleway',sans-serif;font-size: 15px;border-style: dotted;border-width:" 
				+"1px;border-color: #5F9EA0;\">" + mantenimiento.getFechaMantenimiento() + "</td>"
				+"<td style=\"text-align: center;font-weight: 400;font-family: 'Raleway',sans-serif;font-size: 15px;border-style: dotted;border-width:" 
				//+"1px;border-color: #5F9EA0;\">" + mantenimiento.getObjetoMantenimiento().getDescripcionObjeto() + "</td>"
				+"<td style=\"text-align: center;font-weight: 400;font-family: 'Raleway',sans-serif;font-size: 15px;border-style: dotted;border-width:" 
				+"1px;border-color: #5F9EA0;\">" + mantenimiento.getDescripcionMantenimiento() + "</td></tr>";
//				+"<td>" + mantenimiento.getFechaMantenimiento() + "</td>"
//				+"<td>" + mantenimiento.getIsProgramadoMantenimiento() + "</td>"
//				+"<td>" + mantenimiento.getFrecuenciaMantenimiento() + "</td>"
//				+"<td>" + mantenimiento.getObjetoMantenimiento().getDescripcionObjeto() + "</td>";
    	
    };
        		
        
        helper.setText(texto1
			+ texto2                                                                                                                 
			+"</tr></table></div></body></html>", true);
        //<a href='http://localhost:8080/cMantenimiento'><img src='https://c24e867c169a525707e0-bfbd62e61283d807ee2359a795242ecb.ssl.cf3.rackcdn.com/imagenes/gato/etapas-clave-de-su-vida/gatitos/nuevo-gatito-en-casa/gatito-tumbado-lamiendo-sus-patitas.jpg'/></a>
        helper.setSubject("Confirmar Mantenimiento");
        mailSender.send(message);
    }
//    @Scheduled(fixedRate=60000)
//	public void AutomatizacionMantenimiento(){
//		Mantenimiento MantProg;
//		Date now = new Date();
//		Integer auxForMantNumber;
//		String newnumber;
//		String NewNameMante;
//		
//		
//		for (Object[] revisiontiemp: mantenimientoService.MantenimientoRevisionFrecuenciaxTiempo()){
//			
//
//			
//			if(Float.parseFloat(revisiontiemp[1].toString()) < 0){
//				Mantenimiento NewMante = new Mantenimiento();
//				MantProg = mantenimientoService.getMantenimiento(Integer.parseInt(revisiontiemp[0].toString()));
//				
//				auxForMantNumber = Integer.parseInt(MantProg.getNombreMantenimiento().substring(MantProg.getNombreMantenimiento().length() - 3));
//				auxForMantNumber = auxForMantNumber + 1;
//				newnumber = "00000" + auxForMantNumber.toString();
//				NewNameMante = MantProg.getNombreMantenimiento().substring(0,MantProg.getNombreMantenimiento().length() - 3) + newnumber.substring(newnumber.length() - 3); 
//				
//				NewMante.setNombreMantenimiento(NewNameMante);
//				NewMante.setFechaMantenimiento(now);
//				NewMante.setDescripcionMantenimiento(MantProg.getDescripcionMantenimiento());
//				NewMante.setIsAceptadoMantenimiento(false);
//				NewMante.setIsProgramadoMantenimiento(true);
//				NewMante.setFrecuenciaMantenimiento(MantProg.getFrecuenciaMantenimiento());
//				//NewMante.setObjetoMantenimiento(MantProg.getObjetoMantenimiento());
//				NewMante.setActive(true);
//				mantenimientoService.addMantenimiento(NewMante);
//	
////				for(Actividad actividad: MantProg.getActividad()){
////					
////					mantenimientoService.LinkActividad_mantenimiento(actividad.getIdActividad(),
////							mantenimientoService.IdUltimoMante());
////				}
//			}
//		}
//		//return new ModelAndView("redirect:/mantenimiento");    
//	}
    
}
