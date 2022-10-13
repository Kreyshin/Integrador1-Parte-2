package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.ImotorizadoService;
import com.integrador.web.app.interfaces.IMotorizado;
import com.integrador.web.app.model.Motorizado;

@Service
public class MotorizadoService implements ImotorizadoService {

	@Autowired
	private IMotorizado data;
	
	
	@Override
	public List<Motorizado> Listar() {		 
		return  (List<Motorizado>)data.findAll();
	}

	@Override
	public Optional<Motorizado> BuscarPorId(int id) {		 
		return  data.findById(id);
	}

	@Override
	public int Insertar(Motorizado m) {
		int res = 0;
		Motorizado motorizado = data.save(m);
		if(!motorizado.equals(null)) {
			res = 1;
		}		
		return res;
	}

	@Override
	public List<Motorizado> listarPorPlaca(String busccar) {
		return  (List<Motorizado>)data.filtrarPorPlaca(busccar);
	}

}
