package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "UnidadMedida")
public class UnidadMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUnidadMedida")
    private int Id;

}
