package org.maintech.estructura;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EstructuraRepository extends CrudRepository<Estructura, Integer> {
	
	@Query(nativeQuery = true, value= "update estructura e set e.is_active=0 where e.id_estructura = ?1")
	@Transactional
	@Modifying
	void softDeleteEstructura(Integer id);
	//#{#entityName}

}
