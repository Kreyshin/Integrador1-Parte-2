package com.integrador.web.app.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.web.app.model.Empresa;

@Repository
public interface IEmpresa extends JpaRepository<Empresa, Integer> {
    
}