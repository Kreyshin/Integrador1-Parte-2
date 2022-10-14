package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.IclienteService;
import com.integrador.web.app.interfaces.ICliente;
import com.integrador.web.app.model.Cliente;


@Service
public class ClienteService implements IclienteService {

	@Autowired
	private ICliente data;
	
	@Override
	public List<Cliente> Listar() {
		return (List<Cliente>) data.findAll();
	}

	@Override
	public Optional<Cliente> BuscarPorId(int id) {
		Optional<Cliente> cliente = data.findById(id);
		return cliente;
	}

	@Override
	public int Insertar(Cliente c) {
		int res = 0;
	    Cliente cliente = data.save(c);
	    
	    if(!cliente.equals(null)) {
	    	res = 1;
	    }	    
		return res;
	}

	@Override
	public int Eliminar(Cliente clie) {
		data.delete(clie);
		return 1;
	}

}
