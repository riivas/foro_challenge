CREATE TABLE topicos(

    TopicoId bigint NOT NULL AUTO_INCREMENT,
    Titulo VARCHAR(100) NOT NULL,
    Mensaje VARCHAR(300) NOT NULL,
    Curso VARCHAR(50) NOT NULL,
    Status VARCHAR(10) NOT NULL,
    FechaCreacion TIMESTAMP(6) NOT NULL,
    Usuario VARCHAR(100) NOT NULL,

    primary key(TopicoId)
);