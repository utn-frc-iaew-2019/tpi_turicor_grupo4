from flask import Flask, url_for, request, jsonify
from flask_restful import Api
from authlib.flask.client import OAuth
from reservas.paises import Paises

app = Flask(__name__)
api = Api(app)

app.secret_key = "secretaso"
client_id='571953119627-2ss3p3se07dfm8li63fuc9afjbmsrb43.apps.googleusercontent.com'
client_secret="tUTzYtkGtiR9BSi091zFTyY5"

client_kwargs = {
        'scope': 'https://www.googleapis.com/auth/userinfo.profile'
}

redirect_uri = "http://localhost:5000/auth"
oauth = OAuth(app)
google = oauth.register(
        name='google',
        client_id=client_id,
        client_secret=client_secret,
        access_token_url='https://www.googleapis.com/oauth2/v4/token',
        authorize_url='https://accounts.google.com/o/oauth2/v2/auth?access_type=offline&prompt=consent',
        redirect_uri=redirect_uri,
#        api_base_url='https://www.googleapis.com',
        client_kwargs=client_kwargs
)

@app.before_request
def verify_login():
    access_code = request.args.get('access_code')
    if access_code:
        request._reservas = { "user": "JUAN" }
        # VALIDAR ACCESS_CODE, SETEAR USUARIO DE SESION
        return
    #auth_code = request.args.get('authorization_code')
    auth_code = request.args.get('code')
    if auth_code:
        # Hago este save porque sino se queja de que no hay redirect uri
        google.save_authorize_state(redirect_uri=redirect_uri)
        token = google.authorize_access_token()['access_token']
        response = google.get("https://www.googleapis.com/oauth2/v1/userinfo?alt=json")
        nombre = response.json()['name']
        user_id = response.json()['id']
        # GUARDAR USUARIO EN BD (SI NO EXISTE)
        # REGISTRAR SESION CON ACCESS_TOKEN => USUARIO
        return jsonify({ "access_code": token, "nombre": nombre }), 201
    return "No autorizado \n", 401

@app.route('/user')
def user():
    print()
    return request._reservas['user']

@app.route('/login')
def login():
    client = oauth.create_client('google')
    #redirect_uri = 'http://reservasiaew.com/auth'
    return client.authorize_redirect(redirect_uri)

@app.route('/auth')
def authorize():
    print("ESTOY VINIENDO POR ACA POR PAJA")
    print(request.args.get('code'))
    return "DONE"

api.add_resource(Paises, '/paises')

if __name__ == '__main__':
    app.run(debug=True)
