
package br.com.lernejo.model.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 * Representa a tabela Endereco no banco de dados.
 */
@Entity
@Table (name = "endereco")
public class Endereco implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column (name = "IdEndereco", nullable = false)
    private Integer idEndereco;
    @Column (name = "Bairro", length = 50)
    private String bairro;
    @Column (name = "Rua", length = 50)
    private String rua;
    @Column (name = "CEP", length = 9)
    private String cep;
    @Column (name = "Numero")
    private Integer numero;

    @OneToOne (optional = true, fetch = FetchType.LAZY)
    @ForeignKey (name = "EnderecoPessoa")
    @JoinColumn (name = "IdPessoa", referencedColumnName = "IdPessoa")
    private Pessoa pessoa; 
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoCidade")
    @JoinColumn(name = "IdCidade", referencedColumnName="IdCidade")
    private Cidade cidade; 
    
    public Endereco() 
    {
        this.cidade = new Cidade();
        this.pessoa = new Pessoa();
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idEndereco);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.idEndereco, other.idEndereco)) {
            return false;
        }
        return true;
    }
    
    
}
