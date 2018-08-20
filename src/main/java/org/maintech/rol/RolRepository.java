package org.maintech.rol;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RolRepository extends CrudRepository<Rol, Integer> {

	@Query(nativeQuery = true, value= "update rol e set e.is_active=0 where e.id_rol = ?1")
	@Transactional
	@Modifying
	void softDeleteRol(Integer id);
	//#{#entityName}
	
	@Query(value="select * from rol where area_empresa_id_area_empresa = ?1"
			, nativeQuery=true)
	public List<Rol> getFullRol(Integer idAreaEmpresa);
}
