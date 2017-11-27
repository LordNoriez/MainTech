package org.maintech.objetoActividad;


import org.springframework.data.repository.CrudRepository;


public interface ObjetoActividadRepository extends CrudRepository<ObjetoActividad, Integer> {

	void softDeleteObjetoActividad(Integer id);
	
	
	
				
}
