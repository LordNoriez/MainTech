package org.maintech.objeto;

import java.security.Principal;

import javax.mail.internet.MimeMessage;

import org.maintech.actividad.Actividad;
import org.maintech.actividadproveedor.ActividadProveedorService;
import org.maintech.areaempresa.AreaEmpresaService;
import org.maintech.categoria.CategoriaService;
import org.maintech.color.ColorService;
import org.maintech.estructura.EstructuraService;
import org.maintech.objetoActividad.ObjetoListActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/objeto")
public class ObjetoController {
	
	@Autowired
	private ObjetoService objetoService;
	
	@Autowired
	private ActividadProveedorService actividadProveedorService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private AreaEmpresaService areaEmpresaService;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private EstructuraService estructuraService;
	
    @Autowired
    private JavaMailSender mailSender;
    
    
	@RequestMapping(value = "/objeto", method = RequestMethod.GET)
	public String showAllObjetos(Model model) {

		model.addAttribute("objetos", objetoService.getAllObjeto());
		model.addAttribute("categories", categoriaService.getAllCategoria());
		model.addAttribute("objetosPadre", objetoService.returnAllObjeto());
		model.addAttribute("areas", areaEmpresaService.getAllAreaEmpresa());
		return "Objeto/ObjetoRead";

	}
	
	@RequestMapping("/crearObjeto")
	public String crearObjeto(@ModelAttribute("crearModelObjeto") Objeto objeto, 
			BindingResult result, Model model, Principal principal){
		
		model.addAttribute("categories", categoriaService.getAllCategoria());
		model.addAttribute("objects", objetoService.returnAllObjeto());
		model.addAttribute("areas", areaEmpresaService.getAllAreaEmpresa());
		model.addAttribute("colores", colorService.getAllColor());
		model.addAttribute("estructuras", estructuraService.getAllEstructura());
		
		return "Objeto/ObjetoCrear";
	}
	
	@RequestMapping("/objeto/{idObjeto}")
	public String getObjetoUpdate(@PathVariable("idObjeto") Integer id,Model model){
		model.addAttribute("objeto", objetoService.getObjeto(id));
		model.addAttribute("categories", categoriaService.getAllCategoria());
		model.addAttribute("objects", objetoService.returnAllObjeto());
		model.addAttribute("areas", areaEmpresaService.getAllAreaEmpresa());
		model.addAttribute("colores", colorService.getAllColor());
		model.addAttribute("estructuras", estructuraService.getAllEstructura());
		return "Objeto/ObjetoUpdate";
	}
	
//    @PostMapping("/objeto")
//    public String addObjeto(@ModelAttribute Objeto objeto) {
//    	objeto.setActive(true);    	
//		Date date = new Date();
//    	objeto.setFechaCreacionObjeto(date);
//    	
//    	objetoService.addObjeto(objeto);    	
//        return "Se Ingreso Correctamente el Objeto";
//    }
    
	@RequestMapping(method=RequestMethod.POST, value="/addObjeto")
	public String addObjeto(Objeto objeto, @ModelAttribute("crearModellistActividad") ObjetoListActividad listActividad, 
			BindingResult result, Model model, Principal principal) {

		objeto.setActive(true);
		objetoService.addObjeto(objeto);
		
		model.addAttribute("actividades", actividadProveedorService.getActividadProveedorCosto());
		model.addAttribute("objetos", objeto);
		return "ObjetoActividad/ObjetoActividadCrear";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addObjetoLinkActividad")
	public ModelAndView addObjetoLinkActividad(ObjetoListActividad listActividad) {
		
		for (Actividad actividades : listActividad.getActividades()) {
			objetoService.Link(actividades.getIdActividad(), objetoService.UltimoObjetoId());
		}
		return new ModelAndView("redirect:/objeto");
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateObjeto/{idObjeto}")
	public ModelAndView updateObjeto(Objeto objeto, @PathVariable("idObjeto") Integer id) {
		objeto.setActive(true);
		objetoService.updateObjeto(id, objeto);
		return new ModelAndView("redirect:/objeto");
	}
	
	@RequestMapping(value="/deleteObjeto/{idObjeto}")
	public ModelAndView deactiveObjeto(@PathVariable("idObjeto") Integer id) {
		objetoService.softDeleteObjeto(id);
		return new ModelAndView("redirect:/objeto");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/objeto/{idObjeto}")
	public void deleteObjeto(@PathVariable Integer id){
		objetoService.deleteObjeto(id);
	}
	

	@RequestMapping("/reporte")
    public String sendReportEmail() {
    	try {
			sendReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "Se ha enviado el reporte al correo de los responsables";
    }
	
    private void sendReport() throws Exception {
    	
    	// create our mysql database connection
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/DBClass";
        Class.forName(myDriver);
        java.sql.Connection conn = java.sql.DriverManager.getConnection(myUrl, "root", "Narutito1");
        
        String query = "select m.mes, sum(m.costo_actividad) as costo "
        				+" from" 
        				+" (select mantenimiento.id_mantenimiento, actividad.id_actividad," 
        				+" mantenimiento.descripcion_mantenimiento," 
        				+" mantenimiento.fecha_mantenimiento," 
        				+" mantenimiento.nombre_mantenimiento, mantenimiento.objeto_id_objeto," 
        				+" actividad.costo_actividad, actividad.descripcion_actividad," 
        				+" actividad.nombre_actividad," 
        				+" monthname(mantenimiento.fecha_mantenimiento) as mes" 
        				+" from" 
        				+" mantenimiento, actividad, actividad_mantenimientos" 
        				+" where" 
        				+" actividad.id_actividad=actividad_mantenimientos.actividad_id_actividad" 
        				+" and" 
        				+" mantenimiento.id_mantenimiento=actividad_mantenimientos.mantenimientos_id_mantenimiento)" 
        				+" as m" 
        				+" group by m.mes;";
        
        // create the java statement
        java.sql.Statement st = conn.createStatement();
        
        // execute the query, and get a java resultset
        java.sql.ResultSet rs = st.executeQuery(query);
        
        String[] address = {"osdavidm3@gmail.com", "leninronquillo@gmail.com"};
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(address);
        String envio;
        envio="<html><body>  Mes (Costo)<br> ";
        
        while (rs.next())
        {
          String mes = rs.getString("mes");
          String costo= rs.getString("costo");
          
          envio = envio+ mes+" ("+ costo+")<br>";
        		  
        }
        envio = envio+"<br><body></html>";
        st.close();
        helper.setText(envio, true);
   
        helper.setSubject("Reporte de Costos Mensuales");
        mailSender.send(message);
    }

}
