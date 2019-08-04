<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <script src="resource/js/jquery-3.2.0.min.js" type="text/javascript"></script>
        <script src="resource/js/bootstrap.js" type="text/javascript"></script>
        <title>Resgistro de Clientes</title>

        <jsp:include page="resource/rutas.jsp" />
    </head>
    <style>

        .note
        {
            text-align: center;
            height: 80px;
            background: #582707;
            color: #fff;
        }
        .form-content
        {
            padding: 5%;
            border: 1px solid #ced4da;
            margin-bottom: 2%;
        }
        .form-control{
            border-radius:1.5rem;
        }
        .btnSubmit
        {
            border:none;
            border-radius:1.5rem;
            background: #C2AD6B;
            color: #000;
            font-size: 20px;
        }

        body {
            background-image: url("resource/img/fondo1.png");
        }

    </style>
    <body>
        <jsp:include page="resource/nav.jsp"/>
        <br>
        <br>
        <br>
        <br>
        <form action="ServletRegistroUsuario" method="POST" class="needs-validation" novalidate>
            <div class="container register-form " >
                <div class="form">
                    <div class="note">
                        <h3>Registro de Usuario</h3>
                    </div>
                    <div class="form-content" style="background-color: #fff">
                        <div class="row">                          
                            <div class="col-md-4">
                                <h1>Datos de Cuenta</h1>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="txtNombreUsuario" placeholder="Nombre de Usuario" required="">
                                    <div class="valid-feedback">
                                        Nombre de usuario correcto
                                    </div>
                                    <div class="invalid-feedback">
                                        Revisa tu nombre de usuario
                                    </div>
                                </div>

                                <div class="form-group">
                                    <input type="password" class="form-control" name="txtContrasenia" placeholder="Contraseña" required="">
                                    <div class="valid-feedback">
                                        Contraseña correcta
                                    </div>
                                    <div class="invalid-feedback">
                                        Escribe tu contraseña
                                    </div>
                                </div> 
                            </div>
                            <div class="col-md-8">
                                <h1> Datos de Usuario</h1>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="nombre" name="txtPrimerNombre" placeholder="Nombre" required="" oninput="inputAlphabet(this)">
                                    <div class="valid-feedback" id="nombreCorrecto">
                                        Tu nombre está correcto
                                    </div>
                                    <div class="invalid-feedback" id="nombreError">
                                        Tu nombre está incorrecto
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="appaterno" name="txtApellidoPaterno" placeholder="Apellido Paterno" required="" oninput="inputAlphabet(this)">
                                    <div class="valid-feedback" id="appaternoCorrecto">
                                        Tu apellido paterno está correcto
                                    </div>
                                    <div class="invalid-feedback" id="appaternoError">
                                        Tu apellido paterno está incorrecto
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="apmaterno" name="txtApellidoMaterno" placeholder="Apellido Materno" required="" oninput="inputAlphabet(this)">
                                    <div class="valid-feedback" id="apmaternoCorrecto">
                                        Tu apellido materno está correcto
                                    </div>
                                    <div class="invalid-feedback" id="apmaternoError">
                                        Tu apellido materno está incorrecto
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="txtRut" name="txtRut" placeholder="RUT" oninput="checkRut(this)" required="">
                                    <div class="valid-feedback" id="apmaternoCorrecto">
                                        Tu rut está correcto
                                    </div>
                                    <div class="invalid-feedback" id="apmaternoError">
                                        Tu rut no está incorrecto
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex justify-content-center">
                            <div class="col-sm-3">
                                <button type="submit" class=" col btnSubmit" name="btnAccion" value="registrar" >Registrarme</button>
                            </div>
                        </div>
                        <jsp:include page="resource/mensajes.jsp"></jsp:include>
                        </div>
                    </div>
                </div>
            </form>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        <jsp:include page="resource/footer.jsp"></jsp:include>
    </body>
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict';
            window.addEventListener('load', function () {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();




    </script>

    <script>

        function formValidation() {
// Make quick references to our fields.
            var nombre = document.getElementById('nombre');
            var appaterno = document.getElementById('appaterno');
            var apmaterno = document.getElementById('apmaterno');
            var addr = document.getElementById('addr');
            var zip = document.getElementById('zip');
            var state = document.getElementById('state');
            var username = document.getElementById('username');
            var email = document.getElementById('email');
// To check empty form fields.
            if (nombre.value.length === 0) {
                document.getElementById('head').innerText = "* All fields are mandatory *"; // This segment displays the validation rule for all fields
                nombre.focus();
                return false;
            }
// Check each input in the order that it appears in the form.
            if (inputAlphabet(nombre, "Aquí solo van letras", "nombre")) {
                if (inputAlphabet(appaterno, "", "appaterno")) {
                    if (inputAlphabet(apmaterno, "", "apmaterno")) {
                        if (lengthDefine(username, 6, 8)) {
                            if (emailValidation(email, "* Please enter a valid email address *")) {
                                if (trueSelection(state, "* Please Choose any one option")) {
                                    if (textAlphanumeric(addr, "* For Address please use numbers and letters *")) {
                                        if (textNumeric(zip, "* Please enter a valid zip code *")) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        function inputAlphabet(inputtext) {
            var alphaExp = /^[a-zA-Z]+$/;
            if (inputtext.value.match(alphaExp)) {
                inputtext.setCustomValidity('');
                return true;
            } else {
                //document.getElementById('errorNombre').innerText = alertMsg; // This segment displays the validation rule for name.
                inputtext.setCustomValidity("Error");
                return false;
                inputtext.focus();
            }
        }

        function checkRut(rut) {
            // Despejar Puntos
            var valor = rut.value.replace('.', '');
            // Despejar Guión
            valor = valor.replace('-', '');

            // Aislar Cuerpo y Dígito Verificador
            cuerpo = valor.slice(0, -1);
            dv = valor.slice(-1).toUpperCase();

            // Formatear RUN
            rut.value = cuerpo + '-' + dv

            // Si no cumple con el mínimo ej. (n.nnn.nnn)
            if (cuerpo.length < 7) {
                rut.setCustomValidity("RUT Incompleto");
                return false;
            }

            // Calcular Dígito Verificador
            suma = 0;
            multiplo = 2;

            // Para cada dígito del Cuerpo
            for (i = 1; i <= cuerpo.length; i++) {

                // Obtener su Producto con el Múltiplo Correspondiente
                index = multiplo * valor.charAt(cuerpo.length - i);

                // Sumar al Contador General
                suma = suma + index;

                // Consolidar Múltiplo dentro del rango [2,7]
                if (multiplo < 7) {
                    multiplo = multiplo + 1;
                } else {
                    multiplo = 2;
                }

            }

            // Calcular Dígito Verificador en base al Módulo 11
            dvEsperado = 11 - (suma % 11);

            // Casos Especiales (0 y K)
            dv = (dv == 'K') ? 10 : dv;
            dv = (dv == 0) ? 11 : dv;

            // Validar que el Cuerpo coincide con su Dígito Verificador
            if (dvEsperado != dv) {
                rut.setCustomValidity("RUT Inválido");
                return false;
            }

            // Si todo sale bien, eliminar errores (decretar que es válido)
            rut.setCustomValidity('');
        }
    </script>
</html>

