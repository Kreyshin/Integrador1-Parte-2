package com.integrador.web.app.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.integrador.web.app.model.Producto;
import com.integrador.web.app.model.Interfaces.IBuscarProductos;

@Repository
public interface IProducto extends JpaRepository<Producto,Integer> {
    
    @Query(value = "Select pr.id_producto as IdProducto, pr.cod_prod as CodProd, pr.nom_prod as NomProd, ca.des_cate as DesCate, "
                 + "um.des_unme as DesUnme, ma.des_marc as DesMarc, pr.cod_barr_prod as CodBarr, pr.sku_prod as SkuProd, "
                 + "pr.ind_expi as IndExpi, pr.fec_expi as FecExpi, pr.cod_comp_prod as CodComp, pr.imp_cost as ImpCost, "
                 + "pr.estado as Estado "
                 + "From producto As pr Inner Join categoria as ca On "
                 + "pr.categoria_id_categoria = ca.id_categoria "
                 + "Inner Join marca as ma On " 
                 + "pr.marca_id_marca = ma.id_marca "
                 + "Inner Join unidad_medida as um On "
                 + "pr.unidad_medida_id_unidad_medida  = um.id_unidad_medida"
    , nativeQuery = true)
    List<IProductoLista> listadoProductos();

    @Query(value = "{call sp_filtrar_productos(:ISDES_BUSQ)}", nativeQuery = true)
    List<IBuscarProductos> filtrarProductos(@Param("ISDES_BUSQ") String DesBusq);
}