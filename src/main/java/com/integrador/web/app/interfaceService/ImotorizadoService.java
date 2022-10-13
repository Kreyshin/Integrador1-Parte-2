package com.integrador.web.app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.integrador.web.app.model.Motorizado;

public interface ImotorizadoService {
    public List<Motorizado>Listar();
    public Optional<Motorizado>BuscarPorId(int id);
    public int Insertar(Motorizado c);
    public List<Motorizado> listarPorPlaca(String busccar);
}
