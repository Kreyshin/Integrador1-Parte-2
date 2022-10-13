package com.integrador.web.app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.integrador.web.app.model.IRecojoGroupByMotorizado;
import com.integrador.web.app.model.Recojo;

public interface IRecojoService {
    public List<Recojo>Listar();
    public int Insertar(Recojo c);
    public Optional<Recojo>  BucarPorId(int Id);
    public List<IRecojoGroupByMotorizado> ListarRecojosPorMotorizado();
	
}
