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

cur.execute("""
CREATE TABLE users (
id SERIAL PRIMARY KEY NOT NULL,
name TEXT NOT NULL,
mail TEXT NOT NULL);
""")

cur.execute("""
CREATE TABLE sessions (
session_id TEXT PRIMARY KEY NOT NULL,
user_id INT references users(id),
created TIMESTAMP NOT NULL);
""")

cur.execute("""
CREATE TABLE ciudades (
id INT PRIMARY KEY NOT NULL,
descripcion TEXT NOT NULL);
""")

cur.execute("""
CREATE TABLE reservas (
codigo INT PRIMARY KEY NOT NULL,
fecha TIMESTAMP NOT NULL,
cliente INT references users(id) NOT NULL,
costo REAL NOT NULL,
precio_venta REAL NOT NULL);
""")

conn.commit()
cur.close()
conn.close()
