package org.maintech.reporte;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ReporteRepository extends CrudRepository<Reporte, Integer> {
	
	@Query(nativeQuery = true, value= "update reporte e set e.is_active=0 where e.id_tipo_mantenimiento = ?1")
	@Transactional
	@Modifying
	void softDeleteReporte(Integer id);
	//#{#entityName}

}
