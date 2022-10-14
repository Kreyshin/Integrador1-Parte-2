package com.integrador.web.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.integrador.web.app.interfaceService.IclienteService;
import com.integrador.web.app.model.Cliente;
import com.integrador.web.app.model.Motorizado;
import com.integrador.web.app.model.Recojo;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IclienteService service;
	
	@GetMapping("")
	public ModelAndView listar() {
		List<Cliente> clientes = service.Listar();	
		return new ModelAndView("cliente/listaCliente").addObject("clientes", clientes);
	}
	
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioNuevoCliente() {
		return new ModelAndView("cliente/nuevoCliente")
				.addObject("cliente", new Cliente());
	}
	
	@PostMapping("/nuevo")
	public ModelAndView mostrarFormularioNuevoCliente(@Validated Cliente cliente, BindingResult bindingResult) {
		System.out.println("ENTRO EN GRABAR");
		
		if(bindingResult.hasErrors() || cliente.getNombre().isEmpty()) {
			if(cliente.getNombre().isEmpty()) {
				bindingResult.rejectValue("nombre","MultipartNotEmpty");
			}
			
			return new ModelAndView("cliente/nuevoCliente");
		}			
		service.Insertar(cliente);
		return new ModelAndView("redirect:/cliente");
	}
	
	
	@GetMapping("/{id}/editar")
	public ModelAndView mostrarFormilarioDeEditarCliente(@PathVariable Integer id) {
		Optional<Cliente> cliente = service.BuscarPorId(id);
		Cliente clienteResult = cliente.get();
		return new ModelAndView("cliente/editarCliente")
				.addObject("cliente", clienteResult);
	}
	
	@PostMapping("/{id}/editar")
	public ModelAndView actualizarCliente(@PathVariable Integer id, @Validated Cliente cliente, BindingResult bindingResult) {
		Optional<Cliente> clienteBD = service.BuscarPorId(id);

		Cliente clienteActu = clienteBD.get();

		clienteActu.setNombre(cliente.getNombre());
		clienteActu.setApePaterno(cliente.getApePaterno());
		clienteActu.setApeMaterno(cliente.getApeMaterno());
		clienteActu.setTipDocumento(cliente.getTipDocumento());
		clienteActu.setNumDocumento(cliente.getNumDocumento());
		clienteActu.setTelefono(cliente.getTelefono());
		clienteActu.setCorreo(cliente.getCorreo());
		
		service.Insertar(clienteActu);
		
		return new ModelAndView("redirect:/cliente");
	}
	
	
	@PostMapping("/eliminar")
	public ModelAndView eliminarCliente( int idCliente) {
		Optional<Cliente> clienteBD = service.BuscarPorId(idCliente);
		Cliente clienteActu = clienteBD.get();
		int valor = service.Eliminar(clienteActu);	
		return new ModelAndView("redirect:/recojo");
	}
	

	
}
