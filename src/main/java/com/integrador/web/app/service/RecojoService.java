package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.IRecojoService;
import com.integrador.web.app.interfaces.IRecojo;
import com.integrador.web.app.model.IRecojoGroupByMotorizado;
import com.integrador.web.app.model.Recojo;


@Service
public class RecojoService implements IRecojoService {

	@Autowired
	private IRecojo data;
	
	
	@Override
	public List<Recojo> Listar() {       
		return (List<Recojo>)data.findByMotorizadoIsNull();
	}
	@Override
	public int Insertar(Recojo r) {
		int res = 0;
		Recojo recojo = data.save(r);
		if(!recojo.equals(null)) {
			res = 1;
		}		
		return res;
	}

	@Override
	public Optional<Recojo> BucarPorId(int Id) {
		Optional<Recojo> recojo = data.findById(Id);
		return recojo;
	}
	@Override
	public List<IRecojoGroupByMotorizado> ListarRecojosPorMotorizado() {
		
		return (List<IRecojoGroupByMotorizado>)data.recojosPorMotorizado();
	}
	

	

	

}
