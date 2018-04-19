package org.maintech.actividadproveedor;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ActividadProveedorRepository extends CrudRepository<ActividadProveedor, Integer> {

	@Query(nativeQuery = true, value= "update actividad_proveedor e set e.is_active=0 where e.id_actividad_proveedor = ?1")
	@Transactional
	@Modifying
	void softDeleteActividadProveedor(Integer id);
	//#{#entityName}

	@Query(value="select actividad.id_actividad, concat('$ ',  costo.costo, ' - ', proveedor.nombre_proveedor, ' - ', actividad.nombre_actividad) as act " + 
			" from actividad, (select id_actividad, id_proveedor, max(id_costo) as idC from actividad_proveedor group by id_actividad, id_proveedor) as actP, proveedor, costo " + 
			" where actividad.id_actividad=actP.id_actividad and " +
				" actP.id_proveedor=proveedor.id_proveedor and " +
				" actP.idC=costo.id_costo " + 
			" order by proveedor.id_proveedor, actividad.id_actividad;", nativeQuery=true)
	public List<Object[]> getActividadProveedorCosto();
	
	
	@Query(value="select ap.id_actividad, ap.id_proveedor, p.nombre_proveedor,c.costo from actividad_proveedor as ap inner join costo as c on ap.id_costo = c.id_costo inner join proveedor as p on p.id_proveedor = ap.id_proveedor where c.fecha_fin_costo is null and ap.id_actividad = ?1", nativeQuery=true)	
	Object[] getProvCostxAct(Integer id);

	@Query(value="select c.id_costo from actividad_proveedor as ap inner join costo as c on ap.id_costo = c.id_costo where id_actividad = ?1 order by c.id_costo desc limit 1", nativeQuery=true)	
	Integer getLastCosto(Integer idActividad);
	
}
