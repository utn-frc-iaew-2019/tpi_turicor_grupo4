from flask import Flask, url_for, request, jsonify
from flask_restful import Api
import requests
from reservas.paises import Paises
from reservas.usuarios import Usuarios
from reservas.ciudades import Ciudades
import reservas.soap.api as api_soap
from reservas.utils import fecha_string_to_dt
import uuid

app = Flask(__name__)
api = Api(app)
app._sesiones = {}

app.secret_key = "secretaso"
client_id='571953119627-2ss3p3se07dfm8li63fuc9afjbmsrb43.apps.googleusercontent.com'
client_secret="tUTzYtkGtiR9BSi091zFTyY5"

@app.before_request
def verify_login():
    access_code = request.args.get('code')
    autorizado = False
    if access_code:
        payload = {
                'code': access_code,
                'redirect_uri': 'http://localhost:50956/Front/Login.html',
                'client_id': client_id,
                'client_secret': client_secret,
                'scope': '',
                'grant_type': 'authorization_code'
                }
        code_response = requests.post("https://www.googleapis.com/oauth2/v4/token", data=payload)
        print(code_response.request.url)
        print(code_response.request.headers)
        print('')
        print(code_response._content)
        print(code_response.json())
        access_code = code_response.json()['access_token']
        g_headers = {'Authorization': 'Bearer {}'.format(access_code)}
        g_response = requests.get('https://www.googleapis.com/oauth2/v2/userinfo', headers=g_headers)
        if not g_response.ok:
            print('[ERROR] {}'.format(g_response.request.url))
            print('[ERROR] {}'.format(g_response.request.headers))
            print('[ERROR] ACCESS CODE FALLO')
            print('[ERROR] {}'.format(g_headers))
            print('[ERROR] {}'.format(g_response._content))
            return "No autorizado \n", 401

        j = g_response.json()
        user_email = j['email']
        user_name = j['name']
        # VER SI USUARIO EXISTE
        users = Usuarios()
        user = None
        if users.exists(user_email):
            user = users.fetch(user_email)
        else:
            user = users.create(user_name, user_email)
        # CREAR SESION
        sesiones = app._sesiones
        sesion_id = uuid.uuid4()
        sesiones[sesion_id] = user
        response = {'user_code': sesion_id, 'nombre': user['nombre']}
        return jsonify(response)
    user_code = request.headers.get('user_code')
    if user_code:
        print("USER_CODE")
        # VALIDAR USUARIO
        try:
            sesion = app._sesiones[user_code]
            request._sesion = sesion
            autorizado = True
        except KeyError:
            # No se encontraba id de sesion en sesiones
            return "No autorizado \n", 401
    if not autorizado:
        return "No autorizado \n", 401

@app.route('/vehiculos_disponibles')
def vehiculos_disponibles():
    ciudad = request.args.get('ciudad')
    fecha_retiro = request.args.get('fecha_retiro')
    fecha_devolucion = request.args.get('fecha_devolucion')
    fecha_retiro = fecha_string_to_dt(fecha_retiro)
    fecha_devolucion = fecha_string_to_dt(fecha_devolucion)
    api_response = api_soap.consultar_vehiculos_disponibles(ciudad, fecha_retiro, fecha_devolucion)
    response_data = []
    for r in api_response:
        data = {
            'CantidadDisponible': r['CantidadDisponible'],
            'CantidadPuertas': r['CantidadPuertas'],
            'CiudadId': r['CiudadId'],
            'Id': r['Id'],
            'Marca': r['Marca'],
            'Modelo': r['Modelo'],
            'PrecioPorDia': float(r['PrecioPorDia']) + float(r['PrecioPorDia'])*0.2,
            'Puntaje': r['Puntaje'],
            'TieneAireAcon': r['TieneAireAcon'],
            'TieneDireccion': r['TieneDireccion'],
            'TipoCambio': r['TipoCambio'],
            'VehiculoCiudadId': r['VehiculoCiudadId']
            }
        response_data.append(data)
    return jsonify(response_data)


api.add_resource(Paises, '/paises')
api.add_resource(Ciudades, '/ciudades')

if __name__ == '__main__':
    app.run(debug=True)
