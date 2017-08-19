package org.maintech.objeto;

import java.text.DateFormat;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.mail.internet.MimeMessage;

import org.maintech.categoria.Categoria;
import org.maintech.categoria.CategoriaController;
import org.maintech.mantenimiento.MantenimientoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/objeto")
public class ObjetoController {
	
	@Autowired
	private ObjetoService objetoService;
		
    @Autowired
    private JavaMailSender mailSender;

	
	//@RequestMapping(value="/", method=RequestMethod.GET)
	@RequestMapping("/objeto")
	public List<Objeto> getAllObjeto() {

		//this.checkTimeObject(0);
		return objetoService.getAllObjeto();
	}
	
	@RequestMapping("/crearObjeto")
	public ModelAndView crearObjeto(){
		
		ModelAndView mav = new ModelAndView("ObjetoCrear.html", "Crear Objeto", "Crear Objeto");
		List<Categoria> categorias = null;
		CategoriaController cc = new CategoriaController();
		
		mav.addAttribute("categories", cc.getAllCategoria());
		return mav;
	}
	
	@RequestMapping("/objeto/{idObjeto}")
	public Objeto getObjeto(@PathVariable("idObjeto") Integer id){
		
		return objetoService.getObjeto(id);
	}
	
    @PostMapping("/objeto")
    public String addObjeto(@ModelAttribute Objeto objeto) {
    	objeto.setActive(true);    	
		Date date = new Date();
    	objeto.setFechaCreacionObjeto(date);
    	
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
        helper.setText("<html><body><form action='http://localhost:8080/cMantenimiento'><input type='submit' value='Aceptar Mantenimiento de Hoy' /></form>  "
        		+ "<br><body></html>", true);
        //<a href='http://localhost:8080/cMantenimiento'><img src='https://c24e867c169a525707e0-bfbd62e61283d807ee2359a795242ecb.ssl.cf3.rackcdn.com/imagenes/gato/etapas-clave-de-su-vida/gatitos/nuevo-gatito-en-casa/gatito-tumbado-lamiendo-sus-patitas.jpg'/></a>
        helper.setSubject("Confirmar Mantenimiento");
        mailSender.send(message);
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
