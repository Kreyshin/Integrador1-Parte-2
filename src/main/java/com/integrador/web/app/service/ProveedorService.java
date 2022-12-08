package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IProveedor;
import com.integrador.web.app.model.Proveedor;
import com.integrador.web.app.model.Interfaces.IProveedorLista;

@Service
public class ProveedorService implements ICrudService<Proveedor> {

    @Autowired
    private IProveedor repo;

    @Override
    public List<Proveedor> Listar() {      
        return repo.findAll();
    }

    @Override
    public int Insertar(Proveedor clase) {
        int res = 0;
        Proveedor proveedor = repo.save(clase);
        if (!proveedor.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public Proveedor BuscarPorId(int id) {
        Optional<Proveedor> opProveedor = repo.findById(id);
        return opProveedor.get();
    }

    @Override
    public int Actualizar(Proveedor clase) {
        int res = 0;
        Proveedor proveedor = repo.save(clase);
        if(!proveedor.equals(null)){
            res = 1;
        }      
        return res;
    }

    @Override
    public int Eliminar(Proveedor clase) {
        repo.delete(clase);
        return 0;
    }

    public List<IProveedorLista> ListaProveedores()
    {
        return repo.ListarProveedores();
    }
    
    public Proveedor ParsearJsonModelo(String queryData){
                    
        ObjectMapper myMapper = new ObjectMapper();
        Proveedor claseResultado = new Proveedor();
        try {
             claseResultado = myMapper.readValue(queryData, Proveedor.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return claseResultado;
    }

}