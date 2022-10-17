const FGlobal = {
    Confirmacion: (titulo, funcion) => {
        $.confirm({
            closeIcon: false,
            icon: 'far fa-question-circle',
            title: titulo,
            theme: 'modern',
            content: "",
            type: 'blue',
            buttons: {
                SI: {
                    text: '<i class="fas fa-check"></i> Aceptar',
                    btnClass: 'btn-success',
                    action: function () {
                        funcion();
                    }
                },
                NO: {
                    text: '<i class="fas fa-times"></i> Cancelar',
                    btnClass: 'btn-danger',
                    action: function () {
                        toastr.error("Cancelado...", "Aviso!!");
                    }
                }
            }
        });
    },
    LibValidacion: {
        ValidarCampos: (campos) => {
            var error = 0;
            for (var valor in campos) {
                switch (campos[valor]["tipo"]) {
                    case "texto":
                        if (campos[valor]["validaciones"].hasOwnProperty("vacio")) {
                            if (campos[valor]["validaciones"]["vacio"].hasOwnProperty("condicion")) {
                                let CondicionValid = campos[valor]["validaciones"]["vacio"]["condicion"](); 

                                if (CondicionValid  && $(`#${valor}`).val() == "" && $(`#${valor}`).attr("data-valida") == "true") {
                                    error++
                                    if (!$(`#${valor}`).hasClass("is-invalid")) {
                                        $(`#${valor}`).after(`<div class="invalid-feedback" id="ERR-${valor}">${campos[valor]["validaciones"]["vacio"]["mensaje"]}</div>`);
                                    }
                                    $(`#${valor}`).addClass("is-invalid");
                                }
                            } else {
                                if ($(`#${valor}`).val() == "" && $(`#${valor}`).attr("data-valida") == "true") {
                                    error++
                                    if (!$(`#${valor}`).hasClass("is-invalid")) {
                                        $(`#${valor}`).after(`<div class="invalid-feedback" id="ERR-${valor}">${campos[valor]["validaciones"]["vacio"]["mensaje"]}</div>`);
                                    }
                                    $(`#${valor}`).addClass("is-invalid");
                                }
                            }
                        }
                        break;
                    case "select":
                        if (campos[valor]["validaciones"].hasOwnProperty("vacio")) {
                            if (campos[valor]["validaciones"]["vacio"].hasOwnProperty("condicion")) {
                                let CondicionSelecValid = campos[valor]["validaciones"]["vacio"]["condicion"](); 
                                let selectvacio = $(`#${valor}`).select2('data').length == 0 ? "" : $(`#${valor}`).select2('data')[0].id;

                                if (CondicionSelecValid == true && $(`#${valor}`).attr("data-valida") == "true" && selectvacio == "") {
                                    error++
                                    let contentOption = $(`#${valor}`).attr("data-content-option");
                                    if (!$(`#${valor}`).hasClass("is-invalid")) {
                                        let contentID = $(`#${valor}`).attr("data-content-id");
                                        $(`#${contentID}`).append(`<div class="invalid-feedback" id="ERR-${valor}">${campos[valor]["validaciones"]["vacio"]["mensaje"]}</div>`);
                                    }
                                    let padreContenedorOption = $(`#${contentOption}`).parent();
                                    $(`#${valor}`).addClass("is-invalid");
                                    padreContenedorOption.addClass("is-invalid");
                                }
                            } else {
                                if ($(`#${valor}`).select2('data').length == 0 ? "" : $(`#${valor}`).select2('data')[0].id == "" && $(`#${valor}`).attr("data-valida") == "true") {
                                    error++
                                    let contentOption = $(`#${valor}`).attr("data-content-option");
                                    if (!$(`#${valor}`).hasClass("is-invalid")) {
                                        let contentID = $(`#${valor}`).attr("data-content-id");
                                        $(`#${contentID}`).append(`<div class="invalid-feedback" id="ERR-${valor}">${campos[valor]["validaciones"]["vacio"]["mensaje"]}</div>`);
                                    }
                                    let padreContenedorOption = $(`#${contentOption}`).parent();
                                    $(`#${valor}`).addClass("is-invalid");
                                    padreContenedorOption.addClass("is-invalid");
                                }
                            }
                        }
                        break;
                }
            }
   
            if (error == 0) {
                return false;
            } else {
                return true;
            }
        },
        InicializarCampos: (campos) => {
            for (var valor in campos) {
                switch (campos[valor]["tipo"]) {
                    case "texto":
                        if (campos[valor]["validaciones"].hasOwnProperty("longitudDatos")) {
                            $(`#${valor}`).attr('maxlength', campos[valor]["validaciones"]["longitudDatos"]["max"]);
                        }
                        $(`#${valor}`).bind("keyup", ValidacionInputs)
                        break;
                    case "select":
                        $(`#${valor}`).bind("change.select2", ValidacionSelects)
                        break;

                }
            }
        },     
        LimpiarValidacionGlobal: (campos) => {
            for (var valor in campos) {
                switch (campos[valor]["tipo"]) {
                    case "texto":
                        if ($(`#${valor}`).hasClass('is-invalid')) {
                            $(`#${valor}`).removeClass('is-invalid')
                            $(`#ERR-${valor}`).remove();
                        }
                        break;
                    case "select":
                        if ($(`#${valor}`).hasClass('is-invalid')) {
                            $(`#${valor}`).removeClass('is-invalid')
                            $(`#ERR-${valor}`).remove();
                            let contentOption = $(`#${valor}`).attr("data-content-option");
                            let padreContenedorOption = $(`#${contentOption}`).parent();
                            padreContenedorOption.removeClass("is-invalid");
                        }
                        break;
                }
            }
        },
        LimpiarValidacionIndividual: (campo) => {
            switch (campo["tipo"]) {
                case "texto":
                    if ($(`#${campo}`).hasClass('is-invalid')) {
                        $(`#${campo}`).removeClass('is-invalid')
                        $(`#ERR-${campo}`).remove();
                    }
                    break;
                case "select":
                    if ($(`#${campo}`).hasClass('is-invalid')) {
                        $(`#${campo}`).removeClass('is-invalid')
                        $(`#ERR-${campo}`).remove();
                        let contentOption = $(`#${campo}`).attr("data-content-option");
                        let padreContenedorOption = $(`#${contentOption}`).parent();
                        padreContenedorOption.removeClass("is-invalid");
                    }
                    break;
            }
        }
    },
}