-- DROP SCHEMA cotacao;

CREATE SCHEMA cotacao;

-- cotacao.cotacao definition

-- Drop table

-- DROP TABLE cotacao.cotacao;

CREATE TABLE cotacao.cotacao (
	id bigserial NOT NULL,
	data_cotacao timestamp NULL,
	nome_fornecedor varchar(255) NULL,
	id_produto int8 NULL,
	preco numeric(19,2) NULL,
	validade_cotacao timestamp NULL,
	CONSTRAINT cotacao_pkey PRIMARY KEY (id)
);