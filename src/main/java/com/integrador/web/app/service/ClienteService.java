package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.integrador.web.app.interfaceService.IpersonaService;
import com.integrador.web.app.interfaces.ICliente;
import com.integrador.web.app.model.Cliente;

public class ClienteService implements IpersonaService {

	@Autowired
	private ICliente data;
	
	@Override
	public List<Cliente> Listar() {
		return (List<Cliente>) data.findAll();
	}

	@Override
	public Optional<Cliente> BuscarPorId(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int Insertar(Cliente c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
