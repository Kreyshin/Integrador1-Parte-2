package com.integrador.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.integrador.web.app.interfaceService.IclienteService;
import com.integrador.web.app.model.Cliente;

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
	

	
	@PostMapping("/insertar")
	public ModelAndView insertar(@Validated Cliente cliente, BindingResult bindingResult ) {
		if(bindingResult.hasErrors() || cliente.getNombre().isEmpty()) {
			if(cliente.getNombre().isEmpty()) {
				bindingResult.rejectValue("nombre","MultipartNotEmpty");
			}
			
			return new ModelAndView("cliente/nuevoCliente");
		}			
		service.Insertar(cliente);
		return new ModelAndView("redirect:/cliente");
	}

	
}
