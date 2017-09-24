package org.maintech.tipomantenimiento;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TipoMantenimientoRepository extends CrudRepository<TipoMantenimiento, Integer> {
	
	@Query(nativeQuery = true, value= "update tipo_mantenimiento e set e.is_active=0 where e.id_tipo_mantenimiento = ?1")
	@Transactional
	@Modifying
	void softDeleteTipoMantenimiento(Integer id);
	//#{#entityName}

}
