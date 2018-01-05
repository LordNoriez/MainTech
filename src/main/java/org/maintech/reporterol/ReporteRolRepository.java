package org.maintech.reporterol;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReporteRolRepository extends CrudRepository<ReporteRol, Integer> {
	
	@Query(value="select correo_usuario from Usuario, reporte, reporte_rol where Usuario.rol_id_rol=reporte_rol.id_rol and reporte_rol.id_reporte=reporte.id_reporte and Usuario.is_active=1 and LOWER(reporte.nombre_reporte) LIKE LOWER(CONCAT('%',:reporte, '%'))"
			, nativeQuery=true)
    List<String> getAllCorreos(@Param("reporte") String reporte);

	@Query(value="select * from reporte_rol where reporte_rol.id_reporte = ?1 and reporte_rol.id_rol = ?2"
			, nativeQuery=true)	
	public List<ReporteRol> findByIds(Integer idReporte, Integer idRol);
}
