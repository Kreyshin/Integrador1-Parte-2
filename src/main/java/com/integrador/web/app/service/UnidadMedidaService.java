package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IUnidadMedida;
import com.integrador.web.app.model.UnidadMedida;

@Service
public class UnidadMedidaService implements ICrudService<UnidadMedida> {

    @Autowired
    private IUnidadMedida repo;

    @Override
    public List<UnidadMedida> Listar() {
       
        return repo.findAll();
    }

    @Override
    public int Insertar(UnidadMedida clase) {
        int res = 0;
        UnidadMedida medida = repo.save(clase);
        if(!medida.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public UnidadMedida BuscarPorId(int id) {
        Optional<UnidadMedida> otpMedida = repo.findById(id);
        UnidadMedida medida = otpMedida.get();
        return medida;
    }

    @Override
    public int Actualizar(UnidadMedida clase) {
        int res = 0;
        UnidadMedida medida = repo.save(clase);
        if(!medida.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public int Eliminar(UnidadMedida clase) {
        repo.delete(clase);
        return 0;
    }
    
}