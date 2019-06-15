from flask_restful import Resource
from reservas.soap import api

class Paises(Resource):
    def get(self):
        return api.consultar_paises()
