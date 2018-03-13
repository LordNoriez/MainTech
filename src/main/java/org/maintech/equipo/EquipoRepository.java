package org.maintech.equipo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EquipoRepository extends CrudRepository<Equipo, Integer> {

	@Query(nativeQuery = true, value= "update equipo e set e.is_active=0 where e.id_equipo = ?1")
	@Transactional
	@Modifying
	void softDeleteEquipo(Integer id);
	//#{#entityName}
}
