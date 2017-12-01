package org.maintech.actividad;

import java.util.List;

import org.maintech.actividadproveedor.ActividadProveedor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ActividadRepository extends CrudRepository<Actividad, Integer> {

	
	@Query(nativeQuery = true, value= "update actividad e set e.is_active=0 where e.id_actividad = ?1")
	@Transactional
	@Modifying
	void softDeleteActividad(Integer id);
	//#{#entityName}

	@Query(value = "select * from actividad order by id_actividad desc limit 1;", 
	        nativeQuery=true
	    )
	public Actividad findLast();
	
	@Query(value = "select actividad.id_actividad, descripcion_actividad, nombre_actividad, nombre_proveedor, costo, DATE_FORMAT(fecha_inicio_costo, '%d/%M/%Y'), DATE_FORMAT(fecha_fin_costo, '%d/%M/%Y'), proveedor.id_proveedor, costo.id_costo from " + 
	    " actividad, proveedor, (select id_actividad, id_proveedor, max(id_costo) as idC from actividad_proveedor group by id_actividad, id_proveedor) as actProv, costo where " + 
	    " actividad.is_active=true and actProv.id_actividad=actividad.id_actividad and actProv.id_proveedor=proveedor.id_proveedor and " + 
	    " actProv.idC=costo.id_costo;", nativeQuery=true)
	public List<Object> getActividadesProveedores();
	
	@Query(value ="select max(id_costo) from actividad_proveedor where id_actividad=?1 group by id_actividad, id_proveedor;", 
			nativeQuery=true)
	public Integer getCostoActividad(Integer id);
	
	@Query(value ="select id_proveedor from actividad_proveedor where id_actividad=?1;", 
			nativeQuery=true)
	public Integer getProveedorActividad(Integer id);
	
	@Query(value = "select * from actividad_proveedor where id_actividad=?1 and id_proveedor=?2 and id_costo=?3;", 
			nativeQuery=true)
	public ActividadProveedor getActividadProveedor(Integer idActividad, Integer idProveedor, Integer idCosto);
}
