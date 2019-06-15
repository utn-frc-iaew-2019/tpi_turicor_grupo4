from flask import Flask
from flask_restful import Api
from reservas.paises import Paises

app = Flask(__name__)
api = Api(app)

api.add_resource(Paises, '/paises')

if __name__ == '__main__':
    app.run(debug=True)
