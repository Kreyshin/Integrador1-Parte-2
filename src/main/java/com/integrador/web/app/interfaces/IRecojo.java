package com.integrador.web.app.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.integrador.web.app.model.IRecojoGroupByMotorizado;
import com.integrador.web.app.model.Recojo;


@Repository
public interface IRecojo extends CrudRepository<Recojo, Integer> {
	List<Recojo> findByMotorizadoIsNull();
	@Query(value = "SELECT re.motorizado_id as IdMotorizado, concat(mo.nombre,' ',mo.ape_paterno,' ',mo.ape_materno) As NombreMotorizado, count(re.id) as TotalRecojo "
			     + "FROM recojo As re Inner Join motorizado As mo "
			     + "On re.motorizado_id = mo.id	"
			     + "Where re.motorizado_id is not null	"
			     + "group by re.motorizado_id"
			  , nativeQuery = true)
	List<IRecojoGroupByMotorizado> recojosPorMotorizado();
}
