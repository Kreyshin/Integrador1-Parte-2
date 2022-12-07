package com.integrador.web.app.interfaces;

import com.integrador.web.app.model.DocumentoSerie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentoSerie extends JpaRepository<DocumentoSerie, Integer> {

        @Query(value = "{call sp_listar_Series_documento(:IIdeDocu)}", nativeQuery = true)
        List<DocumentoSerie> ListarPorDocumento(@Param("IIdeDocu") int idDocu);

        @Query(value = "{call sp_buscar_serie_documento(:IIdeDocuSeri, :IIdeDocu)}", nativeQuery = true)
        DocumentoSerie BuscarSerieDocumento(@Param("IIdeDocuSeri") int idDocuSeri, @Param("IIdeDocu") int idDocu );
}
