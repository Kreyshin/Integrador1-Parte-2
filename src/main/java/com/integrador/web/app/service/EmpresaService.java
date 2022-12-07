package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IEmpresa;
import com.integrador.web.app.model.Empresa;

@Service
public class EmpresaService implements ICrudService<Empresa> {

    @Autowired
    private IEmpresa repo;

    @Override
    public List<Empresa> Listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int Insertar(Empresa clase) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Empresa BuscarPorId(int id) {
        Optional<Empresa> optEmpresa = repo.findById(id);
        Empresa empresa = optEmpresa.get();
        return empresa;
    }

    @Override
    public int Actualizar(Empresa clase) {
        int res = 0;
        Empresa empresa = repo.save(clase);
        if(!empresa.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public int Eliminar(Empresa clase) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}