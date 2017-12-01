package org.maintech.mantenimiento;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MantenimientoRepository extends CrudRepository<Mantenimiento, Integer> {
	
	
	@Query(nativeQuery = true, value= "update mantenimiento e set e.is_active=0 where e.id_mantenimiento = ?1")
	@Transactional
	@Modifying
	void softDeleteMantenimiento(Integer id);
	//#{#entityName}
	
	
	@Query(value = "SELECT mantenimiento.nombre_mantenimiento, "
			+ "sum(actividad.costo_actividad)  FROM mantenimiento JOIN actividad_mantenimientos "
			+ "ON mantenimiento.id_mantenimiento = actividad_mantenimientos.mantenimientos_id_mantenimiento "
			+ "JOIN actividad ON actividad_mantenimientos.actividad_id_actividad = actividad.id_actividad "
			+ "GROUP BY mantenimiento.id_mantenimiento", 
	        nativeQuery=true
	    )
	    public List<Object[]> CostosMantenimiento();
	    
	    
		@Query(value = "select * from mantenimiento where date(fecha_mantenimiento) = '?1'", 
		        nativeQuery=true
		    )
	    	public List<Mantenimiento> EmergentesDiaMantenimiento(String FechaHoy);
	    
		@Query(value = "select id_mantenimiento, frecuencia_mantenimiento -( timestampdiff(hour,fecha_mantenimiento,"
				+ " now())) as TimpoRespctFrecuencia from mantenimiento "
				+ "where is_programado_mantenimiento = 1 and is_aceptado_mantenimiento = 0",
		        nativeQuery=true
		    )
		    public List<Object[]> MantenimientoxTiempo();
		    
		@Query(value = "select * from mantenimiento where is_aceptado_mantenimiento = 0 and is_programado_mantenimiento = 1",
		        nativeQuery=true
		    )
		    public List<Mantenimiento> MantexAceptar();
		
		@Query(value = "select id_mantenimiento from mantenimiento order by id_mantenimiento desc limit 1;",
		        nativeQuery=true
		    )
		    public Integer UltimoMantenimientoId();
		
		@Query(nativeQuery = true, value= "insert into actividad_mantenimientos(actividad_id_actividad, mantenimientos_id_mantenimiento) values (?1,?2)")
		@Transactional
		@Modifying
		void LinkActividad_mantenimiento(Integer idActividad, Integer idMantenimiento);
		
		@Query(nativeQuery = true, value= "delete from actividad_mantenimientos where mantenimientos_id_mantenimiento = ?1")
		@Transactional
		@Modifying
		void DeleteLinkActividad_mantenimiento(Integer idMantenimiento);

		@Query(nativeQuery = true, value= "update mantenimiento set is_aceptado_mantenimiento = 1 where id_mantenimiento = ?1")
		@Transactional
		@Modifying
		void Acept_mantenimiento(Integer id);
	    
		@Query(value = "select mantenimiento.id_mantenimiento, nombre_mantenimiento, descripcion_mantenimiento, " + 
						" nombre_tipo_mantenimiento, fecha_mantenimiento, " +
						" objeto.id_objeto, marca_objeto, descripcion_objeto, proveedor.id_proveedor, nombre_proveedor, " +
						" is_programado_mantenimiento, frecuencia_mantenimiento, is_aceptado_mantenimiento, " +
						" is_en_proceso_mantenimiento, is_terminado_mantenimiento, sum(costo) " + 
				" from tipo_mantenimiento, proveedor, objeto, mantenimiento, mantenimiento_objeto_actividad " + 
				" where mantenimiento.obj_tipo_mantenimiento_id_tipo_mantenimiento=tipo_mantenimiento.id_tipo_mantenimiento and " + 
					" mantenimiento_objeto_actividad.id_mantenimiento=mantenimiento.id_mantenimiento and " + 
					" mantenimiento_objeto_actividad.id_proveedor=proveedor.id_proveedor and " + 
					" mantenimiento_objeto_actividad.id_objeto=objeto.id_objeto and mantenimiento.is_active=1 " + 
				"group by mantenimiento.id_mantenimiento, nombre_mantenimiento, descripcion_mantenimiento, " + 
					" nombre_tipo_mantenimiento, fecha_mantenimiento, objeto.id_objeto, marca_objeto, descripcion_objeto, proveedor.id_proveedor, nombre_proveedor," +
					" is_programado_mantenimiento, frecuencia_mantenimiento, is_aceptado_mantenimiento, is_en_proceso_mantenimiento, is_terminado_mantenimiento",
		        nativeQuery=true
		    )
		    public List<Object[]> getFullMantenimientos();
		
		@Query(nativeQuery = true, value= "insert into mantenimiento_objeto_actividad(id_actividad,id_mantenimiento, id_proveedor, id_objeto, costo) values(?1,?1,?1,?1,?1);")
		@Transactional
		@Modifying
		void LinkMantenimiento_Actividad_Obj_Provee(Integer idActividad, Integer idMantenimiento, Integer idProveedor, Integer idObjeto, Double costo);
				
}
