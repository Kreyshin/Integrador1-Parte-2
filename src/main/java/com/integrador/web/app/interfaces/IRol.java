package com.integrador.web.app.interfaces;

import com.integrador.web.app.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRol extends JpaRepository<Rol,Integer> {

}
