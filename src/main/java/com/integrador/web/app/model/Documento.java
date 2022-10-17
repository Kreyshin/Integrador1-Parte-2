package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDocumento")
    private int Id;

}
