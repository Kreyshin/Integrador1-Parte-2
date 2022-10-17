package com.integrador.web.app.interfaces;

import com.integrador.web.app.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumento extends JpaRepository<Documento,Integer> {
}
