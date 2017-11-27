package org.maintech.costo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CostoRepository extends CrudRepository<Costo, Integer> {

	@Query(nativeQuery = true, value= "update costo e set e.is_active=0 where e.id_objeto = ?1")
	@Transactional
	@Modifying
	void softDeleteCosto(Integer id);
	//#{#entityName}
}
