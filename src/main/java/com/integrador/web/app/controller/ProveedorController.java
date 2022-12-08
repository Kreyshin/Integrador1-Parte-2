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

import com.integrador.web.app.model.CondicionPago;
import com.integrador.web.app.model.Moneda;
import com.integrador.web.app.model.Proveedor;
import com.integrador.web.app.model.TipoProveedor;
import com.integrador.web.app.model.Interfaces.IProveedorLista;
import com.integrador.web.app.service.CondicionPagoService;
import com.integrador.web.app.service.MonedaService;
import com.integrador.web.app.service.ProveedorService;
import com.integrador.web.app.service.TipoProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService ProvServicio;

    @Autowired
    private TipoProveedorService TipoProvServicio;

    @Autowired
    private CondicionPagoService CondPagoServicio;

    @Autowired
    private MonedaService MoneServicio;


    @GetMapping("")
    public ModelAndView proveedor(){
        return new ModelAndView("Proveedor/Proveedor");
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> listarProductos(){
        Map<String,Object> resultado = new HashMap<>();
        List<IProveedorLista> listProveedores = ProvServicio.ListaProveedores();
        resultado.put("lista", listProveedores);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String,Object> insertarProveedor(String queryData, int idTipoProveedor, int idCondPago, int idMoneda){
        Map<String,Object> resultado = new HashMap<>();
        try {            
            Proveedor proveedor = ProvServicio.ParsearJsonModelo(queryData);
            TipoProveedor tipoProveedor = TipoProvServicio.BuscarPorId(idTipoProveedor);
            CondicionPago condicionPago = CondPagoServicio.BuscarPorId(idCondPago);
            Moneda moneda = MoneServicio.BuscarPorId(idMoneda);
            if(proveedor.getTipPers() == "J"){
                proveedor.setNomProv(proveedor.getDesRazoSoci());
            }else{
                proveedor.setNomProv(proveedor.getPriNomb() + " " + proveedor.getSegNomb() + " " + proveedor.getApePate() + " " + proveedor.getApeMate());
            }  
            
            proveedor.setIdTipoProveedor(tipoProveedor);
            proveedor.setIdCondPago(condicionPago);
            proveedor.setIdMoneda(moneda);
            ProvServicio.Insertar(proveedor);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
       
        List<IProveedorLista> listProveedores = ProvServicio.ListaProveedores();
        resultado.put("lista", listProveedores);
        return resultado;
    }

    @GetMapping("/buscarProveedor")
    @ResponseBody
    public Map<String,Object> buscarProveedor(int idProveedor){
        Map<String,Object> resultado = new HashMap<>();
        Proveedor proveedor = ProvServicio.BuscarPorId(idProveedor);
        resultado.put("data", proveedor);
        return  resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String,Object> actualizarProveedor(String queryData, int idTipoProveedor, int idCondPago, int idMoneda){
        Map<String,Object> resultado = new HashMap<>();
        try {            
            Proveedor proveedor = ProvServicio.ParsearJsonModelo(queryData);
            TipoProveedor tipoProveedor = TipoProvServicio.BuscarPorId(idTipoProveedor);
            CondicionPago condicionPago = CondPagoServicio.BuscarPorId(idCondPago);
            Moneda moneda = MoneServicio.BuscarPorId(idMoneda);
            if(proveedor.getTipPers() == "J"){
                proveedor.setNomProv(proveedor.getDesRazoSoci());
            }else{
                proveedor.setNomProv(proveedor.getPriNomb() + " " + proveedor.getSegNomb() + " " + proveedor.getApePate() + " " + proveedor.getApeMate());
            }              
            proveedor.setIdTipoProveedor(tipoProveedor);
            proveedor.setIdCondPago(condicionPago);
            proveedor.setIdMoneda(moneda);
            ProvServicio.Actualizar(proveedor);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
       
        List<IProveedorLista> listProveedores = ProvServicio.ListaProveedores();
        resultado.put("lista", listProveedores);
        return resultado;
    }

    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String, Object> eliminarProveedor(int idUsua){
        Map<String,Object> resultado = new HashMap<>();
        Proveedor usuario = ProvServicio.BuscarPorId(idUsua);
        ProvServicio.Eliminar(usuario);
        List<Proveedor> listProveedores = ProvServicio.Listar();
        resultado.put("lista", listProveedores);
        return resultado;
    }

}
