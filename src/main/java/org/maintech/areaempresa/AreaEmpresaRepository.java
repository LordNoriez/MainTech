package org.maintech.areaempresa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AreaEmpresaRepository extends CrudRepository<AreaEmpresa, Integer> {
	
	@Query(nativeQuery = true, value= "update area_empresa e set e.is_active=0 where e.id_area_empresa = ?1")
	@Transactional
	@Modifying
	void softDeleteAreaEmpresa(Integer id);
	//#{#entityName}
}
