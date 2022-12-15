package com.integrador.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IPedCompraDetalle;
import com.integrador.web.app.model.PedCompraDetalle;

@Service
public class PedCompraDetalleService implements ICrudService<PedCompraDetalle> {

    @Autowired
    IPedCompraDetalle repo;

    @Override
    public List<PedCompraDetalle> Listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int Insertar(PedCompraDetalle clase) {
        int res = 0;
        PedCompraDetalle pedido = repo.save(clase);
        if(!pedido.equals(null)){
            res = pedido.getNumSecu();
        }
        return res;
    }

    @Override
    public PedCompraDetalle BuscarPorId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int Actualizar(PedCompraDetalle clase) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int Eliminar(PedCompraDetalle clase) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}