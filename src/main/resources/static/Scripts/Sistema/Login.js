var validation;

        // Init form validation rules. For more info check the FormValidation plugin's official documentation:https://formvalidation.io/
validation = FormValidation.formValidation(
	KTUtil.getById('FrmLogin'),
	{
		fields: {
			txt_usuario: {
				validators: {
					notEmpty: {
						message: 'Usuario es necesario'
					}
				}
			},
			txt_clave: {
				validators: {
					notEmpty: {
						message: 'Clave es necesario'
					}
				}
			}
		},
		plugins: {
            trigger: new FormValidation.plugins.Trigger(),
            submitButton: new FormValidation.plugins.SubmitButton(),
            //defaultSubmit: new FormValidation.plugins.DefaultSubmit(), // Uncomment this line to enable normal button submit after form validation
			bootstrap: new FormValidation.plugins.Bootstrap()
		}
	}
);

$('#BtnIniciarSesion').on('click', function (e) {
    e.preventDefault();

    validation.validate().then(function(status) {
        if (status == 'Valid') {
          $.ajax({
            type: "POST",
            dataType: "json",
            url: "/IniciarSesion",
            data: {
                usuario : $("#txt_usuario").val(),
                clave: $("#txt_clave").val(),
            },
            success: function (response) {
                window.location.href = "http://localhost:8080/Inicio";
            }
          });
        } else {
            swal.fire({
                text: "Se encontraron errores en el formulario, por favor intentelo nuevamente.",
                icon: "error",
                buttonsStyling: false,
                confirmButtonText: "OK!",
                customClass: {
                    confirmButton: "btn font-weight-bold btn-light-primary"
                }
            }).then(function() {
                KTUtil.scrollTop();
            });
        }
    });
});