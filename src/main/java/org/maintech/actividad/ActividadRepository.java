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

	@Query(value = "select descripcion_actividad, actividad.id_actividad from actividad inner join objeto_actividad on actividad.id_actividad=objeto_actividad.id_actividad where objeto_actividad.objeto_id_objeto = ?1",
	        nativeQuery=true
	    )
    public List<Object[]> getPlantAct_Objt(Integer idObjeto);
	    
	@Query(value="select CONCAT(descripcion_actividad,'  ',nombre_proveedor) as Descripcion, concat(actividad.id_actividad,'|',actividad_proveedor.id_proveedor) as IDs from objeto_actividad INNER JOIN actividad ON actividad.id_actividad = objeto_actividad.id_actividad INNER JOIN actividad_proveedor ON actividad.id_actividad = actividad_proveedor.id_actividad INNER JOIN proveedor ON proveedor.id_proveedor= actividad_proveedor.id_proveedor where objeto_actividad.objeto_id_objeto = ?1", nativeQuery=true)
	public List<Object[]> getActividadProveedorxObjt(Integer idObjeto);
	
	@Query(value="select concat(descripcion_actividad,' - $', costo.costo) ,actividad.id_actividad, max(actividad_proveedor.id_costo) from objeto_actividad INNER JOIN actividad ON actividad.id_actividad = objeto_actividad.id_actividad INNER JOIN actividad_proveedor ON actividad.id_actividad = actividad_proveedor.id_actividad inner join costo on costo.id_costo = actividad_proveedor.id_costo where objeto_actividad.objeto_id_objeto = ?1 and actividad_proveedor.id_proveedor = ?2", nativeQuery=true)
	public List<Object[]> getidActividadProveedorxObjt(Integer idObjeto, Integer idProveedor);
		
	@Query(value="select costo from costo join (select max(id_costo) as idC from actividad_proveedor where id_actividad = ?1 and id_proveedor = ?2) as maxC on costo.id_costo=maxC.idC;", nativeQuery=true)
	public Double getCostoActividadProveedor(Integer idActividad, Integer idProveedor);	
	
	@Query(value="select a.id_actividad, a.nombre_actividad, p.nombre_proveedor from mantenimiento_objeto_actividad as m inner join actividad as a on m.id_actividad=a.id_actividad inner join proveedor as p on m.id_proveedor=p.id_proveedor where m.id_mantenimiento = ?1", nativeQuery=true)
	public List<Object[]> getactividadxMante(Integer idMantenimiento);

	@Query(nativeQuery = true, value= "delete from objeto_actividad where objeto_id_objeto = ?1")
	@Transactional
	@Modifying
	void deleteAllObjActv(Integer id);

	@Query(nativeQuery = true, value= "insert into objeto_actividad(objeto_id_objeto,id_actividad) values(?1,?2)")
	@Transactional
	@Modifying
	void InsertPlantObjActv(Integer id, Integer parseInt);

	@Query(value="select ap.id_actividad, a.descripcion_actividad,ap.id_proveedor , ap.id_costo, c.costo from actividad_proveedor as ap inner join actividad as a on a.id_actividad = ap.id_actividad inner join costo as c on ap.id_costo = c.id_costo where ap.id_proveedor = ?1", nativeQuery=true)
	public List<Object[]> getidActCostidProve(Integer idProveedor);	
}


