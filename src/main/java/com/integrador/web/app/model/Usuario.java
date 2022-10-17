package com.integrador.web.app.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private int Id;

    @NotBlank
    @Column(name = "Usuario")
    private String Usuario;

    @NotBlank
    @Column(name = "Clave")
    private String Clave;

    @Column(length = 50)
    private String PrimNombre;
    @Column(length = 50)
    private String SeguNombre;
    @Column(length = 50)
    private String ApePate;
    @Column(length = 50)
    private String ApeMate;
    @Column(length = 1)
    private String Sexo;
    @Column(length = 10)
    private String NumTelf;
    @Column(length = 200)
    private String NomUsua;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate FecNaci;

    @Column(name = "Estado")
    private String Estado;

    @ManyToOne(optional = false)
    private Empresa empresa;

    @ManyToOne(optional = false)
    private Rol rol;





}
