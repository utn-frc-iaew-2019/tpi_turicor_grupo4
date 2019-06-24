from flask_restful import Resource
from flask import request 
from reservas.soap import api
from reservas.utils import fecha_string_to_dt, fecha_dt_to_string
import psycopg2

class Reserva(Resource):

    def get(self, reserva_id):
        print("GET RESERVA DETALLE")
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
        cur.execute("""SELECT * FROM reservas WHERE id=%s;""", (reserva_id,))
        query = cur.fectchone()
        codigo = query[1]
        reserva = api.consultar_reserva(codigo)
        ve = reserva['Reserva']['VehiculoPorCiudadEntity']['VehiculoEntity']
        
        data = {
                'codigo_reserva': reserva['Reserva']['CodigoReserva'],
                'fecha_reserva': fecha_dt_to_string(reserva['Reserva']['FechaReserva']),
                'fecha_retiro': fecha_dt_to_string(reserva['Reserva']['FechaHoraRetiro']),
                'fecha_devolucion': fecha_dt_to_string(reserva['Reserva']['FechaHoraDevolucion']),
                'lugar_retiro': reserva['Reserva']['LugarRetiro'],
                'lugar_devolucion': reserva['Reserva']['LugarDevolucion'],
                'precio_total': query[12],
                'vehiculo': ve['Marca'] + ', ' + ve['Modelo'],
                'vehiculo_ciudad_id': reserva['Reserva']['VehiculoPorCiudadEntity']['VehiculoPorCiudadId'],
                'ciudad': query[3]
                }
        cur.close()
        conn.close()
        return data



    def delete(self, reserva_id):
        print("DELETE RESERVA: {}".format(reserva_id))
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
        cur.execute("""SELECT * FROM reservas WHERE id=%s;""", (reserva_id,))
        query = cur.fetchone()
        codigo = query[1]
        reserva = api.cancelar_reserva(codigo)
        ve = reserva['Reserva']['VehiculoPorCiudadEntity']['VehiculoEntity']
        
        data = {
                'codigo_reserva': reserva['Reserva']['CodigoReserva'],
                'fecha_reserva': fecha_dt_to_string(reserva['Reserva']['FechaReserva']),
                'fecha_retiro': fecha_dt_to_string(reserva['Reserva']['FechaHoraRetiro']),
                'fecha_devolucion': fecha_dt_to_string(reserva['Reserva']['FechaHoraDevolucion']),
                'lugar_retiro': reserva['Reserva']['LugarRetiro'],
                'lugar_devolucion': reserva['Reserva']['LugarDevolucion'],
                'precio_total': query[12],
                'vehiculo': ve['Marca'] + ', ' + ve['Modelo'],
                'vehiculo_ciudad_id': reserva['Reserva']['VehiculoPorCiudadEntity']['VehiculoPorCiudadId'],
                'ciudad': query[3]
                }
        # Borro de BD
        cur.execute("""DELETE FROM reservas WHERE id=%s;""", (reserva_id,))
        conn.commit()
        cur.close()
        conn.close()
        return data
