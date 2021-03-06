package br.com.lernejo.controller;

import br.com.lernejo.converters.ConverterSHA1;
import br.com.lernejo.model.dao.HibernateDAO;
import br.com.lernejo.model.dao.InterfaceDAO;
import br.com.lernejo.model.entities.Endereco;
import br.com.lernejo.model.entities.Pessoa;
import br.com.lernejo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Criação do managed bean Pessoa
 * @author Daniel Tiago
 */
@ManagedBean
@SessionScoped
public class MbPessoa implements Serializable
{
   private static final long serialVersionUID = 1L;
   private String verificaSenha;
   private Pessoa pessoa = new Pessoa();
   private Endereco endereco = new Endereco();
   private List<Pessoa> pessoas;
   private List<Endereco> enderecos;

    public MbPessoa() {}
   
   // Criar os daos para endereço e pessoa
    private InterfaceDAO<Pessoa> pessoaDAO()
    {
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession()); 
        return pessoaDAO;
    }
    
    private InterfaceDAO<Endereco> enderecoDAO()
    {
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class, FacesContextUtil.getRequestSession()); 
        return enderecoDAO;
    }
    
    public String limpPessoa()
    {
        pessoa = new Pessoa();
        endereco = new Endereco();
        return editPessoa();
    }
    
    public String editPessoa()
    {
        return "/restrict/cadastrarpessoa.faces";
    }
    
    public String addPessoa()
    {
        Date date = new Date();
        if (pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0)
        {
            pessoa.setDataCadastro(date);
            insertPessoa();    
        }
        else
            updatePessoa();
        return null;
    }
    
    private void insertPessoa()
    {
            pessoa.setPermissao("ROLE_ADMIN");
            pessoaDAO().save(pessoa);
            endereco.setPessoa(pessoa);
            enderecoDAO().save(endereco);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserção realizado corretamente", ""));
     
    }
  
    private void updatePessoa()
    {
        pessoaDAO().update(pessoa);
        enderecoDAO().update(endereco);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização realizado corretamente", ""));
    }
    
    public String deletePessoa()
    {
        pessoaDAO().remove(pessoa);
        enderecoDAO().remove(endereco);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Remoção realizada com sucesso", ""));
        return null;
    }

    public List<Pessoa> getPessoas() 
    {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Endereco> getEnderecos() 
    {   
        enderecos = enderecoDAO().getEntities();
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getVerificaSenha() {
        return verificaSenha;
    }

    public void setVerificaSenha(String verificaSenha) {
        this.verificaSenha = verificaSenha;
    }

    
}
