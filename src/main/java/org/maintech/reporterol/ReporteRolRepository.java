package org.maintech.reporterol;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReporteRolRepository extends CrudRepository<ReporteRol, Integer> {
	@Query(value="select correo_usuario from usuario, reporte, reporte_rol " +
			" where usuario.rol_id_rol=reporte_rol.id_rol and reporte_rol.id_reporte=reporte.id_reporte and " + 
			" reporte.nombre_reporte='?1';", nativeQuery=true)
	public String[] getAllCorreos(String reporte);
}
