package com.integrador.web.app.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.web.app.model.Marca;

@Repository
public interface IMarca extends JpaRepository<Marca,Integer>  {
    
    
}