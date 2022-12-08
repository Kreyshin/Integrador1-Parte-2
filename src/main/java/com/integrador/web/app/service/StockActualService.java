package com.integrador.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IStockActual;
import com.integrador.web.app.model.StockActual;

@Service
public class StockActualService implements ICrudService<StockActual> {

    @Autowired
    private IStockActual repo;

    @Override
    public List<StockActual> Listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int Insertar(StockActual clase) {
        int res = 0;
        StockActual stock = repo.save(clase);
        if (!stock.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public StockActual BuscarPorId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int Actualizar(StockActual clase) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int Eliminar(StockActual clase) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}