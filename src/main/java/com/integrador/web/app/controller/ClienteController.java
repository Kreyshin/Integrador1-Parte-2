package com.integrador.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.web.app.interfaceService.IpersonaService;
import com.integrador.web.app.model.Cliente;

@Controller
@RequestMapping
public class ClienteController {

	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Cliente> clientes = service.Listar();
		model.addAttribute(clientes);
		return "index";
	}
	
}
