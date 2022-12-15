package com.integrador.web.app.controller;

import java.util.ArrayList;
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

import com.integrador.web.app.common.Select;
import com.integrador.web.app.model.Almacen;
import com.integrador.web.app.model.CondicionPago;
import com.integrador.web.app.model.Empresa;
import com.integrador.web.app.model.Moneda;
import com.integrador.web.app.model.PedCompraCabecera;
import com.integrador.web.app.model.PedCompraDetalle;
import com.integrador.web.app.model.Producto;
import com.integrador.web.app.model.Proveedor;
import com.integrador.web.app.model.Interfaces.IBuscarProductos;
import com.integrador.web.app.model.Interfaces.IProveedorLista;
import com.integrador.web.app.model.Interfaces.PedCompDeta;
import com.integrador.web.app.service.AlmacenService;
import com.integrador.web.app.service.CondicionPagoService;
import com.integrador.web.app.service.EmpresaService;
import com.integrador.web.app.service.MonedaService;
import com.integrador.web.app.service.PedCompraCabeceraService;
import com.integrador.web.app.service.PedCompraDetalleService;
import com.integrador.web.app.service.ProductoService;
import com.integrador.web.app.service.ProveedorService;

@Controller
@RequestMapping("/pedidoCompra")
public class PedidoDeCompraController {

    @Autowired
    private AlmacenService AlmaService;

    @Autowired
    private MonedaService MoneService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private CondicionPagoService CondPagoService;

    @Autowired
    private ProveedorService ProvService;

    @Autowired
    private ProductoService ProdService;

    @Autowired
    private PedCompraCabeceraService service;
    @Autowired
    private PedCompraDetalleService serviceDeta;
    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public ModelAndView almacen(){
        return new ModelAndView("PedidoDeCompra/PedidoDeCompra");
    }

    @GetMapping("/cargarProveedores")
    @ResponseBody
    public Map<String,Object> cargarProveedores(){
        Map<String,Object> resultado = new HashMap<>();
        List<IProveedorLista> aList = ProvService.ListaProveedores();
        List<Select> list = new ArrayList<Select>() ;
        for (IProveedorLista proveedor : aList) {
            list.add(new Select(proveedor.getIdProv(),proveedor.getNomProv()));
        }
        resultado.put("lista", list);
        return resultado;
    }

    @GetMapping("/cargarAlmacenes")
    @ResponseBody
    public Map<String,Object> cargarAlmacenes(){
        Map<String,Object> resultado = new HashMap<>();
        List<Almacen> aList = AlmaService.Listar();
        List<Select> list = new ArrayList<Select>() ;
        for (Almacen almacen : aList) {
            list.add(new Select(almacen.getId(),almacen.getDesAlma()));
        }
        resultado.put("lista", list);
        return resultado;
    }

    @GetMapping("/cargarMonedas")
    @ResponseBody
    public Map<String,Object> cargarMonedas(){
        Map<String,Object> resultado = new HashMap<>();
        List<Moneda> aList = MoneService.Listar();
        List<Select> list = new ArrayList<Select>() ;
        for (Moneda moneda : aList) {
            list.add(new Select(moneda.getId(),moneda.getSimbolo() + "-" + moneda.getDesMoneda()));
        }
        resultado.put("lista", list);
        return resultado;
    }

    @GetMapping("/cargarCondicionesPago")
    @ResponseBody
    public Map<String,Object> cargarCodicionesPago(){
        Map<String,Object> resultado = new HashMap<>();
        List<CondicionPago> aList = CondPagoService.Listar();
        List<Select> list = new ArrayList<Select>() ;
        for (CondicionPago condicionPago : aList) {
            list.add(new Select(condicionPago.getId(), condicionPago.getDesCondPago()));
        }
        resultado.put("lista", list);
        return resultado;
    }

    @GetMapping("/filtrarProductos")
    @ResponseBody
    public Map<String,Object> filtrarProductos(String DesBusq){
        Map<String,Object> resultado = new HashMap<>();
        List<IBuscarProductos> list = ProdService.FiltrarProductos(DesBusq);
        resultado.put("lista", list);
        return resultado;
    }

    @GetMapping("/ObtenerNumeroPedido")
    @ResponseBody
    public Map<String,Object> ObtenerNumeroPedido(){
        Map<String,Object> resultado = new HashMap<>();
        String numero = service.ObtenerUltimoNumero();
        System.out.println(numero);
        resultado.put("numero", numero);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String,Object> actualizarProveedor(String queryData, String queryDeta, int IdEmpresa, 
       int IdAlmacen, int idCondPago, int idMoneda, int IdProv){
        Map<String,Object> resultado = new HashMap<>();
        PedCompraCabecera pedido = service.ParsearJsonModelo(queryData);
        Empresa empresa =  new Empresa();
        Almacen almacen = new Almacen();
        Moneda moneda = new Moneda();
        CondicionPago condicionPago = new CondicionPago();
        Proveedor proveedor = new Proveedor();

        empresa = empresaService.BuscarPorId(IdEmpresa);
        almacen = AlmaService.BuscarPorId(IdAlmacen);
        condicionPago = CondPagoService.BuscarPorId(idCondPago);
        moneda = MoneService.BuscarPorId(idMoneda);
        proveedor = ProvService.BuscarPorId(IdProv);

        pedido.setIdEmpresa(empresa);
        pedido.setIdAlmacen(almacen);
        pedido.setIdMoneda(moneda);
        pedido.setIdCondPago(condicionPago);
        pedido.setIdProv(proveedor);

        Integer idGene = service.Insertar(pedido);
        PedCompraCabecera pedidoGene = new PedCompraCabecera();
        pedidoGene = service.BuscarPorId(idGene);
        List<PedCompDeta> detaPedido = service.ParsearJsonDetalles(queryDeta);
    
        Integer VNumsecu = 1;
        Producto producto = new Producto();
        System.out.println(detaPedido.size());
        for (int i=0; i<detaPedido.size(); i++) {
            PedCompraDetalle PedidoDetalle = new PedCompraDetalle();
            PedidoDetalle.setNumSecu(VNumsecu);
            PedidoDetalle.setIdPediCompCabe(pedidoGene);
            PedidoDetalle.setIdEmpresa(empresa);
            producto = productoService.BuscarPorId(detaPedido.get(i).getIdProd());
            PedidoDetalle.setIdProducto(producto);
            PedidoDetalle.setCanComp(detaPedido.get(i).getCanProd());
            PedidoDetalle.setCosUnit(detaPedido.get(i).getCostProd());
            serviceDeta.Insertar(PedidoDetalle);
            VNumsecu++;
          }
        return resultado;
    }

}
