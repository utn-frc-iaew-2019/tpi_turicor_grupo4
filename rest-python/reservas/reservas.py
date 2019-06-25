from flask_restful import Resource
from flask import request 
from reservas.soap import api
from reservas.utils import fecha_string_to_dt, fecha_dt_to_string
import psycopg2

class Reservas(Resource):

    def get(self):
        print("GET RESERVA")
        conn = psycopg2.connect(
            database='iaew',
            user='postgres',
            password='iaew',
            host='127.0.0.1',
            port='5432'
            )
        print("DB CONNECT")
        cur = conn.cursor()
        cliente_id = request._sesion['id']
        cur.execute("""SELECT * FROM reservas WHERE cliente=%s;""", (cliente_id,))
        reservas = []
        for r in cur:
            data = {
                    'id': r[0],
                    'codigo_reserva': r[1],
                    'fecha_reserva': fecha_dt_to_string(r[5]),
                    'fecha_retiro': fecha_dt_to_string(r[6]),
                    'fecha_devolucion': fecha_dt_to_string(r[7]),
                    'lugar_retiro': r[8],
                    'lugar_devolucion': r[9],
                    'precio_total': r[12],
                    'vehiculo': r[4],
                    'vehiculo_ciudad_id': r[2],
                    'ciudad': r[3]
                    }
            reservas.append(data)
        return reservas



    def post(self):
        print("POST RESERVA")
        conn = psycopg2.connect(
            database='iaew',
            user='postgres',
            password='iaew',
            host='127.0.0.1',
            port='5432'
            )
        print("DB CONNECT")
        cur = conn.cursor()

        print("CURSOR")
        json_data = request.get_json(force=True, silent=False)
        print(json_data)
        nombre = json_data['nombre']
        apellido = json_data['apellido']
        dt_devolucion = json_data['fechahora_hasta']
        dt_retiro = json_data['fechahora_desde']
        id_vehiculociudad = json_data['id_vehiculo_ciudad']
        id_ciudad = json_data['id_ciudad']
        lugar_devolucion = json_data['lugar_devolucion']
        lugar_retiro = json_data['lugar_retiro']
        dni = json_data['dni']
        print("DATA")
        print(json_data)

        # BUSCAR CIUDAD
        cur.execute("""SELECT * FROM ciudades WHERE id=%s;""", (id_ciudad,))
        ciudad = cur.fetchone()[1]
        # 
        
        cliente_id = request._sesion['id']

        fecha_devolucion = fecha_string_to_dt(dt_devolucion)
        fecha_retiro = fecha_string_to_dt(dt_retiro)
        nombre_cliente = apellido + ", " + nombre
        
        reserva = api.reservar_vehiculo(
                nombre_cliente,
                fecha_devolucion,
                fecha_retiro,
                id_vehiculociudad,
                lugar_devolucion,
                lugar_retiro,
                dni)
        print("Reserva FRESCA")
        print(reserva)

        fecha_reserva = reserva['Reserva']['FechaReserva']
        fecha_reserva_formateada = "{0}/{1}/{2} {3}:{4}:{5}".format(
                fecha_reserva.day,
                fecha_reserva.month,
                fecha_reserva.year,
                fecha_reserva.hour,
                fecha_reserva.minute,
                fecha_reserva.second)

        costo = float(reserva['Reserva']['TotalReserva'])
        precio_venta = costo + costo * 0.2
        print("COSTO: " + str(costo))

        ve = reserva['Reserva']['VehiculoPorCiudadEntity']['VehiculoEntity']

        data = {
                'codigo_reserva': reserva['Reserva']['CodigoReserva'],
                'fecha_reserva': fecha_reserva_formateada,
                'fecha_retiro': dt_retiro,
                'fecha_devolucion': dt_devolucion,
                'lugar_retiro': lugar_retiro,
                'lugar_devolucion': lugar_devolucion,
                'precio_total': precio_venta,
                'vehiculo': ve['Marca'] + ', ' + ve['Modelo'],
                'vehiculo_ciudad_id': id_vehiculociudad,
                'ciudad': ciudad
                }
        print(data)
        # CREO EN BD
        cur.execute("""INSERT INTO reservas (codigo, vehiculo_ciudad_id, ciudad, vehiculo, fecha_reserva, fecha_retiro, fecha_devolucion, lugar_retiro, lugar_devolucion, cliente, costo, precio_venta) 
                VALUES (%(codigo)s, %(vehiculo_ciudad_id)s, %(ciudad)s, %(vehiculo)s, %(fecha_reserva)s, %(fecha_retiro)s, %(fecha_devolucion)s, %(lugar_retiro)s, %(lugar_devolucion)s, %(cliente)s, %(costo)s, %(precio_venta)s)""", 
                {
                    'codigo': data['codigo_reserva'],
                    'vehiculo_ciudad_id': data['vehiculo_ciudad_id'],
                    'ciudad': ciudad,
                    'vehiculo': data['vehiculo'],
                    'fecha_reserva': fecha_reserva,
                    'fecha_retiro': fecha_retiro,
                    'fecha_devolucion': fecha_devolucion,
                    'lugar_retiro': lugar_retiro,
                    'lugar_devolucion': lugar_devolucion,
                    'cliente': cliente_id,
                    'costo': costo,
                    'precio_venta': precio_venta,
                })
        print("RESERVA CREADA")
        conn.commit()
        # BUSCO RESERVA ID
        cur.execute("""SELECT * FROM reservas WHERE codigo=%s;""", (data['codigo_reserva'],))
        id_reserva = cur.fetchone()[0]
        data['id'] = id_reserva
        #
        cur.close()
        conn.close()
        return data
