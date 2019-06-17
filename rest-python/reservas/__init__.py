from flask import Flask, url_for, request
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

oauth = OAuth(app)
oauth.register(
        name='google',
        client_id=client_id,
        client_secret=client_secret,
        access_token_url='https://www.googleapis.com/oauth2/v4/token',
        authorize_url='https://accounts.google.com/o/oauth2/v2/auth?access_type=offline&prompt=consent',
#        api_base_url='https://www.googleapis.com',
        client_kwargs=client_kwargs
)

@app.route('/login')
def login():
    client = oauth.create_client('google')
    redirect_uri = url_for('authorize',_external=True)
    #redirect_uri = 'http://reservasiaew.com/auth'
    return client.authorize_redirect(redirect_uri)

@app.route('/auth')
def authorize():
    print(request.args.get('code'))
    return "DONE"

api.add_resource(Paises, '/paises')

if __name__ == '__main__':
    app.run(debug=True)
