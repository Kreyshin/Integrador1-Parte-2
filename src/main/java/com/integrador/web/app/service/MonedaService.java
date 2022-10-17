package com.integrador.web.app.service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IMoneda;
import com.integrador.web.app.model.Moneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaService implements ICrudService<Moneda> {

    @Autowired
    private IMoneda repo;

    @Override
    public List<Moneda> Listar() {
        return repo.findAll();
    }

    @Override
    public int Insertar(Moneda clase) {
        int res = 0;
        Moneda moneda = repo.save(clase);
        if (!moneda.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public Moneda BuscarPorId(int id) {
        Optional<Moneda> opMoneda = repo.findById(id);
        return opMoneda.get();
    }

    @Override
    public int Actualizar(Moneda clase) {
        int res = 0;
        Moneda moneda = repo.save(clase);
        if (!moneda.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public int Eliminar(Moneda clase) {
        repo.delete(clase);
        return 1;
    }
}
