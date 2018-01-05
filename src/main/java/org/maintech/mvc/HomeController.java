package org.maintech.mvc;

import java.security.Principal;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.maintech.mantenimiento.Mantenimiento;
import org.maintech.mantenimiento.MantenimientoService;
import org.maintech.reporterol.ReporteRolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings("unused")
@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected String home(final Map<String, Object> model, final Principal principal) {
        logger.info("Home page");        
        return "home";
    }
    
    // SEND REPORTS
    
    @Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	private ReporteRolService reporteRolService;
	
	@Autowired
	private MantenimientoService mantenimientoService;
    
	@Scheduled(fixedRate=30000)
	public void Rep(){
		this.mails();
	}
	
	@RequestMapping("/reportsMail")
    @ResponseBody
    String mails() {
		
		String result = "";
		
		// REPORTE MANTENIMIENTOS EMERGENTES
        try {
            sendEmail();
            result = "Reporte Mantenimientos Emergentes Enviado";
        }catch(Exception ex) {
        	result = "Error al enviar email: "+ex;
        }
        
		// REPORTE COSTOS MENSUALES
        try {
        	Calendar now = Calendar.getInstance();
        	sendEmailCostsReport(now.get(Calendar.MONTH)+1, now.get(Calendar.YEAR));
        	result = result + " Reporte Costos Mensuales Enviado";
        }catch(Exception ex) {
        	result = "Error al enviar email: "+ex;
        }
        
        return result;
    } 

    private void sendEmail() throws Exception{
    	
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


    @RequestMapping("/reporteCostos")
    private void sendEmailCostsReport(Integer mesNum, Integer anio) throws Exception{

    	String[] address = reporteRolService.getAllCorreos("Reportes de Costos");
    	System.out.println(mesNum);
    	System.out.println(anio);
    	String mes = getMonthForInt(mesNum-1).toUpperCase();
    	System.out.println(mes);
    	System.out.println("1");
    	if (!isEmptyStringArray(address)) {
    		System.out.println("2");
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
	    			+"<h1>Reporte de Costos para " + mes + " de " + anio + "</h1>"
	    			+"<table style=\"font-family: 'Raleway',sans-serif;font-size: 15px\">"
	    			+"<tr style=\"text-align: center;font-weight: 600;font-family: 'Raleway',sans-serif;font-size: 15px;color: #008080;\">"
		    			+"<th>Mantenimiento</th>"
		    			+"<th>Fecha</th>"
		    			+"<th> </th>"
		    			+"<th>Equipo</th>"
		    			+"<th>Costos</th>"
	    			+"</tr>";
	        
	        String texto2="";
	        System.out.println("3");
	        for (Object[] mantenimiento: mantenimientoService.CostoMantenimiento(mesNum, anio)) {
	        	if (mantenimiento[0]==null || mantenimiento[1]==null || mantenimiento[2]==null || 
	        			mantenimiento[3]==null || mantenimiento[4]==null){
	        		
	        	} else {
		        	texto2 = texto2 + "<tr style=\"text-align: center;font-family: 'Raleway',sans-serif;font-size: 15px;\"><td>" + mantenimiento[0].toString() + "</td>"
						+"<td>" + mantenimiento[1].toString() + "</td>"
				    	+"<th> </th>"
						+"<td>" + mantenimiento[2].toString() + " " + mantenimiento[3].toString() + "</td>"
						+"<td>$ " + mantenimiento[4].toString() + "</td></tr>";
	        	}
		    };
		    System.out.println("5");
	        helper.setText(texto1
				+ texto2                                                                                                                 
				+"</table><h2>Total Mes: $ " + mantenimientoService.CostoMantenimientosMes(mesNum, anio) + "</h2></div></body></html>", true);
	        helper.setSubject("Reporte de Costos para " + mes + " de " + anio);
	        System.out.println("6");
	        mailSender.send(message);
    	}
    }
    
    String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }
    
    public boolean isEmptyStringArray(String [] array){
		 for(int i=0; i<array.length; i++){ 
		  if(array[i]!=null){
		   return false;
		  }
		  }
		  return true;
	}
}
