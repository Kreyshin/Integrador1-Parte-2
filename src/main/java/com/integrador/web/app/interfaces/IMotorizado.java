package com.integrador.web.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.integrador.web.app.model.Motorizado;

@Repository
public interface IMotorizado extends CrudRepository<Motorizado, Integer> {

}
