package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "DocumentoSerie")
public class DocumentoSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDocuSerie")
    private int Id;
}
