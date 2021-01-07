﻿$(document).ready(OnReady);

var user_code_var;

function OnReady() {
    var galletas = document.cookie;
    if (galletas.includes("user_code") && galletas.includes("name")) {
        var listaCookies = galletas.split(";");
        for (i in listaCookies) {
            busca = listaCookies[i].search("name");
            buscaCode = listaCookies[i].search("user_code");
            if (busca > -1) { $('#lblUsuario').html("Usuario: " + listaCookies[i].split("=")[1]); }
            if (buscaCode > -1) { user_code_var = listaCookies[i].split("=")[1]; }
        }
    }
    else {
        window.location.href = "http://localhost:50956/Front/Login.html";
    }
    cargarCiudades();
    crearTablaVehiculos();
}

function cargarCiudades() {
    $.ajax
    (
        {
            method: "GET",
            url: "http://54.213.148.61:8080/ciudades",
            contentType: "application/json; charset=utf-8",
            headers: { user_code: user_code_var }
        }
    )
    .done(function (response) {
        ciudadesObtenidas(response)
    }).fail(function (msg) {
        onErrorObtenerCiudades(msg)
    });
}

function ciudadesObtenidas(msg) {
    for (var i = 0; i < msg.length; i++) {
      $('#ddlCiudad').append('<option value=' + msg[i].id + '>' + msg[i].descripcion + '</option>');
    }
}

function onErrorObtenerCiudades(msg) {
    mostrarError('Error al obtener las ciudades.');
}

function crearTablaVehiculos() {
    var init = [
        {
            "Marca": "-",
            "Modelo": "-",
            "CantidadPuertas": "-",
            "TipoCambio": "-",
            "TieneDireccion": "-",
            "TieneAireAcon": "-",
            "Puntaje": "-",
            "PrecioPorDia": "-",
            "CantidadDisponible": "-"
        }
    ];
    $('#tableVehiculos').bootstrapTable({
        data: init
    });
}

function cargarVehiculos() {
    var ciudad = $('#ddlCiudad option:selected').val(); 
    var fechaDesdeD = $('[id$=txtDesde]').val();
    var fechaHastaD = $('[id$=txtHasta]').val();
    var horaDesdeD = $('#txtHoraDesde option:selected').val();
    var horaHastaD = $('#txtHoraHasta option:selected').val();
    if (validarFechas(fechaDesdeD,horaDesdeD,fechaHastaD,horaHastaD)) {
        $.ajax
        (
            {
                method: "GET",
                url: "http://54.213.148.61:8080/vehiculos_disponibles?ciudad=" + ciudad + "&fecha_retiro=" + fechaDesdeD + " " + horaDesdeD + ":00" + "&fecha_devolucion=" + fechaHastaD + " " + horaHastaD + ":00",
                contentType: "application/json; charset=utf-8",
                headers: { user_code: user_code_var }
            }
        )
        .done(function (response) {
            vehiculosObtenidos(response)
        }).fail(function (msg) {
            onErrorObtenerVehiculos(msg)
        });
    }
}

function vehiculosObtenidos(msg) {
    if (msg == null) {
        crearTablaVehiculos();
    }
    if (msg.length > 0) {
        for (var i = 0; i < msg.length; i++) {
            if (msg[i].TieneDireccion == true) {
                msg[i].TieneDireccion = 'Sí';
            } else {
                msg[i].TieneDireccion = 'No';
            }
            if (msg[i].TieneAireAcon == true) {
                msg[i].TieneAireAcon = 'Sí';
            } else {
                msg[i].TieneAireAcon = 'No';
            }
            if (msg[i].TipoCambio == 'M') {
                msg[i].TipoCambio = 'Manual';
            } else {
                msg[i].TipoCambio = 'Automática';
            }
            msg[i].PrecioPorDia = '$ ' + msg[i].PrecioPorDia;
        }
        $('#tableVehiculos').bootstrapTable('load', msg);
    }
    else {
        var init = [
            {
                "Marca": "-",
                "Modelo": "-",
                "CantidadPuertas": "-",
                "TipoCambio": "-",
                "TieneDireccion": "-",
                "TieneAireAcon": "-",
                "Puntaje": "-",
                "PrecioPorDia": "-",
                "CantidadDisponible": "-"
            }
        ];
        $('#tableVehiculos').bootstrapTable('load', init);
    }
}

function onErrorObtenerVehiculos(msg) {
    mostrarError('Error al obtener el vehículo.');
}

function mostrarError(msg) {
    $('#lblError').html(msg);
    $('#modalError').modal('show');
}

function validarFechas(fechaDesde, horaDesde, fechaHasta, horaHasta) {
    var string = "";
    string = validarFechaDesde(fechaDesde, horaDesde, string);
    string = validarFechaHasta(fechaDesde, horaDesde, fechaHasta, horaHasta, string);
    if (string === "") {
        return true;
    }
    mostrarError(string);
    return false;
}

function validarFechaDesde(fecha, hora, string) {
    if (fecha === "") {
        string = string + "Debe ingresar una fecha desde.<br/>";
    }
    var today = new Date();
    if (!validarFechaMenor(fecha, hora, today)) {
        string = string + "La fecha desde ingresada es menor que la fecha actual.<br/>";
    }
    return string; 
}

function validarFechaHasta(fechaDesde, horaDesde, fechaHasta, horaHasta, string) {
    if (fechaHasta === "") {
        string = string + "Debe ingresar una fecha hasta.<br/>";
    }

    var fecha = fechaDesde.split("/");
    var hora = horaDesde.split(":");
    var x = new Date();
    x.setFullYear(fecha[2], fecha[1] - 1, fecha[0]);
    x.setHours(hora[0], hora[1], 0);

    if (!validarFechaMenor(fechaHasta, horaHasta, x)) {
        string = string + "La fecha hasta ingresada es menor que la fecha desde.<br/>";
    }
    return string;
}

function validarFechaMenor(date, horaDate, date2) {
    var fecha = date.split("/");
    var hora = horaDate.split(":");
    var x = new Date();
    x.setFullYear(fecha[2], fecha[1] - 1, fecha[0]);
    x.setHours(hora[0], hora[1], 0);

    if (x < date2)
        return false;
    else
        return true;
}