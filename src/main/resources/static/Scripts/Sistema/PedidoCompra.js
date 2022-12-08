
const TblDetallePedido = $('#TblDetallePedido').DataTable({
    columns: [
        { data: 'idProd',
          visible: false },
        { data: null,
          render: function () {
          return `
                   <a href="javascript:;" class="btn btn-sm btn-clean btn-icon delete" title="Eliminar">
                     <span class="svg-icon svg-icon-danger svg-icon-md">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                           <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                               <rect x="0" y="0" width="24" height="24"></rect>
                                 <path d="M6,8 L6,20.5 C6,21.3284271 6.67157288,22 7.5,22 L16.5,22 C17.3284271,22 18,21.3284271 18,20.5 L18,8 L6,8 Z" fill="#000000" fill-rule="nonzero"></path>
                                 <path d="M14,4.5 L14,4 C14,3.44771525 13.5522847,3 13,3 L11,3 C10.4477153,3 10,3.44771525 10,4 L10,4.5 L5.5,4.5 C5.22385763,4.5 5,4.72385763 5,5 L5,5.5 C5,5.77614237 5.22385763,6 5.5,6 L18.5,6 C18.7761424,6 19,5.77614237 19,5.5 L19,5 C19,4.72385763 18.7761424,4.5 18.5,4.5 L14,4.5 Z" fill="#000000" opacity="0.3"></path>
                            </g>
                         </svg>
                       </span>
                    </a>
                `
        }
        },
        { data: 'codProd' },
        { data: 'nomProd' },
        { 
            data: null,
            defaultContent: '<input class="form-control form-control-sm text-right cantidad-unit" type="text" id="" name="" value="1">'
        },
        { 
            data: 'costProd',
            render: function (data, type, row, meta) {
              return type === 'display'
                  ? `<input class="form-control form-control-sm text-right costo-unit" type="text" id="" name="" value="${data}">`
                  : data;
            },
            defaultContent: '<input class="form-control form-control-sm text-right costo-unit" type="text" id="" name="" value="">'
         },
         {
            className: 'datatable-toggle-detail',
            defaultContent: '<a class="datatable-toggle-detail" href=""><i class="fa fa-caret-down"></i></a>',
            data: 'impcosto',
            orderable: false,
            visible: false
        },
    ],
    language: VGlobal.table_es,
    "scrollX": true,
    "scrollY": "200px"
});


$("#BtnBusqProducto").click(function (e) { 
  e.preventDefault();
  if($("#TxtBusqProducto").val() != ""){
    FiltrarProductos();
  }
});


$("#BtnAgregarProductos").click(function (e) { 
  e.preventDefault();
  var Secuencias = [];
  $("#CListProductos .seleccion").each(function () {
    TblDetallePedido.rows.add([
      {
        "idProd" : $(this).attr("data-id"),
        "codProd": $(this).attr("data-cod-comp"),
        "nomProd": $(this).attr("data-nom-prod"),
        "costProd" : $(this).attr("data-cos-unit"),

      }
    ]).draw();
  
  });
  $("#CListProductos .seleccion").toggleClass('seleccion')
});

$("#BtnGrabarPedido").click(function (e) { 
  e.preventDefault();
  FGlobal.NotificacionCorrecta("Se creó correctamente el pedido de compra");
});


$('#TblDetallePedido tbody').on( 'click', '.delete', function (e) {
  e.preventDefault();
  TblDetallePedido
  .row( $(this).parents('tr') )
  .remove()
  .draw();
} );



let SLProveedor = $("#SLProveedor").select2({
    allowClear: true,
    placeholder: "Seleccione Proveedor",
    width: "100%",
    data: LlenarProveedores()
  });

  let SLMoneda = $("#SLMoneda").select2({
    allowClear: true,
    placeholder: "Seleccione Moneda",
    width: "100%",
    data: CargarMonedas()
  });

  let SLCondicionPago = $("#SLCondicionPago").select2({
    allowClear: true,
    placeholder: "Seleccione Condicion Pago",
    width: "100%",
    data: CargarCondicionPago()
  });

  let SLAlmacen = $("#SLAlmacen").select2({
    allowClear: true,
    placeholder: "Seleccione Almacen",
    width: "100%",
    data: CargarAlmacenes()
  });


$("#CListProductos").off('click', '.card-detalle-pedido').on('click', '.card-detalle-pedido', function (e) {
    e.preventDefault();
    $(e.currentTarget).toggleClass('seleccion')
});





function LlenarProveedores() {
    let data
    $.ajax({
      type: "GET",
      url: `pedidoCompra/cargarProveedores`,
      async: false,
      dataType: "json",
      success: function (response) {
        data = response.lista;
      }
    });
    return data;
  }

  function CargarMonedas() {
    let data
    $.ajax({
      type: "GET",
      url: `pedidoCompra/cargarMonedas`,
      async: false,
      dataType: "json",
      success: function (response) {
        data = response.lista;
      }
    });
    return data;
  }
  function CargarCondicionPago() {
    let data
    $.ajax({
      type: "GET",
      url: `pedidoCompra/cargarCondicionesPago`,
      async: false,
      dataType: "json",
      success: function (response) {
        data = response.lista;
      }
    });
    return data;
  }

  function CargarAlmacenes() {
    let data
    $.ajax({
      type: "GET",
      url: `pedidoCompra/cargarAlmacenes`,
      async: false,
      dataType: "json",
      success: function (response) {
        data = response.lista;
      }
    });
    return data;
  }

  function FiltrarProductos(){
    $.ajax({
        type: "GET",
        url: `pedidoCompra/filtrarProductos`,
        async: false,
        data:{
            DesBusq : $("#TxtBusqProducto").val()
        },
        dataType: "json",
        success: function (response) {
          $("#CListProductos").empty();
            $.map(response.lista, function (elementOrValue, indexOrKey) {            
                let option = `<div class="card card-detalle-pedido mb-2"  data-id="${elementOrValue.id}" data-cod-comp="${elementOrValue.codComp}"  data-nom-prod="${elementOrValue.nomProd}" data-cos-unit="${elementOrValue.impCost}">
                <div class="card-body card-body-detalle">
                    <div class="row" style="padding: .2rem .4rem .5rem;">
                        <label class="col-md-2 font-weight-bold">${elementOrValue.codComp}</label>
                        <label class="col-md-8 font-weight-bold">${elementOrValue.nomProd}</label>
                    </div>
                    <div class="datalle-adi" style="padding: .2rem .4rem .5rem;">                 
                        <span class="float-left badge bg-success" style="color:#FFF;">Stock: ${elementOrValue.cantActu}</span>
                        <span class="float-right badge bg-primary text-white">S/ ${elementOrValue.impCost}</span>
                    </div>                          
                </div>                                  
              </div>`
                $("#CListProductos").append(option);
              });
        }
      });
  } 