package com.integrador.web.app.interfaces;

import com.integrador.web.app.model.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMoneda extends JpaRepository<Moneda, Integer> {
}
