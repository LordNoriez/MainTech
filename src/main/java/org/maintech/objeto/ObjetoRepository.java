package org.maintech.objeto;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ObjetoRepository extends CrudRepository<Objeto, Integer> {

	@Query(nativeQuery = true, value= "update objeto e set e.is_active=0 where e.id_objeto = ?1")
	@Transactional
	@Modifying
	void softDeleteObjeto(Integer id);
	//#{#entityName}
	
	@Query(value = "select id_objeto from objeto order by id_objeto desc limit 1",
	        nativeQuery=true
	    )
	    public Integer UltimoObjetoId();
		
	@Query(nativeQuery = true, value= "insert into objeto_actividad(id_actividad,objeto_id_objeto) values(?1,?2)")
	@Transactional
	@Modifying
	void LinkActividad_objeto(Integer idActividad, Integer idObjeto);
}
