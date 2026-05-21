PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS incidencias;
DROP TABLE IF EXISTS reservas;
DROP TABLE IF EXISTS actividades;
DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios (
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre        TEXT NOT NULL,
    dni           TEXT NOT NULL UNIQUE,
    email         TEXT NOT NULL,
    telefono      TEXT,
    tipo_usuario  TEXT NOT NULL CHECK (tipo_usuario IN ('ALUMNO','SOCIO','AMBOS'))
);

CREATE TABLE actividades (
    id               INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre           TEXT NOT NULL,
    tipo_actividad   TEXT NOT NULL CHECK (tipo_actividad IN ('ACADEMICA','DEPORTIVA')),
    duracion         INTEGER NOT NULL CHECK (duracion > 0),
    precio           REAL NOT NULL CHECK (precio >= 0),
    plazas_maximas   INTEGER NOT NULL CHECK (plazas_maximas > 0),
    plazas_ocupadas  INTEGER NOT NULL CHECK (plazas_ocupadas >= 0)
);

CREATE TABLE reservas (
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    id_usuario    INTEGER NOT NULL,
    id_actividad  INTEGER NOT NULL,
    fecha         TEXT NOT NULL,
    estado        TEXT NOT NULL CHECK (estado IN ('ACTIVA','CANCELADA')),
    FOREIGN KEY (id_usuario)   REFERENCES usuarios(id),
    FOREIGN KEY (id_actividad) REFERENCES actividades(id)
);

CREATE TABLE incidencias (
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    id_usuario   INTEGER NOT NULL,
    asunto       TEXT NOT NULL,
    descripcion  TEXT NOT NULL,
    fecha        TEXT NOT NULL,
    estado       TEXT NOT NULL CHECK (estado IN ('ABIERTA','EN_PROCESO','CERRADA')),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);