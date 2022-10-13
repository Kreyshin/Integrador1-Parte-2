package com.integrador.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.integrador.web.app.interfaceService.IRecojoService;
import com.integrador.web.app.interfaceService.ImotorizadoService;
import com.integrador.web.app.model.IRecojoGroupByMotorizado;
import com.integrador.web.app.model.Motorizado;
import com.integrador.web.app.model.Recojo;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/recojo")
public class RecojoController {

	@Autowired
	private IRecojoService service;
	
	@Autowired
	private ImotorizadoService serviceMotorizado;
	
	@GetMapping("")
	public ModelAndView listar() {
		List<Recojo> recojos = service.Listar();
		return new ModelAndView("recojo/asignacion").addObject("recojos", recojos);
	}
	
	@GetMapping("/{id}/asignar")
	public ModelAndView mostrarFormularioAsignacion(@PathVariable Integer id) {
		Optional<Recojo> recojo = service.BucarPorId(id);
		Recojo recojoresult = recojo.get();
		
		List<Motorizado> motorizados = serviceMotorizado.Listar();
		
		return new ModelAndView("recojo/asignarMotorizado")
				.addObject("recojo",recojoresult)
				.addObject("motorizados",motorizados);
	}
	
	@GetMapping("/asignarMotorizado/{idRecojo}/{idMotorizado}")
	public ModelAndView asignarMotorizado(@PathVariable int idRecojo, @PathVariable int idMotorizado) {
		
		Optional<Recojo> recojo = service.BucarPorId(idRecojo);
		Recojo recojoActualizar = recojo.get();
		Optional<Motorizado> motorizado = serviceMotorizado.BuscarPorId(idMotorizado);
		Motorizado motorizadoRes = motorizado.get();
		recojoActualizar.setMotorizado(motorizadoRes);
		service.Insertar(recojoActualizar);
		return new ModelAndView("redirect:/recojo");
	}
	
	
	@GetMapping("/ConsultaRecojosPorMotorizado")
	public ModelAndView ListarConsulta() {
		List<IRecojoGroupByMotorizado> recojos = service.ListarRecojosPorMotorizado();
		return new ModelAndView("recojo/ConsultaRecojo").addObject("recojos", recojos);
	}
	
	
}
