package org.maintech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
//@EnableOAuth2Sso
public class MainTechApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MainTechApplication.class, args);
		
	}
}
