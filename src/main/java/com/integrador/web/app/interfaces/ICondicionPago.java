package com.integrador.web.app.interfaces;

import com.integrador.web.app.model.CondicionPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICondicionPago extends JpaRepository<CondicionPago, Integer> {
}
