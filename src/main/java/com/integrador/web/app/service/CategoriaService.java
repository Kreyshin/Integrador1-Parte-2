package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.ICategoria;
import com.integrador.web.app.model.Categoria;

@Service
public class CategoriaService implements ICrudService<Categoria> {

    @Autowired
    private ICategoria repo;

    @Override
    public List<Categoria> Listar() {        
        return repo.findAll();
    }

    @Override
    public int Insertar(Categoria clase) {
        int res = 0;
        Categoria categoria = repo.save(clase);
        if(!categoria.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public Categoria BuscarPorId(int id) {
        Optional<Categoria> optCate = repo.findById(id);
        Categoria categoria = optCate.get();
        return categoria;
    }

    @Override
    public int Actualizar(Categoria clase) {
        int res = 0;
        Categoria categoria = repo.save(clase);
        if(!categoria.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public int Eliminar(Categoria clase) {
       repo.delete(clase);
        return 0;
    }
    
}