package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IDocumentoSerie;
import com.integrador.web.app.model.DocumentoSerie;

@Service
public class DocumentoSerieService implements ICrudService<DocumentoSerie> {

    @Autowired
    private IDocumentoSerie repo;

    @Override
    public List<DocumentoSerie> Listar() {        
        return repo.findAll();
    }

    @Override
    public int Insertar(DocumentoSerie clase) {
        int res = 0;
        DocumentoSerie documentoSerie = repo.save(clase);
        if (!documentoSerie.equals(null)) {
            res=1;
        }
        return res;
    }

    @Override
    public DocumentoSerie BuscarPorId(int id) {
        Optional<DocumentoSerie> opDocuSeri = repo.findById(id);
        DocumentoSerie documentoSerie = opDocuSeri.get();
        return documentoSerie;
    }

    @Override
    public int Actualizar(DocumentoSerie clase) {
        int res = 0;
        DocumentoSerie documentoSerie = repo.save(clase);
        if (!documentoSerie.equals(null)) {
            res=1;
        }
        return res;
    }

    @Override
    public int Eliminar(DocumentoSerie clase) {
        repo.delete(clase);
        return 0;
    }
    
}