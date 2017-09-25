package org.maintech.categoria;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

	@Query(nativeQuery = true, value= "update categoria e set e.is_active=0 where e.id_categoria = ?1")
	@Transactional
	@Modifying
	void softDeleteCategoria(Integer id);
	//#{#entityName}
}
