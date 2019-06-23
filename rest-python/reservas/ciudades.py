from flask_restful import Resource
from reservas.soap import api
import psycopg2

class Ciudades(Resource):

    def get(self):
        conn = psycopg2.connect(
            database='iaew',
            user='postgres',
            password='iaew',
            host='127.0.0.1',
            port='5432'
            )
        # BUSCAR EN BD
        cur = conn.cursor()
        cur.execute("""SELECT * FROM ciudades""")
        ciudades = []
        for row in cur:
            ciudad = {
                    'id': row[0],
                    'descripcion': row[1]
                    }
            ciudades.append(ciudad)
        cur.close()
        conn.close()
        return ciudades 

