package com.integrador.web.app.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "recojo")
public class Recojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne()
	private Cliente cliente;
	@OneToOne()
	private Motorizado motorizado;
	private String numero;
	private String Contacto;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fecha;

	private LocalTime hora;

	public Recojo() {
	
	}

	public Recojo(Integer id, Cliente cliente, Motorizado motorizado, String numero, String contacto, LocalDate fecha,
			LocalTime hora) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.motorizado = motorizado;
		this.numero = numero;
		Contacto = contacto;
		this.fecha = fecha;
		this.hora = hora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Motorizado getMotorizado() {
		return motorizado;
	}

	public void setMotorizado(Motorizado motorizado) {
		this.motorizado = motorizado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getContacto() {
		return Contacto;
	}

	public void setContacto(String contacto) {
		Contacto = contacto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
	
}
