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
	    
	    public List<Mantenimiento> findByIsProgramadoMantenimientoFalse();
	    
		@Query(value = "select id_mantenimiento, "
				+ "frecuencia_mantenimiento -( timestampdiff(hour,fecha_mantenimiento, now())) as TimpoRespctFrecuencia "
				+ "from mantenimiento where is_programado_mantenimiento = 1",
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

		@Query(nativeQuery = true, value= "update mantenimiento set is_aceptado_mantenimiento = 1 where id_mantenimiento = ?1")
		@Transactional
		@Modifying
		void Acept_mantenimiento(Integer id);
				
}
