DROP TABLE IF EXISTS topicos;

CREATE TABLE topicos(

    id bigint NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(300) NOT NULL,
    curso VARCHAR(50) NOT NULL,
    status VARCHAR(10) NOT NULL,
    fecha_creacion DATETIME(6) NOT NULL,
    autor VARCHAR(100) NOT NULL,

    primary key(id)
);