import reservas.soap.api as api

paises_id = []
ciudades_data = []
for pais in api.consultar_paises():
    paises_id.append(pais['id'])

for pais_id in paises_id:
    ciudades = api.consultar_ciudades(pais_id)
    for ciudad in ciudades:
        data = {
                'id': ciudad['Id'],
                'descripcion': ciudad['Nombre'] + ', ' + ciudad['PaisEntity']['Nombre']
                }
        ciudades_data.append(data)

print(ciudades_data)

import psycopg2

conn = psycopg2.connect(
        database='iaew',
        user='postgres',
        password='iaew',
        host='127.0.0.1',
        port='5432'
        )
print("Connected with database")
cur = conn.cursor()

for ciudad in ciudades_data:
        cur.execute("""
        INSERT INTO ciudades (id, descripcion)
        VALUES (%(id)s, %(descripcion)s)
        """, ciudad)

conn.commit()
cur.close()
conn.close()
