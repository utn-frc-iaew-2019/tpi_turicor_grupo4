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
    """
    RESPONSE
    [{
    'CantidadDisponible': 24,
    'CantidadPuertas': 4,
    'CiudadId': 2,
    'Id': 6,
    'Marca': 'Ford',
    'Modelo': 'Fiesta',
    'PrecioPorDia': Decimal('800'),
    'Puntaje': '5',
    'TieneAireAcon': True,
    'TieneDireccion': True,
    'TipoCambio': 'A',
    'VehiculoCiudadId': 58
    }, {
    """
    request_data = { 'IdCiudad': id_ciudad,
                     'FechaHoraRetiro': fecha_hora_retiro,
                     'FechaHoraDevolucion': fecha_hora_devolucion }
    try:
        return client.service.ConsultarVehiculosDisponibles( request_data , _soapheaders=credentials)['VehiculosEncontrados']['VehiculoModel']
    except Exception as e:
        return e

def reservar_vehiculo(nombre_cliente, dt_devolucion, dt_retiro, id_vehiculociudad, lugar_devolucion, lugar_retiro, dni):
    """
    {
    'Reserva': {
        'ApellidoNombreCliente': 'Juan Perez',
        'CodigoReserva': '8EZTY',
        'Estado': 'Activa',
        'FechaCancelacion': None,
        'FechaHoraDevolucion': datetime.datetime(2019, 10, 21, 0, 0),
        'FechaHoraRetiro': datetime.datetime(2019, 10, 21, 0, 0),
        'FechaReserva': datetime.datetime(2019, 6, 22, 19, 35, 21, 450967, tzinfo=<FixedOffset '-07:00'>),
        'Id': 85,
        'LugarDevolucion': 'Hotel',
        'LugarRetiro': 'Hotel',
        'NroDocumentoCliente': '398405198',
        'TotalReserva': Decimal('0'),
        'UsuarioCancelacion': None,
        'UsuarioReserva': 'grupo_nro4',
        'VehiculoPorCiudadEntity': {
            'CantidadDisponible': 2,
            'CiudadEntity': {
                'Id': None,
                'Nombre': None,
                'PaisEntity': None,
                'PaisId': None
            },
            'CiudadId': 8,
            'Id': 23,
            'VehiculoEntity': {
                'CantidadPuertas': 2,
                'Id': 8,
                'Marca': 'Chevrolet',
                'Modelo': 'Celta',
                'PrecioPorDia': Decimal('300'),
                'Puntaje': '3',
                'TieneAireAcon': True,
                'TieneDireccion': True,
                'TipoCambio': 'M'
            },
            'VehiculoId': 8
        },
        'VehiculoPorCiudadId': 23
    },
    'TimeStamp': datetime.datetime(2019, 6, 22, 19, 35, 21, 904135, tzinfo=<FixedOffset '-07:00'>)
    }
    """
    request_data = {
            'ApellidoNombreCliente': nombre_cliente,
            'FechaHoraDevolucion': dt_devolucion,
            'FechaHoraRetiro': dt_retiro,
            'IdVehiculoCiudad': id_vehiculociudad,
            'LugarDevolucion': lugar_devolucion,
            'LugarRetiro': lugar_retiro,
            'NroDocumentoCliente': dni
            }
    return client.service.ReservarVehiculo(request_data, _soapheaders=credentials)
