package org.maintech.movimiento;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MovimientoRepository extends CrudRepository<Movimiento, Integer> {

	
	@Query(nativeQuery = true, value= "update movimiento e set e.is_active=0 where e.id_movimiento = ?1")
	@Transactional
	@Modifying
	void softDeleteMovimiento(Integer id);
	//#{#entityName}
	
	
	@Query(value = "Select if(isnull(Egresos),if(isnull(Ingresos), '0',Ingresos),if(isnull(Ingresos), Egresos*-1, (Ingresos-Egresos))) as Stock from objeto left join ((select sum(cantidad_movimiento) as Ingresos, objeto_id_objeto from movimiento where tipo_movimiento_id_tipo_movimiento=1 and movimiento.is_active=1 group by objeto_id_objeto) as Ingres left join (select sum(cantidad_movimiento) as Egresos, objeto_id_objeto from movimiento where tipo_movimiento_id_tipo_movimiento=2 and movimiento.is_active=1 group by objeto_id_objeto) as Egres on Egres.objeto_id_objeto=Ingres.objeto_id_objeto) on objeto.id_objeto = Ingres.objeto_id_objeto where objeto.is_active=1 and objeto.id_objeto = ?1",
	        nativeQuery=true
	    )
	    public Integer CantidadInventario(Integer IdObjeto);
	

	@Query(value="select descripcion_movimiento, cantidad_movimiento, DATE_FORMAT(fecha_movimiento , '%d/%M/%Y') as fecha, marca_objeto, descripcion_objeto, id_movimiento, nombre_tipo_movimiento from movimiento join objeto on objeto.id_objeto=movimiento.objeto_id_objeto join tipo_movimiento on id_tipo_movimiento=tipo_movimiento_id_tipo_movimiento where objeto.is_active=1 and movimiento.is_active=1;", nativeQuery=true)
	public List<Object[]> getFullMovimiento();
}
