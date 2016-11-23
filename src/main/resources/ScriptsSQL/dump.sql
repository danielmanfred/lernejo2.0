
/**
 * Author:  Daniel Tiago
 * Created: 13/11/2016
 */
-- Cria o schema lernejo_db
CREATE DATABASE IF NOT EXISTS lernejo_db;
USE lernejo_db;

-- Definição da tabela cidade
DROP TABLE IF EXITS 'cidade';
CREATE TABLE 'cidade'
(
    'IdCidade' int(10) NOT NULL AUTO_INCREMENT,
    'Nome' varchar(75) NOT NULL,
    PRIMARY KEY ('IdCidade')
) ENGINE = innoDB AUTO_INCREMENT = 27 DEFAULT CHARSET = latin1;

-- Preenchimento de dados para a tabela cidade
INSERT INTO 'cidade'('IdCidade', 'Nome') VALUES
(1, 'Natal'),
(2, 'Macau'),
(5, 'Mossoró');

-- Definição da tabela endereço
DROP TABLE IF EXISTS 'endereco';
CREATE TABLE 'endereco'
(
    'IdEndereco' int(10) NOT NULL AUTO_INCREMENT,
    'Bairro' varchar(50) DEFAULT NULL,
    'CEP' varchar(9) DEFAULT NULL,
    'Numero' int(10) DEFAULT NULL,
    'IdCidade' int(10) NOT NULL,
    'IdPessoa' int(10) DEFAULT NULL,
    PRIMARY KEY ('IdEndereco'),
    KEY 'EnderecoCidade' ('IdEndereco'),
    KEY 'EnderecoPessoa' ('IdPessoa'),
    CONSTRAINT 'EnderecoCidade' FOREIGN KEY ('IdEndereco') REFERENCES ('IdEndereco'),
    CONSTRAINT 'EnderecoPessoa' FOREIGN KEY ('IdPessoa') REFERENCES ('IdPessoa')
) ENGINE = innoDB AUTO_INCREMENT = 2 DEFAULT CHARSET = latin1;

-- Preenchimento da tabela endereço
INSERT INTO 'endereco'
(
    'IdEndereco',
    'Bairro',
    'CEP',
    'Numero',
    'IdCidade',
    'IdPessoa'
) VALUES
(1,'Lagoa Nova','09999-111',4,1,1);

-- Definição da tabela Pessoa
DROP TABLE IF NOT EXISTS 'pessoa';
CREATE TABLE 'pessoa'
(
    'IdPessoa' int(10) NOT NULL AUTO_INCREMENT,
    'CPF' varchar(14) NOT NULL,
    'DataCadastro' date NOT NULL,
    'Email' varchar(50) NOT NULL,
    'Nome' varchar(50) NOT NULL,
    'Telefone' varchar(15) NOT NULL,
    'IdSexo' int(10) NOT NULL,
    PRIMARY KEY ('IdPessoa'),
    KEY 'PessoaSexo' ('IdSexo'),
    CONSTRAINT 'PessoaSexo' FOREIGN KEY ('IdSexo') REFERENCES ('IdSexo')
) ENGINE = innoDB AUTO_INCREMENT = 8 DEFAULT CHARSET = latin1;

-- Preenchendo a tabela pessoa
INSERT INTO 'pessoa'
('IdPessoa', 'CPF', 'DataCadastro', 'Email', 'Nome', 'Telefone', 'IdSexo')
VALUES (1, '82731637170', '2016-11-13', 'daniel@gmail', 'Daniel', '(84)98721-2363', 1);

-- Definição da tabela sexo
DROP TABLE IF EXISTS 'sexo';
CREATE TABLE 'sexo'   
(
    'IdSexo' int(10) NOT NULL AUTO_INCREMENT,
    'Descricao' varchar(10) NOT NULL,
    PRIMARY KEY ('IdSexo'),
    UNIQUE KEY 'Descricao' ('Descricao')
) ENGINE = innoDB AUTO_INCREMENT = 3 DEFAULT CHARSET = latin1;

INSERT INTO 'sexo' ('IdSexo', 'Descricao')
VALUES (1, 'FEMININO') (2, 'MASCULINO');