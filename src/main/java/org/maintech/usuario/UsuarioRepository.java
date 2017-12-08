package org.maintech.usuario;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query(nativeQuery = true, value= "update usuario e set e.is_active=0 where e.id_usuario = ?1")
	@Transactional
	@Modifying
	void softDeleteUsuario(Integer id);
	//#{#entityName}
}
