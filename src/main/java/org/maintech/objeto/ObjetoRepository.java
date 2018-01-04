package org.maintech.objeto;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ObjetoRepository extends CrudRepository<Objeto, Integer> {

	@Query(nativeQuery = true, value= "update objeto e set e.is_active=0 where e.id_objeto = ?1")
	@Transactional
	@Modifying
	void softDeleteObjeto(Integer id);
	//#{#entityName}
	
	@Query(value = "select id_objeto from objeto order by id_objeto desc limit 1",
	        nativeQuery=true
	    )
	    public Integer UltimoObjetoId();
		
	@Query(nativeQuery = true, value= "insert into objeto_actividad(id_actividad,objeto_id_objeto) values(?1,?2)")
	@Transactional
	@Modifying
	void LinkActividad_objeto(Integer idActividad, Integer idObjeto);
	
	@Query(value="Select if(isnull(Egresos),if(isnull(Ingresos), '0',Ingresos),if(isnull(Ingresos), Egresos*-1, (Ingresos-Egresos))) as Stock, objeto.id_objeto, objeto.marca_objeto, objeto.modelo_objeto, objeto.serial_objeto, objeto.vida_objeto, nombre_area_empresa , objeto.descripcion_objeto, DATE_FORMAT(objeto.fecha_creacion_objeto, '%d/%M/%Y') as fecha_creacion, DATE_FORMAT(objeto.fecha_obtencion_objeto , '%d/%M/%Y') as fecha_obtencion, nombre_categoria , objP.marca_objeto as MarcaPadre, objP.descripcion_objeto as Padre from objeto left join objeto as objP  on objP.id_objeto=objeto.objeto_padre_id_objeto left join ((select sum(cantidad_movimiento) as Ingresos, objeto_id_objeto from movimiento where tipo_movimiento_id_tipo_movimiento=1 and movimiento.is_active=1 group by objeto_id_objeto) as Ingres left join (select sum(cantidad_movimiento) as Egresos, objeto_id_objeto from movimiento where tipo_movimiento_id_tipo_movimiento=2 and movimiento.is_active=1 group by objeto_id_objeto) as Egres on Egres.objeto_id_objeto=Ingres.objeto_id_objeto) on objeto.id_objeto = Ingres.objeto_id_objeto, area_empresa, categoria where objeto.is_active=1 and area_empresa.id_area_empresa=objeto.area_empresa_id_area_empresa and categoria.id_categoria=objeto.categoria_id_categoria;", nativeQuery=true)
	public List<Object[]> getFullObjeto();
}
