package com.integrador.web.app.service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IRol;
import com.integrador.web.app.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements ICrudService<Rol> {

    @Autowired
    private IRol repo;

    @Override
    public List<Rol> Listar() {
        return repo.findAll();
    }

    @Override
    public int Insertar(Rol clase) {
        int res = 0;
        Rol rol = repo.save(clase);
        if (!rol.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public Rol BuscarPorId(int id) {
        Optional<Rol> opRol = repo.findById(id);
        return opRol.get();
    }



    @Override
    public int Actualizar(Rol clase) {
        int res = 0;
        Rol rol = repo.save(clase);
        if (!rol.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public int Eliminar(Rol clase) {
         repo.delete(clase);
        return 1;
    }



}
