package com.integrador.web.app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.integrador.web.app.model.Cliente;

public interface IpersonaService {
     public List<Cliente>Listar();
     public Optional<Cliente>BuscarPorId(int id);
     public int Insertar(Cliente c);
}
