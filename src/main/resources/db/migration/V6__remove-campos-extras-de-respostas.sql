ALTER TABLE respostas
DROP COLUMN status;

ALTER TABLE respostas
CHANGE COLUMN curso_id topico_id BIGINT NOT NULL;

ALTER TABLE respostas RENAME INDEX fk_topico_curso_id TO fk_resposta_topico_id;
ALTER TABLE respostas RENAME INDEX fk_topico_autor_id TO fk_resposta_autor_id;