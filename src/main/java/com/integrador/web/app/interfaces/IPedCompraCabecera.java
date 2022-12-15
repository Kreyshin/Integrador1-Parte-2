package com.integrador.web.app.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.integrador.web.app.model.PedCompraCabecera;

@Repository
public interface IPedCompraCabecera extends JpaRepository<PedCompraCabecera,Integer> {
    
    @Query(value = "{call sp_obtener_numero_pedido}", nativeQuery = true)
    String ObtenerUltimoNumeroPedido();

}