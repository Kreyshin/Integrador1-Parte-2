package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IMarca;
import com.integrador.web.app.model.Marca;

@Service
public class MarcaService implements ICrudService<Marca> {

    @Autowired
    private IMarca repo;

    @Override
    public List<Marca> Listar() {
        
        return repo.findAll();
    }

    @Override
    public int Insertar(Marca clase) {
        int res = 0;
        Marca marca = repo.save(clase);
        if(!marca.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public Marca BuscarPorId(int id) {
        Optional<Marca> optMarc = repo.findById(id);
        Marca marca = optMarc.get();
        return marca;
    }

    @Override
    public int Actualizar(Marca clase) {
        int res = 0;
        Marca marca = repo.save(clase);
        if(!marca.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public int Eliminar(Marca clase) {
        repo.delete(clase);
        return 0;
    }
    
}