package com.integrador.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.integrador.web.app.interfaceService.ImotorizadoService;
import com.integrador.web.app.model.Motorizado;
import com.integrador.web.app.model.Recojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/motorizado")
public class MotorizadoController {

	@Autowired
	private ImotorizadoService service;
	
	@GetMapping("")
	public ModelAndView listar() 
	{
		List<Motorizado> motorizados = service.Listar();
		return new ModelAndView("motorizado/listaMotorizado").addObject("motorizados", motorizados);
	}
	
	
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioNuevoMotorizado() {
		return new ModelAndView("motorizado/nuevoMotorizado")
				.addObject("motorizado", new Motorizado());
	}
	
	@PostMapping("/insertar")
	public ModelAndView insertar(@Validated Motorizado motorizado, BindingResult bindingResult ) {
		if(bindingResult.hasErrors() || motorizado.getNombre().isEmpty()) {
			if(motorizado.getNombre().isEmpty()) {
				bindingResult.rejectValue("nombre","MultipartNotEmpty");
			}
			
			return new ModelAndView("motorizado/nuevoMotorizado");
		}			
		service.Insertar(motorizado);
		return new ModelAndView("redirect:/motorizado");
	}
	
	
	@GetMapping("/BuscarMotorizados")
	@ResponseBody
	public List<Motorizado> BuscarMotorizados(String buscar) {
		System.out.println("SI ENTRO");
		Map<String, Object> salida = new HashMap<String, Object>();
		System.out.println("SI ENTRO 2");
		List<Motorizado> recojos = service.listarPorPlaca(buscar);
		System.out.println("SI ENTRO 3");
		System.out.println(recojos);
		salida.put("lista", recojos);
		System.out.println("SI ENTRO 4");
		return recojos;
	}
	
}
