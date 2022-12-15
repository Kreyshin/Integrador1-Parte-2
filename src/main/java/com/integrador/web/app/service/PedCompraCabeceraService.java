package com.integrador.web.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IPedCompraCabecera;
import com.integrador.web.app.model.PedCompraCabecera;
import com.integrador.web.app.model.Interfaces.PedCompDeta;

@Service
public class PedCompraCabeceraService implements ICrudService<PedCompraCabecera> {

    @Autowired
    private IPedCompraCabecera repo;

    @Override
    public List<PedCompraCabecera> Listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int Insertar(PedCompraCabecera clase) {
        int res = 0;
        PedCompraCabecera pedido = repo.save(clase);
        if(!pedido.equals(null)){
            res = pedido.getIdPediCompCabe();
        }
        return res;
    }

    @Override
    public PedCompraCabecera BuscarPorId(int id) {
        Optional<PedCompraCabecera> opCabecera = repo.findById(id);
        return opCabecera.get();
    }

    @Override
    public int Actualizar(PedCompraCabecera clase) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int Eliminar(PedCompraCabecera clase) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    public String ObtenerUltimoNumero() {        
        return repo.ObtenerUltimoNumeroPedido();
    }

    public PedCompraCabecera ParsearJsonModelo(String queryData){
                    
        ObjectMapper myMapper = new ObjectMapper();
        myMapper.registerModule(new JavaTimeModule());
        PedCompraCabecera claseResultado = new PedCompraCabecera();
        try {
             claseResultado = myMapper.readValue(queryData, PedCompraCabecera.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return claseResultado;
    }


    public List<PedCompDeta> ParsearJsonDetalles(String queryData){
                    
        ObjectMapper myMapper = new ObjectMapper();
        myMapper.registerModule(new JavaTimeModule());
        List<PedCompDeta> claseResultado = new ArrayList<>();
        TypeReference<List<PedCompDeta>> mymap = new TypeReference<List<PedCompDeta>>() {};
        try {
             claseResultado = myMapper.readValue(queryData, mymap);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return claseResultado;
    }

}