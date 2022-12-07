package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IAlmacen;
import com.integrador.web.app.model.Almacen;

@Service
public class AlmacenService implements ICrudService<Almacen> {

    @Autowired
    private IAlmacen repo;

    @Override
    public List<Almacen> Listar() {
        
        return repo.findAll();
    }

    @Override
    public int Insertar(Almacen clase) {
        int res= 0;
        Almacen almacen = repo.save(clase);
        if(!almacen.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public Almacen BuscarPorId(int id) {
        Optional<Almacen> optAlma = repo.findById(id);
        Almacen almacen = optAlma.get();
        return almacen;
    }

    @Override
    public int Actualizar(Almacen clase) {
        int res= 0;
        Almacen almacen = repo.save(clase);
        if(!almacen.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public int Eliminar(Almacen clase) {
       repo.delete(clase);
        return 0;
    }
    
    public Almacen ParsearJsonModelo(String queryData){
                    
        ObjectMapper myMapper = new ObjectMapper();
        Almacen claseResultado = new Almacen();
        try {
             claseResultado = myMapper.readValue(queryData, Almacen.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return claseResultado;
    }
}