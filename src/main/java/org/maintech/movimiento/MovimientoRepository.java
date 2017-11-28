package org.maintech.movimiento;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MovimientoRepository extends CrudRepository<Movimiento, Integer> {

	
	@Query(nativeQuery = true, value= "update movimiento e set e.is_active=0 where e.id_actividad = ?1")
	@Transactional
	@Modifying
	void softDeleteMovimiento(Integer id);
	//#{#entityName}
}
