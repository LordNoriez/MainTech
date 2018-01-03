package org.maintech.color;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ColorRepository extends CrudRepository<Color, Integer> {
	
	@Query(nativeQuery = true, value= "update color e set e.is_active=0 where e.id_color = ?1")
	@Transactional
	@Modifying
	void softDeleteColor(Integer id);
	//#{#entityName}

}
