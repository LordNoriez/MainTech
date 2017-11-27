package org.maintech.actividadproveedor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ActividadProveedorRepository extends CrudRepository<ActividadProveedor, Integer> {

	@Query(nativeQuery = true, value= "update actividad_proveedor e set e.is_active=0 where e.id_objeto = ?1")
	@Transactional
	@Modifying
	void softDeleteActividadProveedor(Integer id);
	//#{#entityName}
}
