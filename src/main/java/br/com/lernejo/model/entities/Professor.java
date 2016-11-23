package br.com.lernejo.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Representa a tabela Professor do banco de dados.
 */
@Entity
@Table (name = "professor")
public class Professor extends Pessoa
{
    
}
