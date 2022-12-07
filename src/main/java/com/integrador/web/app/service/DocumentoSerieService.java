package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    public List<DocumentoSerie> ListarPorDocumento(int id) {        
        return repo.ListarPorDocumento(id);
    }

    public DocumentoSerie BuscarSerieDocumento(int idSeriDocu, int idDocu) {
        DocumentoSerie documentoSerie = repo.BuscarSerieDocumento(idSeriDocu, idDocu);
        return documentoSerie;
    }

    public DocumentoSerie ParsearJsonModelo(String queryData){
                    
        ObjectMapper myMapper = new ObjectMapper();
        DocumentoSerie claseResultado = new DocumentoSerie();
        try {
             claseResultado = myMapper.readValue(queryData, DocumentoSerie.class);
        } catch (Exception e) {
            // TODO: handle exception
        } 
        return claseResultado;
    }
}