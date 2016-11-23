package br.com.lernejo.suport;

import br.com.lernejo.model.dao.HibernateDAO;
import br.com.lernejo.model.dao.InterfaceDAO;
import br.com.lernejo.model.entities.Sexo;
import br.com.lernejo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Daniel Tiago
 */
@ManagedBean (name = "bbSexo")
@RequestScoped
public class BbSexo implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public List<Sexo> getSexos()
    {
        InterfaceDAO<Sexo> sexoDAO;
        sexoDAO = new HibernateDAO<Sexo>(Sexo.class, FacesContextUtil.getRequestSession());
        return sexoDAO.getEntities();
    }
}
