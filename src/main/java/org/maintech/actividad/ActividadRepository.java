package org.maintech.actividad;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ActividadRepository extends CrudRepository<Actividad, Integer> {

	
	@Query(nativeQuery = true, value= "update actividad e set e.is_active=0 where e.id_actividad = ?1")
	@Transactional
	@Modifying
	void softDeleteActividad(Integer id);
	//#{#entityName}

	@Query(value = "select * from actividad order by id_actividad desc limit 1;", 
	        nativeQuery=true
	    )
	public Actividad findLast();
}
