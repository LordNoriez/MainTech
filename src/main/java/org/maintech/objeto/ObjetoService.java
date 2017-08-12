package org.maintech.objeto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetoService {
	
	@Autowired
	private ObjetoRepository objetoRepository;
	
	public List<Objeto> getAllObjeto(){
		List<Objeto> objetos = new ArrayList<>();
		objetoRepository.findAll()
		.forEach(objetos::add);
		return objetos;
	}
	
	public Objeto getObjeto (Integer id) {
		return objetoRepository.findOne(id);
	}

	public void addObjeto(Objeto topic) {		
		objetoRepository.save(topic);
	}

	public void updateObjeto(Integer id, Objeto topic) {		
		objetoRepository.save(topic);		
	}

	public void deleteObjeto(Integer id) {
		objetoRepository.delete(id);
	}
	
//	public List<Objeto> timeObjeto () {
//		Integer i = 0;
//		
//		List<Objeto> objetos = null;
//		objetos=this.getAllObjeto();
//		List<Objeto> proximos = new ArrayList<Objeto>();
//		DateFormat formatter = new SimpleDateFormat("HH:mm");
//		
//		for (i=0;i<objetos.size();i++) {
//			try {
//				if (objetos.get(i).getTiempoMante() != null) {
//					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");    
//					Date resultdate = new Date(System.currentTimeMillis());
//					
//					if (formatter.parse(objetos.get(i).getTiempoMante()).getTime() < formatter.parse(sdf.format(resultdate)).getTime()) {
//						proximos.add(objetos.get(i));
//					}
//				}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		return proximos;
//	}
	
}
