
package br.com.lernejo.suport;

import br.com.lernejo.model.entities.Pessoa;
import br.com.lernejo.util.FacesContextUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Backing bean para logar o usuário
 * @author Manfred
 */
@ManagedBean(name = "bbUsuarioLogado")
@SessionScoped
public class BbUsuarioLogado implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String login;
    SecurityContext context = SecurityContextHolder.getContext();

    public BbUsuarioLogado() 
    {
    }

    //Backing bean resumido
    public Pessoa procuraPessoa() 
    {
        if (context instanceof SecurityContext) 
        {
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) 
            {
                login = (((User) authentication.getPrincipal()).getUsername());
            }
        }
        Session session = FacesContextUtil.getRequestSession();
        Query query = session.createQuery("from Pessoa user where user.login like ?");
        query.setString(0, login);
        return (Pessoa) query.uniqueResult(); 
    }
}
