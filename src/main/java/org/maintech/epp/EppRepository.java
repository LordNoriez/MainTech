package org.maintech.epp;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EppRepository extends CrudRepository<Epp, Integer> {

	@Query(nativeQuery = true, value= "update epp e set e.is_active=0 where e.id_epp = ?1")
	@Transactional
	@Modifying
	void softDeleteEpp(Integer id);
	//#{#entityName}
    
	@Query(value = "select e.id_epp, e.nombre_epp from mantenimiento_epp as m inner join epp as e on m.id_epp = e.id_epp where m.id_mantenimiento = ?1",
	        nativeQuery=true
	    )
    public List<Object[]> getEppsMainte(Integer id);
  	
	@Query(nativeQuery = true, value= "delete from mantenimiento_epp where id_mantenimiento = ?1")
	@Transactional
	@Modifying
	void deleteAllMantEpp(Integer id);
	
	@Query(nativeQuery = true, value= "insert into mantenimiento_epp(id_mantenimiento,id_epp) values (?1,?2)")
	@Transactional
	@Modifying
	void InsertMantEpp(Integer idMantenmiento, Integer idEpp);
	
}
