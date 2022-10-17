package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Moneda")
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMoneda")
    private int Id;

    @Column(name = "DesMoneda")
    private String DesMoneda;

    @Column(name = "Simbolo")
    private String Simbolo;


    public Moneda() {
    }

    public Moneda(int id, String desMoneda, String simbolo) {
        Id = id;
        DesMoneda = desMoneda;
        Simbolo = simbolo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDesMoneda() {
        return DesMoneda;
    }

    public void setDesMoneda(String desMoneda) {
        DesMoneda = desMoneda;
    }

    public String getSimbolo() {
        return Simbolo;
    }

    public void setSimbolo(String simbolo) {
        Simbolo = simbolo;
    }
}
