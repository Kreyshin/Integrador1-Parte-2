package com.integrador.web.app.interfaces;

import com.integrador.web.app.model.DocumentoSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentoSerie extends JpaRepository<DocumentoSerie, Integer> {
}
