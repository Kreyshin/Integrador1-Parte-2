package com.integrador.web.app.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.integrador.web.app.model.Proveedor;
import com.integrador.web.app.model.Interfaces.IProveedorLista;

@Repository
public interface IProveedor extends JpaRepository<Proveedor,Integer> {
    
    @Query(value = "{call sp_listar_Proveedor}", nativeQuery = true)
    List<IProveedorLista> ListarProveedores();

}