package org.maintech.usuario;

import java.util.List;

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
	
	@Query(value="select area_empresa_id_area_empresa from usuario where correo_usuario = ?1"
			, nativeQuery=true)
	public Integer getAreaByMail(String mail);
	
	@Query(value = "select u.nombre_usuario, r.nombre_rol from usuario as u inner join rol as r on u.rol_id_rol = r.id_rol inner join mantenimiento_usuario as mu on u.id_usuario = mu.id_usuario where mu.id_mantenimiento = ?1 and is_autorizado_mantenimiento = 1;"
		, nativeQuery=true)
    public List<Object[]> getautorizan(Integer id);

	@Query(value = "select u.nombre_usuario, r.nombre_rol from usuario as u inner join rol as r on u.rol_id_rol = r.id_rol inner join mantenimiento_usuario as mu on u.id_usuario = mu.id_usuario where mu.id_mantenimiento = ?1 and is_liberado_mantenimiento = 1;"
			, nativeQuery=true)
	    public List<Object[]> getliberacion(Integer id);
}
