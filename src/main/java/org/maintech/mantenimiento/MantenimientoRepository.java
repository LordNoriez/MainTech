package org.maintech.mantenimiento;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MantenimientoRepository extends CrudRepository<Mantenimiento, Integer> {
	
	
	@Query(nativeQuery = true, value= "update mantenimiento e set e.is_active=0 where e.id_mantenimiento = ?1")
	@Transactional
	@Modifying
	void softDeleteMantenimiento(Integer id);
	//#{#entityName}
}
