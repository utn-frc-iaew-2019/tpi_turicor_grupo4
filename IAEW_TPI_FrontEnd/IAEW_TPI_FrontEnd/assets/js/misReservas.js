$(document).ready(OnReady);

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
    crearTablaReservas();
    cargarReservas();
    $("#btnCancelar").click(function () {
        cancelarReserva();
    });   
}

function crearTablaReservas() {
    var init = [
        {
            "codigo_reserva": "-",
            "fecha_reserva": "-",
            "ciudad": "-",
            "vehiculo": "-",
            "precio_total": "-",
            "id": "-"
        }
    ];
    $('#tableReservas').bootstrapTable({
        data: init
    });
}

function cargarReservas() {
    $.ajax
    (
        {
            method: "GET",
            url: "http://54.213.148.61:8080/reservas",
            contentType: "application/json; charset=utf-8",
            headers: { user_code: user_code_var }
        }
    )
    .done(function (response) {
        reservasObtenidas(response)
    }).fail(function (msg) {
        onErrorObtenerReservas(msg)
    });
}

function reservasObtenidas(msg) {
    if (msg == null) {
        crearTablaReservas();
    }
    if (msg.length > 0) {
        for (var i = 0; i < msg.length; i++) {
            msg[i].precio_total = '$ ' + msg[i].precio_total;
        }
        $('#tableReservas').bootstrapTable('load', msg);
    }
    else {
        var init = [
            {
                "codigo_reserva": "-",
                "fecha_reserva": "-",
                "ciudad": "-",
                "vehiculo": "-",
                "precio_total": "-",
                "id": "-"
            }
        ];
        $('#tableReservas').bootstrapTable('load', init);
    }
}

function onErrorObtenerReservas(msg) {
    mostrarError('Error al obtener las reservas.');
}

function mostrarError(msg) {
    $('#lblError').html(msg);
    $('#modalError').modal('show');
}

function LinkFormatter(value) {
    if (value !== "-") {
        return '<a href="javascript:void(0)" class="btn btn-primary col-12"  onclick="seleccionarReserva(' + value + ')">Detalle</a>';
    }
    else {
        return value;
    }
}

function seleccionarReserva(codigo) {
    $.ajax
    (
        {
            method: "GET",
            url: "http://54.213.148.61:8080/reservas/" + codigo,
            contentType: "application/json; charset=utf-8",
            headers: { user_code: user_code_var }
        }
    )
    .done(function (response) {
        reservaObtenida(response)
    }).fail(function (msg) {
        onErrorObtenerReserva(msg)
    });
}

function reservaObtenida(msg) {
    $('#lblId').html(msg.id);
    $('#lblCodigo').html(msg.codigo_reserva);
    $('#lblFechaReserva').html(msg.fecha_reserva);
    $('#lblCiudad').html(msg.ciudad);
    $('#lblVehiculo').html(msg.vehiculo);
    $('#lblFechaDesde').html(msg.fecha_retiro);
    $('#lblFechaHasta').html(msg.fecha_devolucion);
    $('#lblRetiro').html(msg.lugar_retiro);
    $('#lblDevolucion').html(msg.lugar_devolucion);
    $('#lblPrecio').html(msg.precio_total);
    showDetalle();
}

function onErrorObtenerReservas(msg) {
    mostrarError('Error al obtener la reserva.');
}

function cancelarReserva() {
    var codigo = $('#lblId').html();
    $.ajax
    (
        {
            method: "DELETE",
            url: "http://54.213.148.61:8080/reservas/" + codigo,
            contentType: "application/json; charset=utf-8",
            headers: { user_code: user_code_var }
        }
    )
    .done(function (response) {
        hideDetalle();
        cargarReservas();
    }).fail(function (msg) {
        hideDetalle();
        mostrarError('Error al cancelar la reserva.');
    });
}