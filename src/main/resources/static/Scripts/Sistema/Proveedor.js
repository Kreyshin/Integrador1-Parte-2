const TblProveedor = $('#TblProveedor').DataTable({
    columns: [
        { data: 'idProv', visible: false },
        { data: 'nomProv' },
        { 
            data: 'tipPers',
            className: 'text-center',
            render: function (data, type, row) {
                switch (data) {
                    case "J":
                        return `<span class="label label-lg font-weight-bold label-light-primary label-inline">Juridico</span>`;
                        break;
                    case "N":
                        return `<span class="label label-lg font-weight-bold label-light-info label-inline">Natural</span>`;
                        break;
                }
            }
        },
        { data: 'tipDocu' },
        { data: 'numDocuIden' },
        { data: 'tipProv'},
        { data: 'desMail'},
        {
            data: 'estado',
            className: 'text-center',
            render: function (data, type, row) {
                switch (data) {
                    case "ACT":
                        return `<span class="label label-lg font-weight-bold label-light-primary label-inline">Activo</span>`;
                        break;
                    case "INA":
                        return `<span class="label label-lg font-weight-bold label-light-danger label-inline">Inactivo</span>`;
                        break;
                }

            }
        },
        { data: 'desCondPago'},
        { data: 'desMone'},
        {
      data: null,
      render: function () {
          return `<a class="btn btn-sm btn-clean btn-icon mr-2 edit" title="Editar">
                     <span class="svg-icon svg-icon-primary svg-icon-md">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
                           <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                            <rect x="0" y="0" width="24" height="24"></rect>
                              <path d="M8,17.9148182 L8,5.96685884 C8,5.56391781 8.16211443,5.17792052 8.44982609,4.89581508 L10.965708,2.42895648 C11.5426798,1.86322723 12.4640974,1.85620921 13.0496196,2.41308426 L15.5337377,4.77566479 C15.8314604,5.0588212 16,5.45170806 16,5.86258077 L16,17.9148182 C16,18.7432453 15.3284271,19.4148182 14.5,19.4148182 L9.5,19.4148182 C8.67157288,19.4148182 8,18.7432453 8,17.9148182 Z" fill="#000000" fill-rule="nonzero" transform="translate(12.000000, 10.707409) rotate(-135.000000) translate(-12.000000, -10.707409) ">
                                </path>
                            <rect fill="#000000" opacity="0.3" x="5" y="20" width="15" height="2" rx="1"></rect>
                            </g>
                        </svg>
                      </span>
                   </a>
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
    }
    ],
    language: VGlobal.table_es,
    "scrollX": true
});

$('#TblProveedor tbody').on( 'click', '.edit', function (e) {
   e.preventDefault();
   var data = TblProveedor.row( $(this).parents('tr') ).data();
   BuscarProveedor(data.idProv);
} );

$('#TblProveedor tbody').on( 'click', '.delete', function (e) {
  e.preventDefault();
  var data = TblProveedor.row( $(this).parents('tr') ).data();
  EliminarProveedor(data.idProv);

} );

$('input:radio[name=rdb_estado]').on("click",function (e) {
  if (this.value == 'ACT') {
      $("#cro_inactivo").removeClass("btn-danger").addClass("btn-secondary");
      $("#cro_activo").removeClass("btn-secondary btn-primary").addClass("btn-primary");
  }
  else {
      $("#cro_activo").removeClass("btn-primary").addClass("btn-secondary");
      $("#cro_inactivo").removeClass("btn-secondary btn-danger").addClass("btn-danger");
  }
});

$('input:radio[name=rdb_persona]').on("click",function (e) {
  if (this.value == 'J') {
      $("#cro_natural").removeClass("btn-info").addClass("btn-secondary");
      $("#cro_juridico").removeClass("btn-secondary btn-primary").addClass("btn-primary");
      $("#Cont-Data-Natural").hide();
      $("#Cont-Data-Juridico").show();
  }
  else {
      $("#cro_juridico").removeClass("btn-primary").addClass("btn-secondary");
      $("#cro_natural").removeClass("btn-secondary btn-info").addClass("btn-info");
      $("#Cont-Data-Juridico").hide();
      $("#Cont-Data-Natural").show();
  }
});

$("#TipoDocuIden").change(function () {
    $( "#TipoDocuIden option:selected" ).each(function() {
        if($( this ).val() == "DNI"){
            $("#lbl_num_docu_iden").text("Numero DNI")
        }else{
            $("#lbl_num_docu_iden").text("Numero RUC")
        }  
    });
  }).change();


LlenarTabla();
LlenarTipoProveedor()
LlenarCondicionPago();
LlenarMonedas();
//Botones Mantenimiento
$('#btn_grabar').click((e) => {
if (VGlobal.actualizar == true) {
  Actualizar();
} else {
  Grabar();
}    
});

$("#btn_cancelar").click((e) => {
  LimpiarCampos();
});


function LlenarTabla() {
    $.ajax({
        type: "GET",
        url: `proveedor/listar`,
        dataType: "json",
        success: function (response) {
          TblProveedor.clear().rows.add(response.lista).columns.adjust().draw();
        }
    });
}

function LlenarTipoProveedor() {
    $.ajax({
        type: "GET",
        url: `tipoProveedor/listar`,
        dataType: "json",
        success: function (response) {
          $.map(response.lista, function (elementOrValue, indexOrKey) {
            let option = `<option value="${elementOrValue.id}" >${elementOrValue.desTipoProv}</option>`
            $("#TipoProv").append(option);
          });
      
        }
    });
}

function LlenarCondicionPago() {
    $.ajax({
        type: "GET",
        url: `condicionPago/listar`,
        dataType: "json",
        success: function (response) {
          $.map(response.lista, function (elementOrValue, indexOrKey) {
            let option = `<option value="${elementOrValue.id}" >${elementOrValue.desCondPago}</option>`
            $("#CondPago").append(option);
          });
      
        }
    });
}

function LlenarMonedas() {
    $.ajax({
        type: "GET",
        url: `moneda/listar`,
        dataType: "json",
        success: function (response) {
          $.map(response.lista, function (elementOrValue, indexOrKey) {
            let option = `<option value="${elementOrValue.id}" >${elementOrValue.desMoneda}</option>`
            $("#Moneda").append(option);
          });
      
        }
    });
}


function Grabar() {
let metodo = function () {
    $.ajax({
        type: "POST",
        url: `proveedor/insertar`,
        data: { 
          queryData: JSON.stringify({
            tipPers: $('input:radio[name=rdb_persona]:checked').val(),
            tipDocuIden: $("#TipoDocuIden option:selected").val(),
            numDocuIden: $("#txt_num_docu_iden").val(),
            desMail: $("#txt_des_mail").val(),
            estado: $('input:radio[name=rdb_estado]:checked').val(), 
            priNomb: $("#txt_pri_nombre").val(),
            segNomb: $("#txt_seg_nombre").val(),
            apePate: $("#txt_ape_pate").val(),
            apeMate: $("#txt_ape_mate").val(), 
            desRazoSoci: $("#txt_des_razo_Soci").val(),                       
          }),
          idTipoProveedor: $("#TipoProv option:selected").val(),
          idCondPago: $("#CondPago option:selected").val(),
          idMoneda: $("#Moneda option:selected").val()
        },
        dataType: "json",
        success: function (response) {
                FGlobal.notificacion.satisfactorio("Aviso", "Se Grabo con Exito!!");
                TblProveedor.clear().rows.add(response.lista).columns.adjust().draw();
                LimpiarCampos();
        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    });
}
FGlobal.Confirmacion("¿Desea Grabar el Proveedor?", metodo)
}

function BuscarProveedor(id) {
$.ajax({
     type: "GET",
     url: `proveedor/buscarProveedor`,
     data: {
      idProveedor: id
     },
     dataType: "json",
     async: false,
     success: function (response) {
      console.log(response.data); 
       $("#txt_id_prov").val(response.data.id);
       if (response.data.tipPers == "J") {
        $('#ro_juridico').prop("checked",true);
        $("#cro_natural").removeClass("btn-info").addClass("btn-secondary");
        $("#cro_juridico").removeClass("btn-secondary btn-primary").addClass("btn-primary");
        $("#Cont-Data-Natural").hide();
        $("#Cont-Data-Juridico").show();
        }else{
        $('#ro_natural').prop("checked",true);
        $("#cro_juridico").removeClass("btn-primary").addClass("btn-secondary");
        $("#cro_natural").removeClass("btn-secondary btn-info").addClass("btn-info");
        $("#Cont-Data-Juridico").hide();
        $("#Cont-Data-Natural").show();
        }
        $("#TipoDocuIden").val(response.data.tipDocuIden).change();
        $("#txt_num_docu_iden").val(response.data.numDocuIden);
        $("#TipoProv").val(response.data.idTipoProveedor.id).change();        
        $("#txt_des_mail").val(response.data.desMail);       
       if (response.data.estado == "ACT") {
        $('#ro_activo').prop("checked",true);
        $('#cro_activo').removeClass("btn-secondary").addClass("btn-primary");
        $('#cro_inactivo').removeClass("btn-danger").addClass("btn-secondary");
      }else{
        $('#ro_inactivo').prop("checked",true);
        $('#cro_inactivo').removeClass("btn-secondary").addClass("btn-danger");
        $('#cro_activo').removeClass("btn-primary").addClass("btn-secondary");
      }
     
      $("#txt_pri_nombre").val(response.data.priNomb);
      $("#txt_seg_nombre").val(response.data.SegNomb);
      $("#txt_ape_pate").val(response.data.apePate);
      $("#txt_ape_mate").val(response.data.apeMate);
      $("#txt_des_razo_Soci").val(response.data.desRazoSoci);
      $("#CondPago").val(response.data.idCondPago.id).change();  
      $("#Moneda").val(response.data.idMoneda.id).change();  
      $('#ro_inactivo').prop("disabled",false);
      $('#btn_cancelar').prop("disabled",false);
      VGlobal.actualizar = true;
     }
});
}

function Actualizar() {
let metodo = function () {
   $.ajax({
       type: "POST",
       url: `proveedor/actualizar`,
       data: { 
        queryData: JSON.stringify({
          tipPers: $('input:radio[name=rdb_persona]:checked').val(),
          tipDocuIden: $("#TipoDocuIden option:selected").val(),
          numDocuIden: $("#txt_num_docu_iden").val(),
          desMail: $("#txt_des_mail").val(),
          estado: $('input:radio[name=rdb_estado]:checked').val(), 
          priNomb: $("#txt_pri_nombre").val(),
          segNomb: $("#txt_seg_nombre").val(),
          apePate: $("#txt_ape_pate").val(),
          apeMate: $("#txt_ape_mate").val(), 
          desRazoSoci: $("#txt_des_razo_Soci").val(),                       
        }),
        idTipoProveedor: $("#TipoProv option:selected").val(),
        idCondPago: $("#CondPago option:selected").val(),
        idMoneda: $("#Moneda option:selected").val()
       },
       dataType: "json",
       success: function (response) {
               FGlobal.notificacion.satisfactorio("Aviso", "Se Actualizo con Exito!!");
               TblProveedor.clear().rows.add(response.lista).columns.adjust().draw();
               LimpiarCampos();
       },
       error: function (jqXHR, textStatus, errorThrown) {

       }
   });
}
FGlobal.Confirmacion("¿Desea Actualizar el Proveedor?", metodo)
}

function EliminarProveedor(id) {
let metodo = function () {
$.ajax({
      type: "POST",
      url: `proveedor/eliminar`,
      data: {
        idUsua: id
      },
      dataType: "json",
      async: false,
      success: function (response) {
        TblProveedor.clear().rows.add(response.lista).columns.adjust().draw();
      }
});
}
FGlobal.Confirmacion("¿Desea Eliminar el Proveedor?", metodo)
}

function LimpiarCampos() {
   $("#txt_id_prov").val("");
   $('#ro_juridico').prop("checked",true);
   $('#cro_juridico').removeClass("btn-secondary").addClass("btn-primary");
   $('#cro_natural').removeClass("btn-info").addClass("btn-secondary");
   $('#ro_natural').prop("disabled",false);
   $("#TipoDocuIden").val('RUC').change();
   $("#lbl_num_docu_iden").text("Numero RUC")
   $("#txt_num_docu_iden").val("");
   $("#txt_des_mail").val("");
   $('#ro_activo').prop("checked",true);
   $('#cro_activo').removeClass("btn-secondary").addClass("btn-primary");
   $('#cro_inactivo').removeClass("btn-danger").addClass("btn-secondary");
   $('#ro_inactivo').prop("disabled",true);
   $("#txt_pri_nombre").val("");
   $("#txt_seg_nombre").val("");
   $("#txt_ape_pate").val("");
   $("#txt_ape_mate").val("");
   $("#txt_des_razo_Soci").val("");
   $("#txt_fec_naci").val("");
}


