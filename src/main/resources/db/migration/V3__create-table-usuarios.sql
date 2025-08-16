CREATE TABLE usuarios (

    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    perfil_id BIGINT NOT NULL,
    ativo BOOL NOT NULL DEFAULT 1,

    PRIMARY KEY(id),
    CONSTRAINT fk_usuario_perfil_id FOREIGN KEY(perfil_id) REFERENCES perfis(id)

);