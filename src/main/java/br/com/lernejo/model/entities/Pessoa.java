package br.com.lernejo.model.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 * Representa a tabela Pessoa do banco de dados.
 */

@Entity
@Table (name = "pessoa")
public class Pessoa implements Serializable
{
    protected static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column (name = "IdPessoa", nullable = false)
    protected Integer idPessoa;
    @Column (name = "Nome", nullable = false, length = 80)
    protected String nome;
    @Column (name = "Email", nullable = false, length = 80)
    protected String email;
    @Column (name = "Telefone", nullable = false, length = 14)
    protected String telefone;
    @Column (name = "CPF", nullable = false, length = 80)
    protected String cpf;
    @Column (name = "DataDeNascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dataNascimento;
    @Column (name = "DataDeCadastro", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dataCadastro; 
    
    @Column(name = "Login", length = 20)
    protected String login;
    @Column(name = "Senha", length = 10)
    protected String senha; 
    @Column(name = "Permissao", length = 30)
    protected String permissao;
    
    @OneToOne (mappedBy = "pessoa", fetch = FetchType.LAZY)
    @ForeignKey (name = "EnderecoPessoa")
    protected Endereco endereco;
    
    @ManyToOne (optional = false)
    @ForeignKey (name = "PessoaSexo")
    @JoinColumn (name = "IdSexo", referencedColumnName = "IdSexo")
    protected Sexo sexo;

    public Pessoa() 
    {
        this.sexo = new Sexo();
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idPessoa);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.idPessoa, other.idPessoa)) {
            return false;
        }
        return true;
    }
    
    
}
