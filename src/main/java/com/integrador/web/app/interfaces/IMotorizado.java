package com.integrador.web.app.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.integrador.web.app.model.IRecojoGroupByMotorizado;
import com.integrador.web.app.model.Motorizado;

@Repository
public interface IMotorizado extends CrudRepository<Motorizado, Integer> {
	@Query(value = "SELECT mo.id, mo.ape_materno, mo.ape_paterno, mo.correo, "
		     + "mo.fecha_nacimiento, mo.nombre, mo.num_documento, "
		     + "mo.num_licencia, mo.num_placa, mo.telefono, mo.tip_documento "
		     + "FROM motorizado mo	"
		     + "Where length(?1) = 0 Or  mo.num_placa like %?1%"
		  , nativeQuery = true)
		List<Motorizado> filtrarPorPlaca(String placa);
}
