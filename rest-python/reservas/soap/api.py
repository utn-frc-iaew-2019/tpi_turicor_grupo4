from zeep import Client

client = Client('http://rubenromero-001-site1.itempurl.com/WCFReservaVehiculos.svc?singleWsdl')

# TODO: Meter en una config
credentials = { 'Credentials': { 'UserName': 'grupo_nro4', 'Password': '5PaNNiAqys' } }

def consultar_paises():
    paises_list = []
    response = client.service.ConsultarPaises(_soapheaders=credentials)['Paises']['PaisEntity']
    for pais in response:
        paises_list.append({'id': pais['Id'], 'nombre': pais['Nombre']})
    return paises_list

def cancelar_reserva():
    return "Not implented"

def consultar_ciudades(id_pais):
    return client.service.ConsultarCiudades({'IdPais': id_pais}, _soapheaders=credentials)['Ciudades']['CiudadEntity']

def consultar_reserva():
    return "Not implented"

def consultar_vehiculos_disponibles(id_ciudad, fecha_hora_retiro, fecha_hora_devolucion):
    """
    id_ciudad: int
    fecha_hora_retiro: datetime.datetime
    fecha_hora_devolucion: datetime.datetime
    """
    request_data = { 'IdCiudad': id_ciudad,
                     'FechaHoraRetiro': fecha_hora_retiro,
                     'FechaHoraDevolucion': fecha_hora_devolucion }
    try:
        return client.service.ConsultarVehiculosDisponibles( request_data , _soapheaders=credentials)['VehiculosEncontrados']['VehiculoModel']
    except Exception as e:
        return e

def reservar_vehiculo():
    return "Not implented"
