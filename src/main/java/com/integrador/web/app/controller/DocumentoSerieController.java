package com.integrador.web.app.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.integrador.web.app.model.Documento;
import com.integrador.web.app.model.DocumentoSerie;
import com.integrador.web.app.service.DocumentoSerieService;
import com.integrador.web.app.service.DocumentoService;

@Controller
@RequestMapping("/documentoSerie")
public class DocumentoSerieController {
    
    @Autowired
    private DocumentoSerieService service;

    @Autowired
    private DocumentoService serviceDocu;

    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> listarSeriesDocumento(int IdDoc){
        Map<String,Object> resultado = new HashMap<>();
        List<DocumentoSerie> list = service.ListarPorDocumento(IdDoc);
        resultado.put("lista", list);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String, Object> insertarSerieDocumento(String queryData, int idDocu){
        Map<String,Object> resultado = new HashMap<>();
        try {            
            DocumentoSerie documentoSerie = service.ParsearJsonModelo(queryData);
            Documento documento = serviceDocu.BuscarPorId(idDocu);
            documentoSerie.setDocumento(documento);
            service.Insertar(documentoSerie);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
       
        List<DocumentoSerie> listDocumentos = service.ListarPorDocumento(idDocu);
        resultado.put("lista", listDocumentos);
        return resultado;
    }

    @GetMapping("/buscarSerieDocumento")
    @ResponseBody
    public Map<String,Object> buscarSerieDocumento(int idSeri, int idDocu){
        Map<String,Object> resultado = new HashMap<>();
        DocumentoSerie documentoSerie = service.BuscarSerieDocumento(idSeri,idDocu);
        resultado.put("data", documentoSerie);
        return resultado;
    }    

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String, Object> actualizarSerieDocumento(String queryData, int idDocu){
        Map<String,Object> resultado = new HashMap<>();
        try {            
            DocumentoSerie documentoSerie = service.ParsearJsonModelo(queryData);
            Documento documento = serviceDocu.BuscarPorId(idDocu);
            documentoSerie.setDocumento(documento);
            service.Actualizar(documentoSerie);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
       
        List<DocumentoSerie> listDocumentos = service.ListarPorDocumento(idDocu);
        resultado.put("lista", listDocumentos);
        return resultado;
    }


    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String, Object> eliminarSerieDocumento(int idSeri, int idDocu){
        Map<String,Object> resultado = new HashMap<>();
        DocumentoSerie documentoSerie = service.BuscarSerieDocumento(idSeri,idDocu);
        service.Eliminar(documentoSerie);
        List<DocumentoSerie> listDocumentos = service.ListarPorDocumento(idDocu);
        resultado.put("lista", listDocumentos);
        return resultado;
    }

}