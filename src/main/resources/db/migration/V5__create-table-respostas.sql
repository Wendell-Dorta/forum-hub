CREATE TABLE respostas (

    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(100) NOT NULL DEFAULT 'ABERTO',
    solucao BOOL NOT NULL DEFAULT 0,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_topico_autor_id FOREIGN KEY(autor_id) REFERENCES usuarios(id),
    CONSTRAINT fk_topico_curso_id FOREIGN KEY(curso_id) REFERENCES cursos(id)

);