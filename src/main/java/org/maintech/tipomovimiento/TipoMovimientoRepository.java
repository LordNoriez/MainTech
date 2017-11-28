package org.maintech.tipomovimiento;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TipoMovimientoRepository extends CrudRepository<TipoMovimiento, Integer> {
	
	@Query(nativeQuery = true, value= "update tipo_mantenimiento e set e.is_active=0 where e.id_tipo_mantenimiento = ?1")
	@Transactional
	@Modifying
	void softDeleteTipoMovimiento(Integer id);
	//#{#entityName}

}
