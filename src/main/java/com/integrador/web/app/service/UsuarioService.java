package com.integrador.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.web.app.interfaceService.ICrudService;
import com.integrador.web.app.interfaces.IUsuario;
import com.integrador.web.app.model.Usuario;
import com.fasterxml.jackson.datatype.jsr310.*;
@Service
public class UsuarioService implements ICrudService<Usuario> {

    @Autowired
    private IUsuario repo;

    @Override
    public List<Usuario> Listar() {        
        return repo.findAll();
    }

    @Override
    public int Insertar(Usuario clase) {
        int res = 0;
        Usuario usuario = repo.save(clase);
        if(!usuario.equals(null)){
            res = 1;
        }      
        return res;
    }

    @Override
    public Usuario BuscarPorId(int id) {
        Optional<Usuario> optUsuario = repo.findById(id);
        Usuario usuario = optUsuario.get();
        return usuario;
    }

    @Override
    public int Actualizar(Usuario clase) {
        int res = 0;
        Usuario usuario = repo.save(clase);
        if(!usuario.equals(null)){
            res = 1;
        }      
        return res;
    }

    @Override
    public int Eliminar(Usuario clase) {
         repo.delete(clase);
        return 0;
    }

    public Usuario ParsearJsonModelo(String queryData){
                    
        ObjectMapper myMapper = new ObjectMapper();
        myMapper.registerModule(new JavaTimeModule());
        Usuario claseResultado = new Usuario();
        try {
             claseResultado = myMapper.readValue(queryData, Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return claseResultado;
    }
    
}