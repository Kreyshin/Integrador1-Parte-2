package com.integrador.web.app.interfaceService;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T> {
    public List<T> Listar();
    public  int Insertar(T clase);
    public T BuscarPorId(int id);
    public  int Actualizar(T clase);
    public  int Eliminar(T clase);

}
