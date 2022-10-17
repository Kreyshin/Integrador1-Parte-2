package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Almacen")
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAlmacen")
    private int Id;
}
