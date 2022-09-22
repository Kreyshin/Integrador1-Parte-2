package com.integrador.web.app.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.integrador.web.app.model.Cliente;

public interface ICliente extends CrudRepository<Cliente, Integer> {

}
