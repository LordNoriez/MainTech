package org.maintech;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.maintech.categoria.Categoria;
import org.maintech.mantenimiento.Mantenimiento;
import org.maintech.mantenimiento.MantenimientoController;
import org.maintech.objeto.Objeto;
import org.maintech.objeto.ObjetoController;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTechApplicationTests {

	@Test
	public void contextLoads() {
//		Random rand = new Random();
//		Categoria testCategoria= new  Categoria();
//		Mantenimiento testMantenimiento = new Mantenimiento();
//		Objeto obj = new Objeto();
//		Objeto testObjeto = new Objeto((Integer)(rand.nextInt((100-1)+1)),"Marca","Modelo","Serial", new Date(), new Date(), "Descripcion","longitud", "ancho", "area", "altura", (Integer)(6), obj, testCategoria, testMantenimiento, true);
//		
//		
//		ObjetoController testObjetoController = new ObjetoController();
//		testObjetoController.addObjeto(testObjeto);
		
		Mantenimiento testMantenimiento = new Mantenimiento("Nombre", new Date(),"Descripción");
		MantenimientoController testMantenimientoController = new MantenimientoController();
		testMantenimientoController.addMantenimiento(testMantenimiento);
	}

}
