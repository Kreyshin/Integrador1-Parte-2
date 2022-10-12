package com.integrador.web.app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apeMaterno;
	private String apePaterno;
	private String tipDocumento;
	private String numDocumento;
	private String telefono;
	private String correo;
	
	public Cliente() {
	
	}


	public Cliente(int id, String nombre, String apeMaterno, String apePaterno, String tipDocumento,
			String numDocumento, String telefono, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apeMaterno = apeMaterno;
		this.apePaterno = apePaterno;
		this.tipDocumento = tipDocumento;
		this.numDocumento = numDocumento;
		this.telefono = telefono;
		this.correo = correo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getTipDocumento() {
		return tipDocumento;
	}

	public void setTipDocumento(String tipDocumento) {
		this.tipDocumento = tipDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
