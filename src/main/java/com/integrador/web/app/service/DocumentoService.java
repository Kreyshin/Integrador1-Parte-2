package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IDocumento;
import com.integrador.web.app.model.Documento;

@Service
public class DocumentoService implements ICrudService<Documento> {

    @Autowired
    private IDocumento repo;

    @Override
    public int Actualizar(Documento clase) {
        int res = 0;
        Documento documento = repo.save(clase);
        if(!documento.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public Documento BuscarPorId(int id) {
        Optional<Documento> opDocumento = repo.findById(id);
        Documento documento = opDocumento.get();
        return documento;
    }

    @Override
    public int Eliminar(Documento clase) {
        repo.delete(clase);
        return 0;
    }

    @Override
    public int Insertar(Documento clase) {
        int res = 0;
        Documento documento = repo.save(clase);
        if(!documento.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public List<Documento> Listar() {        
        return repo.findAll();
    }


    
}