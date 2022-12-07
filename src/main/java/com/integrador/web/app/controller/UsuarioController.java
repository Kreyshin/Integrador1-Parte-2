package com.integrador.web.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.integrador.web.app.model.Empresa;
import com.integrador.web.app.model.Rol;
import com.integrador.web.app.model.Usuario;
import com.integrador.web.app.service.EmpresaService;
import com.integrador.web.app.service.RolService;
import com.integrador.web.app.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private EmpresaService serviceEmpr;

    @Autowired
    private RolService servieRol;

    @GetMapping("")
    public ModelAndView Usuario(){
        return new ModelAndView("Usuario/Usuario");
    }    
    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> ListarUsuarios(){
        Map<String,Object> resultado = new HashMap<>();
        List<Usuario> usuarioList = service.Listar();
        resultado.put("lista", usuarioList);
        return  resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String,Object> insertarUsuario(String queryData, int idRol, int idEmpr){
        Map<String,Object> resultado = new HashMap<>();
        try {            
            Usuario usuario = service.ParsearJsonModelo(queryData);
            Empresa empresa = serviceEmpr.BuscarPorId(idEmpr);
            Rol rol = servieRol.BuscarPorId(idRol);
            usuario.setNomUsua(usuario.getPrimNombre() + " " + usuario.getSeguNombre() + " " +
            usuario.getApePate() + " " + usuario.getApeMate());
            usuario.setRol(rol);
            usuario.setEmpresa(empresa);
            service.Insertar(usuario);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
       
        List<Usuario> listUsuarios = service.Listar();
        resultado.put("lista", listUsuarios);
        return resultado;
    }

    @GetMapping("/buscarUsuario")
    @ResponseBody
    public Map<String,Object> buscarUsuario(int idUsua){
        Map<String,Object> resultado = new HashMap<>();
        Usuario usuario = service.BuscarPorId(idUsua);
        resultado.put("data", usuario);
        return  resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String,Object> actualizarUsuario(String queryData, int idRol, int idEmpr){
        Map<String,Object> resultado = new HashMap<>();
        try {            
            Usuario usuario = service.ParsearJsonModelo(queryData);
            Empresa empresa = serviceEmpr.BuscarPorId(idEmpr);
            Rol rol = servieRol.BuscarPorId(idRol);
            usuario.setNomUsua(usuario.getPrimNombre() + " " + usuario.getSeguNombre() + " " +
            usuario.getApePate() + " " + usuario.getApeMate());
            usuario.setRol(rol);
            usuario.setEmpresa(empresa);
            service.Actualizar(usuario);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
       
        List<Usuario> listUsuarios = service.Listar();
        resultado.put("lista", listUsuarios);
        return resultado;
    }


    
    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String, Object> eliminarUsuario(int idUsua){
        Map<String,Object> resultado = new HashMap<>();
        Usuario usuario = service.BuscarPorId(idUsua);
        service.Eliminar(usuario);
        List<Usuario> listUsuarios = service.Listar();
        resultado.put("lista", listUsuarios);
        return resultado;
    }

}
