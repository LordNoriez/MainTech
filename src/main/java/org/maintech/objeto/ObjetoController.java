package org.maintech.objeto;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.mail.internet.MimeMessage;

import org.maintech.categoria.CategoriaService;
import org.maintech.login.UserRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.ldap.userdetails.InetOrgPerson;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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
	private CategoriaService categoriaService;
	
    @Autowired
    private JavaMailSender mailSender;
    
    
	@RequestMapping(value = "/objeto", method = RequestMethod.GET)
	public String showAllObjetos(Model model) {

		model.addAttribute("objetos", objetoService.getAllObjeto());
		model.addAttribute("categories", categoriaService.getAllCategoria());
		model.addAttribute("objetosPadre", objetoService.getAllObjeto());
		return "Objeto/ObjetoRead";

	}
	
	@RequestMapping("/crearObjeto")
	public String crearObjeto(@ModelAttribute("crearModelObjeto") Objeto objeto, 
			BindingResult result, Model model, Principal principal, OAuth2Authentication auth){
		
		model.addAttribute("categories", categoriaService.getAllCategoria());
		model.addAttribute("objects", objetoService.getAllObjeto());
		 
		/*StringTokenizer st = new StringTokenizer(principal.toString(),",");
		
	     while (st.hasMoreTokens()) {
	    	 if (st.nextToken().toLowerCase().contains("email")) {
	    		 model.addAttribute("usu", st.nextToken());
	    		 System.out.println("----------------------   " + st.nextToken()); 
	    	 }
	     }*/
	     
	     
	    
	     /*List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
	     updatedAuthorities.add(new SimpleGrantedAuthority("ROLE_MANAGER")); 
		
	     Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);
		
	     SecurityContextHolder.getContext().setAuthentication(newAuth);*/
		
		model.addAttribute("usu",  auth.getOAuth2Request().getRequestParameters());
		return "Objeto/ObjetoCrear";
	}
	
	@RequestMapping("/objeto/{idObjeto}")
	public String getObjetoUpdate(@PathVariable("idObjeto") Integer id,Model model){
		model.addAttribute("objeto", objetoService.getObjeto(id));
		model.addAttribute("categories", categoriaService.getAllCategoria());
		model.addAttribute("objects", objetoService.getAllObjeto());
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
    
	@RequestMapping(method=RequestMethod.POST, value="/objeto")
	public ModelAndView addObjeto(Objeto objeto) {
//		Objeto objetopadre;
//		objetopadre = objetoService.getObjeto(idObjPadre);
//		objeto.setObjetoPadre(objetopadre);
		objeto.setActive(true);
		objetoService.addObjeto(objeto);
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
// Done for the project for crocker :D		
//	public List<Objeto> checkTimeObject (int funcion) {
//		
//		System.out.println(" 1 ");
//		List<Objeto> objetos = objetoService.getAllObjeto();
//		List<Objeto> proximos = new ArrayList<Objeto>();
//		
//		for(Objeto objeto : objetos){
//			try {
//				System.out.println(" 2 ");
//				if (objeto.getTiempoMante() != null) {
//					System.out.println(" 3 ");
//					
//					Date now = new Date();
//					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//				    Date date = sdf.parse(objeto.getTiempoMante().toString());
//				    
//				    long between = now.getTime() - date.getTime();
//				    
//					System.out.println(date);
//					System.out.println(" < ");
//					System.out.println(now);
//					
//					if (between >= 0){
//						System.out.println(" 4 ");
//						proximos.add(objeto);
//					}						
//				}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		for (Objeto objeto : proximos){
//			System.out.println(objeto.getMarcaObjeto() + " " + objeto.getDescripcionObjeto() + " " + objeto.getTiempoMante());
//			System.out.println(" 5 ");
//		}
//		if (funcion == 0){
//			if (proximos.size() != 0){ 
//				this.home();
//				System.out.println(" 6 ");
//			}			
//		}
//		
//		return proximos;
//	}
	
	
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
