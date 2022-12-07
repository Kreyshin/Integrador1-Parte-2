package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.ITipoProveedor;
import com.integrador.web.app.model.TipoProveedor;

@Service
public class TipoProveedorService implements ICrudService<TipoProveedor> {

    @Autowired
    private ITipoProveedor repo;

    @Override
    public List<TipoProveedor> Listar() {
        return repo.findAll();
    }

    @Override
    public int Insertar(TipoProveedor clase) {
        int res = 0;
        TipoProveedor tipoProveedor = repo.save(clase);
        if(!tipoProveedor.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public TipoProveedor BuscarPorId(int id) {
        Optional<TipoProveedor> optTipoProv = repo.findById(id);
        TipoProveedor tipoProveedor = optTipoProv.get();
        return tipoProveedor;
    }

    @Override
    public int Actualizar(TipoProveedor clase) {
        int res = 0;
        TipoProveedor tipoProveedor = repo.save(clase);
        if(!tipoProveedor.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public int Eliminar(TipoProveedor clase) {
        repo.delete(clase);
        return 0;
    }    
}