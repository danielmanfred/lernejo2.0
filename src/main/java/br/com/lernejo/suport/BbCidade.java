
package br.com.lernejo.suport;

import br.com.lernejo.model.dao.HibernateDAO;
import br.com.lernejo.model.dao.InterfaceDAO;
import br.com.lernejo.model.entities.Cidade;
import br.com.lernejo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Classe backing beans que dar suporte na lista de cidades
 * @author Daniel
 */
@ManagedBean (name = "bbCidade")
@RequestScoped
public class BbCidade implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public List<Cidade> getCidades()
    {
        InterfaceDAO<Cidade> cidadeDAO;
        cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO.getEntities();
    }
}
