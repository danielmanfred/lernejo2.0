package br.com.lernejo.model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 * Representa a tabela Cidade no banco de dados.
 */

@Entity
@Table (name = "cidade")
public class Cidade implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column (name = "IdCidade", nullable = false)
    public Integer idCidade;
    @Column (name = "Nome", nullable = false, length = 50)
    private String nome;

    @OneToMany (mappedBy = "cidade", fetch = FetchType.LAZY)
    @ForeignKey (name = "EnderecoCidade")
    private List<Endereco> enderecos;
    
    public Cidade() 
    {}

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.idCidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.idCidade, other.idCidade)) {
            return false;
        }
        return true;
    }
    
    
}
