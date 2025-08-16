CREATE TABLE respostas (

    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    solucao BOOL NOT NULL DEFAULT 0,
    autor_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_resposta_autor_id FOREIGN KEY(autor_id) REFERENCES usuarios(id),
    CONSTRAINT fk_resposta_topico_id FOREIGN KEY(topico_id) REFERENCES topicos(id)

);