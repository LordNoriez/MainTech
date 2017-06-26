package org.maintech;

import java.util.ArrayList;
import java.util.List;

import org.maintech.objeto.Objeto;
import org.maintech.objeto.ObjetoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;


@SpringBootApplication
@EnableOAuth2Sso
public class MainTechApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MainTechApplication.class, args);
		ObjetoController objC = new ObjetoController();
		try {						
	        while (true) {
	        	List<Objeto> resultado = new ArrayList<Objeto>();
	        	resultado = objC.checkTimeObject();
	        	for (Objeto obj : resultado){
	        		System.out.println(obj.getTiempoMante());
	        	}
	            Thread.sleep(30 * 1000);
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
