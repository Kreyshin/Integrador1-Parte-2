package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IProducto;
import com.integrador.web.app.interfaces.IProductoLista;
import com.integrador.web.app.model.Producto;

@Service
public class ProductoService implements ICrudService<Producto> {

    @Autowired
    private IProducto repo;


    @Override
    public List<Producto> Listar() {        
        return repo.findAll();
    }

    @Override
    public int Insertar(Producto clase) {
        int res = 0;
        Producto producto = repo.save(clase);
        if(!producto.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public Producto BuscarPorId(int id) {
        Optional<Producto> optProd = repo.findById(id);
        Producto producto = optProd.get();
        return producto;
    }

    @Override
    public int Actualizar(Producto clase) {
        int res = 0;
        Producto producto = repo.save(clase);
        if(!producto.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public int Eliminar(Producto clase) {
        repo.delete(clase);
        return 0;
    }
    
    public Producto ParsearJsonModelo(String queryData){
                    
        ObjectMapper myMapper = new ObjectMapper();
        myMapper.registerModule(new JavaTimeModule());
        Producto claseResultado = new Producto();
        try {
            System.out.println(queryData);
             claseResultado = myMapper.readValue(queryData, Producto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return claseResultado;
    }

    public List<IProductoLista> ListaProductos()
    {
        return repo.listadoProductos();
    }
}