package com.integrador.web.app.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.web.app.model.Almacen;

@Repository
public interface IAlmacen extends JpaRepository<Almacen,Integer> {
    
}