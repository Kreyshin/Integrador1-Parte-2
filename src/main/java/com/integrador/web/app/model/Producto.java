package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Producto")
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProducto")
    private int Id;

}
