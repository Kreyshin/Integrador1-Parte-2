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

import com.integrador.web.app.model.Documento;
import com.integrador.web.app.service.DocumentoService;

@Controller
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @GetMapping("")
    public ModelAndView Documento(){
        return  new ModelAndView("Documento/Documento");
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String, Object> insertarDocumento(Documento obj){
        Map<String,Object> resultado = new HashMap<>();
        service.Insertar(obj);
        List<Documento> listDocumentos = service.Listar();
        resultado.put("lista", listDocumentos);
        return resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String, Object> actualizarDocumento(Documento obj){
        Map<String,Object> resultado = new HashMap<>();
        service.Actualizar(obj);
        List<Documento> listDocumentos = service.Listar();
        resultado.put("lista", listDocumentos);
        return resultado;
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String, Object> listarDocumentos(){
        Map<String,Object> resultado = new HashMap<>();
        List<Documento> listDocumentos = service.Listar();
        resultado.put("lista", listDocumentos);
        return resultado;
    }

    @GetMapping("/buscarPorId")
    @ResponseBody
    public Map<String, Object> buscarPorIdDocumento( int Id){
        Map<String,Object> resultado = new HashMap<>();
        Documento documento = service.BuscarPorId(Id);
        resultado.put("data", documento);
        return resultado;
    }

    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String, Object> eliminarDocumento(int Id){
        Map<String,Object> resultado = new HashMap<>();
        Documento documentoEl = service.BuscarPorId(Id);
        service.Eliminar(documentoEl);
        List<Documento> listDocumentos = service.Listar();
        resultado.put("lista", listDocumentos);
        return resultado;
    }

}
