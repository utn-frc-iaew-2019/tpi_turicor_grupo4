import psycopg2

class Usuarios():

    # query - (id, nombre, mail)

    def _open_connection(self):
        conn = psycopg2.connect(
            database='iaew',
            user='postgres',
            password='iaew',
            host='127.0.0.1',
            port='5432'
            )
        return conn

    def exists(self, email):
        conn = self._open_connection()
        cur = conn.cursor()
        cur.execute("""SELECT * FROM users WHERE mail=%s;""", (email,))
        query = cur.fetchone()

        it_exists = False
        # Existe valor en tabla
        if query:
            self.last_query = query
            it_exists = True
        cur.close()
        conn.close()
        return it_exists

    def fetch(self, email):
        if self.last_query:
            if self.last_query[2] == email:
                return {'id': self.last_query[0], 'nombre': self.last_query[1]}
        conn = self._open_connection()
        cur = conn.cursor()
        cur.execute("""SELECT * FROM users WHERE mail=%s;""", (email,))
        query = cur.fetchone()
        usuario = None
        # Existe valor en tabla
        if query:
                usuario = {'id': query[0], 'nombre': query[1]}
        cur.close()
        conn.close()
        return usuario

    def create(self, email, name):
        conn = self._open_connection()
        cur = conn.cursor()
        cur.execute("""INSERT INTO users (name, mail) VALUES (%s, %s);""", (name ,email))
        print("USUARIO {} CREADO".format(email))
        conn.commit()
        cur.execute("""SELECT * FROM users WHERE mail=%s;""", (email,))
        query = cur.fetchone()
        cur.close()
        conn.close()
        return {'id': query[0], 'nombre': query[1]}
