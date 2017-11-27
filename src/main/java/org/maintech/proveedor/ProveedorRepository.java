package org.maintech.proveedor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProveedorRepository extends CrudRepository<Proveedor, Integer> {

	@Query(nativeQuery = true, value= "update proveedor e set e.is_active=0 where e.id_objeto = ?1")
	@Transactional
	@Modifying
	void softDeleteProveedor(Integer id);
	//#{#entityName}
}
