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

    @Column(name = "Usuario")
    private String Usuario;


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

    public Usuario() {
    }

    public Usuario(int id, @NotBlank String usuario, @NotBlank String clave, String primNombre, String seguNombre,
            String apePate, String apeMate, String sexo, String numTelf, String nomUsua, LocalDate fecNaci,
            String estado, Empresa empresa, Rol rol) {
        Id = id;
        Usuario = usuario;
        Clave = clave;
        PrimNombre = primNombre;
        SeguNombre = seguNombre;
        ApePate = apePate;
        ApeMate = apeMate;
        Sexo = sexo;
        NumTelf = numTelf;
        NomUsua = nomUsua;
        FecNaci = fecNaci;
        Estado = estado;
        this.empresa = empresa;
        this.rol = rol;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getPrimNombre() {
        return PrimNombre;
    }

    public void setPrimNombre(String primNombre) {
        PrimNombre = primNombre;
    }

    public String getSeguNombre() {
        return SeguNombre;
    }

    public void setSeguNombre(String seguNombre) {
        SeguNombre = seguNombre;
    }

    public String getApePate() {
        return ApePate;
    }

    public void setApePate(String apePate) {
        ApePate = apePate;
    }

    public String getApeMate() {
        return ApeMate;
    }

    public void setApeMate(String apeMate) {
        ApeMate = apeMate;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getNumTelf() {
        return NumTelf;
    }

    public void setNumTelf(String numTelf) {
        NumTelf = numTelf;
    }

    public String getNomUsua() {
        return NomUsua;
    }

    public void setNomUsua(String nomUsua) {
        NomUsua = nomUsua;
    }

    public LocalDate getFecNaci() {
        return FecNaci;
    }

    public void setFecNaci(LocalDate fecNaci) {
        FecNaci = fecNaci;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    


}
