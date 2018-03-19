package org.maintech.mantenimiento;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.dom4j.Branch;
import org.maintech.actividad.ActividadService;
import org.maintech.epp.EppService;
import org.maintech.mantenimientoObjetoActividad.GroupMantenimientoObjeto;
import org.maintech.mantenimientoObjetoActividad.MantenimientoObjetoActividad;
import org.maintech.movimiento.MovimientoService;
import org.maintech.objeto.Objeto;
import org.maintech.objeto.ObjetoService;
import org.maintech.proveedor.ProveedorService;
import org.maintech.reporterol.ReporteRolService;
import org.maintech.tipomantenimiento.TipoMantenimientoService;
import org.maintech.usuario.UsuarioController;
import org.maintech.usuario.UsuarioService;
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
	
	@Autowired
	private MantenimientoService mantenimientoService;
	
	@Autowired
	private TipoMantenimientoService tipoMantenimientoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioController usuarioController;
	
	@Autowired
	private EppService eppService;

	Integer aux = 0;
	
	@RequestMapping(value = "/mantenimiento", method = RequestMethod.GET)
	public String showAllMantenimientos(Model model) {

		model.addAttribute("mantenimientos", mantenimientoService.getFullMantenimientos());
		return "Mantenimiento/MantenimientoRead";

	}
	
	@RequestMapping("/mantenimientobyId/{idMantenimiento}")
	public String getMantenimientobyId(@PathVariable("idMantenimiento") Integer id,Model model, Principal principal){
		model.addAttribute("varMantenmiento", mantenimientoService.getMantenimiento(id));
		model.addAttribute("MantObjeto", objetoService.getObjeto(mantenimientoService.ObjetoFromMante(id)));
		model.addAttribute("MantEpp", eppService.getEppsMainte(id));
		model.addAttribute("ItemActividad", actividadService.getactividadxMante(id));
		model.addAttribute("Autorizacion", usuarioService.getautorizan(id));
		model.addAttribute("Liberado", usuarioService.getliberacion(id));
		return "Mantenimiento/MantenimientoReadById";
	}
	
	@RequestMapping("/mantenimiento/{idMantenimiento}")
	public String getMantenimientoUpdate(@PathVariable("idMantenimiento") Integer id,Model model, Principal principal){
		model.addAttribute("varMantenmiento", mantenimientoService.getMantenimiento(id));
		model.addAttribute("Itemobjeto", objetoService.getAllObjeto(usuarioService.getAreaByMail(usuarioController.mailUsuario(principal))));
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
			groupMantenimientoObjeto.getCantidadMantenimiento() * actividadService.getCostoActividad(ActividadId, groupMantenimientoObjeto.getListIdProveedor()), groupMantenimientoObjeto.getCantidadMantenimiento());	
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
	

	@RequestMapping(method=RequestMethod.GET, value="/mantenimientoProceso/{idMantenimiento}/{idObjeto}/{cant}")
	public ModelAndView updateMantenimientoProceso(@PathVariable("idMantenimiento") Integer id, 
			@PathVariable("idObjeto") Integer idObj, @PathVariable("cant") Integer cant) {
		
		Mantenimiento mantenimiento = mantenimientoService.getMantenimiento(id);
		if (mantenimiento.getIsAceptadoMantenimiento()) {
			if (mantenimiento.getIsEnProcesoMantenimiento()) {

				Objeto obj = objetoService.getObjeto(idObj);
				if ((obj.getCantidadMantenimiento() - cant) >= 0) {

					mantenimiento.setIsEnProcesoMantenimiento(false);
					mantenimiento.setIsTerminadoMantenimiento(false);
					
					obj.setCantidadMantenimiento(obj.getCantidadMantenimiento() - cant);
					objetoService.updateObjeto(idObj, obj);					
				}
			} else{
				Objeto obj = objetoService.getObjeto(idObj);
				if (movimientoService.getCantidadInventario(idObj) >= (cant)) {
					mantenimiento.setIsEnProcesoMantenimiento(true);
					
					obj.setCantidadMantenimiento(obj.getCantidadMantenimiento() + cant);
					objetoService.updateObjeto(idObj, obj);					
				}				
			}
			mantenimientoService.updateMantenimiento(id, mantenimiento);
		}		
		
		return new ModelAndView("redirect:/mantenimiento");
	}

	@RequestMapping(method=RequestMethod.GET, value="/mantenimientoTerminado/{idMantenimiento}/{idObjeto}/{cant}")
	public ModelAndView updateMantenimientoTerminado(@PathVariable("idMantenimiento") Integer id, 
		@PathVariable("idObjeto") Integer idObj, @PathVariable("cant") Integer cant) {
		
		Mantenimiento mantenimiento = mantenimientoService.getMantenimiento(id);
		if (mantenimiento.getIsAceptadoMantenimiento()) {
			if (mantenimiento.getIsEnProcesoMantenimiento()) {
				if (mantenimiento.getIsTerminadoMantenimiento()) {
					Objeto obj = objetoService.getObjeto(idObj);
					if (movimientoService.getCantidadInventario(idObj) >= (cant)) {
						mantenimiento.setIsTerminadoMantenimiento(false);
						
						obj.setCantidadMantenimiento(obj.getCantidadMantenimiento() + cant);
						objetoService.updateObjeto(idObj, obj);					
					}
				} else{

					Objeto obj = objetoService.getObjeto(idObj);
					if ((obj.getCantidadMantenimiento() - cant) >= 0) {

						mantenimiento.setIsTerminadoMantenimiento(true);
						if (mantenimiento.getIsProgramadoMantenimiento()) {
							Mantenimiento mant = new Mantenimiento();
							mant.setNombreMantenimiento(mantenimiento.getNombreMantenimiento());
							mant.setDescripcionMantenimiento(mantenimiento.getDescripcionMantenimiento());
							mant.setIsProgramadoMantenimiento(true);
							mant.setFrecuenciaMantenimiento(mantenimiento.getFrecuenciaMantenimiento());
							mant.setObjTipoMantenimiento(mantenimiento.getObjTipoMantenimiento());
							mant.setActive(true);
							mant.setIsAceptadoMantenimiento(false);
							mant.setIsEnProcesoMantenimiento(false);
							mant.setIsTerminadoMantenimiento(false);
							
							Integer dias = Math.round(mantenimiento.getFrecuenciaMantenimiento() / 24);
							
							String dt = mantenimiento.getFechaMantenimiento().toString();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							Calendar c = Calendar.getInstance();
							try {
								c.setTime(sdf.parse(dt));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							c.add(Calendar.DATE, dias);  // number of days to add
							
							mant.setFechaMantenimiento(c.getTime());
							mantenimientoService.addMantenimiento(mant);
							Integer idMantNuevo = mantenimientoService.IdUltimoMante();
							
							List<Object[]> moasAnt = mantenimientoService.getMantenimientoActividadObjetoXMant(id);
							
							for (Object[] moa : moasAnt) {
								
								mantenimientoService.LinkMantenimiento_Actividad_Obj_Provee(Integer.parseInt(moa[1].toString()),
									idMantNuevo, Integer.parseInt(moa[3].toString()), Integer.parseInt(moa[4].toString()), 
										Integer.parseInt(moa[5].toString()) * actividadService.getCostoActividad(Integer.parseInt(moa[1].toString()), Integer.parseInt(moa[3].toString())), 
										Integer.parseInt(moa[5].toString()));
							}
						}
						
						obj.setCantidadMantenimiento(obj.getCantidadMantenimiento() - cant);
						objetoService.updateObjeto(idObj, obj);					
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
	
	@RequestMapping("/mantenimientoEpp/{idMantenimiento}")
	public String MantenimientoEpp(@PathVariable("idMantenimiento") Integer id,Model model, Principal principal){
		model.addAttribute("varMantenmiento", mantenimientoService.getMantenimiento(id));
		model.addAttribute("ItemEpp", eppService.getEppsMainte(id));

		return "Epp/EppOnMainte";
		
	}
	
	@RequestMapping("/mantenimientoEppupdated/{idMantenimiento}")
	public ModelAndView MantenimientoEppUpdated(@PathVariable("idMantenimiento") Integer id,Model model, Principal principal,
			HttpServletRequest request){

		String[] foo = request.getParameterValues("foo");
		for (String string : foo) {
			System.out.println(string);
		}
		
		return new ModelAndView("redirect:/mantenimientobyId/" + id);
		
	}
	
    
}
