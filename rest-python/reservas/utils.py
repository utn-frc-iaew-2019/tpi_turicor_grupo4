import re
from datetime import datetime
 
def fecha_string_to_dt(fecha):
        s = re.match('([0-9]*)/([0-9]*)/([0-9]*) ([0-9]*):([0-9]*):([0-9]*)', fecha)
 
        dia = int(s.group(1))
        mes = int(s.group(2))
        año = int(s.group(3))
        hora = int(s.group(4))
        mins = int(s.group(5))
        segs = int(s.group(6))
        
        dt = datetime(año, mes, dia, hora, mins, segs)
        return dt
