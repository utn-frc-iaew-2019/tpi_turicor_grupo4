$(document).ready(OnReady);

function OnReady() {
    var urlParams = new URLSearchParams(window.location.search);
    if (urlParams.get('code')!=null) {
        $.ajax
        (
            {
                method: "GET",
                url: "http://ec2-35-164-13-118.us-west-2.compute.amazonaws.com:8080/login?code=" + urlParams.get('code'),
                contentType: "application/json; charset=utf-8"
            }
        )
        .done(function (response) {
            login(response)
        }).fail(function (msg) {
            onError(msg)
        });
    }
}
    
function login(msg) {
    document.cookie = "user_code=" + msg.user_code;
    document.cookie = "name=" + msg.nombre;
    window.location.href = "http://localhost:50956/Front/Reserva.html";
}

function onError(msg) {
    $('#lblError').html('Error al inciar sesión.');
    $('#modalError').modal('show');
}