from flask import Flask, url_for, request, jsonify
from flask_restful import Api
import requests
from reservas.paises import Paises
from reservas.usuarios import Usuarios
from reservas.ciudades import Ciudades
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
    if access_code:
        g_headers = {'Authorization': 'Bearer {}'.format(access_code)}
        g_response = requests.get('https://www.googleapis.com/oauth2/v2/userinfo', headers)
        if not g_response.ok:
            print('[ERROR] ACCESS CODE FALLO')
            print('[ERROR] {}'.format(g_headers))
            print('[ERROR] {}'.format(g_response._content))
            return "No autorizado \n", 401

        j = g_response.json()
        user_email = j['email']
        user_name = j['name']
        # VER SI USUARIO EXISTE
        users = Users()
        user = None
        if users.exists(user_email):
            user = users.fetch(user_email)
        else:
            user = users.create(user_name, user_email)
        # CREAR SESION
        sesiones = app._sesiones
        sesion_id = uuid.uuid4()
        sesiones[sesion_id] = user
        response = {'user_code': sesion_id, 'nombre': user.nombre}
        return jsonify(response)
    user_code = request.headers.get('user_code')
    if user_code:
        print("USER_CODE")
        # VALIDAR USUARIO
        try:
            sesion = app._sesiones[user_code]
            request._sesion = sesion
        except KeyError:
            # No se encontraba id de sesion en sesiones
            return "No autorizado \n", 401

api.add_resource(Paises, '/paises')
api.add_resource(Ciudades, '/ciudades')

if __name__ == '__main__':
    app.run(debug=True)
