package com.integrador.web.app.service;

import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.ICondicionPago;
import com.integrador.web.app.model.CondicionPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondicionPagoService implements ICrudService<CondicionPago> {

    @Autowired
    private ICondicionPago repo;

    @Override
    public List<CondicionPago> Listar() {
        return repo.findAll();
    }

    @Override
    public int Insertar(CondicionPago clase) {
        int res = 0;
        CondicionPago condicionPago = repo.save(clase);
        if (!condicionPago.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public CondicionPago BuscarPorId(int id) {
        Optional<CondicionPago> optionalCondicionPago = repo.findById(id);
        CondicionPago  condicionPago = optionalCondicionPago.get();
        return condicionPago;
    }

    @Override
    public int Actualizar(CondicionPago clase) {
        int res = 0;
        CondicionPago condicionPago = repo.save(clase);
        if (!condicionPago.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public int Eliminar(CondicionPago clase) {
        repo.delete(clase);
        return 1;
    }
}
